/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Funciones;

import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.net.URI;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jraraujo
 */
public class BuscarImagen {    
    
    JPanel contentPane;
    File fichero, file;
    JTextAreaMessages jtm = new JTextAreaMessages();
    
    public void buscarImagen(JTextField jtxtnombreimagen, JTextArea jtxtdireccionimagen,
            JLabel jlimagen){
        try{
        JFileChooser chooser = new JFileChooser(){
                @Override
            protected JDialog createDialog( Component tt_menu) throws HeadlessException{
                JDialog dialog = super.createDialog(tt_menu);                
                Image iicon = new ImageIcon(getClass().getResource("/Imagenes/s_Fenix.png")).getImage();
                dialog.setIconImage(iicon);
                dialog.setTitle("Buscar Imagen");                                
                dialog.setName("dialog"); 
                dialog.setLayout(null);
                dialog.getContentPane().setBackground(Color.WHITE);                                
                return dialog;
            }            
        };  
                     
            FileNameExtensionFilter filtro=new FileNameExtensionFilter("*.png","png");
            chooser.setFileFilter(filtro);            
            
            int seleccion=chooser.showOpenDialog(contentPane);
            
            if(seleccion==JFileChooser.APPROVE_OPTION)
            {
                fichero=chooser.getSelectedFile();
                jtxtdireccionimagen.setText(fichero.getAbsolutePath());
                String _dir = jtxtdireccionimagen.getText();
                System.out.println(_dir);
                file = new File(jtxtdireccionimagen.getText());
                
                URI uri = null;
                uri=file.toURI();
                System.out.println(uri);
                                             
                String _direccion=uri.getPath();
                
                String _nom = null;
                _nom=_direccion.substring(_direccion.lastIndexOf('/')+1);
                System.out.println("Nombre del archivo: "+_nom);
                jtxtnombreimagen.setText(_nom);
                
                ImageIcon imagen = new ImageIcon(jtxtdireccionimagen.getText());
                Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(jlimagen.getWidth(), 
                        jlimagen.getHeight(), Image.SCALE_DEFAULT));
                jlimagen.setIcon(icono);
                jlimagen.repaint();
            }
        }catch(HeadlessException ex)
        {            
            jtm.jTextAreaError("ERROR: "+ex.getMessage(), ex);
        }
    }
    
}
