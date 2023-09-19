package mvc.dynnav.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.dynnav.data.MagazineRepository;
import mvc.dynnav.model.Magazine;
import mvc.dynnav.model.MagazineType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller("magazineController")
public class MagazineController {

    @GetMapping("/AddMagazine")
    public String addMagazine() {
        return "addMagazine";
    }

    @PostMapping("/SubmitAddMagazine")
    public RedirectView submitMagazine(@RequestParam String title, @RequestParam String isbn, @RequestParam String magazineType) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/AddMagazine");

        MagazineType type = parseMagazineType(magazineType);
        if (type != null) {
            MagazineRepository.addMagazine(new Magazine(title, isbn, type));
        }

        System.out.println("Title: " + title);
        System.out.println("ISBN: " + isbn);
        System.out.println("Type: " + magazineType);

        return redirectView;
    }

    private MagazineType parseMagazineType(String type) {
        switch (type) {
            case "IDX":
                return MagazineType.INDEXED;
            case "NONIDX":
                return MagazineType.NON_INDEXED;
            default:
                return null;
        }
    }
}
