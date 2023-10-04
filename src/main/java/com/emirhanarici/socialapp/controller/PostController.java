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
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseEntity
                .ok(postService.getAllPosts());
    }






}
