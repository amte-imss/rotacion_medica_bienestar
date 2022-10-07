/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.process;

import java.util.List;
import model.rotacioncampo.beans.Especialidad;
import model.rotacioncampo.daos.EspecialidadDAO;

/**
 *
 * @author saul.ortigoza
 */
public class EspecialidadBP {
  public static List<Especialidad> consultaEspecialidad(Especialidad esp) throws Exception{
    EspecialidadDAO espdao = new EspecialidadDAO();
    return (List<Especialidad>)espdao.retrieve(esp);
  }    
}
