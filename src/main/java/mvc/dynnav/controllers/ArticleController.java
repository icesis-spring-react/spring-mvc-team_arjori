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
        //System.out.println(token);
        Teacher teacher = TeacherRepository.find(token);
        if (teacher != null) {
            username = teacher.getUsername();
            model.addAttribute("username",username);
            List<Magazine> magazines = new MagazineRepository().getAllMagazines();
            String magazineTable = magazineTableContent(magazines);
            model.addAttribute("magazines", magazineTable);
            return "addArticle";
        }
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have access to that resource.");
    }

    private String magazineTableContent(List<Magazine> magazines){
        String result="";
        for (Magazine m: magazines) {
            result+="<option value="+m.getISBN()+">"+m.getTitle()+"</option>";
        }
        return result;
    }
    @PostMapping("/SubmitArticle")
    public RedirectView submitArticle(@CookieValue(defaultValue = "token") String token, @RequestParam String title, @RequestParam String magazine, @RequestParam String state) {
        Teacher teacher = TeacherRepository.find(token);
        if (teacher != null) {
            Magazine magazineObj = parseMagazine(magazine);
            ArticleType type = parseArticleType(magazineObj.getType());
            ArticleState stateST = parseArticleState(state);
            if (stateST!=null && type!=null) {
                ArticleRepository.addArticle(new Article(title,magazineObj.getTitle(),type,stateST,teacher));
                System.out.println("Title: " + title);
                System.out.println("Magazine: " + magazineObj.getTitle());
                System.out.println("State: " + stateST);
            }
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
