package com.emirhanarici.socialapp.dto;

import java.util.List;

public record CreateUserRequest(
        String username,
        String name,
        String email,
        String password,
        String profilePic,
        List<String> followers,
        List<String> following,
        String bio
) {
}
