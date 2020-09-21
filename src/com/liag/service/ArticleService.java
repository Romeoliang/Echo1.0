package com.liag.service;

import com.liag.entry.Article;

import java.util.List;

public interface ArticleService {
    public Article findArticleById(int id);
    public List<Article> findAll();
}
