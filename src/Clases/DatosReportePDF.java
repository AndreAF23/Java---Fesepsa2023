/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author aazañero
 */
public class DatosReportePDF {
    private String DOC;
    private String SER;
    private String NUM;
    private String EMI;
    private String VEN;
    private String NUMU;
    private String BAN;
    private String UBI;
    private String SOL;
    private String DOL;
    private String PRO;

    public DatosReportePDF(String DOC, String SER, String NUM, String EMI, String VEN, String NUMU,String BAN, String UBI, String SOL, String DOL, String PRO) {
        this.DOC = DOC;
        this.SER = SER;
        this.NUM = NUM;
        this.EMI = EMI;
        this.VEN = VEN;
        this.NUMU = NUMU;
        this.BAN = BAN;
        this.UBI = UBI;
        this.SOL = SOL;
        this.DOL = DOL;
        this.PRO = PRO;
    }

    public String getDOC() {
        return DOC;
    }

    public void setDOC(String DOC) {
        this.DOC = DOC;
    }

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }
    
    public String getNUM() {
        return NUM;
    }
    
    public void setNUM(String NUM) {
        this.NUM = NUM;
    }
    
    public String getEMI() {
        return EMI;
    }
    
    public void setEMI(String EMI) {
        this.EMI = EMI;
    }

    public String getVEN() {
        return VEN;
    }

    public void setVEN(String VEN) {
        this.VEN = VEN;
    }

    public String getNUMU() {
        return NUMU;
    }

    public void setNUMU(String NUMU) {
        this.NUMU = NUMU;
    }

    public String getBAN() {
        return BAN;
    }

    public void setBAN(String BAN) {
        this.BAN = BAN;
    }

    public String getUBI() {
        return UBI;
    }

    public void setUBI(String UBI) {
        this.UBI = UBI;
    }

    public String getSOL() {
        return SOL;
    }

    public void setSOL(String SOL) {
        this.SOL = SOL;
    }

    public String getDOL() {
        return DOL;
    }

    public void setDOL(String DOL) {
        this.DOL = DOL;
    }

    public String getPRO() {
        return PRO;
    }

    public void setPRO(String PRO) {
        this.PRO = PRO;
    }
    
}
