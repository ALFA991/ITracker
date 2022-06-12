package pl.edu.agh.mwo.itracker;

public class EmployeeReport3 {
    public String employeeName;
    public String ProjectName;
    public double workedHours;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }


    @Override
    public String toString() {
        return
                "Employee Name: " + employeeName +
                ", ProjectName: " + ProjectName +
                ", Worked Hours: " + workedHours;
    }
}
