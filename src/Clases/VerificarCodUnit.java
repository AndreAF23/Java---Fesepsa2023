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
public class VerificarCodUnit {
    
    public String ver(String codigo){
        try{
            String rpta="";
            Clases.Conecx con = new Clases.Conecx();
            String consulta = "[dbo].[AF_MANAGE_CRUDART] 2,'Count(*)','CodigoArticulo','" + codigo + "'";
            java.sql.Statement sql = null;
            sql = con.Conectarse().createStatement();
            
            ResultSet rs = sql.executeQuery(consulta);
            while(rs.next()){
               rpta=rs.getString(1);
            }
            
            //System.out.println(rpta);
            if(rpta.equals("0")){
                return "Codigo no existe";
            }
            if(rpta.equals("1")){
                return "Codigo si existe";
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
            return "Error";
        }
        return "";
    }
    
}
