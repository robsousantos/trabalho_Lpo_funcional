<%-- 
    Document   : Proposta
    Created on : 14/05/2014, 16:18:03
    Author     : Robson
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="objetos.Mercado"%>
<%@page import="java.util.List"%>
<%@page import="objetos.Oferta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% 
 
String nome_usuario =(String) session.getAttribute("nome_usuario");

Mercado mercado = new Mercado();
ResultSet ofertas = null;
ofertas = mercado.listarOfertas();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Criar Proposta!</h1>
        
        <form action="criar_Proposta" method ="post">
                    <p> Ola <% out.print(nome_usuario); %> Preencha os campos abaixo para criar sua oferta.
                
                <input type="hidden" name ="ofertante" value="<% out.print(nome_usuario); %>"></p>
             <p>Desejo:<select name ="desejo">
                <option  value="">Selecionar</option>
                
                <%
                while(ofertas.next()){
                    String oferta = ofertas.getString("TITULO");
                    out.print("<option value='"+oferta+"'>"+oferta+"</option>");
                    }
                               
                %>
                
            </select></p>
             <p>Oferta: <input type="text" name ="oferta"> </p>
             <p><input type="submit" value="Enviar Proposta"> <input type="reset" value="Cancelar"> </p>
        
        </form>
    </body>
</html>
