package com.emirhanarici.socialapp.controller;

import com.emirhanarici.socialapp.dto.UserDto;
import com.emirhanarici.socialapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity
                .ok(userService.createUser(request));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity
                .ok(userService.getAllUser());
    }


}
