package pl.edu.agh.mwo.invigilator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListingFiles {

    public List<File> getAllFiles(String path, List<File> fileList) {
        File[] allFiles = new File(path).listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile() && file.getName().endsWith(".xlsx")) {
                    fileList.add(file);
                } else if (file.isDirectory()) {
                    getAllFiles(file.getAbsolutePath(), fileList);
                }
            }
        }
        return fileList;
    }

    private void main(String[] args) {
        List<File> fileList = new ArrayList<>();
        getAllFiles("", fileList);
    }
}