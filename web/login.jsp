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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="post">
        <h1>Login</h1>
        <p>Nome: <input type="text" name ="nome"></p>
        <p>Senha: <input type="password" name ="senha"></p>
        <p><input type="submit" value="Efetuar login"> <input type="reset" value="Cancelar"></p>
        </form>
    </body>
</html>
