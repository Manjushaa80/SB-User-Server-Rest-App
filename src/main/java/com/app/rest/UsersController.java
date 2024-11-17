package com.app.rest;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.app.model.User;
import com.app.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UsersController {

	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value = "/users", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<User> saveUser(@RequestBody User u) {
		User user = userService.saveUser(u);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);

	}

	@GetMapping(value = "/users/{id}", produces = { "application/json" })
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		User user = userService.getUser(id);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> user = userService.getAllUser();
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);

	}

	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		boolean flag = userService.deleteUser(id);
		if (flag) {
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
		User u = userService.updateUser(id, user);
		if (u != null) {
			return new ResponseEntity<User>(u, HttpStatus.OK);

		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping(value = "/users/{id}")
	public ResponseEntity<User> editUser(@PathVariable int id, @RequestBody User user) {
		User u = userService.editUser(id, user);
		if (u != null) {
			return new ResponseEntity<User>(u, HttpStatus.OK);

		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	//sorting
	
	   @GetMapping(value = "/users/sort-by-salary")
	  public ResponseEntity<List<User>> sortUser()
	  {
		   List<User > ulist =userService.sortByUserSalaryAsc();
		   return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
		  
	  }
	   @GetMapping(value = "/users/sort-by-salary-desc")
		public ResponseEntity<List<User>> sortUserDesc()
		{
		 List<User>ulist =  userService.sortByUserSalaryDesc();
		 return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
		  
		}
		
	   @GetMapping(value = "/users/search-companyname")
		public ResponseEntity<List<User>> searchUserByCompanyName(@RequestParam String companyName)
		{ 
			 List<User> user =  userService.searchUserComanyName(companyName);
			 return new ResponseEntity<List<User>>(user, HttpStatus.OK);
			
		}
	
	   @GetMapping(value = "/users/search-usersdetails")
	   public ResponseEntity<List<User>> searchByUsersDetails(@RequestParam String companyName ,@RequestParam String userDesignation)
	   {
		   List<User> user =userService.searchUsersDetails(companyName,userDesignation);
		   return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	   }
	
	   @GetMapping(value = "/users/page")
	   public ResponseEntity<List<User>> getUsers(@RequestParam Integer page,@RequestParam Integer size)
	   {
		   List<User> user =userService.getUsers(page,size);
		   return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	   }
	   
	   @GetMapping(value = "/users/filter")
	   public ResponseEntity<List<User>> getUsers(@RequestParam Double minSalary,@RequestParam Double maxSalary)
	   {
		   List<User> user=userService.getUsers(minSalary,maxSalary);
		   return new ResponseEntity<List<User>>(user, HttpStatus.OK);
		   
	   }
	
	
	
	
	
	
	
	
	

}