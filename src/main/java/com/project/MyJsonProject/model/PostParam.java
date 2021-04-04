package com.project.MyJsonProject.model;

public class PostParam implements ElementParam {

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Post other = (Post) obj;
		if (author == null) {
			if (other.getTitle() != null)
				return false;
		} else if (!author.equals(other.getAuthor()))
			return false;
		if (title == null) {
			if (other.getTitle() != null)
				return false;
		} else if (!title.equals(other.getTitle()))
			return false;
		return true;
	}
	public PostParam(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	private String title;
	private String author;
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
	

}
