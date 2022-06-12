package pl.edu.agh.mwo.invigilator.report;

import java.util.List;

public class ReportEmployeeProjectHoursSimplest implements Report{
    private double hours;
    private String employee;
    private String date;

    @Override
    public void setTotalHours(double totalHours) {
        hours = totalHours;
    }

    @Override
    public void addDate(String date) {
        date=date;
    }

    @Override
    public void addEmployeeName(String employeeName) {
        employee = employeeName;
    }

    @Override
    public String get() {
        return employee + " have " + hours + " hours.";
    }

    public static String getSummaryForConsole(List<Report> reports) {
        StringBuilder result = new StringBuilder();
        result.append("Report type 1:\n");
        for (Report report : reports) {
            result.append(report.get() + "\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "ReportEmployeeProjectHoursSimplest{" +
                "hours=" + hours +
                ", employee='" + employee + '\'' +
                '}';
    }
}
