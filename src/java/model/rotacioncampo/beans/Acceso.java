package model.rotacioncampo.beans;

/**
 *
 * @author saul.ortigoza
 */
public class Acceso {
  private int USU_CVE;
  private int PER_CVE;
  private String PER_AP1;
  private String PER_AP2;
  private String PER_NOM;
  private String CURP;
  private String PERFIL;
  private int ESP_CVE;
  private int SDE_CVE;
  private int DEL_CVE;

  public Acceso() {
  }

  public Acceso(int USU_CVE) {
    this.USU_CVE = USU_CVE;
  }

  public Acceso(int USU_CVE, int PER_CVE, String PER_AP1, String PER_AP2, String PER_NOM, String CURP, String PERFIL, int ESP_CVE, int SDE_CVE, int DEL_CVE) {
    this.USU_CVE = USU_CVE;
    this.PER_CVE = PER_CVE;
    this.PER_AP1 = PER_AP1;
    this.PER_AP2 = PER_AP2;
    this.PER_NOM = PER_NOM;
    this.CURP = CURP;
    this.PERFIL = PERFIL;
    this.ESP_CVE = ESP_CVE;
    this.SDE_CVE = SDE_CVE;
    this.DEL_CVE = DEL_CVE;
  }

  public int getUSU_CVE() {
    return USU_CVE;
  }

  public void setUSU_CVE(int USU_CVE) {
    this.USU_CVE = USU_CVE;
  }

  public int getPER_CVE() {
    return PER_CVE;
  }

  public void setPER_CVE(int PER_CVE) {
    this.PER_CVE = PER_CVE;
  }

  public String getPER_AP1() {
    return PER_AP1;
  }

  public void setPER_AP1(String PER_AP1) {
    this.PER_AP1 = PER_AP1;
  }

  public String getPER_AP2() {
    return PER_AP2;
  }

  public void setPER_AP2(String PER_AP2) {
    this.PER_AP2 = PER_AP2;
  }

  public String getPER_NOM() {
    return PER_NOM;
  }

  public void setPER_NOM(String PER_NOM) {
    this.PER_NOM = PER_NOM;
  }

  public String getCURP() {
    return CURP;
  }

  public void setCURP(String CURP) {
    this.CURP = CURP;
  }

  public String getPERFIL() {
    return PERFIL;
  }

  public void setPERFIL(String PERFIL) {
    this.PERFIL = PERFIL;
  }

  public int getESP_CVE() {
    return ESP_CVE;
  }

  public void setESP_CVE(int ESP_CVE) {
    this.ESP_CVE = ESP_CVE;
  }

  public int getSDE_CVE() {
    return SDE_CVE;
  }

  public void setSDE_CVE(int SDE_CVE) {
    this.SDE_CVE = SDE_CVE;
  }

  public int getDEL_CVE() {
    return DEL_CVE;
  }

  public void setDEL_CVE(int DEL_CVE) {
    this.DEL_CVE = DEL_CVE;
  }

  @Override
  public String toString() {
    return "{USU_CVE:'" + USU_CVE + "', PER_CVE:'" + PER_CVE + "', PER_AP1:'" + PER_AP1 + "', PER_AP2:'" + PER_AP2 + "', PER_NOM:'" + PER_NOM + "', CURP:'" + CURP + "', PERFIL:'" + PERFIL + "', ESP_CVE:'" + ESP_CVE + "', SDE_CVE:'" + SDE_CVE + "', DEL_CVE:'" + DEL_CVE + "'},";
  }
  
}
