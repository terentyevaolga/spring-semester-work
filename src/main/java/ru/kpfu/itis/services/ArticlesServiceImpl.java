package ru.kpfu.itis.services;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.ArticleDto;
import ru.kpfu.itis.mapper.EntityMapper;
import ru.kpfu.itis.models.Article;
import ru.kpfu.itis.repositories.ArticlesRepository;

@Service
@AllArgsConstructor
public class ArticlesServiceImpl implements ArticlesService {

  private final ArticlesRepository articlesRepository;

  @Override
  public List<ArticleDto> getAll() {
    return articlesRepository.findAll()
        .stream()
        .map(entity -> {
          ArticleDto dto = EntityMapper.map(entity, ArticleDto.class);
          dto.setGroupName(entity.getGroup().getName());
          return dto;
        })
        .collect(
            Collectors.toList());
  }

  @Override
  public List<ArticleDto> getAllArticlesByAuthor(String groupName) {
    return articlesRepository.findArticleByGroupName(groupName).stream()
        .map(entity -> {
          ArticleDto dto = EntityMapper.map(entity, ArticleDto.class);
          dto.setGroupName(entity.getGroup().getName());
          return dto;
        })
        .collect(
            Collectors.toList());
  }
}
