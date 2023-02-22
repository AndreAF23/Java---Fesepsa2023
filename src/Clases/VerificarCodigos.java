/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JTable;
/**
 *
 * @author aazañero
 */
public class VerificarCodigos {
    public String ver(JTable jTable1, int columnacodigos){
        String strcons="",cod = "",faltantes="Faltan registrar codigos:\n";
        int eliminacion=0;
        Boolean completo=true;
        String arraycod[] = new String[jTable1.getRowCount()];
        for(int j=0;j<jTable1.getRowCount();j++){
            arraycod[j]=jTable1.getValueAt(j, columnacodigos).toString();
            System.out.println(arraycod[j]);
        }
        System.out.println("Largo de array:" + arraycod.length);
        
        for (int x=0;x<arraycod.length;x++){
            for (int y=x+1;y<arraycod.length;y++){
                if(arraycod[x] != null && arraycod[y].equals(arraycod[x])){
                    arraycod[x]=null;
                    eliminacion++;
                }
                    
            }
            
        }
        String[] codunicos = new String[arraycod.length - eliminacion];
        if(eliminacion==0){
            for(int i=0;i<arraycod.length;i++){
                codunicos[i]=arraycod[i];
            }
        }else{
            int indice=0;
            for(int x=0;x<arraycod.length;x++){
                if(arraycod[x] != null){
                    
                    codunicos[indice] = arraycod[x];
                    indice++;
                }
            }
            
        }
        
        System.out.println("Largo de array:" + codunicos.length);
        strcons="'";
        for (int i = 0 ; i<codunicos.length ; i++){
            strcons=strcons + codunicos[i] + "','";
        }
        strcons=strcons.substring(0, strcons.length()-2);
        System.out.println();
        
        Clases.Conecx con = new Clases.Conecx();
        try{
            int j=0;
            java.sql.Statement sql = null;
            sql = con.Conectarse().createStatement();
            
            for(int i=0;i<strcons.length();i++){
               if(strcons.substring(i,i+1).equals(",")){
                   j++;
               }
            }
            
            String consulta = "select IIF((SELECT COUNT(*) FROM Articulos WHERE CodigoArticulo IN (" + strcons + "))<" + (j+1) + ",'FALTAN REGISTRAR CODIGOS','CODIGOS COMPLETOS')";
            //System.out.println(consulta);
            
            ResultSet rs = sql.executeQuery(consulta);
            while(rs.next()){
                if(rs.getString(1).contains("FALTA")){
                    completo=false;
                }
            }
            
            if (completo==true){
                return "CODIGOS COMPLETOS";
            }else{
                int comillasnuev=0,comillasant=0,contcomillas=0;
                for(int x=0;x<strcons.length();x++){
                    //System.out.println(strcons.substring(x,x+1));
                    if(strcons.substring(x,x+1).equals("'")){
                        contcomillas++;
                        comillasnuev=x;
                        if(contcomillas%2==0 && comillasnuev!=0){
                            cod=strcons.substring(comillasant+1,comillasnuev);
                            consulta = "SELECT IIF((SELECT TOP 1 CodigoArticulo FROM Articulos WHERE CodigoArticulo='" + cod + "')='" + cod + "','CORRECTO','FALTA')";
                            //System.out.print(consulta);
                            rs = sql.executeQuery(consulta);
                            while(rs.next()){
                                if(rs.getString(1).contains("FALTA")){
                                    faltantes=faltantes + cod +"\n";
                                }
                            }
                        }
                        comillasant=comillasnuev;
                    }
                }
                //consulta = "SELECT IIF((SELECT TOP 1 CodigoArticulo FROM Articulos WHERE CodigoArticulo='" + cod + "')='" + cod + "','CORRECTO','FALTA:'" + cod + "')";
                //System.out.print(consulta);
                return faltantes;
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
            return "Error";
        }
        
    }
    
    
}
