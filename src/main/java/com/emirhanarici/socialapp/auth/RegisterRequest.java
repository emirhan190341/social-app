package com.emirhanarici.socialapp.auth;


import jakarta.annotation.Nullable;
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
    private String username;
    private String name;
    private String email;
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
