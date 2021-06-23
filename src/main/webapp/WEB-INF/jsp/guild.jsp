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
                    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                    <link rel="stylesheet" href="${contextPath}/assets/css/app.css">
                    <title>EasyPlay - Nome server</title>
                </head>

                <body>
                    <%@ include file="components/guild/createChannelPopup.jspf" %>

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

                                                <!-- Sidebar aqui -->
                                                <div class="content">
                                                    <%@ include file="components/guild/sidebar.jspf" %>

                                                        <!-- Conteudo app aqui -->
                                                        <div class="app-body">
                                                            <div class="app-body-content">
                                                                <main class="app-body">
                                                                    <%@ include file="components/guild/content.jspf" %>
                                                                </main>
                                                                <div class="users-wrap">
                                                                    <div id="users-overflow" class="users">
                                                                        <div class="scroller-content">
                                                                            <%@ include
                                                                                file="components/guild/users.jspf" %>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
                    <script src="${contextPath}/assets/js/guild.js"></script>
                </body>

                </html>