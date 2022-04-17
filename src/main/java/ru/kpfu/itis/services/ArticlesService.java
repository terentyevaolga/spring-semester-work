package ru.kpfu.itis.services;

import java.util.List;

import ru.kpfu.itis.dto.ArticleDto;

public interface ArticlesService {

  List<ArticleDto> getAll();

  List<ArticleDto> getAllArticlesByAuthor(String groupName);
}
