package com.project.MyJsonProject.repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.project.MyJsonProject.model.Author;
import com.project.MyJsonProject.model.Element;
import com.project.MyJsonProject.model.Post;


@Repository
public class WriteRepository extends JSONRepository  {
	public void filewriter(JSONObject jsonObject) {
		try {
			String path=System.getProperty("user.home")+"/store.json";
		    File customDir = new File(path);
			 //OutputStream outputStream = new FileOutputStream(path); 
			 //Writer outputStreamWriter = new OutputStreamWriter(outputStream);  
			 //outputStreamWriter.write(jsonObject.toJSONString());
			 //outputStreamWriter.close();
		    FileWriter writer=new FileWriter(customDir);
		    writer.write(jsonObject.toJSONString());
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean addEntity(Element element, String type)
	{
		    if(!checkUniqueID(element.getID(),type))
		    {
			JSONObject obj=getElementJsonArray();
			JSONArray array=(JSONArray) obj.get(type);
			array.add(element.getJSONObject());
			obj.put(type, array);
			filewriter(obj);
			return true;
		    }
		    return false;
	}
	
	public boolean checkUniqueID(int ID, String type)
	{
		JSONObject obj=getElementJsonArray();
		JSONArray array=(JSONArray) obj.get(type);
		for(int i=0;i<array.size();i++)
		{
			JSONObject key=(JSONObject) array.get(i);
			Long id=(Long) key.get("id");
			if(id.intValue()==ID)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteEntity(String element, int id)
	{
		if(checkUniqueID(id,element))
	    {
			JSONObject obj=getElementJsonArray();
			JSONArray array=(JSONArray) obj.get(element);
			for(int i=0;i<array.size();i++)
			{
				JSONObject key=(JSONObject) array.get(i);
				Long ID=(Long) key.get("id");
				if(ID.intValue()==id)
				{
					array.remove(i);
				break;
				}
			}
			obj.put(element, array);
			filewriter(obj);
			return true;
	    }
		return false;
	}
	
	public boolean updateEntity(int id, Map<String,Object> update, String element)
	{
		if(checkUniqueID(id,element) && !update.containsKey("id"))
	    {
			JSONObject obj=getElementJsonArray();
			JSONArray array=(JSONArray) obj.get(element);
			for(int i=0;i<array.size();i++)
			{
				JSONObject key=(JSONObject) array.get(i);
				Long ID=(Long) key.get("id");
				if(ID.intValue()==id)
				{
					for(String str: update.keySet())
					{
						key.put(str, update.get(str));
					}
				}
			}
			obj.put(element, array);
			filewriter(obj);
			return true;
	    }
		return false;
	}
	
	public boolean putEntity(int id, Element element, String type)
	{     if(checkUniqueID(id,type))
         {
		JSONObject obj=getElementJsonArray();
		JSONArray array=(JSONArray) obj.get(type);
		for(int i=0;i<array.size();i++)
		{
			JSONObject key=(JSONObject) array.get(i);
			Long ID=(Long) key.get("id");
			if(ID.intValue()==id)
			{
				array.remove(i);
				array.add(element.getJSONObject());
				break;
			}
		}
		obj.put(type, array);
		filewriter(obj);
		return true;
    }
	return false;
	}

	
	
	
}
