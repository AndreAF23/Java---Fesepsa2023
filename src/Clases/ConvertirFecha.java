/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author aazañero
 */
public class ConvertirFecha {
    
    public String convertir(String fecha){
        String dia="",mes="",anio="";
        dia=fecha.substring(8,10);
        mes=fecha.substring(4,7);
        
        switch(mes){
            case "Jan":
                mes="01";
                break;
            case "Feb":
                mes="02";
                break;
            case "Mar":
                mes="03";
                break;
            case "Apr":
                mes="04";
                break;
            case "May":
                mes="05";
                break;
            case "Jun":
                mes="06";
                break;
            case "Jul":
                mes="07";
                break;
            case "Aug":
                mes="08";
                break;
            case "Sep":
                mes="09";
                break;
            case "Oct":
                mes="10";
                break;
            case "Nov":
                mes="11";
                break;
            case "Dec":
                mes="12";
                break;
            default:
                mes="Error";
                break;
        }
        anio=fecha.substring(24,28);
        fecha=dia + "/" + mes + "/" + anio;
        return fecha;
    }
    
}
