package com.rest.restapp1.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class GreetController 
{
	@ResponseBody
	@GetMapping("/greet")
	public ResponseEntity<String> greet()
	{
		String wish = null;
		int hour = LocalDateTime.now().getHour();
		if(hour < 12 ) wish = "Good Morning.";
		else if(hour < 18 ) wish = "Good Afternoon.";
		else if(hour < 21 ) wish = "Good Evening.";
		else wish = "Good Night.";
		
		return new ResponseEntity<String>(wish, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping("/welcome")
	public String welcome(@RequestParam(value="name", required=false, defaultValue = "Champ") String name)
	{
		return "Hi "+ name+ " Godavari welcomes you to Sankranti.";
	}
	
	@ResponseBody
	@GetMapping("/welcome1/{name}")
	public String welcome1(@PathVariable(value="name", required=false ) String name)
	{
		return "Hi "+ name+ " Godavari welcomes you to Makar Sankranti.";
	}
}
