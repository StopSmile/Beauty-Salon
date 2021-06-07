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
                    <li class="nav-item">
                        <a class="nav-link" href="ClientOrder-Servlet">Записатись на послугу</a>
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
        <form method="post">
            <div class="row">
                <div class="col">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2"
                                data-bs-toggle="dropdown" aria-expanded="false">
                            Перукарські послуги
                        </button>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="dropdownMenu2">
                            <li>
                                <button class="dropdown-item" type="submit" name="service1">Жіноча стрижка</button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service2">Стрижка гарячими ножицями
                                </button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service3">Полірування волосся</button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service5">Чоловіча модельна стрижка
                                </button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service6">Чоловіча стрижка машинкою 1
                                    насадка
                                </button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service7">Дитяча стрижка</button>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu3"
                                data-bs-toggle="dropdown" aria-expanded="false">
                            Манікюрні послуги
                        </button>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="dropdownMenu3">
                            <li>
                                <button class="dropdown-item" type="submit" name="service8">Манікюр обрізний</button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service9">Чоловічий манікюр</button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service10">Педікюр</button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service11">Однотонне покриття нігтів
                                </button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service12">Нарощення нігтів (з
                                    покриттям)
                                </button>
                            </li>
                        </ul>
                    </div>

                </div>
                <div class="col">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu4"
                                data-bs-toggle="dropdown" aria-expanded="false">
                            Проколювання вух
                        </button>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="dropdownMenu4">
                            <li>
                                <button class="dropdown-item" type="submit" name="service13">Проколювання 1 вуха
                                </button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="submit" name="service14">Проколювання 2 вух</button>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-4">
                    <img class="w-100"
                         src="https://images.pexels.com/photos/1122868/pexels-photo-1122868.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                         alt="girl">
                </div>
            </div>
        </form>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>



