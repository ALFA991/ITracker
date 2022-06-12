package pl.edu.agh.mwo.itracker.model.employee;

import pl.edu.agh.mwo.itracker.model.project.Project;

import java.util.Map;

public interface Employee {
    Project getProject(String projectName);

    Map<String, Project> getProjects();

    void setProject(Project project);
}
