package pl.edu.agh.mwo.invigilator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListingFiles {

    private void getAllFiles(String path, List<File> fileList) {
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
    }

    public List<File> main(String path, List<File> fileList) {
        fileList = new ArrayList<>();
        getAllFiles(path, fileList);
        return fileList;
    }

    public List<File> getListOfFiles(String path) {
        File[] mainPath = new File(path).listFiles();
        List<File> files = new ArrayList<>();

        for (File file : mainPath) {
            if (file.isFile() && file.getName().endsWith(".xls")) {
                files.add(file);
            }
        }

        return files;
    }
}