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
    var cadena="<select class='form-control' name='ESP_CVE' id='ESP_CVE' onchange='cargaMetas()'>";
        cadena += "<option value='0'></option>";
        for(var elm=0; elm<especialidades.length; elm++){
            cadena += "<option value='" + especialidades[elm].ESP_CVE + "'>" + especialidades[elm].ESP_NOM + "</option>";
        }
    cadena += "</select>";
    document.getElementById("sESP_CVE").innerHTML=cadena;
    especialidades = null;
    obEsp=null;
    cargaMetas();
}

function cargaMetas(){
  var DEL_CVE = document.getElementById("DEL_CVE")[document.getElementById("DEL_CVE").selectedIndex].value;
  var SDE_CVE = document.getElementById("SDE_CVE")[document.getElementById("SDE_CVE").selectedIndex].value;
  var ESP_CVE = document.getElementById("ESP_CVE")[document.getElementById("ESP_CVE").selectedIndex].value;
  var PRO_ANO = document.getElementById("PRO_ANO").value;
  obRes = new ObjetoAJAX();
  obRes.enviar("meta?DEL_CVE=" + DEL_CVE + "&SDE_CVE=" + SDE_CVE + "&ESP_CVE=" + ESP_CVE + "&PRO_ANO=" + PRO_ANO,"GET","cMta",null);        
}

function cMta(){
    var residentes = eval("(" + obRes.respuestaTexto() + ")");
    var cadena="<table class='table table-bordered'><thead><tr>";
    cadena+="<th>DELEGACION</th><th>SEDE</th><th>ESPECIALIDAD</th><th>PERIODO</th><th>DELEGACION<br>ROTACION</th><th>SEDE<br>ROTACION</th><th>CUPO</th><th>OCUPADO</th><th>RESTANTE</th>";
    if (residentes[0].DEL_CVE=="0"){
        cadena+="<tr><td colspan='9'>No se encontrarón registros</td></tr>";
    } else {
        for(var elm=0; elm<residentes.length; elm++){
            
            cadena+="<tr>";
            cadena+="<td>" + residentes[elm].DEL_NOM + "</td>";
            cadena+="<td>" + residentes[elm].SDE_NOM + "</td>";
            cadena+="<td>" + residentes[elm].ESP_NOM + "</td>";
            cadena+="<td>" + residentes[elm].PRD_NUM + "</td>";
            cadena+="<td>" + residentes[elm].DEL_NOM_ROT + "</td>";
            cadena+="<td>" + residentes[elm].SDE_NOM_ROT + "</td>";
            cadena+="<td>" + residentes[elm].CUP_AUT + "</td>";
            cadena+="<td>" + residentes[elm].CUP_OCU + "</td>";
            cadena+="<td>" + residentes[elm].CUP_RES + "</td>";
            cadena += "</tr>";
        }
   
    }
    cadena += "</tbody></table>";
    document.getElementById("tblResidentes").innerHTML=cadena;
    residentes = null;
    obRes=null;

}


