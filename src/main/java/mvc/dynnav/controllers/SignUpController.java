package mvc.dynnav.controllers;

import mvc.dynnav.data.TeacherRepository;
import mvc.dynnav.model.AcademicDegree;
import mvc.dynnav.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SignUpController {
    @GetMapping("/SignUp")
    public String signUp() {
        return "signUp";
    }

    @PostMapping("/SubmitSignUp")
    public RedirectView submitSignUp(@RequestParam String username, @RequestParam String password, @RequestParam String academicDegree, @RequestParam String fullName) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/SignUp");

        AcademicDegree degree = parseDegree(academicDegree);
        TeacherRepository.add(new Teacher(username, password, fullName, degree));

        return redirectView;
    }

    private AcademicDegree parseDegree(String academicDegree) {
        switch (academicDegree) {
            case "BA":
                return AcademicDegree.BACHELOR_OF_ARTS;
            case "BSc":
                return AcademicDegree.BACHELOR_OF_SCIENCE;
            case "MA":
                return AcademicDegree.MASTER_OF_ARTS;
            case "MSc":
                return AcademicDegree.MASTER_OF_SCIENCE;
            case "PhD":
                return AcademicDegree.DOCTOR_OF_PHILOSOPHY;
            default:
                throw new IllegalStateException("Unexpected value: " + academicDegree);
        }
    }
}