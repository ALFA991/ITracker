package pl.edu.agh.mwo.invigilator.parser;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.mwo.invigilator.report.Report;
import pl.edu.agh.mwo.invigilator.report.ReportEmployeeProjectHoursSimplest;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimplestExcelParserTest {

    public static final String EXAMPLE_FILES = "./src/main/resources/excel_parser_test_data1";
    public static final String EXAMPLE_FILE = "./src/main/resources/excel_parser_test_data2";

    @Test
    public void shouldGetListOfExcelFilesPathsToParse() {
        //given
        List<File> exampleFiles = readExampleData(EXAMPLE_FILES);
        ExcelParser parser = new SimplestExcelParser(exampleFiles);

        //when
        String listOfFiles = parser.getListOfFiles();

        //then
        Assert.assertEquals(getPathsSeveralFiles(), listOfFiles);
    }

    @Test
    public void shouldGetOneExcelFilePathToParse() {
        //given
        List<File> exampleFile = readExampleData(EXAMPLE_FILE);
        ExcelParser parser = new SimplestExcelParser(exampleFile);

        //when
        String listOfFiles = parser.getListOfFiles();

        //then
        Assert.assertEquals(getPathsSingleFile(), listOfFiles);
    }

    @Test
    public void shouldGetReport1() {
        //given
        List<File> exampleFile = readExampleData(EXAMPLE_FILE);
        ExcelParser parser = new SimplestExcelParser(exampleFile);

        //when
        List<Report> reports = parser.getReportsEmployeeProjectHours();
        System.out.println(reports);

        //then
        System.out.println(ReportEmployeeProjectHoursSimplest.getSummaryForConsole(reports));

    }
    @Test
    public void shouldGetReport2() {
        //given
        List<File> exampleFile = readExampleData(EXAMPLE_FILES);
        ExcelParser parser = new SimplestExcelParser(exampleFile);

        //when
        List<Report> reports = parser.getReportsEmployeeProjectHours();

        //then
        System.out.println(ReportEmployeeProjectHoursSimplest.getSummaryForConsole(reports));

    }

    private List<File> readExampleData(String path) {
        File mainFolder = new File(path);
        File[] files1 = mainFolder.listFiles();

        List<File> files = new ArrayList<>();
        for (File file : files1) {
            files.add(file);
        }
        return files;
    }

    private String getPathsSeveralFiles() {
        StringBuilder result = new StringBuilder();
        result.append(new File("./src/main/resources/excel_parser_test_data1/Kowalski_Janek.xls").getAbsolutePath() + ";");
        result.append(new File("./src/main/resources/excel_parser_test_data1/Nowak_Piotr.xls").getAbsolutePath() + ";");
        return result.toString();
    }
    private String getPathsSingleFile() {
        StringBuilder result = new StringBuilder();
        result.append(new File("./src/main/resources/excel_parser_test_data2/Kowalski_Janek.xls").getAbsolutePath() + ";");
        return result.toString();
    }

}