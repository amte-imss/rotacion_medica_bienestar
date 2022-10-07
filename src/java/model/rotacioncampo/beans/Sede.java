/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.beans;

/**
 *
 * @author saul.ortigoza
 */
public class Sede {
  private int DEL_CVE;
  private int SDE_CVE;
  private String SDE_NOM;

  public Sede() {
  }

  public Sede(int SDE_CVE) {
    this.SDE_CVE = SDE_CVE;
  }

  public Sede(int DEL_CVE, int SDE_CVE) {
    this.DEL_CVE = DEL_CVE;
    this.SDE_CVE = SDE_CVE;
  }

  public Sede(int DEL_CVE, int SDE_CVE, String SDE_NOM) {
    this.DEL_CVE = DEL_CVE;
    this.SDE_CVE = SDE_CVE;
    this.SDE_NOM = SDE_NOM;
  }

  public int getDEL_CVE() {
    return DEL_CVE;
  }

  public void setDEL_CVE(int DEL_CVE) {
    this.DEL_CVE = DEL_CVE;
  }

  public int getSDE_CVE() {
    return SDE_CVE;
  }

  public void setSDE_CVE(int SDE_CVE) {
    this.SDE_CVE = SDE_CVE;
  }

  public String getSDE_NOM() {
    return SDE_NOM;
  }

  public void setSDE_NOM(String SDE_NOM) {
    this.SDE_NOM = SDE_NOM;
  }

  @Override
  public String toString() {
    return "{DEL_CVE:'" + DEL_CVE + "', SDE_CVE:'" + SDE_CVE + "', SDE_NOM:'" + SDE_NOM + "'},";
  }
}
