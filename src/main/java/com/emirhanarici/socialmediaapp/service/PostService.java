package com.emirhanarici.socialmediaapp.service;

import com.emirhanarici.socialmediaapp.dto.PostResponse;
import com.emirhanarici.socialmediaapp.entity.Post;
import com.emirhanarici.socialmediaapp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public List<PostResponse> getAllPosts(Optional<Long> userId) {

        List<Post> list;

        if (userId.isPresent()) {
            list = postRepository.findByUserId(userId.get());
        } else
            list = postRepository.findAll();

        return list.stream().map(PostResponse::convert).collect(Collectors.toList());

    }


}
