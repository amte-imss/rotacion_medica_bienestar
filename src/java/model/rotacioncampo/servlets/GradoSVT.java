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
import model.rotacioncampo.beans.Especialidad;
import model.rotacioncampo.process.EspecialidadBP;

/**
 *
 * @author saul
 */
public class GradoSVT extends HttpServlet {

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
      String SDE_CVE = request.getParameter("SDE_CVE");
      Especialidad esp = new Especialidad(Integer.parseInt(SDE_CVE), 0);
      if (SDE_CVE.equals("0")) {
        oStr.append("{SDE_CVE:'");
        oStr.append(SDE_CVE);
        oStr.append("', ESP_CVE:'0', ESP_NOM:'SELECCIONE SEDE'},");
      } else {
        List<Especialidad> lstEsp = EspecialidadBP.consultaEspecialidad(esp);
        
        if (lstEsp.isEmpty()) {
          oStr.append("{SDE_CVE:'");
          oStr.append(SDE_CVE);
          oStr.append("', ESP_CVE:'0', ESP_NOM:'NO SE ENCONTRARON ESPECIALIDADES'},");
        } else {
          for (int ite = 0; ite < lstEsp.size(); ite++) {
            oStr.append(((Especialidad)lstEsp.get(ite)).toString());
          }
        }
      }
    } catch (Exception ex) {
      oStr.append("{SDE_CVE:'0', ESP_CVE:'0', ESP_NOM:'");
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
