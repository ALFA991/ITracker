package pl.edu.agh.mwo.itracker.model.report;

import pl.edu.agh.mwo.itracker.model.employee.Employee;
import pl.edu.agh.mwo.itracker.model.employee.SimpleEmployee;
import pl.edu.agh.mwo.itracker.model.project.Project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ReportProjectHoursSimplest implements Report {
    private String name;
    private Map<String, Employee> employees = new HashMap<>();

    public ReportProjectHoursSimplest(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setEmployee(String employeeName) {
        if (!employees.containsKey(employeeName)) {
            employees.put(employeeName, new SimpleEmployee(employeeName));
        }
    }

    @Override
    public void setProject(String employeeName, String projectName, double totalHours) {
        Employee employee = employees.get(employeeName);
        Project project = employee.getProject(projectName);
        double currentTotalHours = project.getTotalHours();
        project.setTotalHours(currentTotalHours + totalHours);
        employee.setProject(project);
    }

    @Override
    public String getSummaryForConsole() {
        StringBuilder summary = new StringBuilder();
        summary.append("Report type 2:\n");
        summary.append("Created in: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
        summary.append(" by " + System.getProperty("user.name") + "\n");
        summary.append("Title: " + name + "\n");
        summary.append("--------------------------------------\n");




//        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
//            summary.append(entry.getKey() + " have ");
//            Employee employee = entry.getValue();
//            Map<String, Project> projects = employee.getProjects();
//            double totalHoursForAllProjects = 0;
//            for (String projectName : projects.keySet()) {
//                Project project = projects.get(projectName);
//                totalHoursForAllProjects += project.getTotalHours();
//            }
//            summary.append(totalHoursForAllProjects);
//            summary.append(" hours.\n");
//        }
        return summary.toString();
    }

    @Override
    public String toString() {
        return "<Report 1 simplest: " + name + ">";
    }
}
