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
    private Map<Project, Double> projectTotalHours = new HashMap<>();

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

//        double total = currentTotalHours + totalHours;
//        Double currentTotalHoursForProject = projectTotalHours.getOrDefault(project, 0.0);
//        projectTotalHours.put(project, total + currentTotalHoursForProject);
    }

    @Override
    public String getSummaryForConsole() {
        StringBuilder summary = new StringBuilder();
        summary.append("Report type 2:  (project/hours)\n");
        summary.append("Created in: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
        summary.append(" by " + System.getProperty("user.name") + "\n");
        summary.append("Title: " + name + "\n");
        summary.append("--------------------------------------\n");

        setProjectTotalHours();

        for (Project project : projectTotalHours.keySet()) {
            summary.append(project.getName());
            summary.append(" have ");
            summary.append(projectTotalHours.get(project));
            summary.append(" hours.\n");
        }
        return summary.toString();
    }

    private void setProjectTotalHours() {
        for (String emName : employees.keySet()) {
            Employee employee = employees.get(emName);
            Map<String, Project> projects = employee.getProjects();
            for (String projectName : projects.keySet()) {
                Project project = projects.get(projectName);
                double totalHours = project.getTotalHours();

                Double currentTotalHours = projectTotalHours.getOrDefault(project, 0.0);
                projectTotalHours.put(project, currentTotalHours + totalHours);
            }
        }
    }

    @Override
    public String toString() {
        return "<Report 2 simplest: " + name + ">";
    }
}
