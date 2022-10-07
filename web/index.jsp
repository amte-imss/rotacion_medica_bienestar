<%-- 
    Document   : index
    Created on : 6/01/2020, 03:19:55 PM
    Author     : saul
--%>

<%@page import="model.rotacioncampo.process.AccesoBP"%>
<%@page import="model.rotacioncampo.process.ConfiguracionBP"%>
<%@page import="model.rotacioncampo.beans.Configuracion"%>
<%@page import="model.rotacioncampo.beans.Acceso"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%
    String USU_CVE = request.getParameter("usu_cve"); //"45647"; //request.getParameter("usu_cve"); //"45718"
    String pagina = "";
    Acceso ac = new Acceso();
    Configuracion cnf = new Configuracion();
    try {
      if (USU_CVE==null){
        throw new Exception("ACCESO RESTRINGIDO SIN USUARIO");
      }
      cnf = ConfiguracionBP.consultaConfiguracion(cnf);
      ac.setUSU_CVE(Integer.parseInt(USU_CVE));
      ac = AccesoBP.consultaAcceso(ac);
      pagina = "rotacion.jsp?usu_cve=" + USU_CVE;
      
    } catch (Exception ex){
      pagina = "error.jsp?e=" + ex.getMessage();
    }
    response.sendRedirect(pagina);

%>