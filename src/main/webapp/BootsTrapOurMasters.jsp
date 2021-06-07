<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.05.2021
  Time: 17:05
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
            <div class="col-5">
                <table class="table table-dark table-striped">
                    <thead>
                    <tr>
                        <th scope="col">
                            <form method="post">
                                <button class="btn btn-light btn-sm" name="nameUp" type="submit">&#8593;</button>
                                <button class="btn btn-light btn-sm" name="nameDown" type="submit">&#8595;</button>
                            </form>
                            Ім'я
                        </th>
                        <th scope="col">Прізвище</th>
                        <th scope="col">Пошта</th>
                        <th scope="col">
                            <form method="post">
                                <button class="btn btn-light btn-sm" name="rateUp" type="submit">&#8593;</button>
                                <button class="btn btn-light btn-sm" name="rateDown" type="submit">&#8595;</button>
                            </form>
                            Рейтинг
                        </th>
                    </tr>
                    </thead>
                    <c:forEach items="${masters}" var="master">
                        <tbody>
                        <tr>
                            <td>${master.firstName}</td>
                            <td>${master.lastName}</td>
                            <td>${master.email}</td>
                            <td>${master.rating}</td>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
                <table class="table table-dark table-striped">
                    <thead>
                    <tr>
                        <th>${name}</th>
                        <th>${name2}</th>
                    </tr>
                    </thead>
                    <c:forEach items="${masters2}" var="master">
                        <tbody>
                        <tr>
                            <td>${master.name}</td>
                            <td>${master.price}</td>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
                <form method="post">
                    <div class="row align-items-center gy-5">
                        <div class="col-4">
                            <label for="filter" class="form-label"></label>
                            <input type="text" class="form-control" id="filter" name="master" placeholder="Anna">
                            <button class="btn btn-secondary btn" type="submit">Відфільтрувати</button>
                        </div>
                        <div class="col-4">
                        </div>
                        <div class="col-4">
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-3">

            </div>
            <div class="col-4">
                <img class="w-100"
                     src="https://images.pexels.com/photos/1122868/pexels-photo-1122868.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                     alt="girl">
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container-xxl">

    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

</body>
</html>
