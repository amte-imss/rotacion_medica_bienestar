/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.daos;

import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.rotacioncampo.beans.SedeRotacion;

/**
 *
 * @author saul
 */
public class SedeRotacionDAO implements DAO{

    @Override
    public Object create(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object retrieve(Object obj) throws Exception {
    SedeRotacion per = (SedeRotacion)obj;    
    Connection cn = BD.getConection();
    String sql;
    sql = "SELECT a.MTA_CVE, a.ESP_CVE, a.PRD_NUM, a.SDE_CVE_ROT, CONCAT(h.EDO_NOM, ' ', g.DEL_NOM, ' - ', b.SDE_NOM) SDE_NOM_ROT " + //a.SDE_CVE,
            "FROM srm_mta_prg_atn_med_ib_arc a INNER JOIN gra_sde_Cat b ON a.sde_cve_rot=b.sde_Cve " +
            "INNER JOIN ims_del_cat g ON b.DEL_CVE=g.DEL_CVE " +
            "INNER JOIN gra_edo_cat h ON g.EDO_CVE=h.EDO_CVE " +
            "WHERE a.esp_cve=? AND a.PRD_NUM=? AND a.cup_res>0 ORDER BY SDE_NOM_ROT"; //a.sde_cve=? AND 
    PreparedStatement ps = cn.prepareStatement(sql);
    //ps.setInt(1, per.getSDE_CVE());
    ps.setInt(1, per.getESP_CVE());
    ps.setInt(2, per.getPRD_NUM());
    ResultSet rs = ps.executeQuery();
    List<SedeRotacion> lstPer = new ArrayList<SedeRotacion>();
    int ite;
    ite=0;
    if (rs.next()){
      rs.beforeFirst();
      while(rs.next()){
        lstPer.add(ite, new SedeRotacion(rs.getInt("MTA_CVE"), rs.getInt("ESP_CVE"), rs.getInt("PRD_NUM"), rs.getInt("SDE_CVE_ROT"), rs.getString("SDE_NOM_ROT")));
        ite++;
      }
    } 
    rs.close();
    ps.close();
    cn.close();
    return lstPer;
    }

    @Override
    public int update(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object delete(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
