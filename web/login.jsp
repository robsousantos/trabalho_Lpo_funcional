<%-- 
    Document   : login
    Created on : 15/05/2014, 13:36:12
    Author     : Robson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mercado de trocas</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
    </head>
    <body>
        
        <h1>Mercado de trocas </h1>
        
        <div id="login">
                <form action="Login" method="post">

                    <h2>Login</h2>
                <p>Nome: <input type="text" name ="nome"></p>
                <p>Senha: <input type="password" name ="senha"></p>
                <p><input type="submit" value="Efetuar login"> <input type="reset" value="Cancelar"></p>
                </form>
       </div>
    </body>
</html>
