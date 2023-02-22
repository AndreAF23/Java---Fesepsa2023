/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aazañero
 */

public class Conecx {
    Connection cn = null;
    public String datab= "";
    public Connection Conectarse(){
    try{
                String bd="";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                bd = "jdbc:sqlserver://MAESTRO\\MAESTRO;database=fesepsa;user=sa;password=Fesepsa2012";
                //bd= "jdbc:sqlserver://PCFS017;database=fesepsa;user=sa;password=Fesepsa1234!";
                cn = DriverManager.getConnection(bd); 
                if(bd.contains("MAESTRO")){
                    datab="Maestro";
                }else{
                    if(bd.contains("PCFS017")){
                        datab="Local";
                    }
                }
                //System.out.println(datab);
            }catch(ClassNotFoundException | SQLException e){
                System.out.println(e.toString());
            }
            return cn;
    }
}
