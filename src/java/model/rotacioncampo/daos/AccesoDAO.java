package model.rotacioncampo.daos;

import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.rotacioncampo.beans.Acceso;

/**
 *
 * @author saul.ortigoza
 */
public class AccesoDAO implements DAO{

  public Object create(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object retrieve(Object obj) throws Exception {
    Acceso ac = (Acceso)obj;
    Connection cn = BD.getConection();
    String sql;
    sql="SELECT a.USU_CVE, a.PER_CVE, b.PER_AP1, b.PER_AP2, b.PER_NOM, b.CURP, "
            + "CASE WHEN d.CURP IS NOT NULL THEN 'PROFESOR' ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Coordinador Auxiliar de Educación en Salud' THEN 'DELEGACIONAL' ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Jefe de División de Educación en Salud' and c.CURP IS NOT NULL THEN 'JEFE DE DIVISION' ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Coordinador Clínico de Educación e Investigación en Salud' and c.CURP IS NOT NULL THEN 'CLINICO' ELSE "
            + "CASE WHEN e.CURP IS NOT NULL THEN 'DELEGACIONAL' ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Administrador de Subsistema' THEN "
            + "'ADMINISTRADOR' ELSE 'SIN ACCESO' END END END END END END PERFIL, "
            + "CASE WHEN d.CURP IS NOT NULL THEN d.ESP_CVE ELSE "
            + "CASE WHEN c.CURP IS NOT NULL THEN 0 ELSE "
            + "CASE WHEN e.CURP IS NOT NULL THEN 0 ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Coordinador Auxiliar de Educación en Salud' THEN 0 ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Jefe de División de Educación en Salud' THEN 0 ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Administrador de Subsistema' THEN "
            + "0 ELSE 0 END END END END END END ESP_CVE, "
            + "CASE WHEN d.CURP IS NOT NULL THEN d.SDE_CVE ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Coordinador Auxiliar de Educación en Salud' THEN 0 ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Jefe de División de Educación en Salud' and c.CURP IS NOT NULL THEN c.SDE_CVE ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Coordinador Clínico de Educación e Investigación en Salud' and c.CURP IS NOT NULL THEN c.SDE_CVE ELSE "
            + "CASE WHEN e.CURP IS NOT NULL THEN 0 ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Administrador de Subsistema' THEN "
            + "0 ELSE 0 END END END END END END SDE_CVE, "
            + "CASE WHEN d.CURP IS NOT NULL THEN g.DEL_CVE ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Coordinador Auxiliar de Educación en Salud' THEN i.DEL_CVE ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Jefe de División de Educación en Salud' and c.CURP IS NOT NULL THEN c.DEL_CVE ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Coordinador Clínico de Educación e Investigación en Salud' and c.CURP IS NOT NULL THEN c.DEL_CVE ELSE "
            + "CASE WHEN e.CURP IS NOT NULL THEN e.DEL_CVE ELSE "
            + "CASE WHEN f.ROL_TIP_NOM='Administrador de Subsistema' THEN "
            + "0 ELSE 0 END END END END END END DEL_CVE,"
            + "f.ROL_TIP_NOM "
            + "FROM sis_per_acc_arc a "
            + "INNER JOIN gra_per_arc b ON a.PER_CVE=b.PER_CVE "
            + "LEFT JOIN ims_del_cor_cat e ON b.CURP=e.CURP AND e.STA_CVE=1 "
            + "LEFT JOIN ims_cli_cor_Arc c ON b.CURP=c.CURP AND c.STA_CVE=2 "
            + "LEFT JOIN srm_prf_arc d ON b.CURP=d.CURP AND d.PRF_STA_CVE=1 "
            + "LEFT JOIN gra_sde_cat g ON d.SDE_CVE=g.SDE_CVE "
            + "LEFT JOIN sis_per_sde_acc_arc h on a.USU_CVE=h.USU_CVE "
            + "LEFT JOIN gra_sde_cat i on h.sde_cve=i.sde_cve "
            + "INNER JOIN sis_rol_tip_cat f ON a.ROL_TIP_CVE=f.rol_tip_cve "
            + "WHERE a.SIS_MDL_ACT_CVE=82 AND a.USU_ACC_STA_CVE=1 AND a.USU_CVE=?";
    PreparedStatement ps = cn.prepareStatement(sql);
    ps.setInt(1, ac.getUSU_CVE());
    ResultSet rs = ps.executeQuery();
    if (rs.next()){
      ac.setPER_CVE(rs.getInt("PER_CVE"));
      ac.setPER_AP1(rs.getString("PER_AP1"));
      ac.setPER_AP2(rs.getString("PER_AP2"));
      ac.setPER_NOM(rs.getString("PER_NOM"));
      ac.setCURP(rs.getString("CURP"));
      ac.setPERFIL(rs.getString("PERFIL"));
      ac.setESP_CVE(rs.getInt("ESP_CVE"));
      ac.setSDE_CVE(rs.getInt("SDE_CVE"));
      ac.setDEL_CVE(rs.getInt("DEL_CVE"));
    } else {
      ac.setPER_CVE(0);
      ac.setPERFIL("SIN ACCESO");
    }
    rs.close();
    ps.close();
    cn.close();
    return ac;
  }

  public int update(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object delete(Object obj) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
