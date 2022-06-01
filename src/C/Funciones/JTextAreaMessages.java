/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Funciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author jraraujo
 */
public class JTextAreaMessages {
    String mensaje, path;
    URL url;
    ImageIcon icon;    
    f_exportarWord few = new f_exportarWord();
    
    public JTextAreaMessages(){
        
    }
    
    public void jTextAreaSQLError(String mensaje, int coderror, SQLException _ex){        
        try
        {
            Object[] opciones={"Aceptar","Imprimir"};
            JTextArea jta = new JTextArea(10, 30);
            jta.setText(mensaje+". "+". "+coderror+". "+_ex);
            jta.setLineWrap(true);
            jta.setWrapStyleWord(true);
            jta.setEditable(false);            
            int n = JOptionPane.showOptionDialog(null, new JScrollPane(jta), 
                    "FENIX POS[ERROR MESSAGE]", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, null, opciones, opciones[0]);
                    if(n==JOptionPane.NO_OPTION){                        
                        few.TextAreaInDocument(jta);
                    }            
        }catch(HeadlessException ex){
            System.err.println(ex.getMessage());
        }       
    }
    
    public void jTextAreaError(String mensaje, Exception _ex){
        try{
            Object[] opciones={"Aceptar", "Imprimir"};
            JTextArea jta = new JTextArea(10, 30);
            jta.setText(mensaje+". "+_ex);
            jta.setLineWrap(true);
            jta.setWrapStyleWord(true);
            jta.setEditable(false);
            int n = JOptionPane.showOptionDialog(null, new JScrollPane(jta), 
                    "FENIX POS[MESSAGE]", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, null, opciones, opciones);
            if(n==JOptionPane.NO_OPTION){                        
                few.TextAreaInDocument(jta);
            }            
        }catch(HeadlessException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void jTextAreaTablas(String mensaje, Exception _ex){
        try{
            Object[] opciones={"Aceptar", "Imprimir"};
            JTextArea jta = new JTextArea(10, 30);
            jta.setText("ERROR:"+mensaje+". "+_ex);
            jta.setLineWrap(true);
            jta.setWrapStyleWord(true);
            jta.setEditable(false);
            int n = JOptionPane.showOptionDialog(null, new JScrollPane(jta), 
                    "FENIX POS[ERROR MESSAGE]", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, null, opciones, opciones);
            if(n==JOptionPane.NO_OPTION){                        
                few.TextAreaInDocument(jta);
            }            
        }catch(HeadlessException ex){
            System.err.println(ex.getMessage());
        }
    }    
    
    public void jTextAreaMessage(String _ex){
        try{
            Object[] opciones = {"Aceptar","Imprimir"};
            JTextArea jta = new JTextArea(10, 30);
            jta.setText(_ex);
            jta.setLineWrap(true);
            jta.setWrapStyleWord(true);
            jta.setEditable(false);
            int n = JOptionPane.showOptionDialog(null, new JScrollPane(jta), 
                    "FENIX POS[MESSAGE]", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones);
            if(n==JOptionPane.NO_OPTION){                        
                few.TextAreaInDocument(jta);
            }            
        }catch(HeadlessException ex){
            System.err.println(ex);
        }
    }   
    
    public void jTextAreaMessageCambio(String arg1, String arg2, String arg3, String arg4){
        try{         
            Icon monedas = new ImageIcon(getClass().getResource("/Imagenes/monedas.gif"));
            Object[] opciones = {"Aceptar"};
            JEditorPane jta = new JEditorPane();            
            jta.setPreferredSize(new Dimension(400, 30));            
            jta.setEditable(false);
            jta.setContentType("text/html");
            jta.setText("<font color=\"green\">"+"<font face=\"arial\">"+"<font size=\"24\">"+arg1+"</font><br>"
                    +"<font color=\"red\">"+"<font face=\"arial\">"+"<font size=\"24\">"+arg2+"</font><br>"
                    +"<font color=\"purple\">"+"<font face=\"arial\">"+"<font size=\"24\">"+arg3+"</font><br><br>"
                    +"<font color=\"blue\">"+"<font face=\"arial\">"+"<font size=\"24\">"+arg4+"</font><br>");                                            
            int n = JOptionPane.showOptionDialog(null, new JScrollPane(jta), 
                    "FENIX POS[MESSAGE]", JOptionPane.YES_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, monedas, opciones, opciones);                      
        }catch(HeadlessException ex){
            System.err.println(ex);
        }
    } 
    
     private void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }
}
