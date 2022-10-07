/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.process;

import java.util.List;
import model.rotacioncampo.beans.Delegacion;
import model.rotacioncampo.daos.DelegacionDAO;

/**
 *
 * @author saul.ortigoza
 */
public class DelegacionBP {
  public static List<Delegacion> consultaDelegacion(Delegacion del) throws Exception{
    DelegacionDAO deldao = new DelegacionDAO();
    return (List<Delegacion>)deldao.retrieve(del);
  }
}
