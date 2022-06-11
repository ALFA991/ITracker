package pl.edu.agh.mwo.invigilator.parser;

import java.io.File;
import java.util.List;

public class SimplestExcelParser implements ExcelParser {
    private List<File> files;

    public SimplestExcelParser(List<File> files) {
        this.files = files;
    }

    @Override
    public String getListOfFiles() {
        StringBuilder result = new StringBuilder();
        for (File file : files) {
            result.append(file.getAbsoluteFile());
            result.append(";");
        }
        return result.toString();
    }
}
