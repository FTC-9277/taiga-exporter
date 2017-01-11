package net.hazmatrobotics.taigaexport.beans;

public class Diff {
    String[] assigned_to;
    Integer[] status;

    public String[] getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String[] assigned_to) {
        this.assigned_to = assigned_to;
    }

    public Integer[] getStatus() {
        return status;
    }

    public void setStatus(Integer[] status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if (assigned_to != null) return "Assigned to " + assigned_to[1];
        if (status != null) return "New status " + status[0] + " to " + status[1];
        return null;
    }
}
