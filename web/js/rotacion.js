/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargaSede(){
  var DEL_CVE = document.getElementById("DEL_CVE")[document.getElementById("DEL_CVE").selectedIndex].value;
  obSde = new ObjetoAJAX();
  obSde.enviar("sede?DEL_CVE=" + DEL_CVE,"GET","cSde",null);        
}

function cSde(){
    var sedes = eval("(" + obSde.respuestaTexto() + ")");
    var cadena="<select class='form-control' name='SDE_CVE' id='SDE_CVE' onchange='cargaEspecialidad()'>";
        cadena += "<option value='0'></option>";
        for(var elm=0; elm<sedes.length; elm++){
            cadena += "<option value='" + sedes[elm].SDE_CVE + "'>" + sedes[elm].SDE_NOM + "</option>";
        }
    cadena += "</select>";
    document.getElementById("sSDE_CVE").innerHTML=cadena;
    sedes = null;
    obSde=null;
    cargaEspecialidad();
}

function cargaEspecialidad(){
  var DEL_CVE = document.getElementById("DEL_CVE")[document.getElementById("DEL_CVE").selectedIndex].value;
  var SDE_CVE = document.getElementById("SDE_CVE")[document.getElementById("SDE_CVE").selectedIndex].value;
  obEsp = new ObjetoAJAX();
  obEsp.enviar("especialidad?DEL_CVE=" + DEL_CVE + "&SDE_CVE=" + SDE_CVE,"GET","cEsp",null);        
}

function cEsp(){
    var especialidades = eval("(" + obEsp.respuestaTexto() + ")");
    var cadena="<select class='form-control' name='ESP_CVE' id='ESP_CVE' onchange='cargaGrado()'>";
        cadena += "<option value='0'></option>";
        for(var elm=0; elm<especialidades.length; elm++){
            cadena += "<option value='" + especialidades[elm].ESP_CVE + "'>" + especialidades[elm].ESP_NOM + "</option>";
        }
    cadena += "</select>";
    document.getElementById("sESP_CVE").innerHTML=cadena;
    especialidades = null;
    obEsp=null;
    cargaGrado();
    //cargaResidente();
}

function cargaGrado(){
    var SDE_CVE = document.getElementById("SDE_CVE")[document.getElementById("SDE_CVE").selectedIndex].value;
    var ESP_CVE = document.getElementById("ESP_CVE")[document.getElementById("ESP_CVE").selectedIndex].value;  
    obGrad = new ObjetoAJAX();
    obGrad.enviar("grado?SDE_CVE=" + SDE_CVE+"&ESP_CVE=" + ESP_CVE,"GET","cGrad",null);      
}

function cGrad(){
    var grado = eval("(" + obGrad.respuestaTexto() + ")");
    var cadena="<select class='form-control' name='GRD_NUM' id='GRD_NUM' onchange='cargaResidente()'>";
        cadena += "<option value='0'></option>";
        for(var elm=0; elm<grado.length; elm++){
            cadena += "<option value='" + grado[elm].GRD_NUM + "'>" + grado[elm].GRD_NUM + "</option>";
        }
    /*if (grado.length==1){
      cadena += "<option value='" + grado[0].GRD_NUM + "'>" + grado[0].GRD_NUM + "</option>";
    } else {
      if (grado.length!=1){
        cadena += "<option value='0'></option>";
      }
      for(var elm=0; elm<grado.length; elm++){
        cadena += "<option value='" + grado[elm].GRD_NUM + "'>" + grado[elm].GRD_NUM + "</option>";
      }
    }*/
    cadena += "</select>";
    document.getElementById("sGRD_NUM").innerHTML=cadena;
    grado = null;
    obGrad = null;
    cargaResidente();
}

