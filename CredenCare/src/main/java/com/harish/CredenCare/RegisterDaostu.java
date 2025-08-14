package com.harish.CredenCare;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class RegisterDaostu
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	private String name;
	private String studiedUni;
	private String mailid;
	private String WalletId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudiedUni() {
		return studiedUni;
	}
	public void setStudiedUni(String studiedUni) {
		this.studiedUni = studiedUni;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getWalletId() {
		return WalletId;
	}
	public void setWalletId(String walletId) {
		WalletId = walletId;
	}
	
	

}
