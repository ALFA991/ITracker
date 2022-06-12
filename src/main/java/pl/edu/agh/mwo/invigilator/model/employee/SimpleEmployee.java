package pl.edu.agh.mwo.invigilator.model.employee;

import pl.edu.agh.mwo.invigilator.model.project.Project;
import pl.edu.agh.mwo.invigilator.model.project.SimpleProject;

import java.util.HashMap;
import java.util.Map;

public class SimpleEmployee implements Employee {
    private final String name;
    private final Map<String, Project> projects = new HashMap<>();

    public SimpleEmployee(String name) {
        this.name = name;
    }

    @Override
    public void setProject(Project project) {
        projects.put(project.getName(), project);
    }

    @Override
    public Project getProject(String projectName) {
        Project project = projects.getOrDefault(projectName, new SimpleProject(projectName));
        return project;
    }

    @Override
    public Map<String, Project> getProjects() {
        return projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleEmployee that = (SimpleEmployee) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "<Employee: " + name + ">";
    }
}
