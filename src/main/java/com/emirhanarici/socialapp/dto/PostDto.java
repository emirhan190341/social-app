package com.emirhanarici.socialapp.dto;

import com.emirhanarici.socialapp.entity.Post;

import java.util.Date;
import java.util.List;

public record PostDto(
        Long id,
        Integer postedBy,
        String title,
        String text,
        String image,
        List<String> likes,
        Date createdAt

) {
    public static PostDto mapToDto(Post from) {
        return new PostDto(from.getId(), from.getUser().getId(), from.getTitle(), from.getText(), from.getImage(), from.getLikes(), from.getCreatedAt());
    }
}
