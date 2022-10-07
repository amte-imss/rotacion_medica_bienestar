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
public class Rotacion {
    private int ROT_CVE;
    private int REG_CVE;
    private int MTA_CVE;

    public Rotacion() {
    }

    public Rotacion(int ROT_CVE, int REG_CVE, int MTA_CVE) {
        this.ROT_CVE = ROT_CVE;
        this.REG_CVE = REG_CVE;
        this.MTA_CVE = MTA_CVE;
    }

    public int getROT_CVE() {
        return ROT_CVE;
    }

    public void setROT_CVE(int ROT_CVE) {
        this.ROT_CVE = ROT_CVE;
    }

    public int getREG_CVE() {
        return REG_CVE;
    }

    public void setREG_CVE(int REG_CVE) {
        this.REG_CVE = REG_CVE;
    }

    public int getMTA_CVE() {
        return MTA_CVE;
    }

    public void setMTA_CVE(int MTA_CVE) {
        this.MTA_CVE = MTA_CVE;
    }
    
    
}
