/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author aazañero
 */
public class LlenarArea {
     public void llenar(JTextArea jTextArea1,String consulta){
        
        try{
            jTextArea1.setText("");
            Clases.Conecx con = new Clases.Conecx();
            java.sql.Statement sql = con.Conectarse().createStatement();
            sql = con.Conectarse().createStatement();
            ResultSet rs = sql.executeQuery(consulta);
            while(rs.next()){
                jTextArea1.setText(rs.getString(1).trim());
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.toString());
        }
        
    }
}
