/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Funciones;

import java.awt.HeadlessException;
import java.io.File;

/**
 *
 * @author jraraujo
 */
public class f_nuevofolder {
    
     File folder=null;
    String directorio_;
    JTextAreaMessages jtm = new JTextAreaMessages();
    public static String straceptar, strnuevofolder, strmensajetittan, strerror;
    public static String stridioma;
    //f_crearTextoIdioma fcti = new f_crearTextoIdioma();
    
    public f_nuevofolder(){
        //fcti.comprobarf_nuevofolder();
    }
    
    public String crearFolder()
    {
        try
        {
            directorio_="C:\\ProgramData\\Fenix\\Archivos\\";
            folder=new File(directorio_);
            
            if(folder.mkdirs()==false)
            {
                folder.mkdirs();                
            }                  
        }
        catch(HeadlessException ex)
        {
            jtm.jTextAreaError("ERROR:"+"MKDIR001"+ex.getMessage(), ex);
        }
        return directorio_;
    }    
}
