package pl.edu.agh.mwo.itracker.service;

import org.junit.Test;
import pl.edu.agh.mwo.itracker.model.Commands;

public class ITrackerServiceTest {

    @Test
    public void shouldGenerateReportVersion1() {
        //given
        ITrackerService iTrackerService = new ITrackerService();
        String path = "./src/main/resources/excel_parser_test_data1/";

        //when
        iTrackerService.startTracking(Commands.RAP1, path, "", "");

        //then
        //should print:
        //Report type 1:
        //Created in: 2022-06-11 18:29:17 by micha
        //Title: ./src/main/resources/excel_parser_test_data1/
        //--------------------------------------
        //Nowak Piotr have 39.0 hours.
        //Kowalski Jan have 46.0 hours.
    }

    @Test
    public void shouldGenerateReportVersion1SubFolders() {
        //given
        ITrackerService iTrackerService = new ITrackerService();
        String path = "./src/main/resources/excel_parser_test_data3/";

        //when
        iTrackerService.startTracking(Commands.RAP1, path, "", "");

        //then
        //should print:
        //Report type 1:
        //Created in: 2022-06-11 18:29:03 by micha
        //Title: ./src/main/resources/excel_parser_test_data3/
        //--------------------------------------
        //Nowak Piotr have 39.0 hours.
        //Kowalski Janek have 46.0 hours.
        //Kowalski Jan have 46.0 hours.
    }

    @Test
    public void shouldGenerateReportVersion1ForSeveralMonths() {
        //given
        ITrackerService iTrackerService = new ITrackerService();
        String path = "./src/main/resources/excel_parser_test_data4/";

        //when
        iTrackerService.startTracking(Commands.RAP1, path, "", "");

        //then
        //should print:
        //Report type 1:
        //Created in: 2022-06-11 18:28:50 by micha
        //Title: ./src/main/resources/excel_parser_test_data4/
        //--------------------------------------
        //Nowak Piotr have 45.0 hours.
        //Kowalski Jan have 95.0 hours.
    }

    @Test
    public void shouldGenerateReportVersion2ForSeveralMonths() {
        //given
        ITrackerService iTrackerService = new ITrackerService();
        String path = "./src/main/resources/excel_parser_test_data4/";

        //when
        iTrackerService.startTracking(Commands.RAP2, path, "", "");

        //then
        //should print:
        //Report type 2:  (project/hours)
        //Created in: 2022-06-12 11:50:42 by micha
        //Title: ./src/main/resources/excel_parser_test_data4/
        //--------------------------------------
        //Projekt2 have 79.0 hours.
        //Projekt1 have 61.0 hours.
    }
}