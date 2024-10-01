package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ContactUs;
import com.example.CustomerForm;

public interface CustomerFormRepository extends JpaRepository<CustomerForm, Long> {

}
