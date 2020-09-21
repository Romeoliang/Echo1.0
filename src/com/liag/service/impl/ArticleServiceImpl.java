package com.liag.service.impl;

import com.liag.dao.ArticleDao;
import com.liag.dao.impl.ArticleDaoImpl;
import com.liag.entry.Article;
import com.liag.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    private ArticleDao dao = new ArticleDaoImpl();
    @Override
    public Article findArticleById(int id) {

        Article article = dao.findArticleById(id);
        return article;
    }

    @Override
    public List<Article> findAll() {
        List<Article> list = dao.findAll();
        return list;
    }
}
