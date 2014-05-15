/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servilets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Robson
 */
@WebServlet(name = "link", urlPatterns = {"/link"})
public class link extends HttpServlet {

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
  
       int op = Integer.parseInt(request.getParameter("link"));
        RequestDispatcher redirecionar = null;       
       switch(op){
           case 1:
        redirecionar = request.getRequestDispatcher("WEB-INF/Ver ofertas.jsp");
       redirecionar.forward(request, response);
               break;
          case 2:
       redirecionar = request.getRequestDispatcher("WEB-INF/Oferta.jsp");
       redirecionar.forward(request, response);
               break;
          case 3:
       redirecionar = request.getRequestDispatcher("WEB-INF/Proposta.jsp");
       redirecionar.forward(request, response);
               break;
          case 4:
       redirecionar = request.getRequestDispatcher("WEB-INF/Ver propostas.jsp");
       redirecionar.forward(request, response);
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
