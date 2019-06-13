package com.example.wbdvsu119serverjava.models.content;

import com.example.wbdvsu119serverjava.models.layout.Column;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.stream.Collectors;

@Entity
@Table(name="widgets")
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type = "HEADING";
    private String text = "New Widget";
    private Integer size = 3;
    @ManyToOne
    @JsonIgnore
    private com.example.wbdvsu119serverjava.models.layout.Column column;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public com.example.wbdvsu119serverjava.models.layout.Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }
}
