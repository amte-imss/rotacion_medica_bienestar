/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.process;

import java.util.List;
import model.rotacioncampo.beans.Sede;
import model.rotacioncampo.daos.SedeDAO;

/**
 *
 * @author saul.ortigoza
 */
public class SedeBP {
  public static List<Sede> consultaSede(Sede sde) throws Exception{
    SedeDAO sdedao = new SedeDAO();
    return (List<Sede>)sdedao.retrieve(sde);
  }  
}
