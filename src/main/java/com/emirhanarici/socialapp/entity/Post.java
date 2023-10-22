package com.emirhanarici.socialapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_post")
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postedBy", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    private String title;
    @Column(columnDefinition = "text")
    private String text;
    private String image;
    @ElementCollection
    private List<String> likes;
    @Column(name = "createdAt")
    @CreationTimestamp
    private Date createdAt;

//    @Column(name = "`updatedAt`")
//    @UpdateTimestamp
//    private Date updatedAt;

}
