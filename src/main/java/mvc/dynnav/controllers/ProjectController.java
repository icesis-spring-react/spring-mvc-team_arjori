package mvc.dynnav.controllers;

import jakarta.servlet.http.HttpServletResponse;
import mvc.dynnav.data.ProjectRepository;
import mvc.dynnav.model.Project;
import mvc.dynnav.model.ProjectStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller("projectController")
public class ProjectController {

    @GetMapping("/AddProject")
    public String addProject() {
        return "addProject";
    }

    @PostMapping("/SubmitNewProject")
    public RedirectView submitSignIn(HttpServletResponse response, @RequestParam String title, @RequestParam int studentsCount, @RequestParam String status) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/dynnav_war_exploded/welcome");

        ProjectStatus projectStatus = parseStatus(status);
        ProjectRepository.add(new Project(title, studentsCount, projectStatus));

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
}