package com.harish.CredenCare;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class RegisterDaoemp
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	private String companyname;
	private String employername;
	private String employerMail;
	
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getEmployername() {
		return employername;
	}
	public void setEmployername(String employername) {
		this.employername = employername;
	}
	public String getEmployerMail() {
		return employerMail;
	}
	public void setEmployerMail(String employerMail) {
		this.employerMail = employerMail;
	}
	
}
