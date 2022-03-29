package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Article;

import java.util.List;

public interface ArticlesRepository extends JpaRepository {
    List<Article> findAll();
    Article findById(int id);
    Article save(Article article);
}
