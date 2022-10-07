/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function isNumeric(value/*, strict = true */) {
  return typeof value === "number" || !isNaN(arguments[1] == false ? parseFloat(value) : Number(value.replace(/^\s*$/, 'a')));
}

function redondea(num) {
  return (Math.round(num * 100) / 100).toFixed(2);
}

function redondeaObj(obj) {
  if(isNumeric(document.getElementById(obj.id).value)){
    document.getElementById(obj.id).value = redondea(document.getElementById(obj.id).value);
  } else {
    $('#valorNumerico').modal();
  }
}

function ponleCero(obj) {
  if (document.getElementById(obj.id).value == "") {
    document.getElementById(obj.id).value = redondea(0.0);
  }
}


function cargaSede(){
  var DEL_CVE = document.getElementById("DEL_CVE")[document.getElementById("DEL_CVE").selectedIndex].value;  
  obSde = new ObjetoAJAX();
  obSde.enviar("sede?DEL_CVE=" + DEL_CVE,"GET","cSde",null);      
}

function cSde(){
  var sede = eval("(" + obSde.respuestaTexto() + ")");
  var cadena="<select class='form-control' name='SDE_CVE' id='SDE_CVE' onchange='cargaEspecialidad()'>";
  if (sede.length==1){
    cadena += "<option value='" + sede[0].SDE_CVE + "'>" + sede[0].SDE_NOM + "</option>";
  } else {
    cadena += "<option value='0'>SELECCIONE</option>";
    for(var elm=0; elm<sede.length; elm++){
      cadena += "<option value='" + sede[elm].SDE_CVE + "'>" + sede[elm].SDE_NOM + "</option>";
    }
  }
  cadena += "</select>";
  document.getElementById("sSDE_CVE").innerHTML=cadena;
  sede = null;
  obSde = null;
  cargaEspecialidad();
}

function cargaEspecialidad(){
  var SDE_CVE = document.getElementById("SDE_CVE")[document.getElementById("SDE_CVE").selectedIndex].value;  
  obEsp = new ObjetoAJAX();
  obEsp.enviar("especialidad?SDE_CVE=" + SDE_CVE,"GET","cEsp",null);      
}

function cEsp(){
  var especialidad = eval("(" + obEsp.respuestaTexto() + ")");
  var cadena="<select class='form-control' name='ESP_CVE' id='ESP_CVE' onchange='cargaGrado();'>";
  if (especialidad.length==1){
    cadena += "<option value='" + especialidad[0].ESP_CVE + "'>" + especialidad[0].ESP_NOM + "</option>";
  } else {
    if (especialidad.length!=1){
      cadena += "<option value='0'>TODAS</option>";
    }
    for(var elm=0; elm<especialidad.length; elm++){
      cadena += "<option value='" + especialidad[elm].ESP_CVE + "'>" + especialidad[elm].ESP_NOM + "</option>";
    }
  }
  cadena += "</select>";
  document.getElementById("sESP_CVE").innerHTML=cadena;
  especialidad = null;
  obEsp = null;

  //cargaGrado();
  cargaResidentes();
}

function cargaGrado(){
  var ESP_CVE = document.getElementById("ESP_CVE")[document.getElementById("ESP_CVE").selectedIndex].value;  
  obEsp = new ObjetoAJAX();
  obEsp.enviar("grado?ESP_CVE=" + ESP_CVE,"GET","cGrad",null);      
}

function cGrad(){
  var especialidad = eval("(" + obEsp.respuestaTexto() + ")");
  var cadena="<select class='form-control' name='GRD_NUM' id='GRD_NUM' onchange='cargaResidentes()'>";
  if (especialidad.length==1){
    cadena += "<option value='" + especialidad[0].GRD_NUM + "'>" + especialidad[0].GRD_NUM + "</option>";
  } else {
    if (especialidad.length!=1){
      cadena += "<option value='0'>TODAS</option>";
    }
    for(var elm=0; elm<especialidad.length; elm++){
      cadena += "<option value='" + especialidad[elm].GRD_NUM + "'>" + especialidad[elm].GRD_NUM + "</option>";
    }
  }
  cadena += "</select>";
  document.getElementById("sGRD_NUM").innerHTML=cadena;
  especialidad = null;
  obEsp = null;

  //cargaGrado();
  cargaResidentes();
}

function cargaResidentes(){
  document.getElementById("tblResidentes").innerHTML = "";
  var SDE_CVE = document.getElementById("SDE_CVE")[document.getElementById("SDE_CVE").selectedIndex].value;  
  var ESP_CVE = document.getElementById("ESP_CVE")[document.getElementById("ESP_CVE").selectedIndex].value;  
  obRes = new ObjetoAJAX();
  obRes.enviar("residente?BUSCA=SEDE&SDE_CVE=" + SDE_CVE + "&ESP_CVE=" + ESP_CVE,"GET","cRes",null);      
}

