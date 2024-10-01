package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.UserRegister;
import com.example.repository.UserRegisterRepository;
@Service
public class UserRegisterService {

    @Autowired
    private UserRegisterRepository repository;

    public void saveContactUsForm(UserRegister reg) {
        repository.save(reg);
    }
}