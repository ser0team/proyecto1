/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Funciones;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author jraraujo
 */
public class f_exportarWord {
      
    File file = new File("C:\\DescargasTittan\\Pdf's\\HEMARI_Informacion.doc");
    FileOutputStream os;

    private void writeDoc(String FileName, String content) {
        try {
                POIFSFileSystem fs = new POIFSFileSystem();
                DirectoryEntry directory = fs.getRoot();
                directory.createDocument("WordDocument", new ByteArrayInputStream(
                                content.getBytes()));
                 os = new FileOutputStream(FileName);
                fs.writeFilesystem(os);
                os.close();
        } catch (IOException ex) {
                System.out.println(ex.getMessage());
        }
    }

    public void TextAreaInDocument(JTextArea jtextarea) {
        try {
            String text = jtextarea.getText();
            String f = file.getPath();
            writeDoc(f, text);
            Runtime rt = Runtime.getRuntime();         
            rt.exec("cmd.exe /C start "+f);
            //rt.exec("cmd.exe /C start "+ruta+"/"+"HEMARI_Informacion.doc");
        } catch (IOException ex) {
            Logger.getLogger(f_exportarWord.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }    
}
