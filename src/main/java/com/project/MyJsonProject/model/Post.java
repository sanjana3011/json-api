package com.project.MyJsonProject.model;

import javax.persistence.Entity;

import org.json.simple.JSONObject;


public class Post extends Element {
	private String title;
	private String author;
	private int views;
	private int reviews;
	private int ID;

	public Post(int ID, String title, String author, int views, int reviews) {
		this.ID=ID;
		this.title = title;
		this.author = author;
		this.views = views;
		this.reviews = reviews;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJSONObject()
	{
		JSONObject obj=new JSONObject();
		obj.put("title", getTitle());
		obj.put("author",getAuthor());
		obj.put("views", getViews());
		obj.put("reviews",getReviews());
		obj.put("id", getID());
		return obj;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
}
