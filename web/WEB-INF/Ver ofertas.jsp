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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ofertas</h1>
        <table >
            <tr>
                <td>Titulo </td>
                <td>Descrição</td>
                <td>Ação</td>
                
            </tr>
            
               <%
                while(ofertas.next()){
                    out.print("<tr>");
                    String titulo = ofertas.getString("TITULO");
                    String descricao = ofertas.getString("DESCRICAO");
                    int id  = ofertas.getInt("id");
                    int i =1;
                    while(i<=3){
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
