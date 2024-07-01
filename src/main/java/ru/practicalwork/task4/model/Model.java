package ru.practicalwork.task4.model;

import ru.practicalwork.task4.operations.OperationsMake;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Model {
    private List<String> listModel = new ArrayList<>();

    public void addModel(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                this.listModel.add(str);
                System.out.println(str);
            }
        }
    }

    //    public List<FileData> getFileLines() {
//        return new ArrayList<>(fileLines);
//    }
//
//    public void setFileLines(List<FileData> fileLines) {
//        this.fileLines = new ArrayList<>(fileLines);
//    }
//
//    public void addLine(String fileName, String line) {
//        if (line.isBlank()) {
//            return;
//        }
//        String[] parts = line.split(" ");
//        Timestamp ts = null;
//        if (!parts[4].isBlank()) {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
//
//            try {
//                ts = new Timestamp(dateFormat.parse(parts[4]).getTime());
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        fileLines.add(new FileData(fileName, parts[0], parts[1], parts[2], parts[3], ts, parts[5]));
//    }

}
