package com.emirhanarici.socialapp.dto;

import com.emirhanarici.socialapp.entity.User;

import java.util.Date;
import java.util.List;

public record UserDto(
        Integer id,
        String username,
        String name,
        String email,
        String password,
        String profilePic,
        List<String> followers,
        List<String> following,
        String bio,
        Date createdAt
) {
    public static UserDto convertToDto(User from) {
        return new UserDto(from.getId(), from.getUsername(), from.getName(), from.getEmail(), from.getPassword(), from.getProfilePic(), from.getFollowers(), from.getFollowing(), from.getBio(), from.getCreatedAt());
    }

}
