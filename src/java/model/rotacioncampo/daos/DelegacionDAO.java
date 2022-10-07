package model.rotacioncampo.daos;

import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.rotacioncampo.beans.Delegacion;

/**
 *
 * @author saul.ortigoza
 */
public class DelegacionDAO implements DAO{

  public Object create(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object retrieve(Object obj) throws Exception {
    Delegacion del = (Delegacion)obj;
    Connection cn = BD.getConection();
    String sql;
    sql = "SELECT del_cve, CONCAT(edo_nom, ' ', del_nom) del_nom "
            + "FROM srm_reg_ads_vis v INNER JOIN srm_atn_med_ib_esp_grd_arc e ON e.esp_cve=v.esp_cve AND e.grd_num=v.grd_num "
            + "WHERE mta_ctg_cve not in (5) "; //and ((grd_num=3 AND esp_cve IN (6,35,18)) OR (grd_num=2 AND esp_cve IN (37,120,31,39,30,25))) 
    if (del.getDEL_CVE()>0){
      sql += "AND del_cve=? ";
    }
    sql += "GROUP BY del_cve, CONCAT(edo_nom, ' ', del_nom) "
            + "ORDER BY 2";
    PreparedStatement ps = cn.prepareStatement(sql);
    if (del.getDEL_CVE()>0){
        ps.setInt(1, del.getDEL_CVE());
    }
    ResultSet rs = ps.executeQuery();
    List<Delegacion> lstDel = new ArrayList<Delegacion>();
    int ite;
    ite=0;
    if (rs.next()){
      rs.beforeFirst();
      while(rs.next()){
        lstDel.add(ite,new Delegacion(rs.getInt("DEL_CVE"), rs.getString("DEL_NOM")));
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
