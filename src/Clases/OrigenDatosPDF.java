/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JTable;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author aazañero
 */
public class OrigenDatosPDF implements JRDataSource{
    
    private Object [][] datos= null;
    private int index;
    
    public OrigenDatosPDF(){
        
        index = -1;
        datos = new Object[][]{
                                        {"1", "Afganistán", "Kabul", 37172386,"","","","","","",""},
                                        {"2", "Albania", "Tirana", 2862427,"","","","","","",""},
                                        {"3", "Alemania", "Berlín", 83019213,"","","","","","",""},
                                        {"4", "Andorra", "Andorra La Vieja", 76177,"","","","","","",""},
                                        {"5", "Angola", "Luanda", 30809762,"","","","","","",""},
                                      };
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < datos.length);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        RecogerDato exec = new RecogerDato();
        String consulta="";
        Object value = null;
        
        String fieldName = jrf.getName();
        
        switch(fieldName){
            
            case "DOC":
                value = datos[index][0];
            break;
            
            case "SER":
                value = datos[index][1];                
            break;
            
            case "NUM":
                value = datos[index][2];                
            break;
            
            case "EMI":
                value = datos[index][3];                
            break;
            
            case "VEN":
                value = datos[index][4];                
            break;
            
            case "NUMU":
                value = datos[index][5];                
            break;
            
            case "BAN":
                value = datos[index][6];                
            break;
            
            case "UBI":
                value = datos[index][7];                
            break;
            
            case "SOL":
                value = datos[index][8];                
            break;
            
            case "DOL":
                value = datos[index][9];                
            break;
            
            case "PRO":
                value = datos[index][10];                
            break;
            
            case "CODC":
                value="F07040";
            break;
            
            case "RZNS":
                consulta="EXEC [dbo].[AF_MANAGE_CRUDCLIE] 3,'CodigoCliente','F07040','','','RazonSocialCliente'";
                value=exec.recoger(consulta);
            break;
            
            case "RUC":
                consulta="EXEC [dbo].[AF_MANAGE_CRUDCLIE] 3,'CodigoCliente','F07040','','','RucCliente'";
                value=exec.recoger(consulta);
            break;
            
            case "DIR":
                consulta="EXEC [dbo].[AF_MANAGE_CRUDCLIE] 3,'CodigoCliente','F07040','','','DireccionCliente'";
                value=exec.recoger(consulta);
            break;
            
            case "TLF":
                consulta="EXEC [dbo].[AF_MANAGE_CRUDCLIE] 3,'CodigoCliente','F07040','','','Telefono1'";
                value=exec.recoger(consulta);
            break;
            
            case "CORR":
                consulta="EXEC [dbo].[AF_MANAGE_CRUDCLIE] 3,'CodigoCliente','F07040','','','CorreoCliente'";
                value=exec.recoger(consulta);
            break;
            
            case "VEND":
                consulta="EXEC [dbo].[AF_MANAGE_CRUDCLIE] 3,'CodigoCliente','F07040','','','CodigoVendedor'";
                value=exec.recoger(consulta);
                consulta = "SELECT NombreVendedor FROM Vendedores WHERE CodigoVendedor='" + value + "'";
                value=exec.recoger(consulta);
            break;
            
        }
        
        return value;
    
    }
    
    public static JRDataSource getDataSource(){
        JTable jTable1=null;
        return new OrigenDatosPDF();
    }
    }

