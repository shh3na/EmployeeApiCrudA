package com.velocity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  
	
	
}
