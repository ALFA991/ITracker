package pl.edu.agh.mwo.itracker.model.parser;

import pl.edu.agh.mwo.itracker.model.report.Report;

public interface ExcelParser {
    String getListOfFiles();

    Report getReportOption1EmployeeProjectHours(String from, String to);
}
