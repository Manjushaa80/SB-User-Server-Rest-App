package com.app.serviceimpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User getUser(int id) {
		if (userRepository.existsById(id)) {
			return userRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();

	}

	@Override
	public boolean deleteUser(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User updateUser(int id, User user) {
		if (userRepository.existsById(id)) {
			user.setUserId(id);
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public User editUser(int id, User user) {
		if (userRepository.existsById(id)) {
			User u = userRepository.findById(id).get();

			if (user.getUserName() != null) {
				u.setUserName(user.getUserName());
			}

			if (user.getUserAddress() != null) {
				u.setUserAddress(user.getUserAddress());
			}

			if (user.getMobileNo() != null) {
				u.setMobileNo(user.getMobileNo());

			}
			if (user.getGender() != null) {
				u.setGender(user.getGender());
			}
			if (user.getSalary() != null) {
				u.setSalary(user.getSalary());
			}
			if (user.getUserDesignation() != null) {
				u.setUserDesignation(user.getUserDesignation());
			}

			User u1 = userRepository.save(u);
			return u1;

		}
		return null;
	}
	
	@Override
	public List<User> sortByUserSalaryAsc() {
		List<User> list = userRepository.findAllByOrderBySalaryAsc();
		return list;
	}
	@Override
	public List<User> sortByUserSalaryDesc() {
		List<User> list = userRepository.findAllByOrderBySalaryDesc();
		return list;
	}
	
	@Override
	public List<User> searchUserComanyName(String companyName) {
		List<User> list = userRepository.findAllByCompanyName(companyName);
		return list;
	}
	
	@Override
	public List<User> searchUsersDetails(String companyName, String userDesignation) {
		List<User> list = userRepository.findAllByCompanyNameAndUserDesignation(companyName, userDesignation);
		
		return list;
		
	}
	@Override
	public List<User> getUsers(Integer page, Integer size) {
	         PageRequest pr = PageRequest.of(page, size);
	         Page< User> page1 =userRepository.findAll(pr);
	         List<User> list = page1.getContent();
		return list;
	}
	
@Override
	public List<User> getUsers(Double minSalary, Double maxSalary) {
		List<User> list = userRepository.findAllBySalaryBetween(minSalary, maxSalary);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


