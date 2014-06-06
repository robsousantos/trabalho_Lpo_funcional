/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servilets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Mercado;
import objetos.Proposta;

/**
 *
 * @author Robson
 */
@WebServlet(name = "statusDeProposta", urlPatterns = {"/AtualizandoProposta"})
public class statusDeProposta extends HttpServlet {

      private static Mercado mercado= null;

          public statusDeProposta() throws Exception{
        try {
            mercado = new Mercado();
        } catch (Exception ex) {
            throw new  ServletException("Erro ao conectar"+ex);
        }


}
   
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    
    int opcao =Integer.parseInt(request.getParameter("opcao")) ;
    
        switch (opcao) {
            case 1:
        try {
            Proposta proposta = new Proposta();
            proposta.setId(Integer.parseInt(request.getParameter("id")));
            proposta.setStatus("Negociado");
            mercado.atualizaProposta(proposta);
            
              RequestDispatcher redirecionar = request.getRequestDispatcher("WEB-INF/Propostas recebidas.jsp");
       redirecionar.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(statusDeProposta.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                break;
           case 2:
        try {
            Proposta proposta = new Proposta();
            proposta.setId(Integer.parseInt(request.getParameter("id")));
            proposta.setStatus("Ofertas");
            mercado.atualizaProposta(proposta);
            
            RequestDispatcher redirecionar = request.getRequestDispatcher("WEB-INF/Propostas recebidas.jsp");
            redirecionar.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(statusDeProposta.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                break;
           
            }
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
