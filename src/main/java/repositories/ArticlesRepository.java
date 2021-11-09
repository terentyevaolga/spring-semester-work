package repositories;

import models.Article;
import models.Film;

import java.util.List;

public interface ArticlesRepository {
    List<Article> findAll();
    Article findById(int id);
    Article save(Article article);
}
