package com.example.wbdvsu119serverjava.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("PARAGRAPH")
public class ParagraphWidget extends Widget{
	private String text;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
