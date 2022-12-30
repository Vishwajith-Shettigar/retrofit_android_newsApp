package com.example.newsapp.Models;

import java.io.Serializable;

public class Source implements Serializable {

    String id="";

    String name="";

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
