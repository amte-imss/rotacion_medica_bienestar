function enviaMenu(pagina){
    document.forms["frmMenu"].action=pagina+".jsp";
    document.forms["frmMenu"].submit();
    
}


function trim(cadena)
{
    var cadena1=cadena.value
    for(i=0; i<cadena1.length; )
    {
        if(cadena1.charAt(i)==" ")
            cadena1=cadena1.substring(i+1, cadena1.length);
        else
            break;
    }
    for(i=cadena1.length-1; i>=0; i=cadena1.length-1)
    {
    if(cadena1.charAt(i)==" ")
        cadena1=cadena1.substring(0,i);
    else
        break;
    }
    document.getElementById(cadena.id).value=cadena1;
}

function a_Mayuscula(cadena){
    document.getElementById(cadena.id).value = cadena.value.toUpperCase();
}

function v_A(e) {
    var tecla = (document.all) ? e.keyCode : e.which;
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar)
    if (tecla==0) return true;
    if (tecla==32) return true;
    if (tecla==209 || tecla==241) return true;
    patron =/[A-Za-z]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}

function v_9(e) {
    var tecla = (document.all) ? e.keyCode : e.which;
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar)
    if (tecla==0) return true;
    patron =/[0-9]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}

function v_9yPunto(e) {
    var tecla = (document.all) ? e.keyCode : e.which;
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar)
    if (tecla==0) return true;
    if (tecla==46) return true;
    patron =/[0-9]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}

function v_A9(e) {
    var tecla = (document.all) ? e.keyCode : e.which;
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar)
    if (tecla==0) return true;
    if (tecla==32) return true;
    if (tecla==209 || tecla==241) return true;
    //caracteres especiales
    if (tecla==33 || tecla==36 || tecla==37 || tecla==40 || tecla==41 || tecla==42 || tecla==43) return true;
    if (tecla==44 || tecla==45 || tecla==46 || tecla==47 || tecla==58 || tecla==59 || tecla==63) return true;
    if (tecla==95 || tecla==161 || tecla==191) return true;
    patron =/[A-Za-z0-9]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}

function noClDr(){
    return false;
}

function numDef(obj){
    if (document.getElementById(obj.id).value==""){
        document.getElementById(obj.id).value="0";
    }
}

function noPegar(){
  return false;
  
}

//document.oncontextmenu = noClDr;