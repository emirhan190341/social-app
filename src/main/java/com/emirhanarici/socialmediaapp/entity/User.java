package com.emirhanarici.socialmediaapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private int avatar;

    public User(String userName, String password, int avatar) {
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
    }


    public User(int avatarId, String username) {
        this.avatar = avatarId;
        this.userName = username;
    }
}
