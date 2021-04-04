package com.project.MyJsonProject.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;
import com.project.MyJsonProject.model.Element;
import com.project.MyJsonProject.model.ElementParam;

@Repository
public class ReadRepository extends JSONRepository {

	public List<Element> findAllEntites(String element){
		List<Element> elementList =new ArrayList<Element>();
		for(Object obj: getElementJsonArray(element)) { 
			elementList.add(parseElementObject((JSONObject)obj, element));   }
		return elementList;
	}
	
	public Element findElementById(int elementId, String element){
		List<Element> elementList=findAllEntites(element);
		for(Element element1: elementList) {
			if(element1.getID()==elementId)
			return element1;
		}
		return null;
	}
	
	public List<Element> findElementbyParam(ElementParam param, String element)
	{
		List<Element> filteredList=new ArrayList<>();
		List<Element> elementList=findAllEntites(element);
		for(Element element1: elementList)
		{
			
			if(param.equals(element1))
			{
				filteredList.add(element1);
			}
		}
		return filteredList;
	}
	public boolean validateID(int ID, String type)
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
	
	public List<Object> findAllEntites()
	{
		JSONObject allEntities= getElementJsonArray();
		return Arrays.asList(allEntities);
	}

}
