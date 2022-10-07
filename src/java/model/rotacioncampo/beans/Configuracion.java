/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.beans;

/**
 *
 * @author saul.ortigoza
 */
public class Configuracion {
  private int CAL_ANO;
  private int MDL_STA_CVE;

  public Configuracion() {
  }

  public Configuracion(int CAL_ANO, int MDL_STA_CVE) {
    this.CAL_ANO = CAL_ANO;
    this.MDL_STA_CVE = MDL_STA_CVE;
  }

  public int getCAL_ANO() {
    return CAL_ANO;
  }

  public void setCAL_ANO(int CAL_ANO) {
    this.CAL_ANO = CAL_ANO;
  }

  public int getMDL_STA_CVE() {
    return MDL_STA_CVE;
  }

  public void setMDL_STA_CVE(int MDL_STA_CVE) {
    this.MDL_STA_CVE = MDL_STA_CVE;
  }

  @Override
  public String toString() {
    return "{CAL_ANO:'" + CAL_ANO + "', MDL_STA_CVE:'" + MDL_STA_CVE + "'},";
  }

}
