package com.emirhanarici.socialapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String name;
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

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(List<String> followers) {
        this.followers = followers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
