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
        <div class="row align-items-center gy-2">
            <div class="col-3">
                <form method="post" class="row g-3 needs-validation" novalidate>
                    <div class="col-12">
                        <label for="validationCustom01" class="form-label">І'мя</label>
                        <input type="text" class="form-control" id="validationCustom01" name="firstName" required>
                        <div class="valid-feedback">
                            Все добре !
                        </div>
                        <div class="invalid-feedback">
                            Введіть ваше і'мя
                        </div>
                    </div>
                    <div class="col-12">
                        <label for="validationCustom02" class="form-label">Прізвище</label>
                        <input type="text" class="form-control" id="validationCustom02" name="lastName" required>
                        <div class="valid-feedback">
                            Все добре !
                        </div>
                        <div class="invalid-feedback">
                            Введіть ваше прізвище
                        </div>
                    </div>
                    <div class="col-12">
                        <label for="validationCustom03" class="form-label">І'мя користувача</label>
                        <input type="text" class="form-control" id="validationCustom03" name="login" required>
                        <div class="valid-feedback">
                            Все добре !
                        </div>
                        <div class="invalid-feedback">
                            Введіть ім'я користувача
                        </div>
                    </div>
                    <div class="col-12">
                        <label for="validationCustom04" class="form-label">Пароль</label>
                        <input type="password" class="form-control" id="validationCustom04" name="password" required>
                        <div class="valid-feedback">
                            Все добре !
                        </div>
                        <div class="invalid-feedback">
                            Введіть ваш пароль
                        </div>
                    </div>
                    <div class="col-12">
                        <label for="validationCustom05" class="form-label">Пошта</label>
                        <input type="email" class="form-control" id="validationCustom05" name="email" required>
                        <div class="valid-feedback">
                            Все добре !
                        </div>
                        <div class="invalid-feedback">
                            Ввведіть вашу поштову скриньку
                        </div>

                    </div>

                    <div class="col-12">
                        <button class="btn btn-success" type="submit">Зареєструватись</button>
                    </div>
                    <%--                    </form>--%>
                </form>
            </div>

            <div class="col-5">
                <p>${message}</p>
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
<script>
    // Пример стартового JavaScript для отключения отправки форм при наличии недопустимых полей
    (function () {
        'use strict'

        // Получите все формы, к которым мы хотим применить пользовательские стили проверки Bootstrap
        var forms = document.querySelectorAll('.needs-validation')

        // Зацикливайтесь на них и предотвращайте отправку
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>

</body>
</html>


<%--<form method="post">--%>
<%--    <div class="row gy-2">--%>
<%--        <div class="col-12">--%>
<%--            <label for="validationCustom011" class="form-label">Імя</label>--%>
<%--            <input type="text" class="form-control" id="validationCustom01" name="firstName"--%>
<%--                   required>--%>
<%--            <div class="valid-feedback">--%>
<%--                Все добре--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-12">--%>
<%--            <label for="validationCustom021" class="form-label">Прізвище</label>--%>
<%--            <input type="text" class="form-control" id="validationCustom02" name="lastName"--%>
<%--                   required>--%>
<%--            <div class="valid-feedback">--%>
<%--                Все добре--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-12">--%>
<%--            <label for="validationCustomUsername1" class="form-label">Імя користувача</label>--%>
<%--            <div class="input-group has-validation">--%>
<%--                <input type="text" class="form-control" id="validationCustomUsername" name="login"--%>
<%--                       required>--%>
<%--                <div class="invalid-feedback">--%>
<%--                    Будь ласка виберіть імя користувача--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-12">--%>
<%--            <label for="validationCustom031" class="form-label">Пароль користувача</label>--%>
<%--            <input type="text" class="form-control" id="validationCustom03" name="password"--%>
<%--                   required>--%>
<%--            <div class="invalid-feedback">--%>
<%--                Будь ласка виберіть пароль.--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-12">--%>
<%--            <label for="validationCustom041" class="form-label">Поштова скринька</label>--%>
<%--            <input type="text" class="form-control" id="validationCustom04" name="email" required>--%>
<%--            <div class="invalid-feedback">--%>
<%--                Будь ласка вкажіть поштову скриньку.--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-12">--%>
<%--            <label for="validationCustom051" class="form-label">Номер телефону</label>--%>
<%--            <input type="text" class="form-control" id="validationCustom05" name="number" required>--%>
<%--            <div class="invalid-feedback">--%>
<%--                Будь льска вкажіть номер телефону--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label for="phone" class="form-label">Номер телефону(0732-064-910)</label>--%>
<%--            <input type="tel" class="form-control" id="phone" name="number" required--%>
<%--                   pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}">--%>
<%--        </div>--%>
<%--        <div class="col-12">--%>
<%--            <button class="btn btn-success" type="submit">Зареєструватись</button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</form>--%>

