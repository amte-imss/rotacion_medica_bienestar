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
import model.rotacioncampo.beans.Sede;
import model.rotacioncampo.process.SedeBP;

/**
 *
 * @author saul
 */
public class SedeSVT extends HttpServlet {

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
    response.addIntHeader("Expires", 0);
    PrintWriter out = response.getWriter();
    StringBuilder oStr = new StringBuilder("[");
    try
    {
      String DEL_CVE = request.getParameter("DEL_CVE");
      Sede sde = new Sede(Integer.parseInt(DEL_CVE), 0);
      if (DEL_CVE.equals("0")) {
        oStr.append("{DEL_CVE:'");
        oStr.append(DEL_CVE);
        oStr.append("', SDE_CVE:'0', SDE_NOM:'SELECCIONE DELEGACION'},");
      } else {
          List<Sede> lstSde = SedeBP.consultaSede(sde);
        
        if (lstSde.isEmpty()) {
          oStr.append("{DEL_CVE:'");
          oStr.append(DEL_CVE);
          oStr.append("', SDE_CVE:'0', SDE_NOM:'NO SE ENCONTRARON SEDES'},");
        } else {
          for (int ite = 0; ite < lstSde.size(); ite++) {
            oStr.append(((Sede)lstSde.get(ite)).toString());
          }
        }
      }
    }
    catch (Exception ex) {
      oStr.append("{DEL_CVE:'0', SDE_CVE:'0', SDE_NOM:'");
      oStr.append(ex.getMessage());
      oStr.append("'},");
    } finally {
      oStr.replace(oStr.length() - 1, oStr.length(), "]");
      out.println(oStr.toString());
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
