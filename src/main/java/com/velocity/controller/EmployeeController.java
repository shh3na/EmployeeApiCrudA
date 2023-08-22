package com.velocity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.Repository.EmployeeRepository;
import com.velocity.exception.DataNotFoundfException;
import com.velocity.exception.ErrorCode;
import com.velocity.model.Employee;

@RestController
@RequestMapping("/policy")
public class EmployeeController {

	@Autowired
	EmployeeRepository emprepo;

	@PostMapping("/create")
	public ResponseEntity<Employee> newEmplyee(@RequestBody Employee emp) {

		return new ResponseEntity<Employee>(emprepo.save(emp),HttpStatus.CREATED);

	}

	@GetMapping("/getall")
	public List<Employee> getEmployee() {

		List<Employee> listemp = emprepo.findAll();

		return listemp;

	}

	@PutMapping("/update/{id}")
	public void updateEmployee(@PathVariable Long id, @RequestBody Employee e) {

		Optional<Employee> empdata = emprepo.findById(id);

		if (empdata.isPresent()) {
			Employee exemployee = empdata.get();
			exemployee.setEmp_name(e.getEmp_name());
			exemployee.setEmp_salary(e.getEmp_salary());
			exemployee.setEmp_age(e.getEmp_age());
			exemployee.setEmp_city(e.getEmp_city());
			emprepo.save(exemployee);

		} else {
			throw new DataNotFoundfException(ErrorCode.Invalid_ID.getCode(), ErrorCode.Invalid_ID.getMessage(),
					ErrorCode.Invalid_ID.getStatus());
		}

	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) throws Throwable {

		Optional<Employee> empdata = emprepo.findById(id);

		if (empdata.isPresent()) {
			emprepo.deleteById(id);
		} else {
			throw new Throwable();
		}

	}

}
