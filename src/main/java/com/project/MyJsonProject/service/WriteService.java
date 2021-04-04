package com.project.MyJsonProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.MyJsonProject.error.ServiceResponseException;
import com.project.MyJsonProject.model.Author;
import com.project.MyJsonProject.model.Post;
import com.project.MyJsonProject.repository.WriteRepository;


@Service
public class WriteService {
	@Autowired
     WriteRepository writeRepository;
	  
      public void addAuthor(Author author) throws ServiceResponseException 
      {
    	  if(!writeRepository.addEntity(author,"authors"))
    	  {
    		  throw ServiceResponseException.status(HttpStatus.BAD_REQUEST)
              .message("The given authorID " + author.getID()+" already exists");
    	  }
      }
      
      public void addPost(Post post) throws ServiceResponseException 
      {
    	  if(!writeRepository.addEntity(post,"posts"))
    	  {
    		  throw ServiceResponseException.status(HttpStatus.BAD_REQUEST)
              .message("The given postID " + post.getID()+" already exists");
    	  }
      }
      public void putAuthor(int ID, Author author) throws ServiceResponseException 
      {
    	  if(!writeRepository.putEntity(ID,author,"authors"))
    	  {
    		  writeRepository.addEntity(author, "authors");
    		  throw ServiceResponseException.status(HttpStatus.ACCEPTED)
              .message("The given authorID " + ID+" already exists. Updating Value");
    	  }
    	  writeRepository.putEntity(ID, author, "authors");
      }
      
      public void putPost(int ID, Post post) throws ServiceResponseException
      {
    	  if(!writeRepository.putEntity(ID,post,"posts"))
    	  {
    		  writeRepository.addEntity(post, "posts");
    		  throw ServiceResponseException.status(HttpStatus.ACCEPTED)
              .message("The given authorID " + ID+" already exists. Updating Value");
    	  }
    	  writeRepository.putEntity(ID, post, "posts");
      }
	
      public void deletePostbyId(int Id) throws ServiceResponseException
      {
    	  if(!writeRepository.deleteEntity("posts", Id))
    	  {
    		  throw ServiceResponseException.status(HttpStatus.BAD_REQUEST)
              .message("The given postID " + Id+" does not exist");
    	  }
      }
      public void deleteAuthorbyId(int Id) throws ServiceResponseException
      {
    	  if(!writeRepository.deleteEntity("authors", Id))
    	  {
    		  throw ServiceResponseException.status(HttpStatus.BAD_REQUEST)
              .message("The given authID " + Id+" does not exist");
    	  }
      }
      public void updatePost(int id, Map<String, Object> m) throws ServiceResponseException
      {
    	  if(!writeRepository.updateEntity(id, m, "posts"))
    	  {
    		  throw ServiceResponseException.status(HttpStatus.BAD_REQUEST)
              .message("Cannot alter PostId ");
    	  }
      }
      public void updateAuthor(int id, Map<String, Object> m) throws ServiceResponseException
      {
    	  if(!writeRepository.updateEntity(id, m, "authors"))
    	  {
    		  throw ServiceResponseException.status(HttpStatus.BAD_REQUEST)
              .message("Cannot alter AuthId "); 
    	  }
      }

}