package com.blog.user.service;

import com.blog.user.model.Login;
import com.blog.user.model.UserFormModel;

public interface UserService{
	
	public String registerUser(UserFormModel model) throws Exception;
	
	public String login(Login login) throws Exception;

}
