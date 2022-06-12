package pl.edu.agh.mwo.itracker.service;

import lombok.NoArgsConstructor;
import pl.edu.agh.mwo.itracker.model.parser.ListingFiles;
import pl.edu.agh.mwo.itracker.model.Commands;
import pl.edu.agh.mwo.itracker.model.parser.ExcelParser;
import pl.edu.agh.mwo.itracker.model.parser.SimplestExcelParser;
import pl.edu.agh.mwo.itracker.model.report.Report;

import java.io.File;
import java.util.List;

@NoArgsConstructor
public class ITrackerService {

    public void startTracking(Commands commandToResolve, String path) {
        switch (commandToResolve) {
            case RAP1: {
                List<File> listOfFiles = ListingFiles.getAllFiles(new File(path));

                ExcelParser parser = new SimplestExcelParser(listOfFiles);
                Report report = parser.getReportOption1EmployeeProjectHours();
                report.setName(path);
                String summaryForConsole = report.getSummaryForConsole();
                System.out.println(summaryForConsole);
                break;
            }
            case RAP2: {
                System.out.println("Wybrano raport 2. Jest w trakcie implementacji");
                break;
            }
            case RAP3: {
                System.out.println("Wybrano raport 3. Jest w trakcie implementacji");
                break;
            }
            case HELP: {
                System.out.println("Raport - osoby i ilość godzin: rap1 [<excel-path>]");
                System.out.println("Raport - projekt i ilość godzin: rap2 [<excel-path>]");
                System.out.println("Raport - pracownik, projekt i ilość godzin: rap3 [<excel-path>]");
                break;
            }
        }
    }
}
