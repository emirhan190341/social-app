package com.emirhanarici.socialmediaapp.controller;

import com.emirhanarici.socialmediaapp.dto.UserRequest;
import com.emirhanarici.socialmediaapp.dto.UserResponse;
import com.emirhanarici.socialmediaapp.entity.User;
import com.emirhanarici.socialmediaapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.addUser(userRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getOneUser(@PathVariable Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getOneUser(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId, @RequestBody UserRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.updateUser(userId, request));
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }
}
