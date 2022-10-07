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
import model.rotacioncampo.beans.Periodo;

/**
 *
 * @author saul
 */
public class PeriodoDAO implements DAO{

    @Override
    public Object create(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object retrieve(Object obj) throws Exception {
    Periodo per = (Periodo)obj;    
    Connection cn = BD.getConection();
    String sql;
    sql = "SELECT DISTINCT PRD_NUM PRD_NUM FROM srm_mta_prg_rot_cmp_arc WHERE sde_cve=? AND esp_cve=? AND cup_res>0 "
            + "ORDER BY 1";
    PreparedStatement ps = cn.prepareStatement(sql);
    ps.setInt(1, per.getSDE_CVE());
    ps.setInt(2, per.getESP_CVE());
    ResultSet rs = ps.executeQuery();
    List<Periodo> lstPer = new ArrayList<Periodo>();
    int ite;
    ite=0;
    if (rs.next()){
      rs.beforeFirst();
      while(rs.next()){
        lstPer.add(ite, new Periodo(rs.getInt("PRD_NUM"), per.getSDE_CVE(), per.getESP_CVE()));
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
