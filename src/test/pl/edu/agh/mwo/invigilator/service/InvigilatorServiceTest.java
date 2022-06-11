package pl.edu.agh.mwo.invigilator.service;

import org.junit.Test;
import pl.edu.agh.mwo.invigilator.model.Commands;

import static org.junit.Assert.*;

public class InvigilatorServiceTest {

    @Test
    public void shouldGenerateReportVersion1() {
        //given
        InvigilatorService invigilatorService = new InvigilatorService();
        String path = "./src/main/resources/excel_parser_test_data1/";

        //when
        invigilatorService.startInvigilation(Commands.INV1, path);

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
        InvigilatorService invigilatorService = new InvigilatorService();
        String path = "./src/main/resources/excel_parser_test_data3/";

        //when
        invigilatorService.startInvigilation(Commands.INV1, path);

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
        InvigilatorService invigilatorService = new InvigilatorService();
        String path = "./src/main/resources/excel_parser_test_data4/";

        //when
        invigilatorService.startInvigilation(Commands.INV1, path);

        //then
        //should print:
        //Report type 1:
        //Created in: 2022-06-11 18:28:50 by micha
        //Title: ./src/main/resources/excel_parser_test_data4/
        //--------------------------------------
        //Nowak Piotr have 45.0 hours.
        //Kowalski Jan have 95.0 hours.
    }
}