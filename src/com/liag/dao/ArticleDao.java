package com.liag.dao;

import com.liag.entry.Article;

import java.util.List;

public interface ArticleDao {
    public Article findArticleById(int id);
    public List<Article> findAll();
}
