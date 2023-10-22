package com.emirhanarici.socialapp.repository;

import com.emirhanarici.socialapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {


//    @Query("select p from Post p where p.user.id in :postedBy")
//    Optional<List<Post>> findByUserIdIn(List<Long> postedBy);

    Optional<List<Post>> findByUser_Id(Long userId);



}
