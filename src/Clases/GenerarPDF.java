/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JTable;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author aazañero
 */
public class GenerarPDF {
    public  GenerarPDF(){
        try{
            
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/prueba2.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, OrigenDatosPDF.getDataSource());
            
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
            
        }catch(JRException ex){
            ex.toString();
        }
    }
    
    public static void main(String[] args) {
        GenerarPDF jasper = new GenerarPDF();
    }
    
    
}
