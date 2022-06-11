package pl.edu.agh.mwo.invigilator.parser;

import pl.edu.agh.mwo.invigilator.report.Report;

import java.util.List;

public interface ExcelParser {
    String getListOfFiles();

    Report getReportsEmployeeProjectHours();
}
