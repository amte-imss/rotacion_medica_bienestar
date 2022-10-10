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
public class Meta {
    private int DEL_CVE;
    private String DEL_NOM;
    private int SDE_CVE;
    private String SDE_NOM; 
    private int ESP_CVE;
    private String ESP_NOM;
    private int DEL_CVE_ROT;
    private String DEL_NOM_ROT;
    private int SDE_CVE_ROT;
    private String SDE_NOM_ROT;    
    private int PRD_NUM;
    private int CUP_AUT;
    private int CUP_OCU;
    private int CUP_RES;
    private int PRO_ANO;
    private String PRD_NOM;

    public Meta() {
    }

    public Meta(int DEL_CVE, int PRO_ANO) {
        this.DEL_CVE = DEL_CVE;
        this.PRO_ANO = PRO_ANO;
    }

    public Meta(int DEL_CVE, int SDE_CVE, int PRO_ANO) {
        this.DEL_CVE = DEL_CVE;
        this.SDE_CVE = SDE_CVE;
        this.PRO_ANO = PRO_ANO;
    }

    public Meta(int DEL_CVE, int SDE_CVE, int ESP_CVE, int PRO_ANO) {
        this.DEL_CVE = DEL_CVE;
        this.SDE_CVE = SDE_CVE;
        this.ESP_CVE = ESP_CVE;
        this.PRO_ANO = PRO_ANO;
    }
    
    public Meta(int ESP_CVE, String ESP_NOM, int DEL_CVE_ROT, String DEL_NOM_ROT, int SDE_CVE_ROT, String SDE_NOM_ROT, int PRD_NUM, int CUP_AUT, int CUP_OCU, int CUP_RES, int PRO_ANO, String PRD_NOM) {
        this.ESP_CVE = ESP_CVE;
        this.ESP_NOM = ESP_NOM;
        this.DEL_CVE_ROT = DEL_CVE_ROT;
        this.DEL_NOM_ROT = DEL_NOM_ROT;
        this.SDE_CVE_ROT = SDE_CVE_ROT;
        this.SDE_NOM_ROT = SDE_NOM_ROT;
        this.PRD_NUM = PRD_NUM;
        this.CUP_AUT = CUP_AUT;
        this.CUP_OCU = CUP_OCU;
        this.CUP_RES = CUP_RES;
        this.PRO_ANO = PRO_ANO;
        this.PRD_NOM = PRD_NOM;
    }

    public Meta(int DEL_CVE, String DEL_NOM, int SDE_CVE, String SDE_NOM, int ESP_CVE, String ESP_NOM, int DEL_CVE_ROT, String DEL_NOM_ROT, int SDE_CVE_ROT, String SDE_NOM_ROT, int PRD_NUM, int CUP_AUT, int CUP_OCU, int CUP_RES, int PRO_ANO, String PRD_NOM) {
        this.DEL_CVE = DEL_CVE;
        this.DEL_NOM = DEL_NOM;
        this.SDE_CVE = SDE_CVE;
        this.SDE_NOM = SDE_NOM;
        this.ESP_CVE = ESP_CVE;
        this.ESP_NOM = ESP_NOM;
        this.DEL_CVE_ROT = DEL_CVE_ROT;
        this.DEL_NOM_ROT = DEL_NOM_ROT;
        this.SDE_CVE_ROT = SDE_CVE_ROT;
        this.SDE_NOM_ROT = SDE_NOM_ROT;
        this.PRD_NUM = PRD_NUM;
        this.CUP_AUT = CUP_AUT;
        this.CUP_OCU = CUP_OCU;
        this.CUP_RES = CUP_RES;
        this.PRO_ANO = PRO_ANO;
        this.PRD_NOM = PRD_NOM;
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

    public int getPRD_NUM() {
        return PRD_NUM;
    }

    public void setPRD_NUM(int PRD_NUM) {
        this.PRD_NUM = PRD_NUM;
    }

    public int getCUP_AUT() {
        return CUP_AUT;
    }

    public void setCUP_AUT(int CUP_AUT) {
        this.CUP_AUT = CUP_AUT;
    }

    public int getCUP_OCU() {
        return CUP_OCU;
    }

    public void setCUP_OCU(int CUP_OCU) {
        this.CUP_OCU = CUP_OCU;
    }

    public int getCUP_RES() {
        return CUP_RES;
    }

    public void setCUP_RES(int CUP_RES) {
        this.CUP_RES = CUP_RES;
    }

    public int getPRO_ANO() {
        return PRO_ANO;
    }

    public void setPRO_ANO(int PRO_ANO) {
        this.PRO_ANO = PRO_ANO;
    }
    
    public String getPRD_NOM() {
        return PRD_NOM;
    }

    public void setPRD_NOM(String PRD_NOM) {
        this.PRD_NOM = PRD_NOM;
    }

    @Override
    public String toString() {
        return "{DEL_CVE:'" + DEL_CVE + "', DEL_NOM:'" + DEL_NOM + "', SDE_CVE:'" + SDE_CVE + "', SDE_NOM:'" + SDE_NOM + "', "
                + "ESP_CVE:'" + ESP_CVE + "', ESP_NOM:'" + ESP_NOM + "', DEL_CVE_ROT:'" + DEL_CVE_ROT + "', "
                + "DEL_NOM_ROT:'" + DEL_NOM_ROT + "', SDE_CVE_ROT:'" + SDE_CVE_ROT + "', SDE_NOM_ROT:'" + SDE_NOM_ROT + "', "
                + "PRD_NUM:'" + PRD_NUM + "', CUP_AUT:'" + CUP_AUT + "', CUP_OCU:'" + CUP_OCU + "', CUP_RES:'" + CUP_RES + "', "
                + "PRO_ANO:'" + PRO_ANO + "', PRD_NOM:'" + PRD_NOM + "'},";
    }
}
