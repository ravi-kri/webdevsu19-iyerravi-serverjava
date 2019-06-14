package com.example.wbdvsu119serverjava.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("IMAGE")
public class ImageWidget extends Widget{
	private String src;
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
}
