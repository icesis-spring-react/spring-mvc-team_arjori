package mvc.dynnav.controllers;

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

    @GetMapping("/addMagazine")
    public String addMagazine() {
        return "addMagazine";
    }

    @PostMapping("/SubmitMagazine")
    public RedirectView submitMagazine(@RequestParam String title, @RequestParam String isbn, @RequestParam String type) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/addMagazine");

        MagazineType magazineType = parseMagazineType(type);
        if (magazineType != null) {
            MagazineRepository.addMagazine(new Magazine(title, isbn, magazineType));
            return redirectView;
        }
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
