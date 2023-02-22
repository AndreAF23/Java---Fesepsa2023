/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.SQLException;

/**
 *
 * @author aazañero
 */
public class LlenarTexto {
    public void llenar(JTextField jTextField1,String consulta){
        
        try{
            Clases.Conecx con = new Clases.Conecx();
            java.sql.Statement sql = con.Conectarse().createStatement();
            sql = con.Conectarse().createStatement();
            ResultSet rs = sql.executeQuery(consulta);
            while(rs.next()){
                jTextField1.setText(rs.getString(1).trim());
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.toString());
        }
        
    }
}
