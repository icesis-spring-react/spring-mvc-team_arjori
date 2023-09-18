package mvc.dynnav.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Project {
    private String title;
    private int StudentCount;

    @Value("#{T(mvc.dynnav.model.ProjectStatus).IN_PROGRESS}")
    private ProjectStatus status;

    public Project() {
    }

    public Project(String title, int studentCount, ProjectStatus status) {
        this.title = title;
        this.StudentCount = studentCount;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStudentCount() {
        return StudentCount;
    }

    public void setStudentCount(int studentCount) {
        StudentCount = studentCount;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
