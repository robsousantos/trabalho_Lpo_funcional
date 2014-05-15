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
import objetos.Mercado;
import objetos.Oferta;
import objetos.Proposta;

/**
 *
 * @author Robson
 */
@WebServlet(name = "criaProposta", urlPatterns = {"/criar_Proposta"})
public class criaProposta extends HttpServlet {
    
    private static Mercado mercado= null;

    public criaProposta() throws Exception{
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
    
        out.print("salvando oferta");
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
         RequestDispatcher dispatcher = request.getRequestDispatcher("Oferta.jsp");
        dispatcher.forward(request, response);
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
        try {
            Proposta proposta = new Proposta();
            proposta.setOfertante(request.getParameter("ofertante"));
            proposta.setOferta(request.getParameter("oferta"));
            proposta.setDesejo(request.getParameter("desejo"));
            
            mercado.criaProposta(proposta);
            
            RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
           response.sendRedirect("index.jsp");
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
        
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
