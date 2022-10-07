/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.process;

import java.util.List;
import model.rotacioncampo.beans.SedeRotacion;
import model.rotacioncampo.daos.SedeRotacionDAO;

/**
 *
 * @author saul
 */
public class SedeRotacionBP {
  public static List<SedeRotacion> consultaSedeRotacion(SedeRotacion sde) throws Exception{
    SedeRotacionDAO sdedao = new SedeRotacionDAO();
    return (List<SedeRotacion>)sdedao.retrieve(sde);
  }    
}
