<%-- 
    Document   : Ver oferfas
    Created on : 14/05/2014, 17:19:58
    Author     : Robson
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="objetos.Mercado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% 

Mercado mercado = new Mercado();
ResultSet propostas = null;
propostas = mercado.listarProposta();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Propostas</h1>
        
               <%
                while(propostas.next()){
                   
                    String ofertante = propostas.getString("OFERTANTE");
                    String desejo = propostas.getString("DESEJO");
                    String oferta = propostas.getString("OFERTA");
                    int id  = propostas.getInt("id");
                  
                   out.print("<h3>"+ofertante+"</h3> <p> deseja trocar seu(sua) "+oferta+" pelo(a) "+desejo+" ! </p>");
                }
                               
                %>
             
   
    </body>
</html>
