package pl.edu.agh.mwo.invigilator.employee;

import pl.edu.agh.mwo.invigilator.project.Project;

import java.util.Map;

public interface Employee {
    Project getProject(String projectName);

    Map<String, Project> getProjects();

    void setProject(Project project);
}
