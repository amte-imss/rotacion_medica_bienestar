/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.process;

import model.rotacioncampo.beans.Acceso;
import model.rotacioncampo.daos.AccesoDAO;


/**
 *
 * @author saul.ortigoza
 */
public class AccesoBP {
  public static Acceso consultaAcceso(Acceso ac) throws Exception{
    AccesoDAO acdao = new AccesoDAO();
    ac = (Acceso)acdao.retrieve(ac);
    if (ac.getPERFIL().equals("SIN ACCESO")){
      throw new Exception("ACCESO DENEGADO, SU USUARIO NO TIENE PERMISOS");
    }
    if (ac.getPERFIL().equals("PROFESOR") && !(ac.getESP_CVE()>0) && !(ac.getSDE_CVE()>0)){
      throw new Exception("ACCESO DENEGADO, TIENE PERFIL DE PROFESOR PERO NO TIENE ESPECIALIDAD ASIGNADA y/o SEDE ASIGNADA");
    }
    if (ac.getPERFIL().equals("CLINICO") && !(ac.getSDE_CVE()>0)){
      throw new Exception("ACCESO DENEGADO, TIENE PERFIL CLINICO PERO NO TIENE SEDE ASIGNADA");
    }
    if (ac.getPERFIL().equals("DELEGACIONAL") && !(ac.getDEL_CVE()>0)){
      throw new Exception("ACCESO DENEGADO, TIENE PERFIL DELEGACIONAL PERO NO TIENE DELEGACION ASIGNADA");
    }

    return ac;
  }
}
