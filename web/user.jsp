<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Biblioteca-Emprestimo</title>
        <link rel="shortcut icon" href="img/Library.png" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="js/telapaisesController.js" type="text/javascript"></script>
    </head>
    <body onload="MostraPaises()">
         <%
        String usuario = (String) session.getAttribute("usuario");
        if(usuario == null)
        {
            response.sendRedirect("index.jsp");
        }
    %>
        <div class="container">
            <a href="desconectar" class="btn btn-outline-danger" >Sair</a>
            <form name="pesquisa" onsubmit="MostraPaises()">
                <div class="form-group-lg">
                    <input type="text" name="filtro" id="filtro" value="" size="120" placeholder="Informe parte do nome do livro" class="form-control  mb-2 mr-sm-2"/>
                    <input type="submit" name="bpesq" value="pesquisar" class="form-control  mb-2 mr-sm-2 btn btn-primary"/>
                </div>
            </form>
            <div  overflow: auto">
                <div id="preview"></div> 
                                                           
            </div>
        </div>
    </body>
</html>