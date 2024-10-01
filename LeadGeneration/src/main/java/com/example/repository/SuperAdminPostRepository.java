package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SuperAdminPost;

@Repository
public interface SuperAdminPostRepository extends JpaRepository<SuperAdminPost, Long> {
	

}
