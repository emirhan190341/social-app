package com.emirhanarici.socialapp.dto;

import com.emirhanarici.socialapp.entity.User;

import java.util.List;

public record UpdateUserRequest(
        String username,
        String email,
        String password,
        String profilePic,
        List<String> followers,
        List<String> following,
        String bio
) {
    public static UpdateUserRequest convertToDto(User from) {
        return new UpdateUserRequest( from.getUsername(), from.getEmail(), from.getPassword(), from.getProfilePic(), from.getFollowers(), from.getFollowing(), from.getBio());
    }
}
