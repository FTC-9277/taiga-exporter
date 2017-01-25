package net.hazmatrobotics.taigaexport.beans;

import net.hazmatrobotics.taigaexport.TaigaExporter;

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

    public String toString(HistoryItem parent, Task grandparent) {
        String in = "";
        if (grandparent.getUser_story() != null) in = TaigaExporter.usNameMap.get(grandparent.getUser_story()) + ": ";

        if (assigned_to != null) return "Assigned " + in + grandparent.getSubject() + " to " + assigned_to[1];
        if (status != null)
            return "Changed Status of " + in + grandparent.getSubject() + " from " + parent.values.status.get("" + status[0]) + " to " + parent.values.status.get("" + status[1]);
        return null;
    }
}
