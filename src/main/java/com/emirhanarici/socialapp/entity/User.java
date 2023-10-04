package com.emirhanarici.socialapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String profilePic;

    //    @CollectionTable(name = "followers", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "followers")
    @ElementCollection
    private List<String> followers;

    //    @CollectionTable(name = "following", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "following")
    @ElementCollection
    private List<String> following;
    private String bio;
    @Column(name = "createdAt")
    //LocalDateTimeStamp
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date createdAt;


}
