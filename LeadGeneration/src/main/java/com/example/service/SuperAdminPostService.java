package com.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SuperAdminPost;
import com.example.repository.SuperAdminPostRepository;

@Service
public class SuperAdminPostService {

	 @Autowired
	    private SuperAdminPostRepository postRepository;

	    public void savePost(SuperAdminPost post) {
	       
	        SuperAdminPost savedPost = postRepository.save(post);
	        
//	        // Generate and set the referral link after saving
//	        String referralLink = savedPost.generateReferralLink();
//	        
//	        System.out.println("Generated Referral Link: " + referralLink);
	    }

		public List<SuperAdminPost> getAllPosts() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}


