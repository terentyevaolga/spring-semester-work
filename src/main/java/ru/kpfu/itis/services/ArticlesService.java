package ru.kpfu.itis.services;

import java.util.List;

import ru.kpfu.itis.models.Article;

public interface ArticlesService {

  List<Article> getAll();
}
