package pl.edu.agh.mwo.invigilator.parser;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.mwo.invigilator.model.parser.ExcelParser;
import pl.edu.agh.mwo.invigilator.model.parser.SimplestExcelParser;
import pl.edu.agh.mwo.invigilator.model.report.Report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SimplestExcelParserTest {

    public static final String EXAMPLE_FILES = "./src/main/resources/excel_parser_test_data1";
    public static final String EXAMPLE_FILES_SERVARAL_MONTHS = "./src/main/resources/excel_parser_test_data4";
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
        Report report = parser.getReportOption1EmployeeProjectHours();
        report.setName("Test report 1");
        System.out.println(report);

        //then
        System.out.println(report.getSummaryForConsole());

    }
    @Test
    public void shouldGetReport1ForSeveralEmployees() {
        //given
        List<File> exampleFiles = readExampleData(EXAMPLE_FILES);
        ExcelParser parser = new SimplestExcelParser(exampleFiles);

        //when
        Report report = parser.getReportOption1EmployeeProjectHours();
        report.setName("Test report 2");

        //then
        System.out.println(report.getSummaryForConsole());

    }

    @Test
    public void shouldGetReport1ForSeveralMonths() {
        //given
        List<File> exampleFile = getListOfFilesForSeveralMonths1();
        ExcelParser parser = new SimplestExcelParser(exampleFile);

        //when
        Report report = parser.getReportOption1EmployeeProjectHours();
        report.setName("Test report 3: several months");

        //then
        System.out.println(report.getSummaryForConsole());

    }

    private List<File> getListOfFilesForSeveralMonths1() {
        List<File> files = new ArrayList<>();
        files.add(new File(EXAMPLE_FILES_SERVARAL_MONTHS + "/2012/01/Kowalski_Jan.xls"));
        files.add(new File(EXAMPLE_FILES_SERVARAL_MONTHS + "/2012/01/Nowak_Piotr.xls"));
        files.add(new File(EXAMPLE_FILES_SERVARAL_MONTHS + "/2012/02/Kowalski_Jan.xls"));
        files.add(new File(EXAMPLE_FILES_SERVARAL_MONTHS + "/2012/03/Kowalski_Jan.xls"));
        files.add(new File(EXAMPLE_FILES_SERVARAL_MONTHS + "/2012/03/Nowak_Piotr.xls"));
        return files;
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
        result.append(new File("./src/main/resources/excel_parser_test_data1/Kowalski_Jan.xls").getAbsolutePath() + ";");
        result.append(new File("./src/main/resources/excel_parser_test_data1/Nowak_Piotr.xls").getAbsolutePath() + ";");
        return result.toString();
    }
    private String getPathsSingleFile() {
        StringBuilder result = new StringBuilder();
        result.append(new File("./src/main/resources/excel_parser_test_data2/Kowalski_Jan.xls").getAbsolutePath() + ";");
        return result.toString();
    }

}