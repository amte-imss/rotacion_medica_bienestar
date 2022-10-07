<%-- 
    Document   : error
    Created on : 8/01/2020, 03:38:42 PM
    Author     : saul
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Coordinación de Educación en Salud</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://framework-gb.cdn.gob.mx/qa/assets/styles/main.css" rel="stylesheet">
  <link rel="shortcut icon" href="./images/favicon.ico" type="image/vnd.microsoft.icon" />
    </head>
    <body>
<header>
  <nav class="navbar navbar-default navbar-inverse">
    <div class="container-fluid">
      <div class="container"> 
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-1">
            <span class="sr-only">Menu</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse" id="navbar-1">
          <ul class="nav navbar-nav">
            <li class="active"><a href="error.jsp">Error</a></li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
</header>
        
<main>
  <div class="container">
    <div class="row" class="col-xs-12 col-sm-12 col-md-12">
        <h2>Error</h2>
    </div>
      <div class="alert alert-danger"><%= request.getParameter("e") %></div>
    </div>
</main>
    <script src="https://framework-gb.cdn.gob.mx/qa/gobmx.js"></script>            
    </body>
</html>
