package com.emirhanarici.socialmediaapp.repository;

import com.emirhanarici.socialmediaapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUserId(@Param("userId") Long userId);
}
