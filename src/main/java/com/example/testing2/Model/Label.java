package com.example.testing2.Model;

import java.util.List;

public class Label {
    private int id;
    private String name;
    private List<Song> song;
    public Label() {
    }

    public Label(int id, String name, List<Song> song) {
        this.id = id;
        this.name = name;
        this.song = song;
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

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }
}
