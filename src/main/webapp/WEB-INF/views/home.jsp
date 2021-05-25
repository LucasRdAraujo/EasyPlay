<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="pt-br">
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
        <title>EzGame - Home</title>
    </head>

    <body>
        <div class="container">
            <header id="header" class="row">
                <div class="col p-5 text-center">
                    <h1>EzGame</h1>
                </div>
            </header>
            <section class="row">
                <div class="col p-3 text-center">
                    <ul id="c-nav-bar" class="d-flex list-style-none justify-content-center">
                        <li><a href="#home">HOME</a></li>
                        <li><a href="#start-content">OPEN</a></li>
                        <li><a href="#contact">CONTACT</a></li>
                        <li><a href="#about">ABOUT</a></li>
                    </ul>
                </div>
            </section>
            <section id="start-content" class="row body-column">
                <div class="col p-5 text-center">
                    <h2>Bem vindo ao sla vei, qualquer coisa ai</h2>
                    <div class="d-flex p-3 ball-column">
                        <div class="ball ball-white m-5">
                            <i class="fas fa-comments font-size-1"></i>
                        </div>
                        <div class="ball ball-white m-5">
                            <i class="fas fa-trophy font-size-1"></i>
                        </div>
                        <div class="ball ball-white m-5">
                            <i class="fas fa-award font-size-1"></i>
                        </div>
                    </div>
                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. A quibusdam dolorum pariatur
                        quis
                        distinctio fugiat libero eos reiciendis omnis labore, facilis, consequuntur delectus
                        quidem
                        repudiandae? Ab tenetur ipsam nihil enim!</p>
                    <button href="/signin" class="c-btn c-btn-primary">Open in browser</button>
                </div>
            </section>
            <section id="about" class="row">
                <div class="col-md-3 p-5"></div>
                <div class="col p-5">
                    <h2>Algo aqui</h2>
                    <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Deleniti, dolorum? Dolor
                        aliquam,
                        libero
                        omnis architecto exercitationem tempore quidem placeat dolorum labore, obcaecati sit
                        nesciunt
                        soluta
                        illo id? Omnis, quae nostrum!</p>
                </div>
            </section>
            <section class="row">
                <div class="col p-5 text-right">
                    <h2>Algo aqui 2</h2>
                    <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Deleniti, dolorum? Dolor
                        aliquam,
                        libero
                        omnis architecto exercitationem tempore quidem placeat dolorum labore, obcaecati sit
                        nesciunt
                        soluta
                        illo id? Omnis, quae nostrum!</p>
                </div>
                <div class="col-md-3 p-5"></div>
            </section>
            <section id="contact" class="row">
                <div class="col p-5">
                    <h2>Contact</h2>
                    <p>Entre em contato conosco!</p>
                </div>
                <div class="col p-5">
                    <h2>Formulário</h2>
                    <form>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Email</label>
                            <input type="email" class="form-control" id="exampleFormControlInput1"
                                placeholder="name@example.com">
                        </div>
                        <br>
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Envie uma sugestão</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                        </div>
                        <br>
                        <div class="form-group">
                            <button class="c-btn c-btn-primary">Enviar</button>
                        </div>
                    </form>
                </div>
            </section>
            <a class="c-btn-ball c-btn-primary" href="#header"><i class="fas fa-arrow-up"></i></a>
            <footer class="row">
                <div id="footer" class="col p-5 text-light">
                    <p>Copyright a baixo</p>
                    <small>Copyright?</small>
                </div>
            </footer>
        </div>
    </body>
</html>