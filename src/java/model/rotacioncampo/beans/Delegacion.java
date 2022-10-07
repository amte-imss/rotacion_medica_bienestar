/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.beans;

/**
 *
 * @author saul.ortigoza
 */
public class Delegacion {
  private int DEL_CVE;
  private String DEL_NOM;

  public Delegacion() {
  }

  public Delegacion(int DEL_CVE) {
    this.DEL_CVE = DEL_CVE;
  }

  public Delegacion(int DEL_CVE, String DEL_NOM) {
    this.DEL_CVE = DEL_CVE;
    this.DEL_NOM = DEL_NOM;
  }

  public int getDEL_CVE() {
    return DEL_CVE;
  }

  public void setDEL_CVE(int DEL_CVE) {
    this.DEL_CVE = DEL_CVE;
  }

  public String getDEL_NOM() {
    return DEL_NOM;
  }

  public void setDEL_NOM(String DEL_NOM) {
    this.DEL_NOM = DEL_NOM;
  }

  @Override
  public String toString() {
    return "{DEL_CVE:'" + DEL_CVE + "', DEL_NOM:'" + DEL_NOM + "'},";
  }
}
