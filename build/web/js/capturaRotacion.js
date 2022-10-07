/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function cargaMeta(){
    var SDE_CVE = document.getElementById("SDE_CVE").value;
    var ESP_CVE = document.getElementById("ESP_CVE").value;
    var PRD_NUM = document.getElementById("PRD_NUM")[document.getElementById("PRD_NUM").selectedIndex].value;
    
  obMta = new ObjetoAJAX();
  obMta.enviar("sedeRotacion?SDE_CVE=" + SDE_CVE + "&ESP_CVE=" + ESP_CVE + "&PRD_NUM=" + PRD_NUM,"GET","cMta",null);    
}

function cMta(){
    var estados = eval("(" + obMta.respuestaTexto() + ")");
    var cadena="<select class='form-control' name='MTA_CVE' id='MTA_CVE'>";
        cadena += "<option value='0'></option>";
        for(var elm=0; elm<estados.length; elm++){
            cadena += "<option value='" + estados[elm].MTA_CVE + "'>" + estados[elm].SDE_NOM_ROT + "</option>";
        }
    cadena += "</select>";
    document.getElementById("sMTA_CVE").innerHTML=cadena;
    obMta=null;
}

function valida(){
    var hayError=0;
    iniciaValidacion();
    if (document.getElementById("PRD_NUM").value==0){
        pintaValidacion("valas_001","PRD_NUM","val_001","Este campo es obligatorio");
        hayError++;
    }
    if (document.getElementById("MTA_CVE").value==0){
        pintaValidacion("valas_002","MTA_CVE","val_002","Este campo es obligatorio");
        hayError++;
    }
    if (hayError != 0){
      document.getElementById("errores").style.display = "";
      return false;
    }  
        document.forms[0].target="_self";
        document.forms[0].action="guardaRotacion";
        document.forms[0].submit();    
}

function pintaValidacion(ast,val,msj,txt){
  document.getElementById(ast).className = "form-text form-text-error";
  document.getElementById(ast).style.color = "#D0021B";
  document.getElementById(val).className = "form-control form-control-error";
  document.getElementById(msj).style.display="";  
  document.getElementById(msj).innerHTML=txt;
}

function quitaValidacion(ast,val,msj){
  document.getElementById(ast).className = "form-text";
  document.getElementById(ast).style.color = "";
  document.getElementById(val).className = "form-control";
  document.getElementById(msj).style.display = "none";   
}

function iniciaValidacion(){
  document.getElementById("errores").style.display = "none";
  quitaValidacion("valas_001","PRD_NUM","val_001");
  quitaValidacion("valas_002","MTA_CVE","val_002");
}