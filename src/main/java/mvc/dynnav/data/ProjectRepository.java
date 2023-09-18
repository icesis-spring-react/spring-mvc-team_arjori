package mvc.dynnav.data;

import mvc.dynnav.model.Project;
import mvc.dynnav.model.ProjectStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("projectRepository")
public class ProjectRepository {
    private static List<Project> projects = new ArrayList<>();

    static {
        projects.add(new Project("Project 1", 10, ProjectStatus.IN_PROGRESS));
        projects.add(new Project("Project 2", 20, ProjectStatus.COMPLETED));
        projects.add(new Project("Project 3", 15, ProjectStatus.COMPLETED));
        projects.add(new Project("Project 4", 16, ProjectStatus.IN_PROGRESS));
        projects.add(new Project("Project 5", 20, ProjectStatus.IN_PROGRESS));
    }


    public List<Project> getAllProjects() {
        return projects;
    }

    public Project getProjectByTitle(String title) {
        for (Project project : projects) {
            if (project.getTitle().equalsIgnoreCase(title)) {
                return project;
            }
        }
        return null;
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}
