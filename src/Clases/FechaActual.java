/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author aazañero
 */
public class FechaActual {
    public String retornar(){
        String fechaactual = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        return fechaactual;
    }
}
