/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.beans;

/**
 *
 * @author saul.ortigoza
 */
public class Especialidad {
  private int SDE_CVE;
  private int ESP_CVE;
  private String ESP_NOM;

  public Especialidad() {
  }

  public Especialidad(int ESP_CVE) {
    this.ESP_CVE = ESP_CVE;
  }

  public Especialidad(int SDE_CVE, int ESP_CVE) {
    this.SDE_CVE = SDE_CVE;
    this.ESP_CVE = ESP_CVE;
  }

  public Especialidad(int SDE_CVE, int ESP_CVE, String ESP_NOM) {
    this.SDE_CVE = SDE_CVE;
    this.ESP_CVE = ESP_CVE;
    this.ESP_NOM = ESP_NOM;
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

  public String getESP_NOM() {
    return ESP_NOM;
  }

  public void setESP_NOM(String ESP_NOM) {
    this.ESP_NOM = ESP_NOM;
  }

  @Override
  public String toString() {
    return "{SDE_CVE:'" + SDE_CVE + "', ESP_CVE:'" + ESP_CVE + "', ESP_NOM:'" + ESP_NOM + "'},";
  }
}
