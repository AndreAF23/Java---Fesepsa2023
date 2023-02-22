/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Forms.Consulta;
import java.beans.Statement;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author aazañero
 */
public class LlenarTabla {
    public void llenar(JTable jTable1,String consulta){
        Clases.Conecx con = new Clases.Conecx();
        int j = 0;
        try{
            int i=1;
            /*
            for(i=0;i<consulta.length();i++){
               if(consulta.substring(i,i+1).equals(",")){
                   j++;
               }
            }*/
            j=jTable1.getColumnCount();
            //System.out.println("Columnas:"+j);
            java.sql.Statement sql = con.Conectarse().createStatement();
            
            sql = con.Conectarse().createStatement();
            //System.out.println(consulta);
            ResultSet rs = sql.executeQuery(consulta);
            //System.out.println("PASE");
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            while(rs.next()){
                i=1;
                Vector v = new Vector();
                while(i<=j){
                    v.add(rs.getString(i));
                    i++;
                }
                modelo.addRow(v);      
                jTable1.setModel(modelo);
            }
        }catch(SQLException ex){
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