function cargaResidente(){
  var DEL_CVE = document.getElementById("DEL_CVE")[document.getElementById("DEL_CVE").selectedIndex].value;
  var SDE_CVE = document.getElementById("SDE_CVE")[document.getElementById("SDE_CVE").selectedIndex].value;
  var ESP_CVE = document.getElementById("ESP_CVE")[document.getElementById("ESP_CVE").selectedIndex].value;
  var GRD_NUM = document.getElementById("GRD_NUM")[document.getElementById("GRD_NUM").selectedIndex].value;
  obRes = new ObjetoAJAX();
  obRes.enviar("residente?DEL_CVE=" + DEL_CVE + "&SDE_CVE=" + SDE_CVE + "&ESP_CVE=" + ESP_CVE + "&GRD_NUM=" + GRD_NUM, "GET", "cRes",null);        
}

function cRes(){
    var columnas=4;
    var PERFIL = document.getElementById("PERFIL").value;
    var USU_CVE = document.getElementById("USU_CVE").value;
    var SDE_CVE = document.getElementById("SDE_CVE")[document.getElementById("SDE_CVE").selectedIndex].value;
    var ESP_CVE = document.getElementById("ESP_CVE")[document.getElementById("ESP_CVE").selectedIndex].value;
    var GRD_NUM = document.getElementById("GRD_NUM")[document.getElementById("GRD_NUM").selectedIndex].value;
    var residentes = eval("(" + obRes.respuestaTexto() + ")");
    
    var cadena="<p>Total de registros: "+((residentes[0].ADS_CVE=="0")?0:residentes.length)+"</p><table class='table table-bordered'><thead><tr>";
    if (SDE_CVE=="0"){
        cadena+="<th>SEDE</th>";
        columnas++;
    }
    if (ESP_CVE=="0"){
        cadena+="<th>ESPECIALIDAD</th>";
        columnas++;
    }
    //if (GRD_NUM=="0"){
        cadena+="<th>GRADO</th>";
        columnas++;
    //}
    cadena+="<th>NOMBRE</th><th>PERIODO</th><th>SEDE ROTACION</th><th>&nbsp;</th></tr></thead><tbody>";
    if (residentes[0].ADS_CVE=="0"){
        cadena+="<tr><td colspan=" + columnas + ">No se encontrarón registros</td></tr>";
    } else {
        for(var elm=0; elm<residentes.length; elm++){
            
            cadena+="<tr>";
            if (SDE_CVE=="0"){
                cadena+="<td>" + residentes[elm].SDE_NOM + "</td>";
            }
            if (ESP_CVE=="0"){
                cadena+="<td>" + residentes[elm].ESP_NOM + "</td>";
            }
            //if (GRD_NUM=="0"){
                cadena+="<td>" + residentes[elm].GRD_NUM + "</td>";
            //}
            cadena+="<td>" + residentes[elm].PER_AP1 + " " + residentes[elm].PER_AP2 + " " + residentes[elm].PER_NOM + "</td>";
            cadena+="<td>";
            
            if (residentes[elm].PRD_NUM!="0") { 
                cadena+= residentes[elm].PRD_NOM;
            }
            cadena+="</td>";
            cadena+="<td>";
            if (residentes[elm].PRD_NUM!="0") { 
                cadena+= residentes[elm].SDE_NOM_ROT;
            }
            cadena+="</td>";            
            cadena+="<td>";
            if (PERFIL=="CLINICO" || PERFIL=="ADMINISTRADOR"){
                if (residentes[elm].PRD_NUM=="0") { 
                    cadena+="<a href='capturaRotacion.jsp?usu_cve=" + USU_CVE+ "&rcve=" + residentes[elm].REG_CVE + "' target='_self' title='Rotacion de Residente'><span class='glyphicon glyphicon-list-alt'></span></a>";
                }
            }
            if (PERFIL=="ADMINISTRADOR") {
                if (residentes[elm].PRD_NUM!="0") { 
                    cadena+="<a href='eliminaRotacion?usu_cve=" + USU_CVE+ "&rcve=" + residentes[elm].REG_CVE + "' target='_self' title='Elimina rotacion de Residente'><span class='glyphicon glyphicon-remove'></span></a>";
                }
            }
            cadena+="</td>";            
            cadena += "</tr>";
        }
   
    }
    cadena += "</tbody></table>";
    document.getElementById("tblResidentes").innerHTML=cadena;
    residentes = null;
    obRes=null;

}
