package model.rotacioncampo.daos;

import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.rotacioncampo.beans.Grado;

/**
 *
 * @author saul.ortigoza
 */
public class GradoDAO implements DAO{

  public Object create(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object retrieve(Object obj) throws Exception {
    Grado grad = (Grado)obj;
    Connection cn = BD.getConection();
    String sql;
    sql = "SELECT sde_cve, v.esp_cve, e.grd_num "
            + "FROM srm_reg_ads_vis v INNER JOIN srm_atn_med_ib_esp_grd_arc e ON e.esp_cve=v.esp_cve AND e.grd_num=v.grd_num "
            + "WHERE mta_ctg_cve not in (5) " // and ((grd_num=3 AND esp_cve IN (6,35,18)) OR (grd_num=2 AND esp_cve IN (37,120,31,39,30,25))) 
            + "AND sde_cve=? ";
    if (grad.getESP_CVE()>0){
      sql += "AND esp_cve=? ";
    }
    sql += "GROUP BY sde_cve, esp_cve, esp_nom "
            + "ORDER BY 3";
    PreparedStatement ps = cn.prepareStatement(sql);
    ps.setInt(1, grad.getSDE_CVE());
    if (grad.getESP_CVE()>0){
        ps.setInt(2, grad.getESP_CVE());
    }
    ResultSet rs = ps.executeQuery();
    List<Grado> lstDel = new ArrayList<Grado>();
    int ite;
    ite=0;
    if (rs.next()){
      rs.beforeFirst();
      while(rs.next()){
        lstDel.add(ite,new Grado(rs.getInt("GRD_NUM")));
        ite++;
      }
    } 
    rs.close();
    ps.close();
    cn.close();
    return lstDel;
  }

  public int update(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object delete(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}