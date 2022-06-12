package pl.edu.agh.mwo.itracker.model.project;

public class SimpleProject implements Project {
    private String name;
    private double totalHours;


    public SimpleProject(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public double getTotalHours() {
        return totalHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleProject that = (SimpleProject) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "<Project: " + name + ">";
    }
}
