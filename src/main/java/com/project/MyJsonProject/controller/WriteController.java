package com.project.MyJsonProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.MyJsonProject.error.MessageResponse;
import com.project.MyJsonProject.error.ServiceResponseException;
import com.project.MyJsonProject.model.Author;
import com.project.MyJsonProject.model.Post;
import com.project.MyJsonProject.service.WriteService;


@RestController
public class WriteController {
	@Autowired
	WriteService writeService;
	
	@PostMapping("/addauthor")  
	public ResponseEntity<MessageResponse> addAuthor(@RequestBody Author author)   
	{  
		try {
			writeService.addAuthor(author);
			return ResponseEntity.ok(new MessageResponse("Author Added"));
		} catch (ServiceResponseException e) {
			return ResponseEntity.status(e.getStatus()).body(new MessageResponse(e.getMessage()));
		}
	}  
	
	@PostMapping("/addpost")
	public ResponseEntity<MessageResponse> addPost(Post post)
	{
		try {
			writeService.addAuthor(post);
			return ResponseEntity.ok(new MessageResponse("Post Added"));
		} catch (ServiceResponseException e) {
			return ResponseEntity.status(e.getStatus()).body(new MessageResponse(e.getMessage()));
		}
	
	}
	
	@DeleteMapping("/author/{authid}") 
	public ResponseEntity<MessageResponse> deleteAuthor(@PathVariable("authid") int postid)   
	{  
		try {
			writeService.deletePostbyId(postid);
			return ResponseEntity.ok(new MessageResponse("Author Deleted"));
		} catch (ServiceResponseException e) {
			return ResponseEntity.status(e.getStatus()).body(new MessageResponse(e.getMessage()));
		} 
	}  
	 
	@DeleteMapping("/posts/{postid}") 
	public ResponseEntity<MessageResponse> deletePost(@PathVariable("postid") int postid)   
	{  
		try {
			writeService.deleteAuthorbyId(postid);
			return ResponseEntity.ok(new MessageResponse("Post Deleted"));
		} catch (ServiceResponseException e) {
			return ResponseEntity.status(e.getStatus()).body(new MessageResponse(e.getMessage()));
		}
	} 
	
	@PatchMapping("/updatepost/{postId}")
	public ResponseEntity<MessageResponse> updatePost(@PathVariable int postId,
	        @RequestBody Map<String,Object> map) {
		try {
			writeService.updatePost(postId, map);
			return ResponseEntity.ok(new MessageResponse("Post updated"));
		} catch (ServiceResponseException e) {
			return ResponseEntity.status(e.getStatus()).body(new MessageResponse(e.getMessage()));
		}
	}
	
	@PatchMapping("/updateauthor/{authorId}")
	public ResponseEntity<MessageResponse> updateAuthor(@PathVariable int authId,
	        @RequestBody Map<String,Object> map) {
		try {
			writeService.updateAuthor(authId, map);
			return ResponseEntity.ok(new MessageResponse("Author updated"));
		} catch (ServiceResponseException e) {
			return ResponseEntity.status(e.getStatus()).body(new MessageResponse(e.getMessage()));
		}
	}
	

}
