package com.example.todo;

import java.util.Date;

public class Task {

    /**
     * The title of the Task
     */
    private String title;
    /**
     * The description of the Task
     */
    private String description;
    /**
     * The start date of the Task
     */
    private Date dateStart;
    /**
     * The end date of the Task
     */
    private Date dateEnd;
    /**
     * The url of the Task
     */
    private String url;
    /**
     * The state of the Task
     */
    private int state;

    /**
     * The constructor of Task
     * @param title of the Task
     * @param description of the Task
     * @param ds of the Task
     * @param de of the Task
     * @param url of the Task
     * @param state of the Task
     */
    Task(String title, String description, Date ds, Date de, String url, int state){
        this.title = title;
        this.description = description;
        this.dateStart = ds;
        this.dateEnd = de;
        this.url = url;
        this.state = state;
    }

    /**
     * Get the title of the Task
     * @return the title
     */
    public int getState() {
        return state;
    }

    /**
     * Set the state of the Task
     * @param state of the Task
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * Get the title of the Task
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the Task
     * @param title of the Task
     */
    public void setTitle(String title) {
        title = title;
    }

    /**
     * Get the description of the Task
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the Task
     * @param description of the Task
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the start date of the Task
     * @return the start date
     */
    public Date getDateStart() {
        return dateStart;
    }

    /**
     * Set the start date of the Task
     * @param dateStart of the Task
     */
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * Get the end date of the Task
     * @return the end date
     */
    public Date getDateEnd() {
        return dateEnd;
    }

    /**
     * Set the end date of the Task
     * @param dateEnd of the Task
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * Get the url of the Task
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the url of the Task
     * @param url of the Task
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
