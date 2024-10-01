package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CompanyForm;
import com.example.SuperAdminPost;
import com.example.repository.CompanyFormRepository;

@Service
public class CompanyFormService {

	 @Autowired
	    private CompanyFormRepository companyFormRepository;

	 public void savePost(CompanyForm post) {
	       
	        CompanyForm savedPost = companyFormRepository.save(post);
	        
	    }
	}