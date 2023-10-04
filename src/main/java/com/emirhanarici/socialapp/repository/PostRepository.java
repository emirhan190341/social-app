package com.emirhanarici.socialapp.repository;

import com.emirhanarici.socialapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
