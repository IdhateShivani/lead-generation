package com.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CompanyForm;
import com.example.repository.CompanyFormRepository;

@Service
public class CompanyFormService {

    @Autowired
    private CompanyFormRepository companyFormRepository;

    // Save the company form data
    public void savePost(CompanyForm post) {
        companyFormRepository.save(post);
    }

    // Retrieve all company form posts
    public List<CompanyForm> getAllPosts() {
        return companyFormRepository.findAll();
    }

    // Fetch a post by ID
    public CompanyForm getPostById(Long id) {
        return companyFormRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }

    // Delete a post by ID
    public void deletePost(Long id) {
        companyFormRepository.deleteById(id);
    }
}