package com.emirhanarici.socialapp.service;

import com.emirhanarici.socialapp.dto.*;
import com.emirhanarici.socialapp.dto.converter.PostConverter;
import com.emirhanarici.socialapp.dto.converter.ReplyConverter;
import com.emirhanarici.socialapp.dto.converter.UserConverter;
import com.emirhanarici.socialapp.entity.Post;
import com.emirhanarici.socialapp.entity.Reply;
import com.emirhanarici.socialapp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final PostConverter postConverter;
    private final ReplyConverter replyConverter;
    private final UserConverter userConverter;

    public PostDto createOnePost(CreatePostRequest request) {

        Post post = postRepository.save(postConverter.mapToEntity(request));

        return PostDto.mapToDto(post);
    }


    public List<PostDto> getFeedPosts() {

        List<Post> posts = new ArrayList<>();

        UserDto user = userService.getOneUserById(userService.getUserId());
        List<String> following = user.following();

        List<Long> followingIds = following.stream().map(Long::parseLong).toList();

        for (Long followingId : followingIds) {
            posts.addAll(postRepository.findByUser_Id(followingId).orElseThrow());
        }

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


    public ReplyDto replyOnePost(Long postId, CreateReplyRequest request) {

        Post post = postRepository.findById(postId)
                .orElseThrow();


        Integer userId = userService.getUserId();

        Reply reply = replyConverter.mapToEntity(request, userId, post);

        post.getReplies().add(reply);
        postRepository.save(post);

        return ReplyDto.mapToDto(reply);
    }

}
