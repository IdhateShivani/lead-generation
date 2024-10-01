package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserRegister;

public interface UserRegisterRepository extends JpaRepository<UserRegister, Long> {

}
