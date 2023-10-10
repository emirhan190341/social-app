package com.emirhanarici.socialapp.dto;

public record UpdateUserRequest(
        String username,
        String name,
        String email,
        String password,
        String profilePic,
        String bio
) {
}
