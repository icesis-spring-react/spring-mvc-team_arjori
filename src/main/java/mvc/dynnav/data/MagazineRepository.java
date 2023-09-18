package mvc.dynnav.data;

import mvc.dynnav.model.Magazine;
import mvc.dynnav.model.MagazineType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("magazineRepository")
public class MagazineRepository {
    private static List<Magazine> magazines = new ArrayList<>();

    static {
        magazines.add(new Magazine("Magazine 1", "1720493728", MagazineType.INDEXED));
        magazines.add(new Magazine("Magazine 2", "2780491839", MagazineType.INDEXED));
        magazines.add(new Magazine("Magazine 3", "3456721763", MagazineType.INDEXED));
        magazines.add(new Magazine("Magazine 4", "7429387492", MagazineType.NON_INDEXED));
        magazines.add(new Magazine("Magazine 5", "1278361678", MagazineType.NON_INDEXED));
    }

    public List<Magazine> getAllMagazines() {
        return magazines;
    }

    public Magazine getMagazineByTitle(String title) {
        for (Magazine magazine : magazines) {
            if (magazine.getTitle().equalsIgnoreCase(title)) {
                return magazine;
            }
        }
        return null;
    }

    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }
}
