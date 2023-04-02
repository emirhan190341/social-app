package com.emirhanarici.socialmediaapp.dto;

import com.emirhanarici.socialmediaapp.entity.Post;
import com.emirhanarici.socialmediaapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String text;



    public static PostResponse convert(Post post) {
        return new PostResponse(post.getId(), post.getUser().getId(), post.getUser().getUserName(), post.getTitle(), post.getText());
    }


}
