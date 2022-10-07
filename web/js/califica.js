/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function carga()
{
    if (document.getElementById("TAM").value=="0" && document.getElementById("SAM").value=="0" && document.getElementById("SI").value=="0" && document.getElementById("SE").value=="0"){
    if (document.getElementById("CAL_TAM").value!="0.0" && document.getElementById("CAL_TAM").value!=""){
      redondeaObj(document.getElementById("CAL_TAM"));
    }
    if (document.getElementById("CAL_SAM").value!="0.0" && document.getElementById("CAL_SAM").value!=""){
      redondeaObj(document.getElementById("CAL_SAM"));
    }
    if (document.getElementById("CAL_SI").value!="0.0" && document.getElementById("CAL_SI").value!=""){
      redondeaObj(document.getElementById("CAL_SI"));
    }
    if (document.getElementById("CAL_SE").value!="0.0" && document.getElementById("CAL_SE").value!=""){
      redondeaObj(document.getElementById("CAL_SE"));
    }

  }
  
}

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

function calificacionFinal()
{
  if (document.getElementById("CAL_TAM").value!="" && document.getElementById("CAL_SAM").value!="" && document.getElementById("CAL_SI").value!="" && document.getElementById("CAL_SE").value!="")
  {
    document.getElementById("CAL_NUM").value = redondea((parseFloat(document.getElementById("CAL_TAM").value) + parseFloat(document.getElementById("CAL_SAM").value) + parseFloat(document.getElementById("CAL_SI").value) + parseFloat(document.getElementById("CAL_SE").value))/4);
  }
}

function guardaCalificaciones(){
  var TAM= document.getElementById("TAM").value;
  var SAM= document.getElementById("SAM").value;
  var SI= document.getElementById("SI").value;
  var SE= document.getElementById("SE").value;  
  if (TAM=="0" && SAM=="0" && SI=="0" && SE=="0"){
    var cadenaError="Capture: "  
    var hayError = 0;
    var USU_CVE = document.getElementById("USU_CVE").value;
    var ADS_CVE = document.getElementById("ADS_CVE").value;
    var REG_CVE = document.getElementById("REG_CVE").value;
    var GRD_NUM = document.getElementById("GRD_NUM").value;
    var CAL_TAM = document.getElementById("CAL_TAM").value;
    var CAL_SAM = document.getElementById("CAL_SAM").value;
    var CAL_SI = document.getElementById("CAL_SI").value;
    var CAL_SE = document.getElementById("CAL_SE").value;    
    var ARE_TAM = document.getElementById("ARE_TAM").value;
    var ARE_SAM = document.getElementById("ARE_SAM").value;
    var ARE_SI = document.getElementById("ARE_SI").value;
    var ARE_SE = document.getElementById("ARE_SE").value;
    var CAL_NUM = document.getElementById("CAL_NUM").value;
    var TSI_STA_CVE = document.getElementById("TSI_STA_CVE").value;

    if (CAL_TAM==""){
      cadenaError += "<br>&nbsp;&nbsp;&nbsp;Calificacion Trabajo de atencion medica";
      hayError++;
    }
    if (CAL_SAM==""){
      cadenaError += "<br>&nbsp;&nbsp;&nbsp;Calificacion Seminario de atencion medica";
      hayError++;
    }
    if (CAL_SI==""){
      cadenaError += "<br>&nbsp;&nbsp;&nbsp;Calificacion Seminario de investigacion";
      hayError++;
    }
    if (CAL_SE==""){
      cadenaError += "<br>&nbsp;&nbsp;&nbsp;Calificacion Seminario de educacion";
      hayError++;
    }
    if (CAL_NUM==""){
      cadenaError += "<br>&nbsp;&nbsp;&nbsp;Calificacion Global Final";
      hayError++;
    }

    if (hayError != 0){
      
      document.getElementById("msjValidacion").innerHTML = cadenaError;
      $('#validacion').modal();
      return false;
    }
    if(hayError == 0) {
      $('#guardado').modal();
      return true;
     }
  }  
}

function calificacionValida(cal,tip){
  document.getElementById("CAL_NUM").value="";
  if(cal!=""){
    if(isNumeric(cal)){
      if(cal>=70 && cal<=100){
        var pon = 0;
        if (tip == "TAM"){
          redondeaObj(document.getElementById("CAL_TAM"));
        }
        if (tip == "SAM"){
          redondeaObj(document.getElementById("CAL_SAM"));
        }  
        if (tip == "SI"){
          redondeaObj(document.getElementById("CAL_SI"));
        }
        if (tip == "SE"){
          redondeaObj(document.getElementById("CAL_SE"));
        }        
      } else {
        document.getElementById("msjValidacion").innerHTML = "Calificación debe estar entre 70 y 100.";
        $('#validacion').modal();
        return false;
      }
    } else {
        $('#valorNumerico').modal();
        return false;    
    }
    calificacionFinal();  
  }
}
