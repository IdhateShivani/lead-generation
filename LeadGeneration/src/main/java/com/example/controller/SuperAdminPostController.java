/*
package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.SuperAdminPost;
import com.example.repository.SuperAdminPostRepository;
import com.example.service.FirebaseStorageService;
import com.example.service.SuperAdminPostService;

@Controller
public class SuperAdminPostController {

    @Autowired
    private SuperAdminPostService postService;

    @Autowired
    private SuperAdminPostRepository postRepository; 
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    // Method to get all posts and display them
    @GetMapping("/all-posts")
    public String getAllPosts(Model model) {
        List<SuperAdminPost> posts = postRepository.findAll(); // Fetch all posts from the database
        model.addAttribute("posts", posts); // Add posts to the model
        return "all-posts"; // Return the view name
    }

    // Method to display the form to add a post
    @GetMapping("/superpost")
    public String showAddPostForm(Model model) {
        return "forms-elements"; // Ensure the form HTML is named 'forms-elements.html'
    }

    
    @GetMapping("/posts/department/{department}")
    @ResponseBody
    public List<SuperAdminPost> getPostsByDepartment(@PathVariable String department) {
        return postService.getPostsByDepartment(department);
    }

    
    // Method to handle adding a new SuperAdmin post
    @PostMapping("/superpost")
    public String addPost(@RequestParam String title,
                          @RequestParam String description,
                          @RequestParam String department,
                          @RequestParam MultipartFile image, // The image file uploaded by the admin
                          @RequestParam String date,
                          @RequestParam String time,
                          @RequestParam String amount,
                          Model model) {
        SuperAdminPost post = new SuperAdminPost();
        post.setTitle(title);
        post.setDescription(description);
        post.setDepartment(department);
        post.setDate(date);
        post.setTime(time);
        post.setAmount(amount); // Set the amount for the post

        // Handle image upload
        if (!image.isEmpty()) {
            try {
                // Store image in "super post image" folder in Firebase Storage
                String fileName = firebaseStorageService.uploadFile(image, "super post image");
                post.setImage(fileName); // Save the URL of the uploaded image in the post
            } catch (IOException e) {
                e.printStackTrace();
                // You can also handle errors, show messages in the UI, etc.
            }
        }

        // Save the post after the image URL and other details have been set
        postService.savePost(post);

        return "redirect:/success"; // Redirect to success page after saving
    }
}
*/
package com.example.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.SuperAdminPost;
import com.example.repository.SuperAdminPostRepository;
import com.example.service.FirebaseStorageService;
import com.example.service.SuperAdminPostService;

@Controller
public class SuperAdminPostController {

    @Autowired
    private SuperAdminPostService postService;

    @Autowired
    private SuperAdminPostRepository postRepository; 

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    // Method to get all posts and display them
    @GetMapping("/all-posts")
    public String getAllPosts(Model model) {
        List<SuperAdminPost> posts = postRepository.findAll(); // Fetch all posts from the database
        model.addAttribute("posts", posts); // Add posts to the model
        return "all-posts"; // Return the view name
    }

    // New method to get all posts in JSON format
    @GetMapping("/api/all-posts")
    @ResponseBody
    public List<SuperAdminPost> getAllPostsJson() {
        return postRepository.findAll(); // Return all posts in JSON format
    }

    // Method to display the form to add a post
    @GetMapping("/superpost")
    public String showAddPostForm(Model model) {
        return "forms-elements"; // Ensure the form HTML is named 'forms-elements.html'
    }

    // Method to get posts by department
    @GetMapping("/posts/department/{department}")
    @ResponseBody
    public List<SuperAdminPost> getPostsByDepartment(@PathVariable String department) {
        return postService.getPostsByDepartment(department);
    }
    @PostMapping("/superpost")
    public String addPost(@RequestParam String title,
                          @RequestParam String description,
                          @RequestParam String department,
                          @RequestParam MultipartFile image, // If using file upload
                          @RequestParam String date,
                          @RequestParam String time,
                          @RequestParam String amount,
                          Model model) {
        SuperAdminPost post = new SuperAdminPost();
        post.setTitle(title);
        post.setDescription(description);
        post.setDepartment(department);
        post.setDate(date);
        post.setTime(time);
        post.setAmount(amount); // Set the amount for the post

//        // Handle image upload if needed
//        if (!image.isEmpty()) {
//            try {
//                String fileName = firebaseStorageService.uploadFile(image, "super post image");
//                post.setImage(fileName); // Save the URL of the uploaded image in the post
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        if (!image.isEmpty()) {
            try {
                // Upload the file and get the public URL
                String fileName = firebaseStorageService.uploadFile(image, "super post image");
                
                // Store the public URL directly in the post
                post.setImage(fileName); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        postService.savePost(post);
        System.out.println("Data inserted successfully!");
        return "redirect:/success"; 
    }
    @PutMapping("/superposts/{id}")
    @ResponseBody
    public String updateSuperPost(@PathVariable Long id, @RequestBody SuperAdminPost updatedSuperPost) {
        return postRepository.findById(id)
            .map(existingPost -> {
                existingPost.setTitle(updatedSuperPost.getTitle());
                existingPost.setDescription(updatedSuperPost.getDescription());
                existingPost.setDepartment(updatedSuperPost.getDepartment());
                existingPost.setImage(updatedSuperPost.getImage());
                existingPost.setDate(updatedSuperPost.getDate());
                existingPost.setTime(updatedSuperPost.getTime());
                existingPost.setAmount(updatedSuperPost.getAmount());
                postRepository.save(existingPost);
                return "Super post updated successfully!";
            })
            .orElse("Super post not found");
    }

    // DELETE Mapping to delete post by ID
    @DeleteMapping("/posts/{id}")
    @ResponseBody
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "Post deleted successfully!"; // Return a success message
    }
}


