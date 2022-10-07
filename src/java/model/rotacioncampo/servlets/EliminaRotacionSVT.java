/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.rotacioncampo.beans.Rotacion;
import model.rotacioncampo.process.RotacionBP;

/**
 *
 * @author saulob
 */
public class EliminaRotacionSVT extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        response.addHeader("pragma", "no-cache");
        response.addHeader("X-Frame-Options", "DENY");        
        response.addIntHeader("Expires", 0);
        PrintWriter out = response.getWriter();
        try {
            int usu_cve=Integer.parseInt(request.getParameter("usu_cve"));
            int reg_cve=Integer.parseInt(request.getParameter("rcve"));
            
            Rotacion rot = new Rotacion(0, reg_cve, 0);
            
            int resRot = RotacionBP.eliminaRotacion(rot);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/rotacion.jsp?usu_cve=" + usu_cve);
            rd.forward(request, response);
            /*out.println("[{error:'0', descripcion:'Se ha guardado la "
                    + "información correctamente', "
                    + "resultado:'" + respuesta + "'}]");*/
        } catch(Exception e){
          RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp?e=" + e.getMessage());
          rd.forward(request, response);
            /*out.println("[{error:'1', descripcion:'" + e.getMessage() + "', "
                    + "resultado:'0'}]");*/
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
