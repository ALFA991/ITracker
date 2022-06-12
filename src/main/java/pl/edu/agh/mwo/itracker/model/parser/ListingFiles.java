package pl.edu.agh.mwo.itracker.model.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListingFiles {

    public static List<File> getAllFiles(File path) {
        File[] allFiles = path.listFiles();
        List<File> fileList = new ArrayList<>();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile() && file.getName().endsWith(".xls")) {
                    fileList.add(file);
                } else if (file.isDirectory()) {
                    fileList.addAll(getAllFiles(file));
                }
            }
        }
        return fileList;
    }
}