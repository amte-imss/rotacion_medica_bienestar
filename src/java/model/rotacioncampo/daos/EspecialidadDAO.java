package model.rotacioncampo.daos;

import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.rotacioncampo.beans.Especialidad;


/**
 *
 * @author saul.ortigoza
 */
public class EspecialidadDAO implements DAO{

  public Object create(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object retrieve(Object obj) throws Exception {
    Especialidad esp = (Especialidad)obj;
    Connection cn = BD.getConection();
    String sql;
    sql = "SELECT sde_cve, esp_cve, esp_nom "
            + "FROM srm_reg_ads_vis "
            + "WHERE mta_ctg_cve not in (5) and ((grd_num=3 AND esp_cve IN (6,35,18)) OR (grd_num=2 AND esp_cve IN (37,120,31,39,30,25))) "
            + "AND sde_cve=? ";
    if (esp.getESP_CVE()>0){
      sql += "AND esp_cve=? ";
    }
    sql += "GROUP BY sde_cve, esp_cve, esp_nom "
            + "ORDER BY 3";
    PreparedStatement ps = cn.prepareStatement(sql);
    ps.setInt(1, esp.getSDE_CVE());
    if (esp.getESP_CVE()>0){
        ps.setInt(2, esp.getESP_CVE());
    }
    ResultSet rs = ps.executeQuery();
    List<Especialidad> lstEsp = new ArrayList<Especialidad>();
    int ite;
    ite=0;
    if (rs.next()){
      rs.beforeFirst();
      while(rs.next()){
        lstEsp.add(ite,new Especialidad(rs.getInt("SDE_CVE"), rs.getInt("ESP_CVE"), rs.getString("ESP_NOM")));
        ite++;
      }
    } 
    rs.close();
    ps.close();
    cn.close();
    return lstEsp;
  }

  public int update(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object delete(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
