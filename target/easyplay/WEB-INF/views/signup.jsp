<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE HTML>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
                    crossorigin="anonymous">
                <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
                    integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
                    crossorigin="anonymous"></script>
                <link rel="stylesheet" href="resources/assets/css/styles.css">
                <title>EasyPlay - SignUp</title>
            </head>

            <body class="signBackground">
                <!-- d-grid grid-column center-grid -->
                <div class="wrapper">
                    <div id="signupWindow" class="d-flex window-border">
                        <div class="col-md p-4">
                            <form:form action="signupuser" method="post" modelAttribute="AuthForm">
                                <h2>Registro</h2>
                                <p>Por favor ensira suas informações para registrar!</p>
                                <div class="form-group mb-3">
                                    <label for="usernameInput">Username</label>
                                    <form:input id="usernameInput" path="username" />
                                </div>
                                <div class="form-group mb-3">
                                    <label for="emailInput">Email</label>
                                    <form:input id="emailInput" path="email" />
                                </div>
                                <div class="form-group mb-3">
                                    <label for="passwordInput">Senha</label>
                                    <form:input id="passwordInput" path="senha" />
                                </div>
                                <form:button class="btn btn-primary w-100 mb-3">Entrar</form:button>
                            </form:form>
                            <p>Já possui uma conta? <a href="#">Entre por aqui</a></p>
                        </div>
                        <div id="welcome-message" class="col-md p-4">
                            <h2>Bem vindo!</h2>
                            <p>Convide seus amigos também!</p>
                        </div>
                    </div>
                </div>
            </body>

            </html>