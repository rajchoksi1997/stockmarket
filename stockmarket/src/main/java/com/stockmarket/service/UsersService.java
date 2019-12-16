package com.stockmarket.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stockmarket.model.Users;
import com.stockmarket.repository.IUsersRepository;

@Service
public class UsersService {

	@Autowired
	IUsersRepository userRepository;
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public UsersService(){
		
	}
	
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
	
	public void addUser(Users user) {
		userRepository.save(user);
	}
	
	public void changeStatus(String userId) {
		User user = userRepository.getByUserId(userId);
		
		if(user.getStatus() == 'p'){
			user.setStatus('a');
		} else {
			user.setStatus('p');
		}	
		userRepository.save(user);
	}
	
	public User getByUserId(String userId) {
		return userRepository.getByUserId(userId);
	}

	public String[] getSecurityQuestionAndAnswer(String userId) {
		String[] securityData = null;
			securityData = userRepository.getSecurityQuestionAndAnswer(userId).split(",");
		
		return securityData;
	}

	public boolean setNewPassword(String newPassword, String userId) {
		User user = userRepository.getByUserId(userId);
		System.out.println("New Password "+ passwordEncoder().encode(newPassword)+ " old password"+ user.getPassword());
		if(BCrypt.checkpw(newPassword, user.getPassword())){
			return false;
		}
		userRepository.setNewPassword(passwordEncoder().encode(newPassword),userId);
		return true;
	}
	
	public boolean[] isApproved(String userId) {
		boolean approved[] = new boolean[2];
		User user = userRepository.getByUserId(userId);
		if(user != null){
			approved[0] = true;
			if(user.getStatus() == 'a') {
				approved[1] = true;
			}
		}else{
			approved[0] = approved[1] = false;
		}
		return approved;
	}

}
