package com.example.todo;

import java.util.Date;

public class Task {

    private String title;
    private String description;
    private Date dateStart;
    private Date dateEnd;
    private String url;
    private int state;

    Task(String title, String description, Date ds, Date de, String url, int state){
        this.title = title;
        this.state = state;
        this.dateStart = ds;
        this.dateEnd = de;
        this.url = url;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
