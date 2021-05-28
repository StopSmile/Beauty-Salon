<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.05.2021
  Time: 16:48
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

<section>
    <div class="container-xxl">
        <div class="row">
            <div class="col-4">
                <form class="row g-3 needs-validation" novalidate>
                    <div class="col-12">
                        <label for="validationCustom01" class="form-label">Ім'я</label>
                        <input type="text" class="form-control" id="validationCustom01" required>
                        <div class="valid-feedback">
                            Все добре
                        </div>
                        <div class="invalid-feedback">
                            Будь ласка введіть і'мя
                        </div>
                    </div>
                    <div class="col-12">
                        <label for="validationCustom02" class="form-label">Прізвище</label>
                        <input type="text" class="form-control" id="validationCustom02" required>
                        <div class="valid-feedback">
                            Все добре
                        </div>
                        <div class="invalid-feedback">
                            Будь ласка введіть прізвище
                        </div>
                    </div>
                    <div class="col-12">
                        <button class="btn btn-success" type="submit">Отправить форму</button>
                    </div>
                </form>

            </div>
            <div class="col-4">
                2
            </div>
            <div class="col-4">
                3
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
