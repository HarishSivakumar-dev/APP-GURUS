package com.harish.CredenCare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.document.Document;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component 
public class RagService
{
	@Autowired
	private VectorStore vectorstore;
	
	@Autowired 
	private OllamaChatClient chat;
	
	public void addChunks() throws IOException
	{
		String read=new String(Files.readString(Paths.get("C:\\Users\\hai\\Desktop\\TextFeed.txt")));
		Document doc=new Document(read);
		vectorstore.add(Collections.singletonList(doc));
	}
	public String ask(String ques)
	{
		List<Document> result =vectorstore.similaritySearch(SearchRequest.query(ques).withTopK(1));
		System.out.println("Retrived Releveant Chunks !");
		
		StringBuilder sb=new StringBuilder();
		
		for(Document doc : result)
		{
			sb.append(doc.getContent()).append("\n");
			System.out.println("appending !");
		}
		System.out.println("Appended relevant chunks !");
		
		String finalPrompt = "Using the below context and answer the question, If it's not relevant, answer using your own knowledge: \n\n"
                + sb + "\nQuestion: " + ques+"\nTry to answer faster !";
		
		System.out.println(finalPrompt);
		
		System.out.println("retured to the client !");
		return chat.call(new Prompt(finalPrompt)).getResult().getOutput().getContent();

		
	}
	


}
