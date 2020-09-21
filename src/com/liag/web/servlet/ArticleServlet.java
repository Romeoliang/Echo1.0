package com.liag.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liag.entry.Article;
import com.liag.service.ArticleService;
import com.liag.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet("/articleServlet")
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("utf-8");
        ArticleService service = new ArticleServiceImpl();
        List<Article> list = service.findAll();
        int size = list.size();
        Random r = new Random();
        //产生0到size-1的随机值
        int index = r.nextInt(size) + 1;
        Article article = service.findArticleById(index);
        request.setAttribute("article", article);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
