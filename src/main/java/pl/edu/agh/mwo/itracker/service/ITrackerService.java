package pl.edu.agh.mwo.itracker.service;

import lombok.NoArgsConstructor;
import pl.edu.agh.mwo.itracker.Report3;
import pl.edu.agh.mwo.itracker.model.parser.ListingFiles;
import pl.edu.agh.mwo.itracker.model.Commands;
import pl.edu.agh.mwo.itracker.model.parser.ExcelParser;
import pl.edu.agh.mwo.itracker.model.parser.SimplestExcelParser;
import pl.edu.agh.mwo.itracker.model.parser.SimplestExcelParserForReport2;
import pl.edu.agh.mwo.itracker.model.report.Report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.util.List;

@NoArgsConstructor
public class ITrackerService {

    public void startTracking(Commands commandToResolve, String path, String from, String to)  throws FileNotFoundException {
        switch (commandToResolve) {
            case RAP1: {
                List<File> listOfFiles = ListingFiles.getAllFiles(new File(path));

                ExcelParser parser = new SimplestExcelParser(listOfFiles);
                Report report = parser.getReportOption1EmployeeProjectHours(from, to);
                report.setName(path);
                String summaryForConsole = report.getSummaryForConsole();
                System.out.println(summaryForConsole);
                break;
            }
            case RAP2: {
                List<File> listOfFiles = ListingFiles.getAllFiles(new File(path));

                ExcelParser parser = new SimplestExcelParserForReport2(listOfFiles);
                Report report = parser.getReportOption1EmployeeProjectHours(from, to);
                report.setName(path);
                String summaryForConsole = report.getSummaryForConsole();
                System.out.println(summaryForConsole);
                break;
            }
            case RAP3: {
                Report3.executeReport3(path);
                break;
            }
            case HELP: {
                System.out.println("Raport - osoby i ilość godzin: rap1 [<excel-path>] [from] [to]");
                System.out.println("Raport - projekt i ilość godzin: rap2 [<excel-path>] [from] [to]");
                System.out.println("Raport - pracownik, projekt i ilość godzin: rap3 [<excel-path>] [from] [to]");
                System.out.println();
                System.out.println("[from] - filtrowanie po numerze miesiąca - data początkowa");
                System.out.println("[to] - filtrowanie po numerze miesiąca - data końcowa (nie jest konieczna)");
                System.out.println();
                System.out.println("Example: rap1 'C:\\Users\\user\\Desktop' 10 - Raport 'osoby i ilość godzin' z października znajdujący się na podanej ścieżce");
                break;
            }
        }
    }
}
