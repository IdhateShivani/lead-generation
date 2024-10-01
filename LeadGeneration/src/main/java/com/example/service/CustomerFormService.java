package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ContactUs;
import com.example.CustomerForm;
import com.example.repository.ContactUsRepository;
import com.example.repository.CustomerFormRepository;

@Service
public class CustomerFormService {

    @Autowired
    private CustomerFormRepository repository;

    public void saveContactUsForm(CustomerForm contactUs) {
        repository.save(contactUs);
    }
}