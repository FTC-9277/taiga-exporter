package net.hazmatrobotics.taigaexport;

import com.google.gson.Gson;
import net.hazmatrobotics.taigaexport.beans.HistoryItem;
import net.hazmatrobotics.taigaexport.beans.Root;
import net.hazmatrobotics.taigaexport.beans.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class TaigaExporter {
    public static Gson g = new Gson();
    static Root root;
    static Map<Date, String> map = new TreeMap<>();
    public static Map<Integer, String> usNameMap = new TreeMap<>();
    static PrintWriter mainWriter, refWriter;

    public static void main(String... args) throws FileNotFoundException {
        File f = new File("C:\\Users\\robotics9277\\Documents\\taiga-exporter\\data.json");
        FileReader r = new FileReader(f);
        mainWriter = new PrintWriter(new File("C:\\Users\\robotics9277\\Documents\\taiga-exporter\\out.txt"));
        refWriter = new PrintWriter(new File("C:\\Users\\robotics9277\\Documents\\taiga-exporter\\ref.txt"));

        root = g.fromJson(r, Root.class);

        for(Task t : root.getUser_stories()) {
            usNameMap.put(t.getRef(), t.getSubject());
            refWriter.println(t.getRef() + ": " + t.getSubject());
        }

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

        for(String m : map.values()) {
            mainWriter.println(m);
            System.out.println(m);
        }

        mainWriter.flush();

        refWriter.flush();
    }

    private static void handle(Task t, HistoryItem h) {
        if(h.toString(t) != null)
            map.put(h.getCreated_at(), h.toString(t));
    }
}
