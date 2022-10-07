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
public class Periodo {
    private int PRD_NUM;
    private int SDE_CVE;
    private int ESP_CVE;

    public Periodo(int SDE_CVE, int ESP_CVE) {
        this.SDE_CVE = SDE_CVE;
        this.ESP_CVE = ESP_CVE;
    }

    public Periodo() {
    }

    public Periodo(int PRD_NUM, int SDE_CVE, int ESP_CVE) {
        this.PRD_NUM = PRD_NUM;
        this.SDE_CVE = SDE_CVE;
        this.ESP_CVE = ESP_CVE;
    }

    public int getPRD_NUM() {
        return PRD_NUM;
    }

    public void setPRD_NUM(int PRD_NUM) {
        this.PRD_NUM = PRD_NUM;
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

    
    
}
