/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.rotacioncampo.beans.SedeRotacion;
import model.rotacioncampo.process.SedeRotacionBP;

/**
 *
 * @author saul
 */
public class SedeRotacionSVT extends HttpServlet {

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
        StringBuilder oEdo = new StringBuilder("[");
        try {
            //int SDE_CVE = Integer.parseInt(request.getParameter("SDE_CVE"));
            int ESP_CVE = Integer.parseInt(request.getParameter("ESP_CVE"));
            int PRD_NUM = Integer.parseInt(request.getParameter("PRD_NUM"));
            SedeRotacion sde = new SedeRotacion(ESP_CVE, PRD_NUM);
            List<SedeRotacion> lstEdo = SedeRotacionBP.consultaSedeRotacion(sde);
            int ite = 0;
            if (lstEdo.isEmpty()){
                oEdo.append("{MTA_CVE:'");
                oEdo.append("0");
                oEdo.append("',SDE_NOM_ROT:'");
                oEdo.append("No se encontraron registros");
                oEdo.append("'},");
            } else {
                for (ite=0; ite<lstEdo.size(); ite++){
                    oEdo.append("{MTA_CVE:'");
                    oEdo.append(lstEdo.get(ite).getMTA_CVE());
                    oEdo.append("',SDE_NOM_ROT:'");
                    oEdo.append(lstEdo.get(ite).getSDE_NOM_ROT());
                    oEdo.append("'},");
                }
            }

        } catch (Exception e){
            oEdo.append("{MTA_CVE:'");
            oEdo.append("0");
            oEdo.append("',SDE_NOM_ROT:'");
            oEdo.append("Error:");
            oEdo.append(e.getMessage());
            oEdo.append("'},");
        } finally {
            oEdo.replace(oEdo.length()-1, oEdo.length(), "]");
            out.println(oEdo.toString());
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
