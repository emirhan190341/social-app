package com.emirhanarici.socialapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateUserRequest(

        @NotNull(message = "Username cannot be null")
        String username,
        @NotNull(message = "Name cannot be null")
        String name,
        @Email(message = "Email should be valid")
        String email,
        @NotNull(message = "Password cannot be null")
        String password,
        String profilePic,
        List<String> followers,
        List<String> following,
        String bio
) {
}
