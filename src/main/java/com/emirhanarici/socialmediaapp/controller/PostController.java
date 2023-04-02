package com.emirhanarici.socialmediaapp.controller;

import com.emirhanarici.socialmediaapp.dto.PostResponse;
import com.emirhanarici.socialmediaapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(@RequestParam Optional<Long> userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postService.getAllPosts(userId));
    }




}
