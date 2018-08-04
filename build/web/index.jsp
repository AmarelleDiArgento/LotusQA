<%--
  Document   : index
  Created on : 27/07/2018, 03:59:55 PM
  Author     : almoreno
  --%>

  <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta charset="UTF-16"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Lotus QA - Elite Flower</title>
        <link rel="shortcut icon" href="Img/favicon.png" type="image/x-icon"/>
        <!-- CSS -->
        <link href="css/material-icons.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>

        <!-- Etiquetas re recarga y contenido -->
        <meta http-equiv="Expires" content="0"/>
        <meta http-equiv="Last-Modified" content="0"/>
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate"/>
        <meta http-equiv="Pragma" content="no-cache"/>
      </head>
      <body>
        <nav class="white alfrente transparencia z-depth-0 " role="navigation">
          <div class="nav-wrapper">
            <img src="Img/logo.png" class="brand-logo responsive-img" alt="">
              <a href="#login" data-target="mobile-demo" class="sidenav-trigger modal-trigger">
                <i class="material-icons">person</i>
              </a>

            </a>

            <ul class="right hide-on-med-and-down">
              <li>
                <a href="#login" class="modal-trigger">
                  <i class="material-icons left">person</i>Inicia sesión</a>
              </li>

            </ul>
          </div>

        </nav>

        <div class="content">
          <div class="alfrente contenedor">
            <div class=" Loger">
              <div class="row">

                <form action="main.jsp" method="get">
                  <div class="input-field col s12">
                    <label for="User">Usuario</label>
                    <input type="text" class="Loger-text Mayusc" name="User" id="User"/>
                  </div>
                  <div class="input-field col s12">
                    <label for="Password">Password</label>
                    <input type="password" class="Loger-text" name="Password" id="Password"/>
                  </div>

                  <div class="input-field col s2">
                    <input name="accion" value="Ingresar" type="submit" class="modal-action modal-close waves-effect waves-green btn-flat"></div>

                  </form>

                </div>
            </div>
          </div>
          <%-- <div class="carousel carousel-slider center ">
            <div class="carousel-fixed-item center ">
              <a class="btn waves-effect white grey-text darken-text-2">button</a>
            </div>
            <div class="carousel-item red white-text" href="#one!">
              <img src="Img/backgroundIndex1.jpg"/>
            </div>
            <div class="carousel-item amber white-text" href="#two!">
              <h2>Second Panel</h2>
              <p class="white-text">This is your second panel</p>
            </div>
            <div class="carousel-item green white-text" href="#three!">
              <h2>Third Panel</h2>
              <p class="white-text">This is your third panel</p>
            </div>
            <div class="carousel-item blue white-text" href="#four!">
              <h2>Fourth Panel</h2>
              <p class="white-text">This is your fourth panel</p>
            </div>
          </div> --%>

            <div class="slider fullscreen ">

              <ul class="slides">
                <li>
                  <img src="Img/backgroundIndex1.jpg"/></li>
                <li>
                  <img src="Img/backgroundIndex2.jpg"/></li>
                <li>
                  <img src="Img/backgroundIndex3.jpg"/></li>
                <li>
                  <img src="Img/backgroundIndex4.jpg"/></li>
                <li>
                  <img src="Img/backgroundIndex5.jpg"/></li>
                <li>
                  <img src="Img/backgroundIndex6.jpg"/></li>
              </ul>
            </div>

          </div>
        </body>

        <!-- Modal Structure -->
        <div id="login" class="modal">
          <div class="modal-content">
            <h4>Inicia sesión</h4>
            <p>Bienvenido, ingresa tus datos</p>

            </div>
            <div class="modal-footer">
              <a href="#!" class="modal-close waves-effect waves-green btn-flat">Agree</a>
            </div>
          </div>

          <!--Scripts-->
          <script src="js/jquery-3.2.1.min.js"></script>
          <script src="js/materialize.js"></script>
          <script src="js/init.js"></script>

          <script type="text/javascript"></script>

        </html>
