package net.hazmatrobotics.taigaexport;

import com.google.gson.Gson;
import net.hazmatrobotics.taigaexport.beans.HistoryItem;
import net.hazmatrobotics.taigaexport.beans.Root;
import net.hazmatrobotics.taigaexport.beans.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaigaExporter {
    public static Gson g = new Gson();
    static Root root;
    static Map<String, List<String>> map = new HashMap<>();

    public static void main(String... args) throws FileNotFoundException {
        File f = new File("C:\\Users\\robotics9277\\IdeaProjects\\taiga-export\\data.json");
        FileReader r = new FileReader(f);

        root = g.fromJson(r, Root.class);

        for (Task t : root.getTasks()) {
            for (HistoryItem h : t.getHistory()) {
                handle(t, h);
            }
        }

        for (Task t : root.getUser_stories()) {
            for (HistoryItem h : t.getHistory()) {
                handle(t, h);
            }
        }
    }

    private static void handle(Task t, HistoryItem h) {
        if (!map.containsKey(h.getSortDate())) {
            map.put(h.getSortDate(), new ArrayList<String>());
        }
        System.out.println(h.toString(t));
        map.get(h.getSortDate()).add(h.toString(t));
    }
}
