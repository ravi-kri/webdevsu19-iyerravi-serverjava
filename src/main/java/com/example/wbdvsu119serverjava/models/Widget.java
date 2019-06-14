package com.example.wbdvsu119serverjava.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;


@Entity
@Table(name="widgets")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")

@JsonTypeInfo(
use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME,
include=As.PROPERTY, property="type"
)
@JsonSubTypes({
	@Type(name="HEADING",value=HeadingWidget.class),
	@Type(name="PARAGRAPH",value=ParagraphWidget.class),
	@Type(name="LIST",value=ListWidget.class),
	@Type(name="IMAGE",value=ImageWidget.class),
	@Type(name="LINK",value=LinkWidget.class),
	})
public class Widget {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int index;
	@ManyToOne
	@JsonIgnore
	private Topic topic;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
