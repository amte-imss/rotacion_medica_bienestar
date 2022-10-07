/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.process;

import java.util.List;
import model.rotacioncampo.beans.Periodo;
import model.rotacioncampo.daos.PeriodoDAO;

/**
 *
 * @author saul
 */
public class PeriodoBP {
  public static List<Periodo> consultaPeriodo(Periodo del) throws Exception{
    PeriodoDAO deldao = new PeriodoDAO();
    return (List<Periodo>)deldao.retrieve(del);
  }    
}
