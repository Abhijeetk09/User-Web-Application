package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jack.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
