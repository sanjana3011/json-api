package com.project.MyJsonProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.MyJsonProject.error.ServiceResponseException;
import com.project.MyJsonProject.model.Element;
import com.project.MyJsonProject.model.ElementParam;
import com.project.MyJsonProject.repository.ReadRepository;

@Service
public class ReadService {
	
	@Autowired
	ReadRepository readRepository;
	
	 public List<Element> getAllAuthors()
     {
   	    return readRepository.findAllEntites("authors");
     }
     
     public Optional<Element> getAuthorbyId(int id) throws ServiceResponseException 
     {
    	 if(!readRepository.validateID(id, "authors"))
    	 {
    		 throw ServiceResponseException.status(HttpStatus.BAD_REQUEST)
             .message("The given authorID " + id+" does not exist");
    	 }
   	     return Optional.ofNullable(readRepository.findElementById(id,"authors"));
     }
     
     public List<Element> getAllPosts()
     {
   	    return readRepository.findAllEntites("posts");
     }
     
     public Optional<Element> getPostbyId(int id)  throws ServiceResponseException 
     {
    	 if(!readRepository.validateID(id, "posts"))
    	 {
    		 throw ServiceResponseException.status(HttpStatus.BAD_REQUEST)
             .message("The given postID " + id+" does not exist");
    	 }
   	     return Optional.ofNullable(readRepository.findElementById(id,"posts"));
     }
     public Optional<List<Element>> getPostsbyParam(ElementParam param)  
     {
    	 return Optional.ofNullable(readRepository.findElementbyParam(param, "posts"));
     }
     public Optional<List<Element>> getAuthorsbyParam(ElementParam param)  
     {
    	 return Optional.ofNullable(readRepository.findElementbyParam(param, "authors"));
     }
     public List<Object> getAll()
     {
    	 return readRepository.findAllEntites();
     }

}
