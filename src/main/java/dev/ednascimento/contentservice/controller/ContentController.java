package dev.ednascimento.contentservice.controller;

import dev.ednascimento.contentservice.model.Article;
import dev.ednascimento.contentservice.service.ArticleClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content/articles")
public class ContentController {

    public final ArticleClient articleClient;

    public ContentController(ArticleClient articleClient) {
        this.articleClient = articleClient;
    }

    @GetMapping
    public List<Article> findAllArticles() {
        return articleClient.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Article> findOne(@PathVariable Integer id) {
        return articleClient.findOne(id);
    }

    @PostMapping
    public void create(@RequestBody Article article) {
        articleClient.create(article);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Article article, @PathVariable Integer id) {
        articleClient.update(article, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        articleClient.delete(id);
    }
}