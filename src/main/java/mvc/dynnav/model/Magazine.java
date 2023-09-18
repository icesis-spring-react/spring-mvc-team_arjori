package mvc.dynnav.model;

import org.springframework.stereotype.Component;

@Component
public class Magazine {
    private String title;
    private String ISBN;
    private MagazineType type;

    public Magazine() {
    }

    public Magazine(String title, String ISBN, MagazineType type) {
        this.title = title;
        this.ISBN = ISBN;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public MagazineType getType() {
        return type;
    }

    public void setType(MagazineType type) {
        this.type = type;
    }
}