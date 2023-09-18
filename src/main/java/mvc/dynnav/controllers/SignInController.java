package mvc.dynnav.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import mvc.dynnav.data.TeacherRepository;
import mvc.dynnav.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SignInController {
    @GetMapping("/SignIn")
    public String signIn() {
        return "signIn";
    }

    @PostMapping("/SubmitSignIn")
    public RedirectView submitSignIn(HttpServletResponse response, @RequestParam String username, @RequestParam String password) {
        RedirectView redirectView = new RedirectView();
        Teacher teacher = TeacherRepository.find(username);

        if (teacher != null && teacher.getPassword().equals(password)) {
            Cookie cookie = new Cookie("token", username);
            cookie.setMaxAge(30 * 60);
            response.addCookie(cookie);

            redirectView.setUrl("/" + username);
        }
        else
            redirectView.setUrl("/SignIn");

        return redirectView;
    }
}