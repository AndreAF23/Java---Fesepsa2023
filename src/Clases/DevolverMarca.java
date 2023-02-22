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
public class DevolverMarca {
    public String dev(String nombremarca){
        try{
            String res="";
            Clases.Conecx con = new Clases.Conecx();
            java.sql.Statement sql = con.Conectarse().createStatement();
            ResultSet rs = sql.executeQuery("SELECT TOP 1 CodigoMarca FROM Marcas WHERE NombreMarca LIKE '%" + nombremarca + "%'");
            while(rs.next()){
                res=rs.getString(1);
            }
            return res;
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return "";
    }
}
