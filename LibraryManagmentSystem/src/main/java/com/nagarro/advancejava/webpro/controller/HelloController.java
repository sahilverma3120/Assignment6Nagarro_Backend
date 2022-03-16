package com.nagarro.advancejava.webpro.controller;

import java.util.List;
import java.util.NoSuchElementException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.nagarro.advancejava.webpro.entity.Library;
import com.nagarro.advancejava.webpro.entity.LoginManager;

import com.nagarro.advancejava.webpro.services.LibraryServiceImp;

@RestController
public class HelloController {
	@Autowired
	private LibraryServiceImp employeeService;
	
	/***
	 * 
	 * @return emp
	 */
	@GetMapping("/employees")
	@ResponseBody
	public List<Library> getEmployees()
	{
		List<Library>list = this.employeeService.getEmployees();
		return list;
	}
	/***
	 * 
	 * @param code
	 * @return
	 */
	@GetMapping("/employees/{code}")
	@ResponseBody
	public ResponseEntity<Library> getEmpoyee(@PathVariable("code") int code)
	{
		Library emp=employeeService.getEmployee(code);
		if(emp==null)
		{
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(emp));
	}
	/***
	 * 
	 * @param emp
	 * @return
	 */
	@PostMapping(path = "/employees", consumes = "application/json")
	
	public ResponseEntity<Library> addEmployee(@RequestBody Library emp) {
		Library library = null;
		System.out.println("Inaddemployee"+emp.getName());
		try {
			library = this.employeeService.addEmployee(emp);
			System.out.println(emp);
			return ResponseEntity.status(HttpStatus.CREATED).body(library);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@PutMapping("/employees/{code}")
	public Library updateEmployee(@RequestBody Library emp)
	{

	return this.employeeService.updateEmployee(emp);
	}
		@DeleteMapping("/employees/{code}")
		public ResponseEntity<Void> delete(@PathVariable("code") int code) {
			try {
				this.employeeService.delete(code);
				return ResponseEntity.ok().build();
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

		}
		
		@GetMapping("/users/{userId}/{password}")
		@ResponseBody
		public LoginManager getUser(@PathVariable("userId") String userId, @PathVariable("password") String password)
		{
			System.out.println("In Loginmanager"+ userId+" "+password);
			return this.employeeService.validateUser(userId,password);
		}
} 
