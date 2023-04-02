package com.emirhanarici.socialmediaapp.dto;

import com.emirhanarici.socialmediaapp.entity.User;

public record UserRequest(
        String userName,
        String password,
        int avatar
) {
    public static User convert(UserRequest request) {
        return new User(request.userName, request.password, request.avatar);
    }

}
