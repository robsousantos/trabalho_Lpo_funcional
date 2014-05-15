/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servilets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetos.Mercado;
import objetos.Usuario;

/**
 *
 * @author Robson
 */
@WebServlet(name = "efetuarLogin", urlPatterns = {"/Login"})
public class efetuarLogin extends HttpServlet {
    
     private static Mercado mercado= null;

    public efetuarLogin() throws Exception{
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
        try {
            Usuario usuario = new Usuario();
            
            usuario.setNome(request.getParameter("nome"));
            usuario.setSenha(request.getParameter("senha"));
            
            ResultSet login = mercado.login(usuario);
            
            while(login.next()){
            
            if (login.getString("NOME").equals(usuario.getNome()) && login.getString("SENHA").equals(usuario.getSenha())){
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
                session.setAttribute("nome_usuario", usuario.getNome());
                
                
                RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
           response.sendRedirect("index.jsp");
            
           
            }
            
            else {
            
                RequestDispatcher redirecionar = request.getRequestDispatcher("login.jsp");
           response.sendRedirect("login.jsp");
            
            }
            }
        } catch (Exception ex) {
         throw new  ServletException("falha no login"+ex);
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
