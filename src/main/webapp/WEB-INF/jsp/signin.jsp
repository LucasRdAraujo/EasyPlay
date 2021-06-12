<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <!DOCTYPE HTML>
                <html lang="pt-br">

                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <link rel="stylesheet" href="${contextPath}/assets/bootstrap-5.0.0-beta3-dist/css/bootstrap.css">
                    <script src="https://kit.fontawesome.com/6697f5eca6.js" crossorigin="anonymous"></script>
                    <link rel="stylesheet" href="${contextPath}/assets/css/authstyles.css">
                    <title>EasyPlay - SignUp</title>
                </head>

                <body class="signBackground">
                    <div class="wrapper">
                        <div id="signupWindow" class="d-flex window-border">
                            <div class="col-md p-4">
                                <form action="/signin" method="POST">
                                    <h1>Login</h1>
                                    <p>Por favor ensira suas informações para entrar!</p>
                                    <div class="form-group mb-3">
                                        <label for="inp_name">E-MAIL</label>
                                        <input id="inp_name" name="username" type="email" class="form-control" />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="inp_password">SENHA</label>
                                        <input id="inp_password" name="password" type="password" class="form-control" />
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <button class="c-btn c-btn-primary w-100 mb-3">Entrar</button>
                                </form>
                                <p>Não possui uma conta? <a href="${contextPath}/signup">Cadastre-se</a></p>
                            </div>
                            <div id="welcome-message" class="col-md p-4">
                                <h2>Bem vindo!</h2>
                                <p>Convide seus amigos também!</p>
                            </div>
                        </div>
                    </div>
                </body>

                </html>