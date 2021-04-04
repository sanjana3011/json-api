package com.project.MyJsonProject.model;

import org.json.simple.JSONObject;

public abstract class Element {
	private int ID;
	
	public void setID(int ID)
	{
		this.ID=ID;
	}
	public int getID()
	{
		return ID;
	}
	public abstract JSONObject getJSONObject();

}
