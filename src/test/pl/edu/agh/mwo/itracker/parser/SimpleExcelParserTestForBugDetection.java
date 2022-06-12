package pl.edu.agh.mwo.invigilator.parser;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.mwo.invigilator.model.parser.ExcelParser;
import pl.edu.agh.mwo.invigilator.model.parser.SimplestExcelParser;
import pl.edu.agh.mwo.invigilator.model.report.Report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SimpleExcelParserTestForBugDetection {

	@Test
	public void shouldGoFurtherWhenEmptyLineFound() {
		//given
		List<File> files = new ArrayList<>();
		files.add(new File("./src/main/resources/excel_parser_test_data5_errors/Kowalski_Jan_bug1_empty_line.xls"));
		ExcelParser parser = new SimplestExcelParser(files);

		//when
		Report reportType1 = parser.getReportOption1EmployeeProjectHours();
		String summaryForConsole = reportType1.getSummaryForConsole();
		System.out.println(summaryForConsole);

		//then
		Assert.assertTrue(summaryForConsole.contains("Kowalski Jan bug1 empty line have 15.0 hours."));

	}

	@Test
	public void shouldGoFurtherNoHoursFound() {
		//given

		List<File> files = new ArrayList<>();
		files.add(new File("./src/main/resources/excel_parser_test_data5_errors/Nowak_Piot_bug2_hrs_missing.xls"));
		ExcelParser parser = new SimplestExcelParser(files);

		//when
		Report reportType2 = parser.getReportOption1EmployeeProjectHours();
		String summaryForConsole = reportType2.getSummaryForConsole();
		System.out.println(summaryForConsole);

		//then
		Assert.assertTrue(summaryForConsole.contains("Nowak Piot bug2 hrs missing have 5.0 hours."));

	}

	@Test
	public void shouldGoFurtherHrsStringFormat() {
		//given

		List<File> files = new ArrayList<>();
		files.add(new File("./src/main/resources/excel_parser_test_data5_errors/Kowalski_Jan_bug3_hr_string_format.xls"));
		ExcelParser parser = new SimplestExcelParser(files);

		//when
		Report reportType3 = parser.getReportOption1EmployeeProjectHours();
		String summaryForConsole = reportType3.getSummaryForConsole();
		System.out.println(summaryForConsole);

		//then
		Assert.assertTrue(summaryForConsole.contains("Kowalski Jan bug3 hr string format have 15.0 hours."));

	}
}