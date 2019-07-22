package com.sprinkle.cliksource.ClickSourceVideo.entity;
import org.springframework.data.mongodb.core.mapping.Field;

public class Link {
	
	
	//define fields
	@Field(value="linkid")
	private String linkid;
	@Field(value="title")
	private String title;
	@Field(value="oEmbed")
	private String oEmbed;
	
	//define constructors 
	public Link() {
		
	}

	//define getters/setters
	public Link(String title, String oEmbed) {
		super();
		this.title = title;
		this.oEmbed = oEmbed;
	}

	public String getLinkid() {
		return linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getoEmbed() {
		return oEmbed;
	}

	public void setoEmbed(String oEmbed) {
		this.oEmbed = oEmbed;
	}


	// define toString
	@Override
	public String toString() {
		return "Link [linkid=" + linkid + ", title=" + title + ", oEmbed=" + oEmbed + "]";
	}

	
	

	

	

}
