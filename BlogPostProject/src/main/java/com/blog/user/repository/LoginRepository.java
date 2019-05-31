package com.blog.user.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("loginRepository")
public interface LoginRepository extends JpaRepository<LoginRepository, Serializable> {
	
	

}
