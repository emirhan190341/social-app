package com.emirhanarici.socialmediaapp.service;

import com.emirhanarici.socialmediaapp.dto.UserRequest;
import com.emirhanarici.socialmediaapp.dto.UserResponse;
import com.emirhanarici.socialmediaapp.entity.User;
import com.emirhanarici.socialmediaapp.exception.UserNotFoundById;
import com.emirhanarici.socialmediaapp.exception.UsernameAlreadyExists;
import com.emirhanarici.socialmediaapp.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::convert).collect(Collectors.toList());

    }

    public UserResponse addUser(UserRequest request) {
        if (userRepository.existsByUserName(request.userName())) {
            throw new UsernameAlreadyExists("User already exists.");
        }

        return saveUser(request);
    }

    public UserResponse getOneUser(Long userId) {

        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundById("User not found by id: " + userId);
        }

        return findById(userId);

    }

    public UserResponse updateUser(Long id, UserRequest request) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundById("User not found with id " + id));

        existingUser.setUserName(request.userName());
        existingUser.setPassword(request.password());
        existingUser.setAvatar(request.avatar());


        User updatedUser = userRepository.save(existingUser);

        return UserResponse.convert(updatedUser);

    }


    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }


    //Single Responsibility:
    private UserResponse saveUser(UserRequest request) {

        User user = userRepository.save(UserRequest.convert(request));

        return UserResponse.convert(user);

    }

    private UserResponse findById(Long userId) {
        User user = userRepository.findById(userId).get();

        return UserResponse.convert(user);

    }

    private User setUser(UserRequest request) {
        return User.builder()
                .userName(request.userName())
                .password(request.password())
                .avatar(request.avatar())
                .build();
    }


}
