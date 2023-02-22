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
public class RecogerDato {
    public String recoger(String consulta){
        String res="";
        int cont=0;
        try{
            Clases.Conecx con = new Clases.Conecx();
            java.sql.Statement sql = con.Conectarse().createStatement();
            sql = con.Conectarse().createStatement();
            
            ResultSet rs = sql.executeQuery(consulta);
            
            while(rs.next()){
                cont++;
                res=rs.getString(1);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        if(cont==0){
            res="No se encontraron datos";
        }else{
            if(cont>1){
                res="Registro duplicado";
            }
        }
        res=res.trim();
        return res;
    }
}
