<%-- 
    Document   : reporte
    Created on : 13/02/2020, 02:14:00 PM
    Author     : saul
--%>

<%@page import="model.rotacioncampo.process.ResidenteBP"%>
<%@page import="model.rotacioncampo.beans.Residente"%>
<%@page import="java.util.List"%>

<%

  String DEL_CVE = request.getParameter("DEL_CVE");
  String SDE_CVE = request.getParameter("SDE_CVE");
  String ESP_CVE = request.getParameter("ESP_CVE");
try{  
  Residente res = new Residente(Integer.parseInt(SDE_CVE), Integer.parseInt(DEL_CVE), Integer.parseInt(ESP_CVE));
  List<Residente> lstRes = ResidenteBP.consultaResidente(res);
  response.setContentType("application/vnd.ms-excel");  
  response.setHeader("Content-disposition", "inline; filename=reporte.xls");
%>
<%@page contentType="application/vnd.ms-excel" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>reporte</title>
  </head>
  <body>
    <table border="1">
      <tr>
        <td style="background-color: #000000; color: #FFFFFF">DELEGACION<BR>DE ADSCRIPCION</td>
        <td style="background-color: #000000; color: #FFFFFF">SEDE DE<BR>ADSCRIPCION</td>
        <td style="background-color: #000000; color: #FFFFFF">ESPECIALIDAD</td>
        <td style="background-color: #000000; color: #FFFFFF">CURP</td>
        <td style="background-color: #000000; color: #FFFFFF">TELEFONO</td>
        <td style="background-color: #000000; color: #FFFFFF">CORREO</td>
        <td style="background-color: #000000; color: #FFFFFF">NOMBRE</td>
        <td style="background-color: #000000; color: #FFFFFF">DELEGACION<BR>ROTACION</td>
        <td style="background-color: #000000; color: #FFFFFF">SEDE<BR>ROTACION</td>
        <td style="background-color: #000000; color: #FFFFFF">PERIODO</td>
      </tr>
<%
  if(lstRes.size()>0){
  for (int ite = 0; ite<lstRes.size(); ite++){
%>      
      <tr>
        <td><%= lstRes.get(ite).getDEL_NOM() %></td>
        <td><%= lstRes.get(ite).getSDE_NOM() %></td>
        <td><%= lstRes.get(ite).getESP_NOM() %></td>
        <td><%= lstRes.get(ite).getCURP() %></td>
        <td><%= lstRes.get(ite).getTELEFONOS() %></td>
        <td><%= lstRes.get(ite).getCORREO() %></td>
        <td><%= lstRes.get(ite).getPER_AP1() %> <%= lstRes.get(ite).getPER_AP2() %> <%= lstRes.get(ite).getPER_NOM() %></td>
        <td><% if (lstRes.get(ite).getPRD_NUM()!=0) { %><%= lstRes.get(ite).getDEL_NOM_ROT() %><% } %></td>
        <td><% if (lstRes.get(ite).getPRD_NUM()!=0) { %><%= lstRes.get(ite).getSDE_NOM_ROT() %><% } %></td>
        <td><% if (lstRes.get(ite).getPRD_NUM()!=0) { %><%= lstRes.get(ite).getPRD_NUM() %><% } %></td>
      </tr>      
<%
 } 
 } else {
%>
      <tr>
        <td colspan="8">NO SE ENCONTRARON REGISTROS</td>
      </tr>
<%
 }
 %>        

    </table>
  </body>
</html>
<%

  } catch(Exception ex){
    response.sendRedirect("error.jsp?e=" + ex.getMessage());
  }
%>