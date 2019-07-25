package com.sprinkle.cliksource.ClickSourceVideo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class User {
	
	
	//define fields
	@Id
	private ObjectId id;
	
	@Field(value="userid")
	private String userid; 
	
	private List<Link> links = new ArrayList<Link>();
	
	
	
	//define constructors 
	public User() {
		
	}
	
	public User(ObjectId id, String userid, List<Link> links) {
		super();
		this.id = id;
		this.userid = userid;
		this.links = links;
	}
	
	//define getters/setters


	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId objectId) {
		this.id = objectId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<Link> getLinks() {
		return links;
	}
	
	
	 public int findIndexByLinkid(String linkid) 
	    { 
	        int size = links.size(); 
	        return IntStream.range(0, size) 
	            .filter(i -> linkid.equals(links.get(i).getLinkid()))
	            .findFirst() 
	            .orElse(-1);
	    } 


	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(Link link) {
		link.setLinkid(links.size()+"");
		this.links.add(link);
	}
	
	public void deleteLink(int index) {
		this.links.remove(index);
		
	}
	
	// To String
	@Override
	public String toString() {
		return "VideoLibrary [id=" + id + ", userid=" + userid + ", Links=" + links + "]";
	}



}