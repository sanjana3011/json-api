package com.project.MyJsonProject.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ResourceUtils;

import com.project.MyJsonProject.model.Author;
import com.project.MyJsonProject.model.Element;
import com.project.MyJsonProject.model.Post;

public class JSONRepository {
	
	public JSONArray getElementJsonArray(String element) {
		 try {
			    JSONParser parser = new JSONParser();
			    String path=System.getProperty("user.home")+"/store.json";
			    File customDir = new File(path);
			    //InputStream in = getClass().getResourceAsStream(path);
			    //BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			    FileReader reader=new FileReader(customDir);
				Object obj = parser.parse(reader);
				JSONObject jsonObject=(JSONObject)obj;
				JSONArray elements= (JSONArray) (jsonObject.get(element));
				reader.close();
				return elements;
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return null;
	}
	public JSONObject getElementJsonArray() {
		 try {
			    JSONParser jsonParser = new JSONParser();
			    String path=System.getProperty("user.home")+"/store.json";
			    File customDir = new File(path);
			    //InputStream in = getClass().getResourceAsStream(path);
			    //BufferedReader reader = new BufferedReader(new InputStreamReader(in));;
			    FileReader reader=new FileReader(customDir);
				JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);
				reader.close();
				return jsonObject;
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return null;
	}
	
	public Element parseElementObject(JSONObject object, String element)
	{
		if(element.equals("authors"))
		{
			int id=((Long) object.get("id")).intValue();;
			String firstName=(String) object.get("firstName");
			String lastName=(String) object.get("lastName");
			int posts=((Long) object.get("post")).intValue();
			return new Author(id,firstName,lastName, posts);
		}
		if(element.equals("posts"))
		{
			int ID=((Long) object.get("id")).intValue();
			String title=(String) object.get("title");
			String author=(String) object.get("author");
			int views=((Long) object.get("views")).intValue();
			int reviews=((Long) object.get("reviews")).intValue();
			return new Post(ID,title,author,views,reviews);
		}
		return null;
	}
		
		
}
