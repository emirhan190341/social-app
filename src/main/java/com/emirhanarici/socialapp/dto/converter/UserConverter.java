package com.emirhanarici.socialapp.dto.converter;

import com.emirhanarici.socialapp.dto.CreateUserRequest;
import com.emirhanarici.socialapp.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

    public User mapToEntity(CreateUserRequest request) {
        return new User(null, request.username(), request.name(), request.email(), request.password(), request.profilePic(), request.followers(), request.following(), request.bio(), null, null,null);
    }

}
