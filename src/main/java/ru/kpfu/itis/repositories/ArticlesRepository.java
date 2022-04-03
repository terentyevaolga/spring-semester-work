package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.Article;

import java.util.List;

public interface ArticlesRepository extends JpaRepository<Article, Integer> {
}
