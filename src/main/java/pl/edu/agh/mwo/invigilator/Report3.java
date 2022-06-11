package pl.edu.agh.mwo.invigilator;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Report3 {

    public static void executeReport3() throws FileNotFoundException {
        List<String> fileList = new ArrayList<>();
        String path = "/home/students/s/t/stefania/Downloads/invigilator-main/2021/";
        getAllFilesRep3(path, fileList);
    }
    private static List<String> getAllFilesRep3(String path, List<String> fileList) throws FileNotFoundException {
        File[] allFiles = new File(path).listFiles();
        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile() && file.getName().endsWith(".xls")) {
                    String filePath = file.getAbsolutePath();
                    printReport3(filePath);
                    fileList.add(file.getName());
                } else if (file.isDirectory()) {
                    getAllFilesRep3(file.getAbsolutePath(), fileList);
                }
            }
        }
        return fileList;
    }
    public static void printReport3(String filepath) throws FileNotFoundException {
        try{
            HSSFSheet sheet;
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filepath));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            int noOfSheets = wb.getNumberOfSheets();

            File file = new File(filepath);
            String fileName = file.getName();
            String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
            System.out.println("\nProjekty pracownika: " + fileNameWithoutExtension);
            for(int i = 0; i < noOfSheets; i++){
                sheet = wb.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                double sumOfHours = 0;
                System.out.print(sheetName + ": ");
                HSSFRow row = sheet.getRow(0);
                int rowNo = 1;
                while (sheet.getRow(rowNo) != null) {
                    sumOfHours += sheet.getRow(rowNo).getCell(2).getNumericCellValue();
                    rowNo++;
                }
                System.out.println(sumOfHours);

            }
            fs.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
