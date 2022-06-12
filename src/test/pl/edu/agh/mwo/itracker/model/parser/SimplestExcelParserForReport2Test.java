package pl.edu.agh.mwo.itracker.model.parser;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.mwo.itracker.model.report.Report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SimplestExcelParserForReport2Test {
    public static final String EXAMPLE_FILES = "./src/main/resources/excel_parser_test_data1";
    public static final String EXAMPLE_FILES_SERVARAL_MONTHS = "./src/main/resources/excel_parser_test_data4";
    public static final String EXAMPLE_FILE = "./src/main/resources/excel_parser_test_data2";


    @Test
    public void shouldGetListOfExcelFilesPathsToParse() {
        //given
        List<File> exampleFiles = readExampleData(EXAMPLE_FILES);
        ExcelParser parser = new SimplestExcelParserForReport2(exampleFiles);

        //when
        String listOfFiles = parser.getListOfFiles();

        //then
        Assert.assertEquals(getPathsSeveralFiles(), listOfFiles);
    }


    @Test
    public void shouldGetOneExcelFilePathToParse() {
        //given
        List<File> exampleFile = readExampleData(EXAMPLE_FILE);
        ExcelParser parser = new SimplestExcelParserForReport2(exampleFile);

        //when
        String listOfFiles = parser.getListOfFiles();

        //then
        Assert.assertEquals(getPathsSingleFile(), listOfFiles);
    }

    @Test
    public void shouldGetReportProjectHoursForSingleExcelFile() {
        //given
        List<File> exampleFile = readExampleData(EXAMPLE_FILE);
        ExcelParser parser = new SimplestExcelParserForReport2(exampleFile);

        //when
        Report report = parser.getReportOption1EmployeeProjectHours();
        report.setName("Test report 2");
        System.out.println(report);

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