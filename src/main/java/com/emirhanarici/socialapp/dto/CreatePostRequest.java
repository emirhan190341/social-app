package com.emirhanarici.socialapp.dto;

import java.util.Date;
import java.util.List;

public record CreatePostRequest(
        Integer postedBy,
        String title,
        String text,
        String image,
        List<String> likes,
        Date createdAt
) {
}
