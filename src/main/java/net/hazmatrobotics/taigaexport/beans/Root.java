package net.hazmatrobotics.taigaexport.beans;

public class Root {
    String name;
    Task[] tasks;
    Task[] user_stories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public Task[] getUser_stories() {
        return user_stories;
    }

    public void setUser_stories(Task[] user_stories) {
        this.user_stories = user_stories;
    }
}
