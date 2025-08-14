package com.harish.CredenCare;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/app")
public class AiController
{
	@Autowired
	private RagService rag;
	
	@PostConstruct
    public void init() throws IOException
	{
		System.out.println("entered init block !");
        rag.addChunks();
    }
	
	@PostMapping("/ai/chat")
	public String chatResponse(@RequestBody message msg)
	{
		String mesg=msg.getMessage();
		
		return rag.ask(mesg);
	}
	

}
