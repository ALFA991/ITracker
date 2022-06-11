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
        String commandForReport1 = "";

        //when
        invigilatorService.startInvigilation(Commands.INV1);

        //then
        //should print:
        //Report type 1:
        //Kowalski Jan have 46.0 hours.
        //Nowak Piotr have 39.0 hours.
    }
}