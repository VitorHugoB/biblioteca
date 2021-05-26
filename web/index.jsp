<%-- 
    Document   : index
    Created on : 06/03/2021, 18:25:09
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>Biblioteca</title>
    <link rel="icon" href="img/logo2.png" type="image/png" sizes="16x16">
    <link rel="shortcut icon" href="img/Library.png" >
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    

    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
      body
      {
          background-image: linear-gradient(to bottom right, white, #2F6ECC);
      }
  
    </style>   
   <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet" type="text/css"/>
  </head>
  <body class="text-center conteiner-fluid">
    
<main class="form-signin">
    <form action="index.jsp">
    <img class="mb-4" src="img/Library.png" alt="" width="152" height="137">   
    <h1 class="h3 mb-3 fw-normal">Biblioteca</h1>
    <label class="visually-hidden">RA</label>
    <input type="text" id="RA" class="form-control" name="usuario" placeholder="RA" required autofocus>
    
    <div class="checkbox mb-3">
      <label>
       
      </label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Entrar</button>
    <p class="mt-5 mb-3 text-muted">&copy;2021</p>
  </form>
  <%      
      String usuario =request.getParameter("usuario");
     
     
     if (usuario!=null && !usuario.isEmpty())
     {session.setAttribute("usuario",usuario);
     response.sendRedirect("login");
     }
        %>
    
    
</main>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
  </body>
</html>
