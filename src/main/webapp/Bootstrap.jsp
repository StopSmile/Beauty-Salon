<%--
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
                        <a class="nav-link" href="#">Про нас</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Контакти</a>
                    </li>
                </ul>
                <form method="post">
                    <form class="d-flex">
                        <a class="btn btn-outline-success" href="bootstrapcabinet-servlet" role="button">Особистий кабінет</a>
                    </form>
                </form>
            </div>
        </div>
    </nav>
</header>
<section>
    <div class="container-xxl">
        <div class="row align-items-center">
            <div class="col-8">
                <h1>«Догляд за собою повинен починатися в серці і душі. Без цього будь-яка косметика – безсила»</h1>
            </div>
            <div class="col-4">
                <img class="w-100" src="https://tsina.lviv.ua/wp-content/uploads/2018/03/salon_caramel-style.jpg" alt="Salon">
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container-xxl">
        <div class="row align-items-center">
            <h1>Наші майстри</h1>
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://parykmakherskaya.in-kiev.org/wp-content/uploads/2017/11/perukar-plyusy-minusy-profesiyi.jpg" class="d-block w-100" alt="One">
                    </div>
                    <div class="carousel-item">
                        <img src="https://www.kf-ks.info/wp-content/uploads/%D0%91%D1%96%D0%BB%D0%BE%D0%B3%D0%BE%D1%80%D0%BE%D0%B4%D0%BA%D0%B0-%D0%BF%D0%B5%D1%80%D1%83%D0%BA%D0%B0%D1%80%D0%BD%D1%8F-%D0%B4%D0%BB%D1%8F-%D0%B4%D1%96%D1%82%D0%B5%D0%B9-.jpg" class="d-block w-100" alt="two">
                    </div>
                    <div class="carousel-item">
                        <img src="https://gordonua.com/img/article/15309/1_big.jpg" class="d-block w-100" alt="tree">
                    </div>
                    <div class="carousel-item">
                        <img src="https://img2.abo.media/upload/article/bm9blvukecznuf95omoz.jpg" class="d-block w-100" alt="four">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"  data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Предыдущий</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"  data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Следующий</span>
                </button>
            </div>
        </div>
    </div>
</section>


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