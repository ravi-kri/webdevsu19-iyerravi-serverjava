package com.example.wbdvsu119serverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @OneToMany(mappedBy = "course")
    private List<Module> modules;

    @ManyToOne
    @JsonIgnore
    private Faculty author;

    @Transient
    public String getAuthorName() {
        return author != null ? author.getFirstName() + " " + author.getLastName() : "";
    }

    public Faculty getAuthor() {
        return author;
    }

    public void setAuthor(Faculty author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    
    public void addToModules(Module m) {
		m.setCourse(this);
		if(m.getLessons() != null)
		{		
			for(Lesson l: m.getLessons())
			{
				l.setModule(m);
				m.addToLessons(l);
			}
		}
		this.modules.add(m);
	}
}
