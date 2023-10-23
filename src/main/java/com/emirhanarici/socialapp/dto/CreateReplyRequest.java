package com.emirhanarici.socialapp.dto;


public record CreateReplyRequest(
        Integer userId,
        Integer postId,
        String text,
        String userProfilePic,
        String username
) {
}
