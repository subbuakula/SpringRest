package com.rest.restapp1.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.restapp1.model.Student;

@RestController
@RequestMapping("api1")
public class StudentController 
{

	@GetMapping(value="/getStudent", produces = "application/json")
	public ResponseEntity<Student> getstudent()
	{
		Student student = new Student(2,"Subrahmanyam","Mechanical","Ambajipeta");
//		Student student = new Student();
//		student.setId(2);
//		student.setName("Subrahmanyam");
//		student.setDept("Mechanical");
//		student.setAddress("Ambajipeta");
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
		
	@GetMapping("/greet")
	public String greet()
	{
		String wish = null;
		int hour = LocalDateTime.now().getHour();
		if(hour < 12 ) wish = "Good Morning.";
		else if(hour < 18 ) wish = "Good Afternoon.";
		else if(hour < 21 ) wish = "Good Evening.";
		else wish = "Good Night.";
		
		return wish;
	}
	
	@PostMapping("/save" content)
	public ResponseEntity<String> saveStudent(@RequestBody Student student)
	{
		String status = null;
		System.out.println(student);
		status = "record saved successfully.";
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
