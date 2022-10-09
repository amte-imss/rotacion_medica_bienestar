/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rotacioncampo.beans;

/**
 *
 * @author saul
 */
public class Residente {
  private int ADS_CVE;
  private int REG_CVE;
  private int PER_CVE;
  private String CURP;
  private String PER_AP1;
  private String PER_AP2;
  private String PER_NOM;
  private int GRD_NUM;
  private int SDE_CVE;
  private String SDE_NOM;
  private int DEL_CVE;
  private String DEL_NOM;
  private int ESP_CVE;
  private String ESP_NOM;
  private int MTA_CVE;
  private int PRD_NUM;
  private int SDE_CVE_ROT;
  private String SDE_NOM_ROT;
  private int DEL_CVE_ROT;
  private String DEL_NOM_ROT;  
  private String PRD_NOM;

    public Residente() {
    }

    public Residente(int ADS_CVE) {
        this.ADS_CVE = ADS_CVE;
    }

    public Residente(String CURP) {
        this.CURP = CURP;
    }

    public Residente(int SDE_CVE, int DEL_CVE) {
        this.SDE_CVE = SDE_CVE;
        this.DEL_CVE = DEL_CVE;
    }

    public Residente(int SDE_CVE, int DEL_CVE, int ESP_CVE) {
        this.SDE_CVE = SDE_CVE;
        this.DEL_CVE = DEL_CVE;
        this.ESP_CVE = ESP_CVE;
    }
    
    public Residente(int SDE_CVE, int DEL_CVE, int ESP_CVE, int GRD_NUM) {
        this.SDE_CVE = SDE_CVE;
        this.DEL_CVE = DEL_CVE;
        this.ESP_CVE = ESP_CVE;
        this.GRD_NUM = GRD_NUM;
    }
    
    public Residente(int ADS_CVE, int REG_CVE, int PER_CVE, String CURP, String PER_AP1, String PER_AP2, String PER_NOM, int GRD_NUM, int SDE_CVE, String SDE_NOM, int DEL_CVE, String DEL_NOM, int ESP_CVE, String ESP_NOM, int MTA_CVE, int PRD_NUM, int SDE_CVE_ROT, String SDE_NOM_ROT, int DEL_CVE_ROT, String DEL_NOM_ROT, String PRD_NOM) {
        this.ADS_CVE = ADS_CVE;
        this.REG_CVE = REG_CVE;
        this.PER_CVE = PER_CVE;
        this.CURP = CURP;
        this.PER_AP1 = PER_AP1;
        this.PER_AP2 = PER_AP2;
        this.PER_NOM = PER_NOM;
        this.GRD_NUM = GRD_NUM;
        this.SDE_CVE = SDE_CVE;
        this.SDE_NOM = SDE_NOM;
        this.DEL_CVE = DEL_CVE;
        this.DEL_NOM = DEL_NOM;
        this.ESP_CVE = ESP_CVE;
        this.ESP_NOM = ESP_NOM;
        this.MTA_CVE = MTA_CVE;
        this.PRD_NUM = PRD_NUM;
        this.SDE_CVE_ROT = SDE_CVE_ROT;
        this.SDE_NOM_ROT = SDE_NOM_ROT;
        this.DEL_CVE_ROT = DEL_CVE_ROT;
        this.DEL_NOM_ROT = DEL_NOM_ROT;
        this.PRD_NOM = PRD_NOM;
    }

    public int getPRD_NUM() {
        return PRD_NUM;
    }

    public void setPRD_NUM(int PRD_NUM) {
        this.PRD_NUM = PRD_NUM;
    }

    public int getSDE_CVE_ROT() {
        return SDE_CVE_ROT;
    }

    public void setSDE_CVE_ROT(int SDE_CVE_ROT) {
        this.SDE_CVE_ROT = SDE_CVE_ROT;
    }

    public String getSDE_NOM_ROT() {
        return SDE_NOM_ROT;
    }

    public void setSDE_NOM_ROT(String SDE_NOM_ROT) {
        this.SDE_NOM_ROT = SDE_NOM_ROT;
    }

    public int getDEL_CVE_ROT() {
        return DEL_CVE_ROT;
    }

    public void setDEL_CVE_ROT(int DEL_CVE_ROT) {
        this.DEL_CVE_ROT = DEL_CVE_ROT;
    }

    public String getDEL_NOM_ROT() {
        return DEL_NOM_ROT;
    }

    public void setDEL_NOM_ROT(String DEL_NOM_ROT) {
        this.DEL_NOM_ROT = DEL_NOM_ROT;
    }

    public int getADS_CVE() {
        return ADS_CVE;
    }

    public void setADS_CVE(int ADS_CVE) {
        this.ADS_CVE = ADS_CVE;
    }

    public int getREG_CVE() {
        return REG_CVE;
    }

    public void setREG_CVE(int REG_CVE) {
        this.REG_CVE = REG_CVE;
    }

    public int getPER_CVE() {
        return PER_CVE;
    }

    public void setPER_CVE(int PER_CVE) {
        this.PER_CVE = PER_CVE;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
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

    public int getGRD_NUM() {
        return GRD_NUM;
    }

    public void setGRD_NUM(int GRD_NUM) {
        this.GRD_NUM = GRD_NUM;
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

    public int getMTA_CVE() {
        return MTA_CVE;
    }

    public void setMTA_CVE(int MTA_CVE) {
        this.MTA_CVE = MTA_CVE;
    }
    
    public String getPRD_NOM() {
        return PRD_NOM;
    }

    public void setPRD_NOM(String PRD_NOM) {
        this.PRD_NOM = PRD_NOM;
    }

    @Override
    public String toString() {
        return "{ADS_CVE:'" + ADS_CVE + "', REG_CVE:'" + REG_CVE + "', PER_CVE:'" + PER_CVE + "', "
                + "CURP:'" + CURP + "', PER_AP1:'" + PER_AP1 + "', PER_AP2:'" + PER_AP2 + "', "
                + "PER_NOM:'" + PER_NOM + "', GRD_NUM:'" + GRD_NUM + "', SDE_CVE:'" + SDE_CVE + "', "
                + "SDE_NOM:'" + SDE_NOM + "', DEL_CVE:'" + DEL_CVE + "', DEL_NOM:'" + DEL_NOM + "', "
                + "ESP_CVE:'" + ESP_CVE + "', ESP_NOM:'" + ESP_NOM + "', MTA_CVE:'" + MTA_CVE + "', "
                + "PRD_NUM:'" + PRD_NUM + "', SDE_CVE_ROT:'" + SDE_CVE_ROT + "', SDE_NOM_ROT:'" + SDE_NOM_ROT + "', "
                + "DEL_CVE_ROT:'" + DEL_CVE_ROT + "', DEL_NOM_ROT:'" + DEL_NOM_ROT + "', PRD_NOM:'" + PRD_NOM +"'},";
    }
  
}
