package assm2;

import java.util.ArrayList;

public class MyArticleService implements ArticleService{
    @Override
    public ArrayList<String> getLinks(String url) {
        ArrayList<String> links = new ArrayList<>();
        return links;
    }

    @Override
    public Article getArticle(String url) {
        Article article = new Article();
        return article;
    }
}
