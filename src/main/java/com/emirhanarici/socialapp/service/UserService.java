package com.emirhanarici.socialapp.service;

import com.emirhanarici.socialapp.dto.CreateUserRequest;
import com.emirhanarici.socialapp.dto.UserDto;
import com.emirhanarici.socialapp.dto.converter.UserConverter;
import com.emirhanarici.socialapp.entity.User;
import com.emirhanarici.socialapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public Integer getUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).get();
        return user.getId();
    }

    public UserDto createUser(CreateUserRequest request) {

        User user = userRepository.save(userConverter.mapToEntity(request));

        return UserDto.convertToDto(user);

    }

    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();

        return users
                .stream()
                .map(UserDto::convertToDto)
                .collect(Collectors.toList());
    }


    public UserDto getOneUserById(Integer userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        return UserDto.convertToDto(user);
    }


    public boolean followOneUserById(Integer followingId) {

        Integer userId = getUserId();

        User user1 = userRepository.findById(userId)
                .orElseThrow();
        List<String> following = user1.getFollowing();
        User user2 = userRepository.findById(followingId)
                .orElseThrow();

        if (!following.contains(followingId.toString())) {
            following.add(String.valueOf(followingId));

            userRepository.save(user1);

            List<String> followers = user2.getFollowers();
            followers.add(String.valueOf(userId));

            userRepository.save(user2);
            return true;
        } else {

            following.remove(String.valueOf(followingId));
            user1.setFollowing(following);

            userRepository.save(user1);

            List<String> followers = user2.getFollowers();
            followers.remove(String.valueOf(userId));
            user2.setFollowers(followers);

            userRepository.save(user2);
            return false;
        }
    }


}
