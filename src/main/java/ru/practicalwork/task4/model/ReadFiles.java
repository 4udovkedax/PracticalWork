package ru.practicalwork.task4.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {
    List<String> values = new ArrayList<>();

    public List<String> getValues() {
        return values;
    }

    public List<String> readingFromDir(File pathFile){
        if (pathFile.isDirectory()) {
            File[] files = pathFile.listFiles();

            if (files != null) {
                for (File f : files) {
                    List<String> newStr;
                    try {
                        newStr = Files.readAllLines(f.toPath());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    values.addAll(newStr);
                }
            }
            return values;
        }
        return new ArrayList<>();
    }
}
