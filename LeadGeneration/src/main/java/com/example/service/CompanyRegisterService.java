package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CompanyRegister;
import com.example.UserRegister;
import com.example.repository.CompanyRegisterRepository;
import com.example.repository.UserRegisterRepository;
@Service
public class CompanyRegisterService {

    @Autowired
    private CompanyRegisterRepository repository;

    public void saveContactUsForm(CompanyRegister reg) {
        repository.save(reg);
    }
}