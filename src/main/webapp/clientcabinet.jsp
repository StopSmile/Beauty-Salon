<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.05.2021
  Time: 14:33
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
                        <a class="nav-link" href="BootsTrapOurServices-Servlet">Наші послуги</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="bootstrapourmasters-servlet">Список майстрів</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Записатись на послугу</a>
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
                        <button class="btn btn-outline-success" name="logout" type="submit">Вийти</button>
                    </form>
                </form>
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
        <div class="row">
            <div class="col 4">
                <% User user = (User) session.getAttribute("user"); %>
                <p>Login : <%= user.getLogin() %></p>
                <p> First name :  <%= user.getFirstName() %></p>
                <p> Last name :  <%= user.getLastName() %></p>
                <p> Email : <%= user.getEmail() %></p>


            </div>
            <div class="col 4">

            </div>
            <div class="col 4">
            </div>
        </div>
    </div>
</section>

<%--<form method="post">--%>
<%--    <form class="d-flex">--%>
<%--        <button class="btn btn-outline-success" name="logout" type="submit">Вийти</button>--%>
<%--    </form>--%>
<%--</form>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>


<%--<input class="form-control-sm" type="text" name="login" placeholder="login"--%>
<%--       aria-label="Search">--%>
<%--<input class="form-control-sm" type="text" name="password" placeholder="password"--%>
<%--       aria-label="Search">--%>


<%--<section>--%>
<%--  <div class="container-xxl">--%>
<%--    <div class="row">--%>
<%--      <div class="col 4">--%>
<%--      </div>--%>
<%--      <div class="col 4">--%>
<%--        <% User user = (User) session.getAttribute("user"); %>--%>
<%--        <p> Login : <%= user.getLogin() %>--%>
<%--        </p>--%>
<%--        <p> First name :  <%= user.getFirstName() %>--%>
<%--        </p>--%>
<%--        <p> Last name :  <%= user.getLastName() %>--%>
<%--        </p>--%>
<%--      </div>--%>
<%--      <div class="col 4">--%>
<%--      </div>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</section>--%>

<%--<form method="post">--%>
<%--    <form class="d-flex">--%>
<%--        <button class="btn btn-outline-success" name="logout" type="submit">Вийти</button>--%>
<%--    </form>--%>
<%--</form>--%>