package com.example.controller;
import com.example.CompanyForm;
import com.example.service.CompanyFormService;
import com.example.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
//
//@Controller
//public class CompanyFormController {
//
//    @Autowired
//    private CompanyFormService companyFormService;
//
//    @Autowired
//    private FirebaseStorageService firebaseStorageService; // Add FirebaseStorageService
//
//    @GetMapping("/companyform")
//    public String showForm(Model model) {
//        return "company-add-post"; // Ensure this HTML is available in your templates folder
//    }
//    
//    @GetMapping("/companyposts") // Endpoint to fetch all company posts
//    public String getCompanyPosts(Model model) {
//        List<CompanyForm> posts = companyFormService.getAllPosts();
//        model.addAttribute("posts", posts); // Pass posts data to the view
//        return "company-post-superadmin"; // Ensure this maps to your HTML file for display
//    }
//    
//    @PostMapping("/companyform")
//    public String submitForm(@RequestParam String title,
//                             @RequestParam String description,
//                             @RequestParam String department,
//                             @RequestParam MultipartFile image, // Ensure image is received as a MultipartFile
//                             @RequestParam String amount,
//                             Model model) {
//    	
//        CompanyForm post = new CompanyForm();
//        post.setTitle(title);
//        post.setDescription(description);
//        post.setDepartment(department);
//        post.setAmount(amount);
//
//        // Handle image upload to the "company form image" folder
//        if (!image.isEmpty()) {
//            try {
//                // Specify the folder name "company form image" for this form
//                String fileName = firebaseStorageService.uploadFile(image, "company form image");
//                post.setImage(fileName); // Save the Firebase URL in your entity
//            } catch (IOException e) {
//                e.printStackTrace();
//                // Optionally add some error handling logic, such as showing an error message
//            }
//        }
//
//        // Save the post after setting all the details
//        companyFormService.savePost(post);
//        return "redirect:/success"; // Redirect after saving
//    }
//}


@Controller
public class CompanyFormController {

    @Autowired
    private CompanyFormService companyFormService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/companyform")
    public String showForm(Model model) {
        return "company-add-post"; // Ensure this HTML is available in your templates folder
    }
    
    @GetMapping("/companyposts")
    @ResponseBody // Add this annotation to return data as JSON
    public List<CompanyForm> getCompanyPosts() {
        return companyFormService.getAllPosts();
    }

//    
//    @GetMapping("/companyform/{id}") // Fetch a specific company post by ID
//    public String getCompanyPostById(@PathVariable Long id, Model model) {
//        CompanyForm post = companyFormService.getPostById(id);
//        model.addAttribute("post", post);
//        return "all-posts"; // Ensure you have a detail view for displaying the post
//    }

    @PostMapping("/companyform")
    public String submitForm(@RequestParam String title,
                             @RequestParam String description,
                             @RequestParam String department,
                             @RequestParam MultipartFile image,
                             @RequestParam String amount,
                             Model model) {
        CompanyForm post = new CompanyForm();
        post.setTitle(title);
        post.setDescription(description);
        post.setDepartment(department);
        post.setAmount(amount);

        // Handle image upload to the "company form image" folder
        if (!image.isEmpty()) {
            try {
                String fileName = firebaseStorageService.uploadFile(image, "company form image");
                post.setImage(fileName); // Save the Firebase URL in your entity
            } catch (IOException e) {
                e.printStackTrace();
                // Optionally add some error handling logic, such as showing an error message
            }
        }

        // Save the post after setting all the details
        companyFormService.savePost(post);
        System.out.println("Data inserted successfully!");
        return "redirect:/success"; // Redirect after saving
    }

    @DeleteMapping("/companyform/{id}") 
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        companyFormService.deletePost(id);
        System.out.println("Data deleted successfully!");
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/companyposts-superadmin") // New endpoint to fetch posts for the Super Admin
    public String getCompanyPostsForSuperAdmin(Model model) {
        List<CompanyForm> posts = companyFormService.getAllPosts(); // Fetch all company posts
        model.addAttribute("posts", posts); // Add posts to the model
        return "company-post-superadmin"; // Return the view for displaying posts
    }

}