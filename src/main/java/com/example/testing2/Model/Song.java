package com.example.testing2.Model;

import java.util.List;

public class Song {
    private int id;
    private String name;
    private List<Label> labels;
    public Song() {
    }
    public Song(int id, String name, List<Label> labels) {
        this.id = id;
        this.name = name;
        this.labels = labels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
