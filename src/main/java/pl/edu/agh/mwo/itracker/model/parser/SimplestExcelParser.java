package pl.edu.agh.mwo.itracker.model.parser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import pl.edu.agh.mwo.itracker.DateChecker;
import pl.edu.agh.mwo.itracker.model.report.Report;
import pl.edu.agh.mwo.itracker.model.report.ReportEmployeeProjectHoursSimplest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class SimplestExcelParser implements ExcelParser {
	private final static int ROW_ID_DATE = 0;
	private final static int ROW_ID_TASK = 1;
	private final static int ROW_ID_HOURS = 2;
	String regex = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-](\\d{4})$";
	DateChecker dc = new DateChecker(regex);
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

	@Override
	public Report getReportOption1EmployeeProjectHours() {
		Report report = new ReportEmployeeProjectHoursSimplest("");

		for (File file : files) {
			String employeeName = file.getName();
			employeeName = employeeName.replaceAll(".xls", "");
			employeeName = employeeName.replaceAll("_", " ");
			report.setEmployee(employeeName);

			Workbook workbook;
			try (FileInputStream fileInputStream = new FileInputStream(file)) {
				workbook = new HSSFWorkbook(fileInputStream);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			Iterator<Sheet> sheetIterator = workbook.sheetIterator();

			while (sheetIterator.hasNext()) {
				double sumOfHours = 0;
				Sheet sheet = sheetIterator.next();
				String projectName = sheet.getSheetName();

				int rowId = 0;

				while (true) {
					Row row = sheet.getRow(rowId);
					if (row == null) {
						break;
					}
					Cell cellDate = row.getCell(ROW_ID_DATE);

//					cellDate.setCellType(Cell.CELL_TYPE_STRING);

//					DataFormatter dataFormatter = new DataFormatter();
//					String formattedCellStr = dataFormatter.formatCellValue(cellDate);

					if (cellDate == null) {
						rowId++;
						continue;
					} else if (cellDate.getCellType() == CellType.NUMERIC && !dc.check(cellDate.getDateCellValue())) {
						rowId++;
						continue;
					} else if (cellDate.getCellType() == CellType.STRING && !dc.check(cellDate.getStringCellValue())) {
						rowId++;
						continue;
					}

					Cell cell = row.getCell(ROW_ID_HOURS);
					if (cell == null) {
						break;
					}
					CellType cellType = cell.getCellType();
					if (cellType.equals(CellType.NUMERIC)) {
						double value = cell.getNumericCellValue();
						sumOfHours += value;
					}




					rowId++;
				}
				report.setProject(employeeName, projectName, sumOfHours);
			}
		}
		return report;
	}


	private boolean isHoursValue(String value) {
		try {
			double v = Double.parseDouble(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
