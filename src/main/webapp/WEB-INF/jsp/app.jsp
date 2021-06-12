<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <!DOCTYPE html>
                <html lang="pt-br">

                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <script src="https://kit.fontawesome.com/6697f5eca6.js" crossorigin="anonymous"></script>
                    <link rel="stylesheet" href="${contextPath}/assets/css/app.css">
                    <title>EasyPlay</title>
                </head>

                <body>
                    <!-- <form:form action="/api/v1/guilds" method="POST" modelAttribute="serverDto">
                        <spring:bind path="name">
                            <form:input id="inp_name" type="text" path="name" placeholder="Server name" />
                            <form:errors path="name"></form:errors>
                        </spring:bind>
                        <form:button type="submit">Criar servidor</form:button>
                    </form:form> -->

                    <div class="app-m">
                        <div class="app-1">
                            <div class="app-2">
                                <div class="bg-c"></div>
                                <div class="layers-1 layers-2">
                                    <div class="layer-3 base-layer">
                                        <div class="container-1">
                                            <div class="base">
                                                <nav class="app-nav app-nav-container">
                                                    <div class="p-relative">
                                                        <div class="app-nav-list-item">
                                                            <div class="home-button">
                                                                <a href="${contextPath}/channels/app">
                                                                    <div class="app-nav-wrapper"></div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </nav>

                                                <!-- Pagina APP aqui -->
                                                <div class="content">
                                                    <%@ include file="components/sidebar.jspf" %>
                                                    <%@ include file="components/content.jspf" %>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </body>

                </html>