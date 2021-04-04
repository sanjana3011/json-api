package com.project.MyJsonProject.model;

import javax.persistence.Entity;

import org.json.simple.JSONObject;


public class Author extends Element{
	private String firstName; 
	private String lastName; 
	private int post;
	private int ID;
	
	public Author(int ID, String firstName, String lastName, int post) {
		this.ID=ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.post = post;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPosts() {
		return post;
	}
	public void setPosts(int post) {
		this.post = post;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJSONObject()
	{
		JSONObject obj=new JSONObject();
		obj.put("firstName", getFirstName());
		obj.put("lastName", getLastName());
		obj.put("id", getID());
		obj.put("post", getPosts());
		return obj;
		
	}

	

}
