/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Funciones;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
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
 * @author jraraujo
 */
public class f_ExportarExcel {
    
    public void exportarExcel(JTable jtable){
        try{
            JFileChooser chooser = new JFileChooser(){
            @Override
            protected JDialog createDialog( Component tt_menu) throws HeadlessException{
                    JDialog dialog = super.createDialog(null);                
                    Image iicon = new ImageIcon(getClass().getResource("/Imagenes/usuario.png")).getImage();
                    dialog.setIconImage(iicon);                    
                    dialog.setName("dialog"); 
                    dialog.setLayout(null);                    
                    return dialog;
                }            
            };  
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filtro);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                String ruta = chooser.getSelectedFile().toString().concat(".xls");
                try{
                    File archivoXLS = new File(ruta);
                    if(archivoXLS.exists()){
                        archivoXLS.delete();
                    }
                    archivoXLS.createNewFile(); 
                    Workbook libro = new HSSFWorkbook();
                    FileOutputStream archivo = new FileOutputStream(archivoXLS);
                    Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                    hoja.setDisplayGridlines(false);
                    for (int f = 0; f < jtable.getRowCount(); f++) {
                        Row fila = hoja.createRow(f);
                        for (int c = 0; c < jtable.getColumnCount(); c++) {
                            Cell celda = fila.createCell(c);
                            if (f == 0) {
                                celda.setCellValue(jtable.getColumnName(c));
                            }
                        }
                    }
                    int filaInicio = 1;
                    for (int f = 0; f < jtable.getRowCount(); f++) {
                        Row fila = hoja.createRow(filaInicio);
                        filaInicio++;
                        for (int c = 0; c < jtable.getColumnCount(); c++) {
                            Cell celda = fila.createCell(c);
                            if (jtable.getValueAt(f, c) instanceof Double) {
                                celda.setCellValue(Double.parseDouble(jtable.getValueAt(f, c).toString()));
                            } else if (jtable.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) jtable.getValueAt(f, c)));
                            } else {
                                celda.setCellValue(String.valueOf(jtable.getValueAt(f, c)));
                            }
                        }
                    }
                    libro.write(archivo);
                    archivo.close();
                    Desktop.getDesktop().open(archivoXLS);
                } catch (IOException | NumberFormatException e) {
                    throw e;
                }
            }
        }catch(HeadlessException | IOException | NumberFormatException ex){

        }    
    }
}
