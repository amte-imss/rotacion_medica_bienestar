function  ObjetoAJAX() {
    var xhr;
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");
    } else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
    } else
        xhr = null;

    //declaracion de metodos de la clase
    this.enviar = m_enviar;
    this.respuestaTexto = m_texto;
    this.respuestaXML = m_XML;
    this.obtenerEncabezados = m_encabezados;
    this.estado = m_estado;
    this.textoEstado = m_textoEstado;

    //funciones para la implementacion de los metodos
    function m_enviar(url, method, funcionRetorno, objForm){
        var dataSend = null;
        //si el metodo es "POST" serializa los datos del formulario
        if(method.toLowerCase()=="post" && objForm!=null){
            dataSend = obtenerDatos(objForm);
        }
        //si el metodo es "GET" serializa los datos del formulario y los anexa a la URL
        else if(method.toLowerCase()=="get" && objForm!=null){
            var dataUrl = "";
            dataUrl = obtenerDatos(objForm);
            if(url.indexOf("?")==-1){
                url += "?" + dataUrl;
            } else {
                url += "&" + dataUrl;
            }
        }

        //realiza siempre la peticion en modo asincrono
        xhr.open(method, url, true);
        xhr.onreadystatechange=function(){
            //si la respuesta esta disponible se ejecuta la funcion de retorno
            if(xhr.readyState==4){
                eval(funcionRetorno+"("+")");
            }
        };
        if(objForm!=null){
            //establece el encabezado apropiado para el envio de datos de un formulario
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        }
        xhr.send(dataSend);
    }

    function obtenerDatos(objForm){
        var controles = objForm.elements;
        var datos = new Array();
        var cad = "";
        for(var i=0; i<controles.length; i++){
            cad = encodeURIComponent(controles[i].name) + "=";
            cad += encodeURIComponent(controles[i].value);
            datos.push(cad);
        }
        // se forma la cadena con el metodo join() del array para evitar
        // multiples concatenaciones
        cad = datos.join("&");
        return cad;
    }

    function m_texto(){
        return xhr.responseText;
    }

    function m_XML(){
        return xhr.responseXML;
    }

    function m_encabezados(){
        return xhr.getAllResponseHeaders();
    }

    function m_estado(){
        return xhr.status;
    }

    function m_textoEstado(){
        return xhr.statusText;
    }
}
