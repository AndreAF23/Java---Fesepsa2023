/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author aazañero
 */
public class VerificarVacios {
    public boolean verificar(JTable jTable1){
        boolean pasar=true;
        
        for(int i=0;i<jTable1.getRowCount();i++){
            for(int j=0;j<jTable1.getColumnCount();j++){
                if(jTable1.getValueAt(i,j)==null || ((String)jTable1.getValueAt(i,j)).equals("")){
                    pasar=false;
                    break;
                }
            }
            if(pasar==false){
                break;
            }
        }
        return pasar;
    }
}
