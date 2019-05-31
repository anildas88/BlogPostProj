package com.blog.user.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.user.entity.UserFormEntity;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserFormEntity, Serializable>{
	
	//using HQL query
	@Query(name="from UserFormEntity where email=:email and password=:password ")
	public UserFormEntity findByUnameAndPwd(String email,String password);
	

}
