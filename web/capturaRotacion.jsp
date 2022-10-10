<%-- 
    Document   : capturaRotacion
    Created on : 11/02/2020, 01:52:07 PM
    Author     : saul
--%>

<%@page import="model.rotacioncampo.process.SedeRotacionBP"%>
<%@page import="model.rotacioncampo.beans.SedeRotacion"%>
<%@page import="model.rotacioncampo.process.PeriodoBP"%>
<%@page import="model.rotacioncampo.beans.Periodo"%>
<%@page import="model.rotacioncampo.process.ResidenteBP"%>
<%@page import="java.util.List"%>
<%@page import="model.rotacioncampo.beans.Residente"%>
<%@page import="model.rotacioncampo.process.AccesoBP"%>
<%@page import="model.rotacioncampo.process.ConfiguracionBP"%>
<%@page import="model.rotacioncampo.beans.Configuracion"%>
<%@page import="model.rotacioncampo.beans.Acceso"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%
    String USU_CVE = request.getParameter("usu_cve"); //"45117"
    String pagina = "";
    Acceso ac = new Acceso();
    Configuracion cnf = new Configuracion();
    //try {
        if (USU_CVE == null) {
            throw new Exception("ACCESO RESTRINGIDO SIN USUARIO");
        }
        cnf = ConfiguracionBP.consultaConfiguracion(cnf);
        ac.setUSU_CVE(Integer.parseInt(USU_CVE));
        ac = AccesoBP.consultaAcceso(ac);
        int ite;
        int REG_CVE = Integer.parseInt(request.getParameter("rcve"));
        List<Residente> lstRes = ResidenteBP.consultaResidente(REG_CVE);
        Periodo per = new Periodo(0, null, lstRes.get(0).getSDE_CVE(), lstRes.get(0).getESP_CVE(), lstRes.get(0).getGRD_NUM());
        List<Periodo> lstPer = PeriodoBP.consultaPeriodo(per);
        SedeRotacion sro = new SedeRotacion(lstRes.get(0).getSDE_CVE(), lstRes.get(0).getESP_CVE(), 0);
        List<SedeRotacion> lstSRo = SedeRotacionBP.consultaSedeRotacion(sro);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Coordinación de Educación en Salud</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://framework-gb.cdn.gob.mx/qa/assets/styles/main.css" rel="stylesheet">
        <link rel="shortcut icon" href="./images/favicon.ico" type="image/vnd.microsoft.icon" />
        <script src="js/General.js" type="text/javascript"></script>
        <script src="js/ObjetoAJAX.js" type="text/javascript"></script>
        <script src="js/capturaRotacion.js" type="text/javascript"></script>
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
                                <li class="active"><a href="rotacion.jsp?usu_cve=<%= USU_CVE%>">Rotación</a></li>
                                <li><a href="sedes.jsp?usu_cve=<%= USU_CVE%>">Sedes</a></li>
                                <li><a href="reportes.jsp?usu_cve=<%= USU_CVE%>">Reportes</a></li>            
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
                <form role="form" action="guardaRotacion" method="post" target="_self" autocomplete="off">
                    <input type="hidden" id="USU_CVE" name="USU_CVE" value="<%= ac.getUSU_CVE()%>" />
                    <input type="hidden" id="PERFIL" name="PERFIL" value="<%= ac.getPERFIL()%>" />
                    <input type="hidden" id="PRO_ANO" name="PRO_ANO" value="2020" />
                    <input type="hidden" id="REG_CVE" name="REG_CVE" value="<%= lstRes.get(0).getREG_CVE()%>" />
                    <input type="hidden" id="SDE_CVE" name="SDE_CVE" value="<%= lstRes.get(0).getSDE_CVE()%>" />
                    <input type="hidden" id="ESP_CVE" name="ESP_CVE" value="<%= lstRes.get(0).getESP_CVE()%>" />
                    <div id="errores" class="alert alert-danger" style="display:none"><strong>¡Error de registro!</strong> No has llenado campos requeridos. Por favor verifica.</div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="DEL_NOM">Delegación:</label>
                                <div>
                                    <p class="form-control-static"><%= lstRes.get(0).getDEL_NOM()%></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label class="control-label" for="SDE_NOM">Sede:</label>
                                <div>
                                    <p class="form-control-static"><%= lstRes.get(0).getSDE_NOM()%></p>
                                </div>
                            </div>
                        </div>            
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="GRD_NUM">Grado:</label>
                                <div>
                                    <p class="form-control-static"><%= lstRes.get(0).getGRD_NUM()%></p>
                                </div>
                            </div>
                        </div>                        
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label class="control-label" for="ESP_NOM">Especialidad:</label>
                                <div>
                                    <p class="form-control-static"><%= lstRes.get(0).getESP_NOM()%></p>
                                </div>
                            </div>
                        </div>
                    </div>    
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="CURP">CURP:</label>
                                <div>
                                    <p class="form-control-static"><%= lstRes.get(0).getCURP()%></p>
                                </div>
                            </div>
                        </div>                        
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label class="control-label" for="PER_NOM">Nombre:</label>
                                <div>
                                    <p class="form-control-static"><%= lstRes.get(0).getPER_AP1()%> <%= lstRes.get(0).getPER_AP2()%> <%= lstRes.get(0).getPER_NOM()%></p>
                                </div>
                            </div>
                        </div>
                    </div>   
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="PRD_NUM">Periodo<span id="valas_001" class="form-text">*</span>:</label>
                                <select class="form-control" name="PRD_NUM" id="PRD_NUM" onchange="cargaMeta()">
                                    <%
                                        ite = 0;
                                        if (lstPer.isEmpty()) {
                                    %>
                                    <option value="0">Sin sedes de rotacion</option>
                                    <%
                                    } else {
                                    %>
                                    <option value="0"></option>
                                    <%
                                        for (ite = 0; ite < lstPer.size(); ite++) {
                                    %>
                                    <option value="<%= lstPer.get(ite).getPRD_NUM()%>"><%= lstPer.get(ite).getPRD_NOM()%></option>
                                    <%
                                            }
                                        }
                                        lstPer = null;
                                    %>
                                </select>
                                <small id="val_001" class="form-text form-text-error" style="color:#D0021B; display: none"></small>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label class="control-label" for="MTA_CVE">Sede de rotación<span id="valas_002" class="form-text">*</span>:</label>
                                <span id="sMTA_CVE">
                                    <select class="form-control" name="MTA_CVE" id="MTA_CVE">
                                        <%
                                            ite = 0;
                                            if (lstSRo.isEmpty()) {
                                        %>
                                        <option value="0">Capture Periodo</option>
                                        <%
                                        } else {
                                            if (lstSRo.size() != 1) {
                                        %>
                                        <option value="0"></option>
                                        <%
                                            }
                                            for (ite = 0; ite < lstSRo.size(); ite++) {
                                        %>
                                        <option value="<%= lstSRo.get(ite).getMTA_CVE()%>"><%= lstSRo.get(ite).getSDE_NOM_ROT()%></option>
                                        <%
                                                }
                                            }
                                            lstPer = null;
                                        %>
                                    </select>
                                </span>
                                <small id="val_002" class="form-text form-text-error" style="color:#D0021B; display: none"></small>
                            </div>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="clearfix col-md-12">
                            <div class="pull-right">
                                <%
                                    if (ac.getPERFIL().equals("CLINICO") || ac.getPERFIL().equals("ADMINISTRADOR")) {
                                %>                        
                                <button class="btn btn-primary" id="guarda" onclick="valida();" type="button">
                                    Guardar
                                </button>                
                                <%
                                    }
                                %>                        

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
    /*} catch (Exception ex) {
        pagina = "error.jsp?e=" + ex.getMessage();
        response.sendRedirect(pagina);
    }*/

%>