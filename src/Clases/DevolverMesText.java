/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author aazañero
 */
public class DevolverMesText {
    public String devolver(int mes){
        switch(mes){
            case 1: return("Enero");
            case 2: return("Febrero");
            case 3: return("Marzo");
            case 4: return("Abril");
            case 5: return("Mayo");
            case 6: return("Junio");
            case 7: return("Julio");
            case 8: return("Agosto");
            case 9: return("Septiembre");
            case 10: return("Octubre");
            case 11: return("Noviembre");
            case 12: return("Diciembre");
        }
        return "Error";
    }
}
