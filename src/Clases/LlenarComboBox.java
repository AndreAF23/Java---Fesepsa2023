/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author aazañero
 */
public class LlenarComboBox {
    public void llenar(JComboBox jComboBox,String consulta) throws SQLException{
        
            Clases.Conecx con = new Clases.Conecx();
            java.sql.Statement sql = con.Conectarse().createStatement();
            sql = con.Conectarse().createStatement();
            
            ResultSet rs = sql.executeQuery(consulta);
            while(rs.next()){
                jComboBox.addItem(rs.getString(1).trim());
            }
          
        
    }
}
