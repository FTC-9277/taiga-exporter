package net.hazmatrobotics.taigaexport.beans;

public class HistoryItem {
    String comment;
    String created_at;
    String[] user;
    Boolean is_snapshot;
    Task snapshot;
    Values values;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String[] getUser() {
        return user;
    }

    public void setUser(String[] user) {
        this.user = user;
    }

    public Boolean getIs_snapshot() {
        return is_snapshot;
    }

    public void setIs_snapshot(Boolean is_snapshot) {
        this.is_snapshot = is_snapshot;
    }

    public Task getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(Task snapshot) {
        this.snapshot = snapshot;
    }

    public Values getValues() {
        return values;
    }

    public void setValues(Values values) {
        this.values = values;
    }
}
