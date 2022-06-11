package pl.edu.agh.mwo.invigilator.report;

public class ReportEmployeeProjectHoursSimplest implements Report{
    private double hours;
    private String employee;

    @Override
    public void setTotalHours(double totalHours) {
        hours = totalHours;
    }

    @Override
    public void addEmployeeName(String employeeName) {
        employee = employeeName;
    }

    @Override
    public String toString() {
        return "ReportEmployeeProjectHoursSimplest{" +
                "hours=" + hours +
                ", employee='" + employee + '\'' +
                '}';
    }
}
