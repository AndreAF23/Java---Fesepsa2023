/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author aazañero
 */
public class EjecutarQuery {
    
    public String ejecutar(String consulta){
        String res="";
        try{
            Clases.Conecx con = new Clases.Conecx();
            java.sql.Statement sql = con.Conectarse().createStatement();
            ResultSet rs = sql.executeQuery(consulta);
            while(rs.next()){
                res=rs.getString(1).trim();
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            res="Error";
        }
        return res;
    }
    
}
