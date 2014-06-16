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
ResultSet ofertasdoUsuario = null;


ofertas = mercado.listaOfertasdeOutrosUsuarios(nome_usuario);
ofertasdoUsuario = mercado.listaOfertasdoUsuario(nome_usuario);
String proprietario= null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><a href="index.jsp">Inicio</a> > Criar Proposta!</h1>
        
        <form action="criar_Proposta" method ="post">
                    <p> Ola <% out.print(nome_usuario); %> Preencha os campos abaixo para criar sua oferta.
                
                <input type="hidden" name ="ofertante" value="<% out.print(nome_usuario); %>"></p>
             <p>Desejo:<select name ="desejo">
                <option  value="">Selecionar</option>
                
                <%
                while(ofertas.next()){
                    int id = ofertas.getInt("ID");
                    String oferta = ofertas.getString("TITULO_OFERTA");
                   proprietario = ofertas.getString("USUARIO_OFERTA");
                    out.print("<option value='"+id+"'>"+oferta+" de "+proprietario+" </option> de "+proprietario);
                    } 
                               
                %>
                
            </select></p>
            <p>Oferta: <select name="oferta">
                <option  value="">Selecionar</option>
                
                <%
                while(ofertasdoUsuario.next()){
                    int id = ofertasdoUsuario.getInt("ID");
                    String oferta = ofertasdoUsuario.getString("TITULO_OFERTA");
                   
                    out.print("<option value='"+oferta+"'>"+oferta+" </option> ");
                    } 
                               
                %>
            
            
            
            </select>
            </p>
            <p><input type="submit" value="Enviar Proposta"> <h3><a href="link?link=1">Cancelar</a></h3></p>
        
        </form>
    </body>
</html>
