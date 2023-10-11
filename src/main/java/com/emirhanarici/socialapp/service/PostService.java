package com.emirhanarici.socialapp.service;

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
    private final UserService userService;

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


    public boolean likeOnePost(Long postId) {

        Integer userId = userService.getUserId();

        Post post = postRepository.findById(postId)
                .orElseThrow();

        List<String> likes = post.getLikes();

        if (!likes.contains(userId.toString())) {
            likes.add(String.valueOf(userId));
            postRepository.save(post);

            return true;
        } else {
            likes.remove(userId.toString());
            postRepository.save(post);

            return false;
        }


    }


}
