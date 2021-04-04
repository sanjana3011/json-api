package com.project.MyJsonProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.MyJsonProject.model.AuthParam;
import com.project.MyJsonProject.model.Author;
import com.project.MyJsonProject.model.Post;
import com.project.MyJsonProject.repository.ReadRepository;
import com.project.MyJsonProject.repository.WriteRepository;
import com.project.MyJsonProject.service.ReadService;

public class ReadControllerTests {


	public static void main(String[] args)   
	{
		ReadRepository readRepository=new ReadRepository();
		WriteRepository writeRepository=new WriteRepository();
		Author author=new Author(3,"sanjana", "none", 20);
		//Map<String, Object> m=new HashMap<>();
		//m.put("title", "Post10");
		//writeRepository.updateEntity(1, m, "posts");
		//System.out.println(readRepository.findAllEntites("posts"));
		//writeRepository.addEntity(author, "authors");
		 //writeRepository.addEntity(author);
		writeRepository.putEntity(3, author, "authors");
		System.out.println(readRepository.findAllEntites("authors"));
		//AuthParam param=new AuthParam("Elon","Musk");
		//System.out.println(readRepository.findElementbyParam(param, "authors"));
		//System.out.println(System.getProperty("user.home"));
	} 
	/*
	@GetMapping("/getauthors")  
	public ResponseEntity<List<Author>> getAllAuthors()   
	{  
	return ResponseEntity.ok(readService.getAllAuthors());
	} 
	
	@GetMapping("/author/{authid}")  
	private ResponseEntity<Author> getAuthor(@PathVariable("authid") int authid)   
	{ 
	return ResponseEntity.of(readService.getAuthorbyId(authid));
	} 
	
	@GetMapping("/getposts")
	public ResponseEntity<List<Post>> getAllPosts()
	{
	return ResponseEntity.ok(readService.getAllPosts());
	}
	
	@GetMapping("/post/{postid}")  
	private ResponseEntity<Post> getPost(@PathVariable("postid") int postid)   
	{  
	return ResponseEntity.of(readService.getPostbyId(postid));
	}  
	
*/
}
