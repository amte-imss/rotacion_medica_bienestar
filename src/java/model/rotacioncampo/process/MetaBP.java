/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.process;

import java.util.List;
import model.rotacioncampo.beans.Meta;
import model.rotacioncampo.daos.MetaDAO;

/**
 *
 * @author saul
 */
public class MetaBP {
  public static List<Meta> consultaMeta(Meta mta)
    throws Exception
  {
    MetaDAO resdao = new MetaDAO();
    return (List)resdao.retrieve(mta);
  }    
}
