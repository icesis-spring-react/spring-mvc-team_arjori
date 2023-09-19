package mvc.dynnav.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Project {
    private String title;
    private int studentCount;

    @Value("#{T(mvc.dynnav.model.ProjectStatus).IN_PROGRESS}")
    private ProjectStatus status;

    private Teacher author;

    public Project() {
    }

    public Project(String title, int studentCount, ProjectStatus status, Teacher author) {
        this.title = title;
        this.studentCount = studentCount;
        this.status = status;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        studentCount = studentCount;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Teacher getAuthor() { return author; }

    public void setAuthor(Teacher author) { this.author = author; }
}
