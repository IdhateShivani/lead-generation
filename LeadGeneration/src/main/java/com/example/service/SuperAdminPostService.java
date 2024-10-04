/*
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
   }

		public List<SuperAdminPost> getAllPosts() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

*/

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
        postRepository.save(post);
    }

    public List<SuperAdminPost> getAllPosts() {
        return postRepository.findAll();
    }

    public List<SuperAdminPost> getPostsByDepartment(String department) {
        return postRepository.findByDepartment(department);
    }

   

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}

