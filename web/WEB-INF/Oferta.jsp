<%-- 
    Document   : Oferta
    Created on : 14/05/2014, 13:59:37
    Author     : Robson
--%>

<%@page import="objetos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
String nome_usuario =(String) session.getAttribute("nome_usuario");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <title>Mercado de trocas</title> </head>
    <body>
        <h1>Mercado de trocas</h1>
        <h2><a href="index.jsp">Inicio</a> > Criar oferta</h2>
     
        <form action="criar_Oferta" method ="post">
            <p> Ola <% out.print(nome_usuario); %> Preencha os campos abaixo para criar sua oferta.
                
                <input type="hidden" name ="ofertante" value="<% out.print(nome_usuario); %>"></p>
            <p> Titulo: <input type="text" name ="titulo"></p>
            <p> Descrição: <br/> 
                <textarea name ="descricao"> </textarea> </p>
                <input type="hidden" name ="grupo" value="Ofertas">
            
            <p><input type="submit" value="Enviar Oferta"> <input type="reset" value="Cancelar"> </p>
        </form>
    </body>
</html>
