<%-- 
    Document   : Ver oferfas
    Created on : 14/05/2014, 17:19:58
    Author     : Robson
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="objetos.Mercado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% 
String usuario =(String) session.getAttribute("nome_usuario");
Mercado mercado = new Mercado();
ResultSet propostas = null;
propostas = mercado.PropostasPorUsuario(usuario);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><a href="index.jsp">Inicio</a> > Propostas recebidas</h1>
        
               <%
                int numRegistros = 0;  
                while(propostas.next()){
                   
                    String ofertante = propostas.getString("USUARIO_PROPOSTA");
                    String desejo = propostas.getString("TITULO_OFERTA");
                    String oferta = propostas.getString("PROPOSTA");
                    int id  = propostas.getInt("id");
                  
                   out.print("<h3>"+ofertante+"</h3> <p> deseja trocar seu(sua) "+oferta+" por seu(sua) "+desejo+" deseja aceitar <a href='AtualizandoProposta?id="+id+"&opcao=1' > SIM </a> ou <a href='AtualizandoProposta?id="+id+"&opcao=2' > não </a> ? </p>");
                
                numRegistros++;
                }
                
                if (numRegistros==0){
                    out.print("<h3>Você não recebeu nenhuma proposta <a href='index.jsp'> Voltar </a> </h3>");
                    };
                %>
             
   
    </body>
</html>
