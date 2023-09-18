package mvc.dynnav.data;

import mvc.dynnav.model.Article;
import mvc.dynnav.model.ArticleState;
import mvc.dynnav.model.ArticleType;
import mvc.dynnav.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("articleeRepository")
public class ArticleRepository {
    private static final List<Article> ARTICLES = new ArrayList<>();

    static {
        List<Teacher> teacherList = TeacherRepository.getTeacherList();
        ARTICLES.add(new Article("Article 1","Magazine 1", ArticleType.INDEXED, ArticleState.ACCEPTED,teacherList.get(0)));
        ARTICLES.add(new Article("Article 2","Magazine 2", ArticleType.INDEXED, ArticleState.IN_REVISION,teacherList.get(0)));
        ARTICLES.add(new Article("Article 3","Magazine 3", ArticleType.INDEXED, ArticleState.DEVELOPMENT,teacherList.get(0)));
        ARTICLES.add(new Article("Article 4","Magazine 4", ArticleType.NON_INDEXED, ArticleState.IN_REVISION,teacherList.get(0)));
        ARTICLES.add(new Article("Article 5","Magazine 5", ArticleType.NON_INDEXED,ArticleState.ACCEPTED,teacherList.get(0)));
        ARTICLES.add(new Article("Article 6","Magazine 1", ArticleType.INDEXED, ArticleState.ACCEPTED,teacherList.get(1)));
        ARTICLES.add(new Article("Article 7","Magazine 2", ArticleType.INDEXED, ArticleState.DEVELOPMENT,teacherList.get(1)));
        ARTICLES.add(new Article("Article 8","Magazine 3", ArticleType.INDEXED, ArticleState.DEVELOPMENT,teacherList.get(1)));
        ARTICLES.add(new Article("Article 9","Magazine 4", ArticleType.NON_INDEXED, ArticleState.ACCEPTED,teacherList.get(1)));
        ARTICLES.add(new Article("Article 10","Magazine 5", ArticleType.NON_INDEXED,ArticleState.ACCEPTED,teacherList.get(1)));

    }

    public List<Article> getAllArticles() {
        return ARTICLES;
    }

    public Article getArticlesByTitle(String title) {
        for (Article article : ARTICLES) {
            if (article.getTitle().equalsIgnoreCase(title)) {
                return article;
            }
        }
        return null;
    }

    public static void addArticle(Article article) {
        ARTICLES.add(article);
    }
    public static List<Article> getArticlesByAuthor(Teacher author){
        ArrayList<Article> result = new ArrayList<>();
        for (Article a:ARTICLES) {
            if (a.getAuthor().equals(author)){
                result.add(a);
            }
        }
        if(result.isEmpty()){
            return null;
        }
        else return result;
    }
}
