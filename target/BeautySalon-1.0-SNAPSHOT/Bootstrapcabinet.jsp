<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.05.2021
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<style>


    body {
        background: url(Images/5.jpeg); /* Цвет фона и путь к файлу */
        color: #ffffff; /* Цвет текста */
        /*#ffffff*/
    }
</style>
<header>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-xxl">
            <a class="navbar-brand" href="bootstrap-servlet">Madea</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                    aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Наші послуги</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="bootstrapourmasters-servlet">Список майстрів</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Про нас</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Контакти</a>
                    </li>
                </ul>
                <form method="post">
                    <form class="d-flex">
                        <a class="btn btn-outline-success" href="bootstrapcabinet-servlet" role="button">Особистий
                            кабінет</a>
                    </form>
                </form>
            </div>
        </div>
    </nav>
</header>
<section>
    <div class="container-xxl">
        <div class="row align-items-center gy-5">
            <div class="col-3">

                <form method="post">
                    <div class="row gy-2">
                        <div class="col-12">
                            <label for="name">Ім'я користувача</label>
                            <input type="text" class="form-control" id="name" name="login">
                            <label for="pass">Пароль</label>
                            <input type="text" class="form-control" id="pass" name="password">
                        </div>

                        <div class="col-7">
                            <button type="submit" class="btn btn-success">Увійти</button>
                        </div>

                        <div class="col-5">
                            <a class="btn btn-success" href="BootsTrapRegistration-Servlet" role="button">Реєстрація</a>
                        </div>

                    </div>
                </form>


            </div>
            <div class="col-5">
                <%--                <blockquote class="blockquote">--%>
                <%--                    <p>Коли ти сповнена печалі, розчарована в коханні, – зроби макіяж, найкращу зачіску – і атакуй.</p>--%>
                <%--                </blockquote>--%>
                <%--                <h1>«Коли ти сповнена печалі, розчарована в коханні, – зроби макіяж, найкращу зачіску – і атакуй»</h1>--%>
                <%--                <h2>«Догляд за собою повинен починатися в серці і душі. Без цього будь-яка косметика – безсила»</h2>--%>
                <%--                <h3>«Обличчя – це дзеркало, яке відображає рух внутрішнього життя. Приділяйте йому особливу увагу»</h3>--%>
                <%--                <h4>«Це сторінка вашого особистого кабінету»</h4>--%>
                <p>${massage}</p>


            </div>
            <div class="col-4">
                <img class="w-100"
                     src="https://images.pexels.com/photos/1122868/pexels-photo-1122868.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                     alt="girl">
            </div>
        </div>
    </div>

</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

</body>
</html>


<%--<div class="row gy-5">--%>
<%--    <div class="col-6">--%>
<%--        <button type="button" class="btn btn-success">Sign in</button>--%>
<%--    </div>--%>
<%--    <div class="col-6">--%>
<%--        <button type="button" class="btn btn-success">Registration</button>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<div class="row gy-5">--%>
<%--    <div class="col-5">--%>
<%--        <button type="button" class="btn btn-primary">Sign in</button>--%>
<%--    </div>--%>
<%--    <div class="col-2">--%>

<%--    </div>--%>
<%--    <div class="col-5">--%>
<%--        <button type="button" class="btn btn-success">Registration</button>--%>
<%--    </div>--%>
<%--</div>--%>