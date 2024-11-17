package com.app.service;

import java.util.List;

import com.app.model.User;

public interface UserService {

	User saveUser(User u);

	User getUser(int id);

	List<User> getAllUser();

	boolean deleteUser(int id);

	User updateUser(int id, User user);

	User editUser(int id, User user);

	List<User> sortByUserSalaryAsc();

	List<User> sortByUserSalaryDesc();

	List<User> searchUserComanyName(String companyName);

	List<User> searchUsersDetails(String companyName, String userDesignation);

	List<User> getUsers(Integer page, Integer size);

	List<User> getUsers(Double minSalary, Double maxSalary);

	
	

	
	

}
