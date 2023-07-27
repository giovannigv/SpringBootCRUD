package com.giovanni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giovanni.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>  {
    UserEntity findByUsername(String username) throws Exception;
}