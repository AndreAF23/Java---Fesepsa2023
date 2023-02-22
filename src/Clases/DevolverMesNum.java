/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author aazañero
 */
public class DevolverMesNum {
    public String dev(String mes){
        switch(mes){
            case "Enero": return "01";
            case "Febrero": return "02";
            case "Marzo": return "03";
            case "Abril": return "04";
            case "Mayo": return "05";
            case "Junio": return "06";
            case "Julio": return "07";
            case "Agosto": return "08";
            case "Septiembre": return "09";
            case "Octubre": return "10";
            case "Noviembre": return "11";
            case "Diciembre": return "12";
        }
        return "";
    }
}
