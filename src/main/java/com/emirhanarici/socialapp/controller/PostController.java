package com.emirhanarici.socialapp.controller;

import com.emirhanarici.socialapp.dto.CreatePostRequest;
import com.emirhanarici.socialapp.dto.PostDto;
import com.emirhanarici.socialapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createOnePost(@RequestBody CreatePostRequest request) {
        return ResponseEntity
                .ok(postService.createOnePost(request));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getFeedPosts() {
        return ResponseEntity
                .ok(postService.getFeedPosts());
    }

    @PutMapping("/like/{postId}")
    public ResponseEntity<String> likeOnePost(@PathVariable Long postId) {

        boolean bool = postService.likeOnePost(postId);

        if (bool) {
            return ResponseEntity
                    .ok("Post liked successfully.");
        }
        return ResponseEntity
                .ok("Post unliked successfully.");
    }


}
