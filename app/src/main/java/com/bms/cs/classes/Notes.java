package com.bms.cs.classes;


import java.io.Serializable;
import java.util.ArrayList;

public class Notes implements Serializable {
    String Title,description;
    int id;



    public Notes(String title, String description, int id) {
        Title = title;
        this.description = description;
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
