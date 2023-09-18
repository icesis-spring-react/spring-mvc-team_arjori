package mvc.dynnav.controllers;

import mvc.dynnav.data.ArticleRepository;
import mvc.dynnav.data.MagazineRepository;
import mvc.dynnav.data.TeacherRepository;
import mvc.dynnav.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller("articleController")
public class ArticleController {

private String username;
    @GetMapping("/addArticle")
    public String addArticle(@CookieValue(defaultValue = "token") String token,Model model) {
        Teacher teacher = TeacherRepository.find(token);
        if (teacher != null) {
            username = teacher.getUsername();
            model.addAttribute("username",username);
            List<Magazine> magazines = new MagazineRepository().getAllMagazines();
            model.addAttribute("magazines", magazines);
            return "addArticle";
        }
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have access to that resource.");
    }
    @PostMapping("/SubmitArticle")
    public RedirectView submitSignUp(@CookieValue(defaultValue = "token") String token, @RequestParam String title, @RequestParam String magazineISBN, @RequestParam String stateName) {

        Teacher teacher = TeacherRepository.find(token);
        if (teacher != null) {
            Magazine magazine = parseMagazine(magazineISBN);
            ArticleType type = parseArticleType(magazine.getType());
            ArticleState state = parseArticleState(stateName);
            if (state!=null && type!=null) ArticleRepository.addArticle(new Article(title,magazine.getTitle(),type,state,teacher));
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("/addArticle");
            return redirectView;
        }
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have access to that resource.");
    }

    private ArticleState parseArticleState(String stateName) {
        switch (stateName){
            case "ACP":
                return ArticleState.ACCEPTED;
            case "REV":
                return ArticleState.IN_REVISION;
            case "DES":
                return ArticleState.DEVELOPMENT;
            default:
                return null;
        }
    }

    private ArticleType parseArticleType(MagazineType type) {
        switch (type){
            case INDEXED: return ArticleType.INDEXED;
            case NON_INDEXED: return ArticleType.NON_INDEXED;
            default: return null;
        }
    }

    private Magazine parseMagazine(String isbn) {
        return new MagazineRepository().getMagazineByISBN(isbn);
    }

}
