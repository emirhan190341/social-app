package com.emirhanarici.socialapp.auth;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Username cannot be null")
    private String username;
    @NotBlank(message = "Name cannot be null")
    private String name;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be null")
    private String email;
    @NotBlank(message = "Password cannot be null")
    private String password;
    @Nullable
    private String profilePic;
    @Nullable
    private List<String> followers;
    @Nullable
    private List<String> following;
    @Nullable
    private String bio;
}
