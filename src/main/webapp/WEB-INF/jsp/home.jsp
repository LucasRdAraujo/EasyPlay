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
                    <link rel="stylesheet" href="./assets/bootstrap-5.0.0-beta3-dist/css/bootstrap.css">
                    <script src="https://kit.fontawesome.com/6697f5eca6.js" crossorigin="anonymous"></script>
                    <link rel="stylesheet" href="${contextPath}/assets/css/styles.css">
                    <title>EasyPlay - Home</title>
                </head>

                <body>
                    <div class="container-fluid">
                        <header class="row header-spacing">
                            <div class="d-grid g-row-gap-110 brand-header w-100 header-spacing">
                                <nav id="nav" class="navbar navbar-dark">
                                    <a class="navbar-brand f-archivo" href="#">EasyPlay</a>
                                </nav>
                                <div class="header-title-column text-light text-position">
                                    <h1 class="f-archivo">Imagine só...</h1>
                                    <p>Um lugar onde você possa se reunir ou conhecer novos amigos. Onde você
                                        possa acompanhar as competições de seu pro-player favorito.</p>
                                    <a href="${contextPath}/signin" class="c-btn c-btn-primary">Começar</a>
                                </div>
                                <img class="header-img" src="${contextPath}/assets/svg/header-img.svg" alt="">
                            </div>
                        </header>
                    </div>
                    <div class="container-fluid">
                        <section class="row p-5 content-spacing">
                            <div class="col-md p-4 text-center">
                                <img style="width: 70%;" src="${contextPath}/assets/svg/trophy.svg" alt="">
                            </div>
                            <div class="col-md-5 p-4 align-self-center text-dark">
                                <h2 class="f-archivo">Reuna-se com seus amigos</h2>
                                <p>
                                    No EasyPlay você pode criar servidores privados para conversar com seus amigos e
                                    sentir-se mais em
                                    casa. Os servidores são separados em tópicos criados pelos próprios usuários.
                                </p>
                            </div>
                        </section>

                        <section class="row p-5 text-center section-gray section-gray-waves content-spacing">
                            <div class="col-md p-4">
                                <div>
                                    <div class="circle circle-primary circle-xxxlarge text-light mb-2">
                                        <i class="fas fa-trophy"></i>
                                    </div>
                                    <h2 class="f-archivo">Reuna-se para competir com amigos</h2>
                                    <p>No EasyPlay é possível competir com seus amigos em torneios, ganhe pontos para se
                                        tornar um
                                        campeão!
                                    </p>
                                </div>
                            </div>
                            <div class="col-md p-4">
                                <div>
                                    <div class="circle circle-primary circle-xxxlarge text-light mb-2">
                                        <i class="fas fa-exclamation-circle"></i>
                                    </div>
                                    <h2 class="f-archivo">Por dentro dos campeonatos</h2>
                                    <p>No EasyPlay você ficará bem informado de campeonatos que estão ocorrendo em
                                        outros
                                        servidores.</p>
                                </div>
                            </div>
                            <div class="col-md p-4">
                                <div>
                                    <div class="circle circle-primary circle-xxxlarge text-light mb-2">
                                        <i class="fas fa-shield-alt"></i>
                                    </div>
                                    <h2 class="f-archivo">Eu sou profissional</h2>
                                    <p>Ganhe pontos e adquira distintivos enquanto joga e mostre para seus amigos.</p>
                                </div>
                            </div>
                        </section>

                        <section class="row p-5 content-spacing">
                            <div class="col-md-5 p-4 align-self-center text-dark">
                                <h2 class="f-archivo">Moderação personalizada</h2>
                                <p>
                                    Organize sua comunidade com uma ferramenta simples de moderação por tags, monte
                                    canais privados e
                                    muito mais.
                                </p>
                            </div>
                            <div class="col-md p-4 text-center">
                                <img style="width: 70%;" src="${contextPath}/assets/svg/trophy.svg" alt="">
                            </div>
                        </section>

                        <section class="row p-5 section-gray section-gray-waves-top content-spacing">
                            <div class="col-md p-4 text-dark text-center">
                                <h2 class="f-archivo mb-3">Quer se juntar a esta comunidade?</h2>
                                <a href="${contextPath}/signin" class="c-btn c-btn-primary">Começar</a>
                            </div>
                        </section>
                    </div>
                    <div class="container-fluid">
                        <footer class="row">
                            <div class="d-grid g-row-gap-10 w-100 text-light">
                                <div class="row">
                                    <div class="col-md p-4">
                                        <h2 class="f-archivo">Envie-nos uma sugestão</h2>
                                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Earum dolor quo
                                            vitae explicabo
                                            ipsa
                                            cum omnis qui, odio eligendi nihil voluptatum a molestias voluptas culpa
                                            nulla tempora
                                            placeat
                                            numquam excepturi?</p>
                                    </div>
                                    <div class="col-md p-4">
                                        <h2 class="f-archivo">Contato</h2>
                                        <form>
                                            <div class="form-group mb-3">
                                                <label for="exampleInputEmail1">Email address</label>
                                                <input type="email" class="form-control" id="exampleInputEmail1"
                                                    aria-describedby="emailHelp">
                                            </div>
                                            <div class="form-group mb-3">
                                                <label for="exampleInputPassword1">Caixa de sugestões</label>
                                                <textarea style="height: 75px;" class="form-control" name="" id=""
                                                    cols="30" rows="10"></textarea>
                                            </div>
                                            <button type="submit"
                                                class="btn btn-warning text-light w-100">Submit</button>
                                        </form>
                                    </div>
                                </div>
                                <div class="p-2 text-center">
                                    <h2 class="f-archivo">EasyPlay</h2>
                                </div>
                                <div class="d-grid grid-column-center p-2">
                                    <div class="circle circle-xlarge circle-bg-color">
                                        <a href="#" class="footer-a"><i class="fab fa-discord"></i></a>
                                    </div>
                                    <div class="circle circle-xlarge circle-bg-color">
                                        <a href="#" class="footer-a"><i class="fab fa-facebook"></i></a>
                                    </div>
                                    <div class="circle circle-xlarge circle-bg-color">
                                        <a href="#" class="footer-a"><i class="fab fa-linkedin"></i></a>
                                    </div>
                                    <div class="circle circle-xlarge circle-bg-color">
                                        <a href="#" class="footer-a"><i class="fab fa-twitter"></i></a>
                                    </div>
                                </div>
                            </div>
                        </footer>
                    </div>
                </body>

                </html>