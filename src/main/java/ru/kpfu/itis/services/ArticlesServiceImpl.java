package ru.kpfu.itis.services;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.Article;
import ru.kpfu.itis.repositories.ArticlesRepository;

@Service
@AllArgsConstructor
public class ArticlesServiceImpl implements ArticlesService {

  private final ArticlesRepository articlesRepository;

  @Override
  public List<Article> getAll() {
    return articlesRepository.findAll();
  }
}
