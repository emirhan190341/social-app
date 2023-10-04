package com.emirhanarici.socialapp.dto.converter;

import com.emirhanarici.socialapp.dto.CreatePostRequest;
import com.emirhanarici.socialapp.dto.PostDto;
import com.emirhanarici.socialapp.entity.Post;
import com.emirhanarici.socialapp.entity.User;
import com.emirhanarici.socialapp.repository.PostRepository;
import com.emirhanarici.socialapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostConverter {

    private final UserRepository userRepository;


    public Post mapToEntity(CreatePostRequest request) {

        User user = userRepository.findById(request.postedBy())
                .orElseThrow();

        return new Post(null, user, request.title(), request.text(), request.image(), request.likes(), request.createdAt());
    }
}
