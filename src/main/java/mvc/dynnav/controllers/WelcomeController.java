package mvc.dynnav.controllers;

import mvc.dynnav.data.ArticleRepository;
import mvc.dynnav.data.ProjectRepository;
import mvc.dynnav.data.TeacherRepository;
import mvc.dynnav.model.Article;
import mvc.dynnav.model.Project;
import mvc.dynnav.model.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class WelcomeController {
    @GetMapping("/{username}")
    public String welcome(@CookieValue(defaultValue = "token") String token, @PathVariable String username, Model model) {
        Teacher teacher = TeacherRepository.find(username);
        if (teacher != null && username.equals(token)) {
            List<Article> articles = ArticleRepository.getArticlesByAuthor(teacher);
            List<Project> projects = ProjectRepository.findByAuthor(teacher);
            String table = articleTableContent(articles);
            model.addAttribute("fullName", teacher.getFullName());
            model.addAttribute("academicGrade", teacher.getAcademicDegree().getValue());
            model.addAttribute("articles",table);
            model.addAttribute("projects",projects);
            return "welcome";
        }
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have access to that resource.");
    }
    private String articleTableContent(List<Article> articles){
        String result="";
        for (Article a: articles) {
            result+="<tr>" +
                    "<td>"+a.getTitle()+"</td>"+
                    "<td>"+a.getMagazineName()+"</td>"+
                    "<td>"+a.getType()+"</td>"+
                    "<td>"+a.getState()+"</td>" +
                    "</tr>";
        }
        return result;
    }
}