function cRes(){
  var SDE_CVE = document.getElementById("SDE_CVE")[document.getElementById("SDE_CVE").selectedIndex].value;  
  var ESP_CVE = document.getElementById("ESP_CVE")[document.getElementById("ESP_CVE").selectedIndex].value;  
  var USU_CVE = document.getElementById("USU_CVE").value;
  var PERFIL = document.getElementById("PERFIL").value;
  var residentes = eval("(" + obRes.respuestaTexto() + ")");
  var cadena="<table class='table table-bordered'>";
  cadena+="<thead>";
  cadena+="<tr>";
  if (ESP_CVE==0){
    cadena+="<th>ESPECIALIDAD</th>";
    cadena+="<th>GRADO</th>";
    cadena+="<th>NOMBRE</th>";
    cadena+="<th>CALIFICACION FINAL</th>";
    cadena+="<th><a onclick='javascript:recarga()' href='imprimeFormatos.jsp?SDE_CVE=" + SDE_CVE + "&ESP_CVE=" + ESP_CVE + "' target='_blank' title='Impresion General'><span class='glyphicon glyphicon-print'></span></a></th>"; //aqui va lo de impresion de formatos general
  } else {
    cadena+="<th>GRADO</th>";
    cadena+="<th>NOMBRE</th>";
    cadena+="<th>CALIFICACION FINAL</th>";
    cadena+="<th><a onclick='javascript:recarga()' href='imprimeFormatos.jsp?SDE_CVE=" + SDE_CVE + "&ESP_CVE=" + ESP_CVE + "' target='_blank' title='Impresion General'><span class='glyphicon glyphicon-print'></span></a></th>"; //aqui va lo de impresion de formatos general
  }
  cadena+="</tr>";
  cadena+="</thead>";
  cadena+="<tbody>";
  if (residentes[0].ADS_CVE=="0"){
    if (ESP_CVE=="0"){
      cadena += "<tr>";
      cadena += "<td colspan='5' class='danger'>";
      cadena += residentes[0].SDE_NOM;
      cadena += "</td>";
      cadena += "</tr>";
     } else {
       cadena += "<tr>";
      cadena += "<td colspan='5' class='danger'>";
      cadena += residentes[elm].SDE_NOM;
      cadena += "</td>";
      cadena += "</tr>";
     }
  } else {
    for(var elm=0; elm<residentes.length; elm++){
      color="";
      if (residentes[elm].BAN_CAL=="1"){
        color="warning";
      }
      if (residentes[elm].BAN_IMP=="0"){
        color="success";
      }
      cadena += "<tr>";
      if (ESP_CVE=="0"){
        cadena += "<td class='" + color + "'>";
        cadena += residentes[elm].ESP_NOM;
        cadena += "</td>";
      }
      
      cadena += "<td class='" + color + "'>";
      cadena += residentes[elm].GRD_NUM;
      cadena += "</td>";
      cadena += "<td class='" + color + "'>";
      cadena += residentes[elm].PER_AP1 + " " + residentes[elm].PER_AP2 + " " + residentes[elm].PER_NOM;
      cadena += "</td>";
      cadena += "<td class='" + color + "'>";
      if(redondea(residentes[elm].CAL_NUM)==redondea(0)){
        cadena += "&nbsp;";
      } else {
        cadena += redondea(residentes[elm].CAL_NUM);
      }
      cadena += "</td>";
      cadena += "<td class='" + color + "'>";
      if (residentes[elm].BAN_IMP=="1" && (PERFIL=="ADMINISTRADOR" || PERFIL=="PROFESOR" || PERFIL=="CLINICO")){
        cadena += "<a href='califica.jsp?usu_cve=" + document.getElementById("USU_CVE").value + "&ads_cve=" + residentes[elm].ADS_CVE + "' target='_self' title='Calificar Residente'><span class='glyphicon glyphicon-list-alt'></span></a>&nbsp;";
      }
      if (residentes[elm].BAN_CAL=="1"){
        cadena += "&nbsp;&nbsp;<a onclick='javascript:recarga()' href='imprime?USU_CVE=" + USU_CVE + "&ADS_CVE=" + residentes[elm].ADS_CVE + "' target='_blank' title='Generar CEM4'><span class='glyphicon glyphicon-print'></span></a>"
      }
      if (USU_CVE=="39177" && PERFIL=="ADMINISTRADOR" && residentes[elm].BAN_IMP=="0"){
        //cadena += "&nbsp;&nbsp;<a onclick='javascript:desbloquea(" + residentes[elm].ADS_CVE + ")' title='Desbloquear Residente para Calificar'><span class='glyphicon glyphicon-pencil'></span></a>"
      }
      cadena += "&nbsp;";
      cadena += "</td>";
      cadena += "</tr>";
    }
  }
  obRes = null;
  cadena += "</tbody>";
  cadena += "</table>";
  document.getElementById("tblResidentes").innerHTML = cadena;  
  
}

function recarga(){
  var a = setTimeout("cargaResidentes()", 5000);
  
}

function carga(){
  cargaEspecialidad();
  
}




