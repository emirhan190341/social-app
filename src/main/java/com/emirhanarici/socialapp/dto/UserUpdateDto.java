package com.emirhanarici.socialapp.dto;

import com.emirhanarici.socialapp.entity.User;

public record UserUpdateDto(
        String message,
        String username,
        String name,
        String email,
        String password,
        String profilePic,
        String bio
) {
    public static UserUpdateDto convertToDto(User user, String message) {
        return new UserUpdateDto(message, user.getUsername(), user.getName(), user.getEmail(), user.getPassword(), user.getProfilePic(), user.getBio());
    }
}
