package mvc.dynnav.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.dynnav.data.ProjectRepository;
import mvc.dynnav.data.TeacherRepository;
import mvc.dynnav.model.Project;
import mvc.dynnav.model.ProjectStatus;
import mvc.dynnav.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller("projectController")
public class ProjectController {

    @GetMapping("/AddProject")
    public String addProject() {
        return "addProject";
    }

    @PostMapping("/SubmitAddProject")
    public RedirectView submitAddProject(HttpServletRequest request, HttpServletResponse response, @RequestParam String title, @RequestParam int studentsCount, @RequestParam String projectStatus) {
        System.out.println("Title: " + title);
        System.out.println("Students count: " + studentsCount);
        System.out.println("Status: " + projectStatus);

        ProjectStatus status = parseStatus(projectStatus);
        System.out.println("Parsed status: " + status);

        String username = getUsername(request);
        Teacher author = TeacherRepository.find(username);

        ProjectRepository.add(new Project(title, studentsCount, status, author));

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/AddProject");

        return redirectView;
    }

    private ProjectStatus parseStatus(String status) {
        switch (status) {
            case "COM":
                return ProjectStatus.COMPLETED;
            case "PRO":
                return ProjectStatus.IN_PROGRESS;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
    }

    private String getUsername(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String username = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    username = cookie.getValue();
                }
            }
        }

        return username;
    }

    @GetMapping("/GoBack")
    public RedirectView goBack(HttpServletRequest request, HttpServletResponse response) {
        RedirectView redirectView = new RedirectView();
        String username = getUsername(request);
        if (username != null) {
            redirectView.setUrl(request.getContextPath() + "/" + username);
        } else {
            redirectView.setUrl(request.getContextPath() + "/SignIn");
        }
        return redirectView;
    }
}