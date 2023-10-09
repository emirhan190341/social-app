package com.emirhanarici.socialapp.controller;

import com.emirhanarici.socialapp.dto.CreateUserRequest;
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
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return ResponseEntity
                .ok(userService.getAllUser());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getOneUserById(@PathVariable Integer userId) {
        return ResponseEntity
                .ok(userService.getOneUserById(userId));
    }








    @PutMapping("/follow/{followingId}")
    public ResponseEntity<String> followOneUserById(@PathVariable Integer followingId) {
        boolean bool = userService.followOneUserById(followingId);

        if (bool) {
            return ResponseEntity
                    .ok("User followed.");
        }
        return ResponseEntity
                .ok("User unfollowed");
    }


}
