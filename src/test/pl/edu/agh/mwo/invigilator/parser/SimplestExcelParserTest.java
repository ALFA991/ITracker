package pl.edu.agh.mwo.invigilator.parser;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class SimplestExcelParserTest {

    public static final String EXAMPLE_FILES = "./src/main/resources/excel_parser_test_data1";

    @Test
    public void shouldGetListOfExcelFilesToParse() {
        //given
        List<File> exampleFiles = readExampleData(EXAMPLE_FILES);
        ExcelParser parser = new SimplestExcelParser(exampleFiles);

        //when
        String listOfFiles = parser.getListOfFiles();

        //then
        Assert.assertEquals(getPaths(EXAMPLE_FILES), listOfFiles);

    }

    private List<File> readExampleData(String path) {
        File mainFolder = new File(path);
        List<File> files = Arrays.stream(mainFolder.listFiles()).toList();
        return files;
    }

    private String getPaths(String path) {
        StringBuilder result = new StringBuilder();
        result.append(new File("./src/main/resources/excel_parser_test_data1/Kowalski_Jan.xls").getAbsolutePath() + ";");
        result.append(new File("./src/main/resources/excel_parser_test_data1/Nowak_Piotr.xls").getAbsolutePath() + ";");
        return result.toString();
    }

}