package com.emirhanarici.socialapp.service;

import com.emirhanarici.socialapp.controller.PostController;
import com.emirhanarici.socialapp.dto.CreatePostRequest;
import com.emirhanarici.socialapp.dto.PostDto;
import com.emirhanarici.socialapp.dto.converter.PostConverter;
import com.emirhanarici.socialapp.entity.Post;
import com.emirhanarici.socialapp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostConverter postConverter;

    public PostDto createOnePost(CreatePostRequest request) {

        Post post = postRepository.save(postConverter.mapToEntity(request));

        return PostDto.mapToDto(post);
    }


    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts
                .stream()
                .map(PostDto::mapToDto)
                .collect(Collectors.toList());
    }


}
