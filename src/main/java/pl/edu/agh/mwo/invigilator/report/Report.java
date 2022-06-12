package pl.edu.agh.mwo.invigilator.report;

public interface Report {
    void addEmployeeName(String employeeName);

    void setTotalHours(double sumOfHours);

    void addDate(String date);

    public String get();
}
