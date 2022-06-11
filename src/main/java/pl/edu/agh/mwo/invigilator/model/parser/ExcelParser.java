package pl.edu.agh.mwo.invigilator.model.parser;

import pl.edu.agh.mwo.invigilator.model.report.Report;

public interface ExcelParser {
    String getListOfFiles();

    Report getReportOption1EmployeeProjectHours();
}
