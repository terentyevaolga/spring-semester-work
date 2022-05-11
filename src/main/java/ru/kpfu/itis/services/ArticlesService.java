package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.ArticleDto;

import java.util.List;

public interface ArticlesService {

  List<ArticleDto> getAll();

  List<ArticleDto> getAllArticlesByAuthor(String groupName);

}
