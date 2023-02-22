/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aazañero
 */
public class GenerarLog {
    public void Log(String carpeta,String archivo,String contenido){
        try{
            Instant instant = Instant.now();
            String fechaactual=instant.toString().substring(0,10);
            String user = System.getProperty("user.name");
            File directorios = new File("C:/Users/" + user + ".FESEPSA/Desktop/" + carpeta  + fechaactual);
             if (!directorios.exists()) {
                 if (directorios.mkdirs()) {
                     //System.out.println("Multiples directorios fueron creados");
                 } else {
                     //System.out.println("Error al crear directorios");
                 }
             }
            FileWriter fichero = new FileWriter("C:/Users/" + user + ".FESEPSA/Desktop/" + carpeta + fechaactual + "/Log-" + archivo + fechaactual + ".txt");
            fichero.write(contenido);
            fichero.close();
        }catch (IOException ex){
            Logger.getLogger(GenerarLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
