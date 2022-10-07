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
public class SedeRotacion {
    private int MTA_CVE;
    private int SDE_CVE;
    private int ESP_CVE;
    private int PRD_NUM;
    private int SDE_CVE_ROT;
    private String SDE_NOM_ROT;

    public SedeRotacion() {
    }

    public SedeRotacion(int SDE_CVE, int ESP_CVE, int PRD_NUM) {
        this.SDE_CVE = SDE_CVE;
        this.ESP_CVE = ESP_CVE;
        this.PRD_NUM = PRD_NUM;
    }

    public SedeRotacion(int MTA_CVE, int SDE_CVE, int ESP_CVE, int PRD_NUM, int SDE_CVE_ROT, String SDE_NOM_ROT) {
        this.MTA_CVE = MTA_CVE;
        this.SDE_CVE = SDE_CVE;
        this.ESP_CVE = ESP_CVE;
        this.PRD_NUM = PRD_NUM;
        this.SDE_CVE_ROT = SDE_CVE_ROT;
        this.SDE_NOM_ROT = SDE_NOM_ROT;
    }

    public int getMTA_CVE() {
        return MTA_CVE;
    }

    public void setMTA_CVE(int MTA_CVE) {
        this.MTA_CVE = MTA_CVE;
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
    
    
}