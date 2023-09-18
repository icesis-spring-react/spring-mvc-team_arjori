package mvc.dynnav.model;

import org.springframework.stereotype.Component;

@Component
public class Article {
    private String title;
    private String magazineName;
    private ArticleType type;
    private ArticleState state;
    private Teacher author;
    public Article() {
    }

    public Article(String title, String magazineName, ArticleType type, ArticleState state, Teacher author) {
        this.title = title;
        this.magazineName = magazineName;
        this.type = type;
        this.state=state;
        this.author=author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public ArticleType getType() {
        return type;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    public ArticleState getState() {
        return state;
    }

    public void setState(ArticleState state) {
        this.state = state;
    }

    public Teacher getAuthor() {
        return author;
    }

    public void setAuthor(Teacher author) {
        this.author = author;
    }
}
