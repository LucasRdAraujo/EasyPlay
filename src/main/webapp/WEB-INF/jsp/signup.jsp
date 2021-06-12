<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <!DOCTYPE HTML>
                <html>

                <head>
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
                                <form:form action="/signup" method="POST" modelAttribute="userDto">
                                    <h2>Registro</h2>
                                    <p>Por favor ensira suas informações para registrar!</p>
                                    <div class="form-group mb-3">
                                        <label for="usernameInput">USERNAME</label>
                                        <spring:bind path="username">
                                            <form:input id="inp_username" type="text" path="username"
                                                placeholder="Username" class="form-control" />
                                            <form:errors path="username"></form:errors>
                                        </spring:bind>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="emailInput">E-MAIL</label>
                                        <spring:bind path="email">
                                            <form:input id="inp_email" type="email" path="email" placeholder="Email"
                                                class="form-control" />
                                            <form:errors path="email"></form:errors>
                                        </spring:bind>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="passwordInput">SENHA</label>
                                        <spring:bind path="password">
                                            <form:input id="inp_password" type="password" path="password"
                                                placeholder="Password" class="form-control" />
                                            <form:errors path="password"></form:errors>
                                        </spring:bind>
                                    </div>
                                    <form:button class="c-btn c-btn-primary w-100 mb-3">Cadastrar</form:button>
                                </form:form>
                                <p>Já possui uma conta? <a href="${contextPath}/signin">Entre aqui</a></p>
                            </div>
                        </div>
                    </div>
                </body>

                </html>