package com.project.MyJsonProject.model;

public class AuthParam implements ElementParam {


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Author other = (Author) obj;
		if (firstName == null) {
			if (other.getFirstName() != null)
				return false;
		} else if (!firstName.equals(other.getFirstName()))
			return false;
		if (lastName == null) {
			if (other.getLastName() != null)
				return false;
		} else if (!lastName.equals(other.getLastName()))
			return false;
		return true;
	}

	private String firstName; 
	private String lastName;
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
	public AuthParam(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	} 
	

}
