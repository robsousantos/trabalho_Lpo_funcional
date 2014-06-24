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
ResultSet negociados = null;
negociados = mercado.ListaNegociados();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
        <title>Mercado de trocas</title> </head>
    <body>
        <h1>Mercado de trocas</h1>
        <h2><a href="index.jsp">Inicio</a> > Trocas concluidas</h2>
             
               <%
              int numRegistros = 0; 
                        while(negociados.next()){
                            String proprietario = negociados.getString("USUARIO_OFERTA");
                            String ofertante = negociados.getString("usuario_proposta");
                            String proposta = negociados.getString("PROPOSTA");
                            String oferta = negociados.getString("titulo_OFERTA");
                            int id  = negociados.getInt("id");

                        out.print("<h3>"+proprietario+"</h3> <p> aceitou trocar seu(sua) "+oferta+" pelo(a) "+proposta+" de "+ofertante+" !</p>");
                        numRegistros++;
                        }
              if (numRegistros == 0){
              out.print("<h3> nenhuma troca foi efetuada <a href='index.jsp'> voltar ao inicio</a></h3>");
              }
                             
                %>
             
   
    </body>
</html>
