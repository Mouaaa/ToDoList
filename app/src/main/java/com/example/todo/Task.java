package com.example.todo;

public class Task {

    /**
     * The title of the Task
     */
    private String title;

    /**
     * The priority of the Task
     */
    private String priority;

    /**
     * The start date of the Task
     */
    private String startDate;

    /**
     * The end date of the Task
     */
    private String endDate;

    /**
     * The state of the Task
     */
    private String state;

    /**
     * The description of the Task
     */
    private String description;

    /**
     * The url of the Task
     */
    private String url;


    /**
     * The constructor of Task
     * @param title of the Task
     * @param priority of the Task
     * @param ds of the Task
     * @param de of the Task
     * @param state of the Task
     * @param description of the Task
     * @param url of the Task
     */
    Task(String title, String priority, String ds, String de, String state, String description, String url){
        this.title = title;
        this.priority = priority;
        this.startDate = ds;
        this.endDate = de;
        this.state = state;
        this.description = description;
        this.url = url;
    }

    /**
     * Get the title of the Task
     * @return the title
     */
    public String getState() {
        return state;
    }

    /**
     * Set the state of the Task
     * @param state of the Task
     */
    public void setState(String state) {
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

    /**
     * Get the priority of the Task
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Set the priority of the Task
     * @param priority of the Task
     */
    public void setPriority(String priority) {this.priority = priority;}

}
