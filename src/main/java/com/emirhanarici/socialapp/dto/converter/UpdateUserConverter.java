package com.emirhanarici.socialapp.dto.converter;

import com.emirhanarici.socialapp.dto.UpdateUserRequest;
import com.emirhanarici.socialapp.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserConverter {

    public User mapToEntity(UpdateUserRequest request) {
        return new User(request.username(), request.name(), request.password(), request.profilePic(), request.bio());
    }

    // String message,
    //        String username,
    //        String name,
    //        String email,
    //        String password,
    //        String profilePic,
    //        String bio
}
