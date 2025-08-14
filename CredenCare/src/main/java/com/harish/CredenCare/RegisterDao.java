package com.harish.CredenCare;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegisterDao
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	private String universityname;
	private String deanname;
	private String Principalname;
	private String emailid;
	private String walletid;
	public String getUniversityname() {
		return universityname;
	}
	public void setUniversityname(String universityname) {
		this.universityname = universityname;
	}
	public String getDeanname() {
		return deanname;
	}
	public void setDeanname(String deanname) {
		this.deanname = deanname;
	}
	public String getPrincipalname() {
		return Principalname;
	}
	public void setPrincipalname(String principalname) {
		Principalname = principalname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getWalletid() {
		return walletid;
	}
	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}

}
