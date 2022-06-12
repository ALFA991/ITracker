package pl.edu.agh.mwo.invigilator;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Report3 {
    static Map<String,EmployeeReport3> employeeMap = new HashMap<String,EmployeeReport3>();
    static List<EmployeeReport3> EmployeeReport3ObjList = new ArrayList<EmployeeReport3>();
    static EmployeeReport3 record;

    public static void main(String[] args) throws FileNotFoundException {
        executeReport3("/home/students/s/t/stefania/Documents/Projekt/invigilator/src/main");
        System.out.println("Report 3 results: \n");
        for (int i = 0;i < EmployeeReport3ObjList.size();i++){
            record = EmployeeReport3ObjList.get(i);
            System.out.println(record.toString());
        }
    }
    public static void executeReport3(String path) throws FileNotFoundException {
        List<String> fileList = new ArrayList<>();
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

            for(int i = 0; i < noOfSheets; i++){
                double sumOfHours = 0;
                sheet = wb.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                String keyTxt = fileNameWithoutExtension + sheetName;

                record = employeeMap.get(keyTxt);
                if (record == null){
                    record = new EmployeeReport3();
                    record.setEmployeeName(fileNameWithoutExtension);
                    EmployeeReport3ObjList.add(record);

                }
                String projName = record.getProjectName();
                if (projName == null){
                    record.setProjectName(sheetName);
                    employeeMap.put(keyTxt,record);
                    projName = sheetName;
                }
                if (!projName.contains(sheetName)){
                    record = new EmployeeReport3();
                    EmployeeReport3ObjList.add(record);
                    record.setEmployeeName(fileNameWithoutExtension);
                    record.setProjectName(sheetName);
                    employeeMap.put(keyTxt,record);

                }





                HSSFRow row = sheet.getRow(0);
                int rowNo = 1;
                while (sheet.getRow(rowNo) != null) {
                    double hours = sheet.getRow(rowNo).getCell(2).getNumericCellValue();
                    sumOfHours += sheet.getRow(rowNo).getCell(2).getNumericCellValue();
                    record.setWorkedHours(sumOfHours);
                    rowNo++;
                }
                //System.out.println(sumOfHours + " hours.");

            }
            fs.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
