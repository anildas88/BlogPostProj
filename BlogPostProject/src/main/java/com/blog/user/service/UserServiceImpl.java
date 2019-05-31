package com.blog.user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.constants.ApplicationConstant;
import com.blog.user.entity.UserFormEntity;
import com.blog.user.model.Login;
import com.blog.user.model.UserFormModel;
import com.blog.user.repository.UserRepository;

@Service("service")
public class UserServiceImpl implements UserService {

	@Autowired(required=true)
	private UserRepository repository;

	/*
	 * this method is use for saving registration form data to db
	 * @see com.blog.user.service.UserService#registerUser(com.blog.user.model.UserFormModel)
	 */
	@Override
	public String registerUser(UserFormModel model) throws Exception{
		// create entity class obj
		UserFormEntity entity=new UserFormEntity();
		
		//copy properties from model to entity
		BeanUtils.copyProperties(model, entity);
		
		if (entity!= null) {
			
			//call repository method
			//get the saved entuty
			entity=repository.save(entity);
		}
		
		//check for null and return boolean value
		if (entity == null) {
			//return message using constant class
			return ApplicationConstant.REGISTRATION_FAILURE_MSG;
		}
		else {
			//return message using constant class
			return ApplicationConstant.REGISTRATION_SUCCESS_MSG;
		}
	}//method

	
	
	/*
	 * 
	 * check creadientials
	 * @see com.blog.user.service.UserService#login(com.blog.user.model.Login)
	 */
	@Override
	public String login(Login login) throws Exception {

		String email=login.getEmail();
		String pwd=login.getPwd();
		
		//call repository
		UserFormEntity entity=repository.findByUnameAndPwd(email, pwd);
		if (entity== null) {
			return ApplicationConstant.LOGIN_FAILURE_MSG;
		}
		else {
			return ApplicationConstant.LOGIN_SUCCESS_MSG;
		}
	}
	

}
