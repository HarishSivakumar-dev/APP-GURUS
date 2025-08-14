package com.harish.CredenCare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class MailService
{
	@Autowired 
	JavaMailSender mailsender;
	
	@PostMapping("/sendmail")
	public String mailsender(@RequestBody MailId idm)
	{
		SimpleMailMessage mail= new SimpleMailMessage();
		
		mail.setFrom("harishss.2k07@gmail.com");
		mail.setTo(idm.getEmail());
		mail.setSubject("Implementation of a transaction: Reg,");
		mail.setText("✅ Blockchain Transaction Confirmed: The certificate you submitted has been added to the blockchain. Not you made the transation ? CLICK HERE TO ROLLBACK !");
		
		mailsender.send(mail);
		
		return "Mail Sent Successfully";
		
	}
	

}
