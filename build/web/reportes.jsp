<%-- 
    Document   : reportes
    Created on : 13/02/2020, 11:00:01 AM
    Author     : saul
--%>

<%@page import="model.rotacioncampo.process.EspecialidadBP"%>
<%@page import="model.rotacioncampo.beans.Especialidad"%>
<%@page import="model.rotacioncampo.process.SedeBP"%>
<%@page import="model.rotacioncampo.beans.Sede"%>
<%@page import="model.rotacioncampo.process.DelegacionBP"%>
<%@page import="java.util.List"%>
<%@page import="model.rotacioncampo.beans.Delegacion"%>
<%@page import="model.rotacioncampo.process.AccesoBP"%>
<%@page import="model.rotacioncampo.process.ConfiguracionBP"%>
<%@page import="model.rotacioncampo.beans.Configuracion"%>
<%@page import="model.rotacioncampo.beans.Acceso"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
    String USU_CVE = request.getParameter("usu_cve"); //"45117"
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
    int ite;
    Delegacion del = new Delegacion(ac.getDEL_CVE());
    List<Delegacion> lstDel = DelegacionBP.consultaDelegacion(del);
    Sede sde = new Sede(ac.getDEL_CVE(),ac.getSDE_CVE());
    List<Sede> lstSde = SedeBP.consultaSede(sde);
    Especialidad esp = new Especialidad(ac.getSDE_CVE(), ac.getESP_CVE());
    List<Especialidad> lstEsp = EspecialidadBP.consultaEspecialidad(esp);  
    int columnas=4;

%>
<html lang="es">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Coordinación de Educación en Salud</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://framework-gb.cdn.gob.mx/qa/assets/styles/main.css" rel="stylesheet">
  <link rel="shortcut icon" href="./images/favicon.ico" type="image/vnd.microsoft.icon" />
  <script src="js/General.js" type="text/javascript"></script>
  <script src="js/ObjetoAJAX.js" type="text/javascript"></script>
  <script src="js/rotacion.js" type="text/javascript"></script>
</head>

    <body>
<header>
  <nav class="navbar navbar-default navbar-inverse">
    <div class="container-fluid">
      <div class="container"> 
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-1">
            <span class="sr-only">Menu</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse" id="navbar-1">
          <ul class="nav navbar-nav">
            <li><a href="rotacion.jsp?usu_cve=<%= USU_CVE %>">Rotación</a></li>
            <li><a href="sedes.jsp?usu_cve=<%= USU_CVE %>">Sedes</a></li>
            <li class="active"><a href="reportes.jsp?usu_cve=<%= USU_CVE %>">Reportes</a></li>            
          </ul>
        </div>
      </div>
    </div>
  </nav>
</header>

<main>
  <div class="container">
    <div class="row" class="col-xs-12 col-sm-12 col-md-12">
        <h2>Rotacion</h2>
    </div>
      <form role="form" action="reporte.jsp" method="post" target="_blank" autocomplete="off" class="form-horizontal">
        <input type="hidden" id="USU_CVE" value="<%= ac.getUSU_CVE() %>" />
        <input type="hidden" id="PERFIL" value="<%= ac.getPERFIL() %>" />
        <input type="hidden" id="PRO_ANO" name="PRO_ANO" value="2020" />
        <div class="row">
        <div class="form-group">
          <label class="control-label col-sm-2" for="DEL_CVE">Delegación<span id="valas_001" class="form-text">*</span>:</label>
          <div class="col-sm-6">
            <select class="form-control" name="DEL_CVE" id="DEL_CVE" onchange="cargaSede()">
                  <%
                    ite=0;
                    if (lstDel.isEmpty()){
                  %>
                      <option value="0">No se encontraron registros</option>
                  <%
                    } else {
                      if (lstDel.size()!=1){
                  %>
                      <option value="0"></option>
                  <%
                      }
                      for (ite = 0; ite<lstDel.size(); ite++){
                  %>
                  <option value="<%= lstDel.get(ite).getDEL_CVE() %>"><%= lstDel.get(ite).getDEL_NOM() %></option>
                  <%
                      }
                    }
                    lstDel = null;
                  %>               
            </select>
            <small id="val_001" class="form-text form-text-error" style="color:#D0021B; display: none"></small>
          </div>
        </div>
        </div>
        <div class="row">
        <div class="form-group">    
          <label class="control-label col-sm-2" for="SDE_CVE">Sede<span id="valas_002" class="form-text">*</span>:</label>
          <div class="col-sm-6">
          <span id="sSDE_CVE">
            <select class="form-control" name="SDE_CVE" id="SDE_CVE" onchange="cargaEspecialidad()">
                <%
                  ite=0;
                  if (lstSde.isEmpty()){
                %>
                    <option value="0">CAPTURE DELEGACION</option>
                <%
                  } else {
                    if (lstSde.size()!=1){
                %>
                    <option value="0"></option>
                <%
                    }
                    for (ite = 0; ite<lstSde.size(); ite++){
                %>
                <option value="<%= lstSde.get(ite).getSDE_CVE() %>"><%= lstSde.get(ite).getSDE_NOM() %></option>
                <%
                    }
                  }
                  lstSde = null;
                %>
            </select>
          </span>
          <small id="val_002" class="form-text form-text-error" style="color:#D0021B; display: none"></small>
          </div>
        </div>
        </div>
        <div class="row">
        <div class="form-group">    
          <label class="control-label col-sm-2" for="ESP_CVE">Especialidad<span id="valas_003" class="form-text">*</span>:</label>
          <div class="col-sm-6">
          <span id="sESP_CVE">
            <select class="form-control" name="ESP_CVE" id="ESP_CVE">
                <%
                  ite=0;
                  if (lstEsp.isEmpty()){
                %>
                    <option value="0">CAPTURE SEDE</option>
                <%
                  } else {
                    if (lstEsp.size()!=1){
                %>
                    <option value="0"></option>
                <%
                    }
                    for (ite = 0; ite<lstEsp.size(); ite++){
                %>
                <option value="<%= lstEsp.get(ite).getESP_CVE() %>"><%= lstEsp.get(ite).getESP_NOM() %></option>
                <%
                    }
                  }
                  lstEsp = null;
                %>
            </select>

          </span>
          <small id="val_003" class="form-text form-text-error" style="color:#D0021B; display: none"></small>
          </div>
        </div>
        <div class="row">
            <div class="clearfix col-md-12">
                <div class="pull-right">            
                    <button class="btn btn-primary" id="genera" onclick="" type="submit">
                        Genera reporte
                    </button>                
                </div>
            </div>
        </div>
            <div class="row">&nbsp;</div>
      </form> 
       
  </div>
</main>
<script src="https://framework-gb.cdn.gob.mx/qa/gobmx.js"></script>            
    </body>
</html>
<%
    } catch (Exception ex){
      pagina = "error.jsp?e=" + ex.getMessage();
      response.sendRedirect(pagina);
    }

%>