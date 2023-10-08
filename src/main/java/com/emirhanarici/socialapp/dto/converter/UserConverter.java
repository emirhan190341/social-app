package com.emirhanarici.socialapp.dto.converter;

import com.emirhanarici.socialapp.dto.CreateUserRequest;
import com.emirhanarici.socialapp.entity.User;
import com.emirhanarici.socialapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final UserRepository userRepository;

    public User mapToEntity(CreateUserRequest request) {
        return new User(null, request.username(), request.email(), request.password(), request.profilePic(), request.followers(), request.following(), request.bio(),null,null);
    }

}
