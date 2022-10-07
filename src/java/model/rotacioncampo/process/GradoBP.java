/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.process;

import java.util.List;
import model.rotacioncampo.beans.Grado;
import model.rotacioncampo.daos.GradoDAO;

/**
 *
 * @author saul.ortigoza
 */
public class GradoBP {
  public static List<Grado> consultaGrado(Grado grad) throws Exception{
    GradoDAO deldao = new GradoDAO();
    return (List<Grado>)deldao.retrieve(grad);
  }
}
