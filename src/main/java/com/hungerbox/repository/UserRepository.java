package com.hungerbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungerbox.entity.User;

public interface UserRepository extends  JpaRepository<User, Integer> {

}
