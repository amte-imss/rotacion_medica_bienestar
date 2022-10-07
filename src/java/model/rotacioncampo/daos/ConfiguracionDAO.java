package model.rotacioncampo.daos;

import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.rotacioncampo.beans.Configuracion;

/**
 *
 * @author saul.ortigoza
 */
public class ConfiguracionDAO implements DAO{

  public Object create(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object retrieve(Object obj) throws Exception {
    Configuracion cnf = new Configuracion();
    Connection cn = BD.getConection();
    String sql = "select a.PRO_ANO CAL_ANO, b.MDL_STA_CVE from srm_per_ins_cnf_arc a, sis_mdl_cat b where a.ins_tip_cve=1 and b.MDL_CVE=82";
    PreparedStatement ps = cn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if (rs.next()){
      cnf.setCAL_ANO(rs.getInt("CAL_ANO"));
      cnf.setMDL_STA_CVE(rs.getInt("MDL_STA_CVE"));
    } else {
      cnf.setCAL_ANO(0);
      cnf.setMDL_STA_CVE(0);
    }
    rs.close();
    ps.close();
    cn.close();
    return cnf;
  }
  
  public Object retrieveAnterior(int ADS_CVE) throws Exception {
    Configuracion cnf = new Configuracion();
    Connection cn = BD.getConection();
    String sql = "select CUR_ANO as CAL_ANO,  1 as MDL_STA_CVE from srm_per_ads_arc1 where ads_cve=?";
    PreparedStatement ps = cn.prepareStatement(sql);
    ps.setInt(1, ADS_CVE);
    ResultSet rs = ps.executeQuery();
    if (rs.next()){
      cnf.setCAL_ANO(rs.getInt("CAL_ANO"));
      cnf.setMDL_STA_CVE(rs.getInt("MDL_STA_CVE"));
    } else {
      cnf.setCAL_ANO(0);
      cnf.setMDL_STA_CVE(0);
    }
    rs.close();
    ps.close();
    cn.close();
    return cnf;
  }  

  public int update(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object delete(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
