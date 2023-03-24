package com.example.todo;

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
    private String startDate;
    /**
     * The end date of the Task
     */
    private String endDate;
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
    Task(String title, String description, String ds, String de, String url, int state){
        this.title = title;
        this.description = description;
        this.startDate = ds;
        this.endDate = de;
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
    public String getStartDate() {
        return startDate;
    }

    /**
     * Set the start date of the Task
     * @param startDate of the Task
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Get the end date of the Task
     * @return the end date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Set the end date of the Task
     * @param endDate of the Task
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
