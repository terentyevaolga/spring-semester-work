package ru.kpfu.itis.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.models.Article;
import ru.kpfu.itis.services.ArticlesService;

@Controller("/main")
@AllArgsConstructor
public class ArticlesController {

    private final ArticlesService articlesService;

    @GetMapping
    public String getArticles(Model model) {
        List<Article> articles = articlesService.getAll();
        model.addAttribute("articles", articles);
        return "main";
    }

    @PostMapping
    public String setArticleToSession(Model model, HttpSession session) throws ServletException, IOException {
        Integer s = Integer.valueOf((String) Objects.requireNonNull(model.getAttribute("article")));
        session.setAttribute("article", s);
        return "redirect:/main";
    }
}
