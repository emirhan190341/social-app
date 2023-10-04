package com.emirhanarici.socialapp.service;

import com.emirhanarici.socialapp.dto.CreateUserRequest;
import com.emirhanarici.socialapp.dto.UserDto;
import com.emirhanarici.socialapp.dto.converter.UserConverter;
import com.emirhanarici.socialapp.entity.User;
import com.emirhanarici.socialapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

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




}
