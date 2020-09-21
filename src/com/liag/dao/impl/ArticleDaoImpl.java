package com.liag.dao.impl;

import com.liag.dao.ArticleDao;
import com.liag.entry.Article;
import com.liag.util.BaseDao;
import com.liag.util.JdbcUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ArticleDaoImpl extends BaseDao implements ArticleDao {
    @Override
    public Article findArticleById(int id) {
        String sql = "select a_text from echo where id=?";
        try {
            Article article = super.queryBean(sql, Article.class, id);
            return article;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            return null;
    }

    @Override
    public List<Article> findAll() {
        String sql = "select * from echo";
        try {
            List<Article> list = super.queryBeanList(sql, Article.class);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
