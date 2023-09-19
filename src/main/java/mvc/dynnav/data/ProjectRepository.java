package mvc.dynnav.data;

import mvc.dynnav.model.Project;
import mvc.dynnav.model.ProjectStatus;
import mvc.dynnav.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("projectRepository")
public class ProjectRepository {
    private static final List<Project> projects = new ArrayList<>();

    static {
        projects.add(new Project("Project 1", 10, ProjectStatus.IN_PROGRESS, TeacherRepository.find("alan_t")));
        projects.add(new Project("Project 2", 20, ProjectStatus.COMPLETED, TeacherRepository.find("alan_t")));
        projects.add(new Project("Project 3", 15, ProjectStatus.COMPLETED, TeacherRepository.find("alan_t")));
        projects.add(new Project("Project 4", 16, ProjectStatus.IN_PROGRESS, TeacherRepository.find("alan_t")));
        projects.add(new Project("Project 5", 20, ProjectStatus.IN_PROGRESS, TeacherRepository.find("alan_t")));
        projects.add(new Project("Project 6", 10, ProjectStatus.IN_PROGRESS, TeacherRepository.find("dijkstra1130")));
        projects.add(new Project("Project 7", 20, ProjectStatus.COMPLETED, TeacherRepository.find("dijkstra1130")));
        projects.add(new Project("Project 8", 15, ProjectStatus.COMPLETED, TeacherRepository.find("dijkstra1130")));
        projects.add(new Project("Project 9", 16, ProjectStatus.IN_PROGRESS, TeacherRepository.find("dijkstra1130")));
        projects.add(new Project("Project 10", 20, ProjectStatus.IN_PROGRESS, TeacherRepository.find("dijkstra1130")));
    }


    public static List<Project> findAll() {
        return projects;
    }

    public static Project findByTitle(String title) {
        for (Project project : projects) {
            if (project.getTitle().equalsIgnoreCase(title)) {
                return project;
            }
        }
        return null;
    }

    public static void add(Project project) {
        projects.add(project);
    }

    public static List<Project> findByAuthor(Teacher author) {
        ArrayList<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (project.getAuthor().equals(author)) {
                result.add(project);
            }
        }
        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }
    }
}
