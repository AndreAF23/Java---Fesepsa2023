/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Forms.Consulta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aazañero
 */
public class LlenarSaldos {
    public void llenar(JTable jTable1,String consulta){
        Clases.Conecx con = new Clases.Conecx();
        
        try{
            int i=1;
            /*
            for(i=0;i<consulta.length();i++){
               if(consulta.substring(i,i+1).equals(",")){
                   j++;
               }
            }*/
            
            java.sql.Statement sql = con.Conectarse().createStatement();
            sql = con.Conectarse().createStatement();
            ResultSet rs = sql.executeQuery(consulta);
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);Vector v = new Vector();
            
            while(rs.next()){
                if(rs.getString(1).equals("01")){
                    v.add("FA");
                }else{
                    if(rs.getString(1).equals("05")){
                        v.add("LE");
                    }else{
                        if(rs.getString(1).equals("07")){
                            v.add("NC");
                        }else{
                            if(rs.getString(1).equals("00")){
                                v.add("AN");
                            }else{
                                if(rs.getString(1).equals("08")){
                                    v.add("ND");
                                }else{
                                    v.add("");
                                }
                            }
                        }
                    }
                }
                
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                
                modelo.addRow(v);      
                jTable1.setModel(modelo);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
