package model.rotacioncampo.daos;

import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.rotacioncampo.beans.Rotacion;

/**
 *
 * @author saul
 */
public class RotacionDAO implements DAO{

    @Override
    public Object create(Object obj) throws Exception {
      Rotacion cele = (Rotacion)obj;
        Connection cn = BD.getConection();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
      int res = 0;        
      try {
        String sql = "insert into srm_rot_cmp_arc "
            + "select null, "
            + "?, "
            + "?";
        ps = cn.prepareStatement(sql);
        ps.setInt(1, cele.getREG_CVE());
        ps.setInt(2, cele.getMTA_CVE());
        ps.executeUpdate();
        res = ps.getUpdateCount();
        
        String sql2 = "update srm_mta_prg_rot_cmp_arc set cup_ocu=cup_ocu+1, cup_res=cup_res-1 where mta_cve=? ";
        ps2 = cn.prepareStatement(sql2);
        ps2.setInt(1, cele.getMTA_CVE());
        ps2.executeUpdate();
      } catch (Exception e) {
      } finally {
        try {
          if (ps!=null) { ps.close(); ps2.close(); }
        } catch (SQLException e) {
        } finally {
          try {
            if(cn!=null) { cn.close(); }
          } catch (SQLException e) {
          }
        }
      }

        return res;
    }

    @Override
    public Object retrieve(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object delete(Object obj) throws Exception {
      Rotacion cele = (Rotacion)obj;
        Connection cn = BD.getConection();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
      int res = 0;        
      try {
        String sql = "select * from srm_rot_cmp_arc where reg_cve=?";
        ps3 = cn.prepareStatement(sql);
        ps3.setInt(1, cele.getREG_CVE());
        int rot_cve, mta_cve;
        rot_cve=0;
        mta_cve=0;
       ResultSet rs = ps3.executeQuery();  
          if (rs.next()) {
              rot_cve=rs.getInt("ROT_CVE");
              mta_cve=rs.getInt("MTA_CVE");
          }
          rs.close();
        
          
        sql = "delete from srm_rot_cmp_arc  "
            + "where rot_cve=?";
        ps = cn.prepareStatement(sql);
        ps.setInt(1, rot_cve);
        ps.executeUpdate();
        res = ps.getUpdateCount();
        
        String sql2 = "update srm_mta_prg_rot_cmp_arc set cup_ocu=cup_ocu-1, cup_res=cup_res+1 where mta_cve=? ";
        ps2 = cn.prepareStatement(sql2);
        ps2.setInt(1, mta_cve);
        ps2.executeUpdate();
      } catch (Exception e) {
      } finally {
        try {
          if (ps!=null) { ps.close(); ps2.close(); ps3.close(); }
        } catch (SQLException e) {
        } finally {
          try {
            if(cn!=null) { cn.close(); }
          } catch (SQLException e) {
          }
        }
      }

        return res;
    }
    
}
