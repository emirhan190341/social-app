package com.emirhanarici.socialmediaapp.dto;

import com.emirhanarici.socialmediaapp.entity.User;

public record UserResponse(
        Long id,
        int avatarId,
        String username

) {


    public static UserResponse convert(User from) {
        return new UserResponse(from.getId(),
                from.getAvatar(), from.getUserName());
    }

    public static User convertToUser(UserResponse response) {
        return new User(response.avatarId, response.username);
    }

}
