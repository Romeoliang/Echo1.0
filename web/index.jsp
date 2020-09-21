<%@ page import="com.liag.service.ArticleService" %>
<%@ page import="com.liag.service.impl.ArticleServiceImpl" %>
<%@ page import="com.liag.entry.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>
    <style type="text/css">
        .bg-video{
            width: 100%;
            position: absolute;
            left: 0;
            top: -91px;
            z-index: -1;
        }
        .bottom{
            width: 240px;
            height: 240px;
            margin: 500px auto 0;
        }
        @font-face{
            font-family:myFont;
            src:url('font/ll.ttf');
        }
        .form-container{
            width: 726px;
            height: 133px;
            /*    min-height: 500px;*/
            margin-left: -255px;
            margin-top: -320px;
            border :1px solid #aaa;
            border-radius: 8px;
            padding: 10px;
            background: rgba(255,255,255,.7);
            font-family: myFont, fantasy;
            font-size: 26px;
            color: pink;
        }
        #box{
            padding: 0;
            margin-top: 297px;
            border: 1px solid transparent;
            outline: none;
            width: 240px; /*宽*/
            height: 110px;/*高*/
            background-image:url(img/22.gif);/*背景图片*/
            border-radius: 240px;
        }
        body{
            background:url(img/bg.jpg) top left;
            background-size:100%;
        }
    </style>


    <script type="text/javascript">
        function Reload() {
            window.location.reload();
        }
    </script>
</head>
<body>
<%
    ArticleService service = new ArticleServiceImpl();
    List<Article> list = service.findAll();
    int size = list.size();
    Random r = new Random();
    //产生0到size-1的随机值
    int index = r.nextInt(size) + 1;
    Article article = service.findArticleById(index);
    request.setAttribute("article", article);
%>

    <div class="bottom">
        <div class="form-container">${article.a_text}</div>
        <button id="box" onclick="Reload()"></button>
    </div>


</body>
</html>