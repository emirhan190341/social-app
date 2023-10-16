package com.emirhanarici.socialapp.auth;


import com.emirhanarici.socialapp.config.JwtService;
import com.emirhanarici.socialapp.entity.Role;
import com.emirhanarici.socialapp.entity.User;
import com.emirhanarici.socialapp.exception.AuthenticationFailedException;
import com.emirhanarici.socialapp.repository.TokenRepository;
import com.emirhanarici.socialapp.repository.UserRepository;
import com.emirhanarici.socialapp.token.Token;
import com.emirhanarici.socialapp.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .profilePic(request.getProfilePic())
                .followers(request.getFollowers())
                .following(request.getFollowing())
                .bio(request.getBio())
                .role(Role.USER)
                .build();

        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        saveUserToken(savedUser, jwtToken);


        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(mapToRegisterResponse(savedUser, request.getUsername()))
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            var user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow();

            var jwtToken = jwtService.generateToken(user);
            revokeAllUserTokens(user);
            saveUserToken(user, jwtToken);


            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .user(mapToRegisterResponse(user,request.getUsername()))
                    .build();
        } catch (AuthenticationException e) {
            throw new AuthenticationFailedException("Authentication failed");
        }
    }


    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());

        if (validUserTokens.isEmpty())
            return;

        validUserTokens.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }

    private RegisterUserResponse mapToRegisterResponse(User user, String username) {
        return new RegisterUserResponse(user.getId(), username, user.getName(), user.getEmail(), user.getPassword(), user.getProfilePic(), user.getBio());
    }
}
