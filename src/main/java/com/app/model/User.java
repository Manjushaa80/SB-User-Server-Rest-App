package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Data")
public class User {
	@Id
	private Integer userId;
	private String userName;
	private String userAddress;
	private Long mobileNo;
	private String gender;
	private Double salary;
	private String companyName;
	private String userDesignation;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer userId, String userName, String userAddress, Long mobileNo, String gender, Double salary,
			String companyName, String userDesignation) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.salary = salary;
		this.companyName = companyName;
		this.userDesignation = userDesignation;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUserDesignation() {
		return userDesignation;
	}
	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", mobileNo="
				+ mobileNo + ", gender=" + gender + ", salary=" + salary + ", companyName=" + companyName
				+ ", userDesignation=" + userDesignation + "]";
	}
	
	
	

}
