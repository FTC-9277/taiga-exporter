package net.hazmatrobotics.taigaexport.beans;

/**
 * Created by robotics9277 on 1/4/2017.
 */
public class Task {
    String milestone;
    String assigned_to;
    String created_date;
    String description;
    String[] user;
    String subject;
    String status;
    Integer user_story;
    HistoryItem[] history;

    public String getMilestone() {
        return milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getUser() {
        return user;
    }

    public void setUser(String[] user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUser_story() {
        return user_story;
    }

    public void setUser_story(Integer user_story) {
        this.user_story = user_story;
    }

    public HistoryItem[] getHistory() {
        return history;
    }

    public void setHistory(HistoryItem[] history) {
        this.history = history;
    }
}
