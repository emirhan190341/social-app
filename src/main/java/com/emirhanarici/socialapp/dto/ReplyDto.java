package com.emirhanarici.socialapp.dto;

import com.emirhanarici.socialapp.entity.Reply;

public record ReplyDto(
        Long id,
        Integer userId,
        Long postId,
        String text,
        String userProfilePic,
        String username
) {


    public static ReplyDto mapToDto(Reply reply) {
        return new ReplyDto(reply.getId(), reply.getUser().getId(), reply.getPost().getId(), reply.getText(), reply.getUserProfilePic(), reply.getUsername());
    }
}
