package net.hazmatrobotics.taigaexport.beans;

import java.lang.reflect.Array;
import java.util.Map;

public class Values {
    Map<String, String> status;
    Map<String, String> milestone;
    String[] users;

    public Map<String, String> getStatus() {
        return status;
    }

    public void setStatus(Map<String, String> status) {
        this.status = status;
    }

    public Map<String, String> getMilestone() {
        return milestone;
    }

    public void setMilestone(Map<String, String> milestone) {
        this.milestone = milestone;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }
}
