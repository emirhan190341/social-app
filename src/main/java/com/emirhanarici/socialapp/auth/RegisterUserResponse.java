package com.emirhanarici.socialapp.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {
    private Integer id;
    private String username;
    private String name;
    private String email;
    private String password;
    private String profilePic;
    private String bio;

}
