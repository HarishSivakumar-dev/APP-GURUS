package com.harish.CredenCare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/app")
public class RegisterController
{
	
	@Autowired
	private AdminRepo ap;
	
	@Autowired
	private EmployerDao dao;
	
	@Autowired
	private StudentRepo std;
	
	@PostMapping("/admin/register")
	public ResponseEntity<?> registerController(@RequestBody RegisterDao rd)
	{
		ap.save(rd);
		return ResponseEntity.status(HttpStatus.CREATED).body("Registered");
		
	}
	@PostMapping("/employer/register")
	public ResponseEntity<?> registerforEmployer(@RequestBody RegisterDaoemp rd)
	{
		dao.save(rd);
		return ResponseEntity.status(HttpStatus.CREATED).body("Registered");
	}
	@PostMapping("/student/register")
	public ResponseEntity<?> registerforStudent(@RequestBody RegisterDaostu rd)
	{
		std.save(rd);
		return ResponseEntity.status(HttpStatus.CREATED).body("Registered");
	}

}
