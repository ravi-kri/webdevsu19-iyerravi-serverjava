package com.example.wbdvsu119serverjava.models.layout;

import com.example.wbdvsu119serverjava.models.content.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import sun.misc.Launcher;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rows")
public class Row {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToOne
    @JsonIgnore
    private Page page;
    @OneToMany(mappedBy = "row")
    private List<Column> columns;

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

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
