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
import model.rotacioncampo.beans.Residente;

/**
 *
 * @author saul
 */
public class ResidenteDAO implements DAO{

    @Override
    public Object create(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object retrieve(Object obj) throws Exception {
    Residente res = (Residente)obj;
    Connection cn = BD.getConection();
    String sql = "SELECT a.ADS_CVE, a.REG_CVE, a.PER_CVE, a.CURP, replace(a.PER_AP1,'''','''''') PER_AP1, "
            + "replace(a.PER_AP2,'''','''''') PER_AP2, replace(a.PER_NOM,'''','''''') PER_NOM, a.GRD_NUM, "
            + "a.SDE_CVE, a.SDE_NOM, a.DEL_CVE, CONCAT(a.EDO_NOM,' ',a.DEL_NOM) DEL_NOM, a.ESP_CVE, a.ESP_NOM, "
            + "b.MTA_CVE, c.PRD_NUM, d.SDE_CVE SDE_CVE_ROT, d.SDE_NOM SDE_NOM_ROT, e.del_cve DEL_CVE_ROT, "
            + "CONCAT(f.EDO_NOM,' ',e.DEL_NOM) DEL_NOM_ROT "
            + "FROM srm_reg_ads_vis a "
            + "LEFT JOIN srm_atn_med_ib_arc b ON a.REG_CVE=b.REG_CVE " //srm_rot_cmp_arc 
            + "LEFT JOIN srm_mta_prg_atn_med_ib_arc c ON b.mta_cve=c.mta_cve " //srm_mta_prg_rot_cmp_arc
            + "LEFT JOIN gra_sde_cat d ON c.sde_cve_rot=d.sde_cve "
            + "LEFT JOIN ims_del_cat e ON d.del_Cve=e.del_cve "
            + "LEFT JOIN gra_edo_cat f ON e.edo_cve=f.edo_cve "
            + "INNER JOIN srm_atn_med_ib_esp_grd_arc g ON g.esp_cve=a.esp_cve AND g.grd_num=a.grd_num "
            + "WHERE mta_ctg_cve not in (5) "; //and ((a.grd_num=3 AND a.esp_cve IN (6,35,18)) OR (a.grd_num=2 AND a.esp_cve IN (37,120,31,39,30,25)))
    if (res.getDEL_CVE() != 0) {
      sql = sql + "and a.DEL_cve=? ";
    }
    if (res.getSDE_CVE() != 0) {
      sql = sql + "AND a.SDE_cve=? ";
    }
    if (res.getESP_CVE() != 0) {
      sql = sql + "AND a.ESP_cve=? ";
    }
    sql = sql + "ORDER BY 12, 10, 14, 4, 5, 6, 7 ";
    int itePS=1;
    PreparedStatement ps = cn.prepareStatement(sql);
    
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
    List<Residente> lstRes = new ArrayList<Residente>();
    
    int ite = 0;
    if (rs.next()) {
      rs.beforeFirst();
      while (rs.next()) {
        lstRes.add(ite, new Residente(rs.getInt("ADS_CVE"), rs.getInt("REG_CVE"), rs.getInt("PER_CVE"), rs.getString("CURP"), rs.getString("PER_AP1").replace("'", "''"), rs.getString("PER_AP2").replace("'", "''"), rs.getString("PER_NOM").replace("'", "''"), rs.getInt("GRD_NUM"), rs.getInt("SDE_CVE"), rs.getString("SDE_NOM"), rs.getInt("DEL_CVE"), rs.getString("DEL_NOM"), rs.getInt("ESP_CVE"), rs.getString("ESP_NOM"), rs.getInt("MTA_CVE"), rs.getInt("PRD_NUM"), rs.getInt("SDE_CVE_ROT"), rs.getString("SDE_NOM_ROT"), rs.getInt("DEL_CVE_ROT"), rs.getString("DEL_NOM_ROT")));
        ite++;
      }
    }
    rs.close();
    ps.close();
    cn.close();
    return lstRes;
    }
    
    public Object retrieveU(int REG_CVE) throws Exception {
    Connection cn = BD.getConection();
    String sql = "SELECT a.ADS_CVE, a.REG_CVE, a.PER_CVE, a.CURP, replace(a.PER_AP1,'''','''''') PER_AP1, "
            + "replace(a.PER_AP2,'''','''''') PER_AP2, replace(a.PER_NOM,'''','''''') PER_NOM, a.GRD_NUM, "
            + "a.SDE_CVE, a.SDE_NOM, a.DEL_CVE, CONCAT(a.EDO_NOM,' ',a.DEL_NOM) DEL_NOM, a.ESP_CVE, a.ESP_NOM, "
            + "b.MTA_CVE, c.PRD_NUM, d.SDE_CVE SDE_CVE_ROT, d.SDE_NOM SDE_NOM_ROT, e.del_cve DEL_CVE_ROT, "
            + "CONCAT(f.EDO_NOM,' ',e.DEL_NOM) DEL_NOM_ROT "
            + "FROM srm_reg_ads_vis a "
            + "LEFT JOIN srm_rot_cmp_arc b ON a.REG_CVE=b.REG_CVE "
            + "LEFT JOIN srm_mta_prg_rot_cmp_arc c ON b.mta_cve=c.mta_cve "
            + "LEFT JOIN gra_sde_cat d ON c.sde_cve_rot=d.sde_cve "
            + "LEFT JOIN ims_del_cat e ON d.del_Cve=e.del_cve "
            + "LEFT JOIN gra_edo_cat f ON e.edo_cve=f.edo_cve "
            + "WHERE mta_ctg_cve not in (5) and ((a.grd_num=3 AND a.esp_cve IN (6,35,18)) OR (a.grd_num=2 AND a.esp_cve IN (37,120,31,39,30,25))) and a.REG_CVE=? ";
    sql = sql + "ORDER BY 12, 10, 14, 4, 5, 6, 7 ";
    int itePS=2;
    PreparedStatement ps = cn.prepareStatement(sql);
    ps.setInt(1, REG_CVE);
    ResultSet rs = ps.executeQuery();
    List<Residente> lstRes = new ArrayList<Residente>();
    
    int ite = 0;
    if (rs.next()) {
      rs.beforeFirst();
      while (rs.next()) {
        lstRes.add(ite, new Residente(rs.getInt("ADS_CVE"), rs.getInt("REG_CVE"), rs.getInt("PER_CVE"), rs.getString("CURP"), rs.getString("PER_AP1").replace("'", "''"), rs.getString("PER_AP2").replace("'", "''"), rs.getString("PER_NOM").replace("'", "''"), rs.getInt("GRD_NUM"), rs.getInt("SDE_CVE"), rs.getString("SDE_NOM"), rs.getInt("DEL_CVE"), rs.getString("DEL_NOM"), rs.getInt("ESP_CVE"), rs.getString("ESP_NOM"), rs.getInt("MTA_CVE"), rs.getInt("PRD_NUM"), rs.getInt("SDE_CVE_ROT"), rs.getString("SDE_NOM_ROT"), rs.getInt("DEL_CVE_ROT"), rs.getString("DEL_NOM_ROT")));
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
