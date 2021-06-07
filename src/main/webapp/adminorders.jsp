<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Замовлення
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="AdminOrders-Servlet">Усі замовлення</a></li>
                            <li><a class="dropdown-item" href="AdminActiveOrders-Servlet">Активні замовлення</a></li>
                            <li><a class="dropdown-item" href="AdminDoneOrders-Servlet">Виконані замовлення</a></li>
                        </ul>
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
            <div class="col 12">
                <table class="table table-dark table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Ім'я клієнта</th>
                        <th scope="col">Прізвище клієнта</th>
                        <th scope="col">Послуга</th>
                        <th scope="col">Датування</th>
                        <th scope="col">З</th>
                        <th scope="col">По</th>
                        <th scope="col">Ім'я майстра</th>
                        <th scope="col">Прізвище майстра</th>
                        <th scope="col">Статус</th>
                    </tr>
                    </thead>
                    <c:forEach items="${orders}" var="order">
                        <tbody>
                        <tr>
                            <td>${order.firstName}</td>
                            <td>${order.lastName}</td>
                            <td>${order.serviceName}</td>
                            <td>${order.date}</td>
                            <td>${order.timeStart}</td>
                            <td>${order.timeEnd}</td>
                            <td>${order.masterFirstName}</td>
                            <td>${order.masterLastName}</td>
                            <td>${order.orderName}</td>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>


