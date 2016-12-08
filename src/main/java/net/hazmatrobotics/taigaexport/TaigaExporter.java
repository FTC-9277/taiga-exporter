package net.hazmatrobotics.taigaexport;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaigaExporter {
    public static Gson g = new Gson();

    public static void main(String... args) throws FileNotFoundException {
        File f = new File("C:\\Users\\robotics9277\\IdeaProjects\\taiga-export\\data.json");
        FileReader r = new FileReader(f);
    }
}
