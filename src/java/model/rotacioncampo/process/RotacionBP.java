package model.rotacioncampo.process;

import model.rotacioncampo.beans.Rotacion;
import model.rotacioncampo.daos.RotacionDAO;

/**
 *
 * @author saul
 */
public class RotacionBP {
    public static int insertaRotacion(Rotacion cele) throws Exception{
        RotacionDAO cdao = new RotacionDAO();
        return Integer.parseInt(cdao.create(cele).toString());
    }    
    
    public static int eliminaRotacion(Rotacion rot) throws Exception {
        RotacionDAO rdao = new RotacionDAO();
        return Integer.parseInt(rdao.delete(rot).toString());
    }
}
