package com.example.wbdvsu119serverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    
    @ManyToOne
    @JsonIgnore
    private Module module;
    
    @OneToMany(mappedBy = "lesson")
    private List<Topic> topics;

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
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

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void addToTopics(Topic t) {
		t.setLesson(this);
		if(t.getWidgets() != null) {
			for(Widget w: t.getWidgets()) {
				w.setTopic(t);
				t.addToWidgets(w);
			}
		}
		this.getTopics().add(t);
	}
}
