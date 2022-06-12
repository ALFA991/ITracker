package pl.edu.agh.mwo.invigilator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListingFiles {

    private static void getAllFiles(String path, List<String> fileList) {
        File[] allFiles = new File(path).listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile() && file.getName().endsWith(".xlsx")) {
                    fileList.add(file.getName());
                } else if (file.isDirectory()) {
                    getAllFiles(file.getAbsolutePath(), fileList);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> fileList = new ArrayList<>();

        getAllFiles("", fileList);
        fileList.add("C:\\Users\\Basia\\invigilator\\src\\main\\resources\\excel_parser_test_data1\\Kowalski_Jan.xls");
        System.out.println(fileList);
    }
}