package model.rotacioncampo.process;

import java.util.List;
import model.rotacioncampo.beans.Residente;
import model.rotacioncampo.daos.ResidenteDAO;


public class ResidenteBP
{
  public ResidenteBP() {}
  
  public static List<Residente> consultaResidente(Residente res)
    throws Exception
  {
    ResidenteDAO resdao = new ResidenteDAO();
    return (List)resdao.retrieve(res);
  }
  
  public static List<Residente> consultaResidente(int REG_CVE)
    throws Exception
  {
    ResidenteDAO resdao = new ResidenteDAO();
    return (List)resdao.retrieveU(REG_CVE);
  }
  

}