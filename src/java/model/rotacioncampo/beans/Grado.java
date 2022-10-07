/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.beans;

/**
 *
 * @author saul.ortigoza
 */
public class Grado {
  private int SDE_CVE;
  private int ESP_CVE;
  private int GRD_NUM;

  public Grado() {
  }

  public Grado(int ESP_CVE) {
    this.ESP_CVE = ESP_CVE;
  }

  public Grado(int SDE_CVE, int ESP_CVE) {
    this.SDE_CVE = SDE_CVE;
    this.ESP_CVE = ESP_CVE;
  }
  
  public Grado(int SDE_CVE, int ESP_CVE, int GRD_NUM) {
    this.SDE_CVE = SDE_CVE;
    this.ESP_CVE = ESP_CVE;
    this.GRD_NUM = GRD_NUM;
  }

  public int getSDE_CVE() {
    return SDE_CVE;
  }

  public void setSDE_CVE(int SDE_CVE) {
    this.SDE_CVE = SDE_CVE;
  }

  public int getESP_CVE() {
    return ESP_CVE;
  }

  public void setESP_CVE(int ESP_CVE) {
    this.ESP_CVE = ESP_CVE;
  }
  
  public int getGRD_NUM() {
    return GRD_NUM;
  }

  public void setGRD_NUM(int GRD_NUM) {
    this.GRD_NUM = GRD_NUM;
  }

  @Override
  public String toString() {
    return "{SDE_CVE:'" + SDE_CVE + "', ESP_CVE:'" + ESP_CVE + "', GRD_NUM:'" + GRD_NUM + "'},";
  }
}
