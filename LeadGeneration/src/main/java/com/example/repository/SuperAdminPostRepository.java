package com.example.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SuperAdminPost;

@Repository
public interface SuperAdminPostRepository extends JpaRepository<SuperAdminPost, Long> {

	List<SuperAdminPost> findByDepartment(String department);

	
	

}
