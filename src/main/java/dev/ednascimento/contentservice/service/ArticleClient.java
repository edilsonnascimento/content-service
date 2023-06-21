package dev.ednascimento.contentservice.service;

import dev.ednascimento.contentservice.model.Article;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;
import java.util.Optional;

public interface ArticleClient {
    @GetExchange
    List<Article> findAll();

    @GetExchange("/{id}")
    Optional<Article> findOne(@PathVariable Integer id);

    @PostExchange
    void create(@RequestBody Article article);

    @PutExchange("/{id}")
    void update(@RequestBody Article article, @PathVariable Integer id);

    @DeleteExchange("/{id}")
    void delete(@PathVariable Integer id);
}