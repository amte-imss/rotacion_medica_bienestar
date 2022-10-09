package model.rotacioncampo.daos;

import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.rotacioncampo.beans.Sede;

/**
 *
 * @author saul.ortigoza
 */
public class SedeDAO implements DAO{

  public Object create(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object retrieve(Object obj) throws Exception {
    Sede sde = (Sede)obj;
    Connection cn = BD.getConection();
    String sql;
    sql = "SELECT del_cve, sde_cve, sde_nom " 
            + "FROM srm_reg_ads_vis a "
            + "WHERE mta_ctg_cve not in (5) " // and ((grd_num=3 AND esp_cve IN (6,35,18)) OR (grd_num=2 AND esp_cve IN (37,120,31,39,30,25))) 
            + "AND CONCAT(a.esp_cve,'|',a.grd_num) in (select CONCAT(a.esp_cve,'|',a.grd_num) from srm_atn_med_ib_esp_grd_arc g WHERE g.esp_cve=a.esp_cve AND g.grd_num=a.grd_num) "
            + "AND del_cve=? ";
    if (sde.getSDE_CVE()>0){
      sql += "AND sde_cve=? ";
    }
    sql += "GROUP BY del_cve, sde_cve, sde_nom "
            + "ORDER BY 3";
    PreparedStatement ps = cn.prepareStatement(sql);
    ps.setInt(1, sde.getDEL_CVE());
    if (sde.getSDE_CVE()>0){
        ps.setInt(2, sde.getSDE_CVE());
    }
    ResultSet rs = ps.executeQuery();
    List<Sede> lstSde = new ArrayList<Sede>();
    int ite;
    ite=0;
    if (rs.next()){
      rs.beforeFirst();
      while(rs.next()){
        lstSde.add(ite,new Sede(rs.getInt("DEL_CVE"), rs.getInt("SDE_CVE"), rs.getString("SDE_NOM")));
        ite++;
      }
    } 
    rs.close();
    ps.close();
    cn.close();
    return lstSde;
  }

  public int update(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object delete(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
