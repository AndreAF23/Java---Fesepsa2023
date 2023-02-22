/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author aazañero
 */
public class LlenarPDF implements JRDataSource {

    private int index;
    private final Object[][] ecuenta;
    
    public LlenarPDF(){
        index = -1;
        ecuenta = new Object[][]{
                {"1","1","1","1","1","1","1","1",1.2,1.2,"1"}
        };
    }
    
    @Override
    public boolean next() throws JRException {
        index++;
        return(index < ecuenta.length);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        String fieldName = jrf.getName();
        
        switch(fieldName){
            case "fldDOC":
                value = ecuenta[index][0];
            break;
            case "fldSerie":
                value = ecuenta[index][1];
            break;
            case "fldNumero":
                value = ecuenta[index][2];
            break;
            case "fldEmision":
                value = ecuenta[index][3];
            break;
            case "fldVencimiento":
                value = ecuenta[index][4];
            break;
            case "fldNum.Unico":
                value = ecuenta[index][5];
            break;
            case "fldBanco":
                value = ecuenta[index][6];
            break;
            case "fldUbica":
                value = ecuenta[index][7];
            break;
            case "fldSoles":
                value = ecuenta[index][8];
            break;
            case "fldDolares":
                value = ecuenta[index][9];
            break;
            case "fldProtesto":
                value = ecuenta[index][10];
            break;  
        }
        
        return value;
    }
    
    public static JRDataSource getDataSource(){
        return new LlenarPDF();
    }
    
}
