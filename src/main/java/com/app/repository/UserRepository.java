package com.app.repository;





import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	List<User> findAllByOrderBySalaryAsc();
	List<User> findAllByOrderBySalaryDesc();
	List<User> findAllByCompanyName(String companyName);
	List<User> findAllByCompanyNameAndUserDesignation(String companyName,String userDesignation);
	List<User> findAllBySalaryBetween(Double minSalary,Double maxSalary);
	

}
