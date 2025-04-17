package com.example.TaskMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskMgmt.entity.User;
import com.example.TaskMgmt.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean verifyUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password) != null;
    }

    public boolean saveUser(User user) {
        return userRepository.save(user) != null;
    }

    public User getUserByEmail(String email) {
        return userRepository.findById(email).orElse(null);
    }

    

    public void deleteUserByEmail(String email) {
        userRepository.deleteById(email);
    }

    public User authenticate(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

	public void updateUser(String firstName, String lastName, String email, String otp) {
		// TODO Auto-generated method stub
		
	}
}
