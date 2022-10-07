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
import model.rotacioncampo.beans.Meta;

/**
 *
 * @author saul
 */
public class MetaDAO implements DAO{

    @Override
    public Object create(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object retrieve(Object obj) throws Exception {
    Meta res = (Meta)obj;
    Connection cn = BD.getConection();
    String sql = "SELECT "
            + "b.DEL_CVE, CONCAT(f.EDO_NOM, ' ', e.DEL_NOM) DEL_NOM, b.sde_cve, b.sde_nom, c.esp_cve, c.esp_nom, "
            + "d.DEL_CVE DEL_CVE_ROT, CONCAT(h.EDO_NOM, ' ', g.DEL_NOM) DEL_NOM_ROT, d.sde_cve SDE_CVE_ROT, d.sde_nom SDE_NOM_ROT, "
            + "a.prd_num, a.cup_aut, a.cup_ocu, a.cup_res, a.PRO_ANO "
            + " FROM srm_mta_prg_rot_cmp_arc a "
            + "INNER JOIN gra_sde_cat b ON a.sdE_cve=b.sde_cve "
            + "INNER JOIN ims_del_cat e ON b.del_cve=e.del_cve "
            + "INNER JOIN gra_edo_cat f ON e.EDO_CVE=f.edo_cve "
            + "INNER JOIN srm_esp_cat c ON a.ESP_CVE=c.esp_cve "
            + "INNER JOIN gra_sde_cat d ON a.sde_cve_rot=d.sde_cve "
            + "INNER JOIN ims_del_cat g ON d.DEL_CVE=g.DEL_CVE "
            + "INNER JOIN gra_edo_cat h ON g.EDO_CVE=h.EDO_CVE "
            + "WHERE a.pro_ano=? ";
    if (res.getDEL_CVE() != 0) {
      sql = sql + "and b.DEL_cve=? ";
    }
    if (res.getSDE_CVE() != 0) {
      sql = sql + "AND a.SDE_cve=? ";
    }
    if (res.getESP_CVE() != 0) {
      sql = sql + "AND a.ESP_cve=? ";
    }
    sql = sql + "ORDER BY 2,4,6,11,8,10 ";
    int itePS=1;
    PreparedStatement ps = cn.prepareStatement(sql);
    ps.setInt(itePS, res.getPRO_ANO());
    itePS++;
    if (res.getDEL_CVE() != 0) {
        ps.setInt(itePS, res.getDEL_CVE());
        itePS++;
    }
    if (res.getSDE_CVE() != 0) {
        ps.setInt(itePS, res.getSDE_CVE());
        itePS++;
    }
    if (res.getESP_CVE() != 0) {
      ps.setInt(itePS, res.getESP_CVE());
    }
    ResultSet rs = ps.executeQuery();
    List<Meta> lstRes = new ArrayList<Meta>();
    
    int ite = 0;
    if (rs.next()) {
      rs.beforeFirst();
      while (rs.next()) {
        lstRes.add(ite, new Meta(rs.getInt("DEL_CVE"), rs.getString("DEL_NOM"), rs.getInt("SDE_CVE"), 
                rs.getString("SDE_NOM"), rs.getInt("ESP_CVE"), rs.getString("ESP_NOM"), rs.getInt("DEL_CVE_ROT"), 
                rs.getString("DEL_NOM_ROT"), rs.getInt("SDE_CVE_ROT"), rs.getString("SDE_NOM_ROT"), rs.getInt("PRD_NUM"), 
                rs.getInt("CUP_AUT"), rs.getInt("CUP_OCU"), rs.getInt("CUP_RES"), rs.getInt("PRO_ANO")));
        ite++;
      }
    }
    rs.close();
    ps.close();
    cn.close();
    return lstRes;
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
