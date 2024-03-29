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
     * The progress of the Task
     */
    private String progress;

    /**
     * The context of the Task
     */
    private String context;

    /**
     * The description of the Task
     */
    private String description;

    /**
     * The url of the Task
     */
    private String url;

    /**
     * Refers to the checkbox of the task
     */
    private boolean isSelected;

    /**
     * The constructor of Task
     * @param title of the Task
     * @param priority of the Task
     * @param ds of the Task
     * @param de of the Task
     * @param progress of the Task
     * @param context of the Task
     * @param description of the Task
     * @param url of the Task
     */
    Task(String title, String priority, String ds, String de, String progress, String context, String description, String url){
        this.title = title;
        this.priority = priority;
        this.startDate = ds;
        this.endDate = de;
        this.progress = progress;
        this.context = context;
        this.description = description;
        this.url = url;
        this.isSelected = false;
    }

    /**
     * Get the title of the Task
     * @return the title
     */
    public String getProgress() {
        return progress;
    }

    /**
     * Set the state of the Task
     * @param progress of the Task
     */
    public void setProgress(String progress) {
        this.progress = progress;
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
        this.title = title;
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

    /**
     * Get the context of the Task
     * @return the context
     */
    public String getContext() {
        return context;
    }

    /**
     * Set the context of the Task
     * @param context of the Task
     */
    public void setContext(String context) {this.context = context;}

    /**
     * Get isSelected value of the Task
     * @return if the Task isSelected
     */
    public boolean isSelected() {return isSelected;}

    /**
     * Set if the Task isSelected or not
     * @param selected
     */
    public void setSelected(boolean selected) {isSelected = selected;}

    /**
     * Get url value of the Task
     * @return the url of the Task
     */
    public String getUrl() {return url;}

    /**
     * Set url of the Task
     * @param url
     */
    public void setUrl(String url) {this.url = url;}

}
