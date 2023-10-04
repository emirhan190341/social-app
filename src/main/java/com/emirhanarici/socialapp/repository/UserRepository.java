package com.emirhanarici.socialapp.repository;

import com.emirhanarici.socialapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
