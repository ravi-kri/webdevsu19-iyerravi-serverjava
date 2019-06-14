package com.example.wbdvsu119serverjava.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("LINK")
public class LinkWidget extends Widget{
	private String href;
	private String title;
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
