//package com.example.controller;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.example.SuperAdminPost;
//import com.example.service.FirebaseStorageService;
//import com.example.service.SuperAdminPostService;
//
//import org.springframework.ui.Model;
//
//@Controller
//public class SuperAdminPostController {
//
//    @Autowired
//    private SuperAdminPostService postService;
//
//    @Autowired
//    private FirebaseStorageService firebaseStorageService;
//
//    @GetMapping("/superpost")
//    public String showAddPostForm(Model model) {
//        // You can add any necessary attributes to the model if needed
//        return "superdashboard"; 
//    }
//
//    @PostMapping("/superpost")
//    public String addPost(@RequestParam String title,
//                          @RequestParam String description,
//                          @RequestParam MultipartFile image,
//                          @RequestParam String date,
//                          @RequestParam String time,
//                          Model model) {
//        SuperAdminPost post = new SuperAdminPost();
//        post.setTitle(title);
//        post.setDescription(description);
//        post.setDate(date);
//        post.setTime(time);
//        
//        // Handle image upload
//        if (!image.isEmpty()) {
//            try {
//                String imageUrl = firebaseStorageService.uploadFile(image);
//                post.setImage(imageUrl); // Save the image URL in your entity
//            } catch (IOException e) {
//                e.printStackTrace();
//                // Handle the error
//            }
//        }
//
//        // Save the post to generate ID and then set the referral link
//        postService.savePost(post);
//        
//        // Generate the referral link after saving
//        String referralLink = "http://localhost:8080/refer/" + post.getId();
//        post.setReferralLink(referralLink);
//        postService.savePost(post); // Update with the referral link
//
//        return "redirect:/success"; // Redirect after saving
//    }
//}
//****************************************************************************************************
/*

package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.SuperAdminPost;
import com.example.service.FirebaseStorageService;
import com.example.service.SuperAdminPostService;

@Controller
public class SuperAdminPostController {

    @Autowired
    private SuperAdminPostService postService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/allposts")
    public String getAllPosts(Model model) {
        List<SuperAdminPost> posts = postService.getAllPosts();
        model.addAttribute("superAdminPost", posts); // Make sure you add posts to the model
        return "all-posts"; // Ensure the HTML file is named 'allposts.html' and placed in 'src/main/resources/templates'
    }



    
    @GetMapping("/superpost")
    public String showAddPostForm(Model model) {
        return "forms-elements";
    }

//    @PostMapping("/superpost")
//    public String addPost(@RequestParam String title,
//                          @RequestParam String description,
//                          @RequestParam String department,
//                          @RequestParam MultipartFile image,
//                          @RequestParam String date,
//                          @RequestParam String time,
//                          Model model) {
//        SuperAdminPost post = new SuperAdminPost();
//        post.setTitle(title);
//        post.setDescription(description);
//        post.setDepartment(department);
//        post.setDate(date);
//        post.setTime(time);
//
//        // Handle image upload
//        if (!image.isEmpty()) {
//            try {
//                // Upload the file and get the filename
//                String fileName = firebaseStorageService.uploadFile(image);
//                post.setImage(fileName); // Save only the filename in your entity
//            } catch (IOException e) {
//                e.printStackTrace();
//                // Handle the error
//            }
//        }
//
//        // Save the post to generate ID and then set the referral link
//        postService.savePost(post);
//
////        // Generate the referral link after saving
////        String referralLink = "http://localhost:8080/refer/" + post.getId();
////        post.setReferralLink(referralLink);
////        postService.savePost(post); // Update with the referral link
////
//        return "redirect:/success"; // Redirect after saving
//    }
//
//      
//}
    @PostMapping("/superpost")
    public String addPost(@RequestParam String title,
                          @RequestParam String description,
                          @RequestParam String department,
                          @RequestParam MultipartFile image,
                          @RequestParam String date,
                          @RequestParam String time,
                          @RequestParam String amount) {
        SuperAdminPost post = new SuperAdminPost();
        post.setTitle(title);
        post.setDescription(description);
        post.setDepartment(department);
        post.setDate(date);
        post.setTime(time);
        post.setTime(amount);

        // Handle image upload
        if (!image.isEmpty()) {
            try {
                String fileName = firebaseStorageService.uploadFile(image);
                post.setImage(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Save the post
        postService.savePost(post);

        return "redirect:/success"; // Redirect after saving
    }
}
*/

package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.SuperAdminPost;
import com.example.service.FirebaseStorageService;
import com.example.service.SuperAdminPostService;

@Controller
public class SuperAdminPostController {

    @Autowired
    private SuperAdminPostService postService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    // Method to get all posts and display them
    @GetMapping("/allposts")
    public String getAllPosts(Model model) {
        List<SuperAdminPost> posts = postService.getAllPosts();
        model.addAttribute("superAdminPost", posts); // Add posts to the model for display
        return "all-posts"; // HTML file to display the posts, ensure it's present in 'src/main/resources/templates'
    }

    // Method to display the form to add a post
    @GetMapping("/superpost")
    public String showAddPostForm(Model model) {
        return "forms-elements"; // Ensure the form HTML is named 'forms-elements.html'
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
