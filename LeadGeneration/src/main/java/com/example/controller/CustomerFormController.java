package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.CustomerForm;
import com.example.repository.CustomerFormRepository;
import com.google.common.net.MediaType;
/*
@Controller
public class CustomerFormController {
	
	 @Autowired
	    private CustomerFormRepository contactUsRepository;

		
		  @GetMapping("/customerform") 
		  public String showContactUsForm(Model model) {
		  model.addAttribute("contactUs", new CustomerForm()); 
		  return "CustomerForm"; // The
		  }
		  @PostMapping("/customerform")
		  public String submitContactUsForm(@ModelAttribute CustomerForm contactUs,
		                                     @RequestParam String postId, // Capture postId from form submission
		                                     @RequestParam String userId, // Capture userId from form submission
		                                     @RequestParam String department) { // Capture department

		      // Save the form data to the database
		      contactUs.setPostId(postId); 
		      contactUs.setUserId(userId); 
		      contactUs.setDepartment(department); 
		      contactUsRepository.save(contactUs);

		      // Redirect to the success page
		      return "redirect:/success";
		  }

		  
	}
*/
@Controller
public class CustomerFormController {

    @Autowired
    private CustomerFormRepository customerFormRepository;

    // GET - Show form for creating a new customer
    @GetMapping("/customerform")
    public String showCustomerForm(Model model) {
        model.addAttribute("customerForm", new CustomerForm());
        return "CustomerForm"; // Display the form page
    }

    // GET - Retrieve all customer form entries
    @GetMapping("/customerforms")
    @ResponseBody
    public List<CustomerForm> getAllCustomerForms() {
        return customerFormRepository.findAll();
    }

    /*
    // POST - Create a new customer form entry
    @PostMapping("/customerform")
    @ResponseBody
    public ResponseEntity<String> submitCustomerForm(@RequestBody CustomerForm customerForm) {

        // Save the form data to the database
        customerFormRepository.save(customerForm);

        // Return a success message as JSON
        return ResponseEntity.ok("Customer form submitted successfully!");
    }

*/
    
    // POST - Handle JSON submission
    @PostMapping(value = "/customerform", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> submitCustomerFormJson(@RequestBody CustomerForm customerForm) {
        // Save the form data to the database
        customerFormRepository.save(customerForm);

        // Return a success message as JSON
        return ResponseEntity.ok("Customer form submitted successfully");
    }

    // POST - Handle form submission (application/x-www-form-urlencoded)
    @PostMapping(value = "/customerform")
    public String submitCustomerFormForm(
            @RequestParam String name,
            @RequestParam String phoneNumber,
            @RequestParam String email,
            @RequestParam String comment,
            @RequestParam String date) {
        
        // Create a new CustomerForm object and set the fields
        CustomerForm customerForm = new CustomerForm();
        customerForm.setName(name);
        customerForm.setPhoneNumber(phoneNumber);
        customerForm.setEmail(email);
        customerForm.setComment(comment);
        customerForm.setDate(date);

        // Save the form data to the database
        customerFormRepository.save(customerForm);

        // Redirect to the success page after submission
        return "redirect:/success"; // Redirect to success page
    }
    
    // GET - Retrieve a specific form entry by ID
    @GetMapping("/customerform/{id}")
    @ResponseBody
    public CustomerForm getCustomerFormById(@PathVariable Long id) {
        return customerFormRepository.findById(id).orElse(null);
    }

    // PUT - Update an existing customer form entry by ID
    @PutMapping("/customerform/{id}")
    @ResponseBody
    public String updateCustomerForm(@PathVariable Long id,
                                     @RequestBody CustomerForm updatedCustomerForm) {
        return customerFormRepository.findById(id)
            .map(existingForm -> {
                existingForm.setName(updatedCustomerForm.getName());
                existingForm.setPhoneNumber(updatedCustomerForm.getPhoneNumber());
                existingForm.setEmail(updatedCustomerForm.getEmail());
                existingForm.setComment(updatedCustomerForm.getComment());
                existingForm.setDate(updatedCustomerForm.getDate());
                customerFormRepository.save(existingForm);
                return "Customer form updated successfully!";
            })
            .orElse("Customer form not found");
    }

    // DELETE - Remove a customer form entry by ID
    @DeleteMapping("/customerform/{id}")
    @ResponseBody
    public String deleteCustomerForm(@PathVariable Long id) {
        if (customerFormRepository.existsById(id)) {
            customerFormRepository.deleteById(id);
            return "Customer form deleted successfully!";
        } else {
            return "Customer form not found";
        }
    }
}
