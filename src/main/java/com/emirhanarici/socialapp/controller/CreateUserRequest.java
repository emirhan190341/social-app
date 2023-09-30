package com.emirhanarici.socialapp.controller;

import java.util.List;

public record CreateUserRequest(
        String username,
        String email,
        String password,
        String profilePic,
        List<String> followers,
        List<String> following,
        String bio
) {
}
