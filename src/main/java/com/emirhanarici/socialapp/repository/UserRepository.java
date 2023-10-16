package com.emirhanarici.socialapp.repository;

import com.emirhanarici.socialapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

//    @Modifying
//    @Query("update User u set u.bio = :phone where u.id = :id")
//    void updateBio(@Param(value = "id") long id, @Param(value = "bio") String bio);


}
