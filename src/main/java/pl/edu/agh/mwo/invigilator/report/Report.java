package pl.edu.agh.mwo.invigilator.report;

public interface Report {
    void setName(String name);

    String getName();

    void setEmployee(String employee);

    void setProject(String employeeName, String projectName, double sumOfHours);

    String getSummaryForConsole();
}
