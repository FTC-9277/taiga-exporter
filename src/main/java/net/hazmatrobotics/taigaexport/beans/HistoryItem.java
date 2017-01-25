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

        String parentProj = "";
        if (parent.getUser_story() != null) parentProj = TaigaExporter.usNameMap.get(parent.getUser_story()) + ": ";

        if (comment.trim().length() > 0)
            return leader + user[1] + " commented on " + parentProj + parent.getSubject() + " - " + comment.trim();
        if (is_snapshot) {
            if(parent.getUser_story() != null)
                return leader + "Created Task " + parentProj +
                        parent.getSubject();
            else
                return leader + "Created Project " + parent.getSubject();
        }
        if (diff.toString(this, parent) != null) return leader + diff.toString(this, parent);
        return null;
    }
}
