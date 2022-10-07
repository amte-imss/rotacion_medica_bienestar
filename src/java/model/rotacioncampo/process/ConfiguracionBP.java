/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.process;

import model.rotacioncampo.beans.Configuracion;
import model.rotacioncampo.daos.ConfiguracionDAO;

/**
 *
 * @author saul.ortigoza
 */
public class ConfiguracionBP {
  public static Configuracion consultaConfiguracion(Configuracion cnf) throws Exception{
    ConfiguracionDAO cnfdao = new ConfiguracionDAO();
    cnf = (Configuracion)cnfdao.retrieve(cnf);
    if (cnf.getCAL_ANO()==0){
      throw new Exception("NO ESTA CONFIGURADO EL AÑO DE CAPTURA DE ROTACION DE CAMPO, FAVOR DE VERIFICAR CON AREA DE SISTEMAS");
    }
    //if (cnf.getMDL_STA_CVE()==0){
    //  throw new Exception("NO SE ENCUENTRA DISPONIBLE EN ESTE MOMENTO, FAVOR DE VERIFICAR CON AREA DE SISTEMAS");
    //}
    return cnf;
  }
  
  public static Configuracion consultaConfiguracionAnterior(int ADS_CVE) throws Exception{
    Configuracion cnf = new Configuracion();
    ConfiguracionDAO cnfdao = new ConfiguracionDAO();
    cnf = (Configuracion)cnfdao.retrieveAnterior(ADS_CVE);
    if (cnf.getCAL_ANO()==0){
      throw new Exception("NO ESTA CONFIGURADO EL AÑO DE CAPTURA DE ROTACION DE CAMPO, FAVOR DE VERIFICAR CON AREA DE SISTEMAS");
    }
    /*if (cnf.getMDL_STA_CVE()==0){
      throw new Exception("NO SE ENCUENTRA DISPONIBLE EN ESTE MOMENTO, FAVOR DE VERIFICAR CON AREA DE SISTEMAS");
    }*/
    return cnf;
  }
}
