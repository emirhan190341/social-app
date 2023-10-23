package com.emirhanarici.socialapp.dto.converter;

import com.emirhanarici.socialapp.dto.CreateReplyRequest;
import com.emirhanarici.socialapp.entity.Post;
import com.emirhanarici.socialapp.entity.Reply;
import com.emirhanarici.socialapp.entity.User;
import com.emirhanarici.socialapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReplyConverter {


    private final UserRepository userRepository;

    public Reply mapToEntity(CreateReplyRequest request,Integer userId, Post post) {

        User user = userRepository.findById(userId)
                .orElseThrow();


        return new Reply(null, user, post, request.text(), request.userProfilePic(), request.username());
    }


}
