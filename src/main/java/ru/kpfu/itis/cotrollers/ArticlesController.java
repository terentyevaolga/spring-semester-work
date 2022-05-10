package ru.kpfu.itis.cotrollers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.dto.ArticleDto;
import ru.kpfu.itis.services.ArticlesService;

import java.util.List;

@RestController("/articles")
@AllArgsConstructor
public class ArticlesController {

    private final ArticlesService articlesService;

    @GetMapping
    public ResponseEntity<List<ArticleDto>> getArticles() {
        List<ArticleDto> articles = articlesService.getAll();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{author}")
    public ResponseEntity<List<ArticleDto>> getArticlesByAuthor(@PathVariable("author") String author) {
        List<ArticleDto> articles = articlesService.getAllArticlesByAuthor(author);
        return ResponseEntity.ok(articles);
    }
}
