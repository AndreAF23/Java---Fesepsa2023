/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 *
 * @author aazañero
 */
public class ExportarExcel3 {
    public void exportarExcel(JTable t1,JTable t2,JTable t3) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            File archivoXLS = new File(ruta);
            if (archivoXLS.exists()) {
                archivoXLS.delete();
            }
            archivoXLS.createNewFile();
            Workbook libro = new HSSFWorkbook();
            FileOutputStream archivo = new FileOutputStream(archivoXLS);
            try {
                
                Sheet hoja = libro.createSheet("Movimientos del mes");
                hoja.setDisplayGridlines(true);
                for (int f = 0; f < t1.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t1.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t1.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t1.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t1.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t1.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t1.getValueAt(f, c).toString()));
                        } else if (t1.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t1.getValueAt(f, c)));
                        } else {
                            if(String.valueOf(t1.getValueAt(f, c)).equals("")){
                                celda.setCellValue("\t");
                            }else{
                            celda.setCellValue(String.valueOf(t1.getValueAt(f, c)));
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                throw e;
            }
            
            //
            try {
                
                Sheet hoja = libro.createSheet("Sin Movimientos");
                hoja.setDisplayGridlines(true);
                for (int f = 0; f < t2.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t2.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t2.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t2.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t2.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t2.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t2.getValueAt(f, c).toString()));
                        } else if (t2.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t2.getValueAt(f, c)));
                        } else {
                            if(String.valueOf(t2.getValueAt(f, c)).equals("")){
                                celda.setCellValue("\t");
                            }else{
                            celda.setCellValue(String.valueOf(t2.getValueAt(f, c)));
                            }
                        }
                    }
                }
                
            } catch (NumberFormatException e) {
                throw e;
            }
            
            try {
                
                Sheet hoja = libro.createSheet("Saldos Iniciales");
                hoja.setDisplayGridlines(true);
                for (int f = 0; f < t3.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t3.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t3.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t3.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t3.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t3.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t3.getValueAt(f, c).toString()));
                        } else if (t3.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t3.getValueAt(f, c)));
                        } else {
                            if(String.valueOf(t3.getValueAt(f, c)).equals("")){
                                celda.setCellValue("\t");
                            }else{
                            celda.setCellValue(String.valueOf(t3.getValueAt(f, c)));
                            }
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (NumberFormatException e) {
                throw e;
            }
            
        }
    }
}
