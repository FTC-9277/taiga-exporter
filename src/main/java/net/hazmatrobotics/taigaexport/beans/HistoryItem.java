package net.hazmatrobotics.taigaexport.beans;

import net.hazmatrobotics.taigaexport.TaigaExporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryItem {
    String comment;
    Date created_at;
    String[] user;
    Boolean is_snapshot;
    Task snapshot;
    Values values;
    Diff diff;

    static DateFormat hr_df = new SimpleDateFormat("w, MMM dd");
    static SimpleDateFormat df = new SimpleDateFormat("D:yyyy");

    public Diff getDiff() {
        return diff;
    }

    public void setDiff(Diff diff) {
        this.diff = diff;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
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

    public String getSortDate() {
        return df.format(created_at);
    }

    public String toString(Task parent) {
        String leader = hr_df.format(created_at) + ": ";
        if (comment.trim().length() > 0) return leader + parent.subject + ", " + user[1] + " commented - " + comment.trim();
        if (is_snapshot) {
            if(parent.getUser_story() != null)
                return leader + "Created Task - " + parent.getSubject() + " in " +
                        TaigaExporter.usNameMap.get(parent.getUser_story());
            else
                return leader + "Created Task - " + parent.getSubject();
        }
        if (diff.toString(this) != null) return leader + parent.subject + " - " + diff.toString(this);
        return null;
    }
}
