package com.bms.cs.classes;


import java.io.Serializable;

public class Notes implements Serializable {
    String title;
    String textM;

    public Notes(String title, String textM) {
        this.title = title;
        this.textM = textM;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextM() {
        return textM;
    }

    public void setTextM(String textM) {
        this.textM = textM;
    }
}
