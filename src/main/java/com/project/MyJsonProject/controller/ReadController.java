package com.project.MyJsonProject.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.MyJsonProject.error.MessageResponse;
import com.project.MyJsonProject.error.ServiceResponseException;
import com.project.MyJsonProject.model.AuthParam;
import com.project.MyJsonProject.model.Element;
import com.project.MyJsonProject.model.ElementParam;
import com.project.MyJsonProject.model.PostParam;
import com.project.MyJsonProject.service.ReadService;


@RestController
public class ReadController {

	@Autowired
	ReadService readService;
	
	
	@GetMapping("/")  
	public ResponseEntity<List<Object>> getAll()   
	{
	return ResponseEntity.ok(readService.getAll());
	} 
	
	@GetMapping("/authors")  
	public ResponseEntity<List<Element>> getAllAuthors()   
	{  
	return ResponseEntity.ok(readService.getAllAuthors());
	} 
	
	@GetMapping("/authors/{authid}")  
	public ResponseEntity getAuthor(@PathVariable("authid") int authid)   
	{ 
	try {
		return ResponseEntity.of(readService.getAuthorbyId(authid));
	} catch (ServiceResponseException e) {
		  return ResponseEntity.status(e.getStatus()).body(new MessageResponse(e.getMessage()));
	}
	} 
	@GetMapping("/post")  
	public ResponseEntity getFileteredPosts(@RequestParam("title") String title, @RequestParam("author") String author)
	{ 
		ElementParam param=new PostParam(title, author);
		return ResponseEntity.of(readService.getPostsbyParam(param));
	} 
	@GetMapping("/author")  
	public ResponseEntity getFileteredAuthors(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
	{ 
		ElementParam param=new AuthParam(firstName, lastName);
		return ResponseEntity.of(readService.getAuthorsbyParam(param));
	}
	@GetMapping("/posts")
	public ResponseEntity<List<Element>> getAllPosts()
	{
	return ResponseEntity.ok(readService.getAllPosts());
	}
	
	@GetMapping("/posts/{postid}")  
	public ResponseEntity getPost(@PathVariable("postid") int postid)   
	{  
	try {
		return ResponseEntity.of(readService.getPostbyId(postid));
	} catch (ServiceResponseException e) {
		return ResponseEntity.status(e.getStatus()).body(new MessageResponse(e.getMessage()));
	}
	}  
	

}
