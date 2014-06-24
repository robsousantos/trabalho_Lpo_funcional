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
ResultSet ofertas = null;
ofertas = mercado.listarOfertas();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <title>Mercado de trocas</title> </head>
    <body>
        <h1>Mercado de trocas</h1>
        <h2><a href="index.jsp">Inicio</a> > Ofertas</h2>
        <table width="100%">
            <tr class="linhatitulo">
                <td>Titulo </td>
                <td>Descrição</td>
                <TD>Proprietário</td>
                <td>Ação</td>
                
            </tr>
            
               <%
                while(ofertas.next()){
                    out.print("<tr>");
                    String titulo = ofertas.getString("TITULO_OFERTA");
                    String descricao = ofertas.getString("DESCRICAO");
                    String proprietario = ofertas.getString("USUARIO_OFERTA");
                    int id  = ofertas.getInt("ID");
                    int i =1;
                    while(i<=4){
                        switch(i){
                        case 1:
                            out.print("<td>"+titulo+"</td>");
                            i++;
                            break;
                        case 2:
                            out.print("<td>"+descricao+"</td>");
                            i++;
                            break;
                        case 3:
                            out.print("<td>"+proprietario+"</td>");
                            i++;
                            break;
                        case 4:
                            out.print("<td><a href='link?link=3'>Fazer proposta</a></td>");
                            i++;
                            break;
                        };
                    
                    }
                 out.print("</tr>");    
                   
                }
                               
                %>
             
        </table>
    </body>
</html>
