/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Listados;

import C.EntradasProducto.entradasproducto;
import C.Funciones.Instancias;
import Frames.EntradasProducto.EntradasDesdeDevoluciones;
import Frames.Menu;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.table.JTableHeader;

/**
 *
 * @author jraraujo
 */
public class ListarEntradas extends javax.swing.JFrame {
    
    entradasproducto entpro = new entradasproducto();
    JTableHeader th;

    /**
     * Creates new form ListarEntradas
     */
    public ListarEntradas() {
        initComponents();
        this.setLocationRelativeTo(null);
        entpro.mostrarEntradas(jtlistarentradas, Menu.idcompania);
        jtlistarentradas.setDefaultEditor(Object.class, null);
        th = jtlistarentradas.getTableHeader();
        th.setBackground(Color.decode("#66535A"));
        th.setForeground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrolPane1 = new javax.swing.JScrollPane();
        jtlistarentradas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Himawari[Lista de Entradas]");
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jtlistarentradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Entrada", "Id Compra", "Id Almacen", "Id Pasillo", "Id Anaquel", "Id Bin", "Id Producto", "Cantidad", "Comentarios", "Id Empleado", "Id Empresa"
            }
        ));
        jtlistarentradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtlistarentradasMouseClicked(evt);
            }
        });
        ScrolPane1.setViewportView(jtlistarentradas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrolPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrolPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        Instancias._listarentradas = null;
        
    }//GEN-LAST:event_formWindowClosing

    private void jtlistarentradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtlistarentradasMouseClicked

        EntradasDesdeDevoluciones.jtxtidentrada.setText(jtlistarentradas.getValueAt(jtlistarentradas.getSelectedRow(), 0).toString());
        EntradasDesdeDevoluciones.jtxtidcompra.setText(jtlistarentradas.getValueAt(jtlistarentradas.getSelectedRow(), 1).toString());
        EntradasDesdeDevoluciones.jtxtidalmacen.setText(jtlistarentradas.getValueAt(jtlistarentradas.getSelectedRow(), 2).toString());
        EntradasDesdeDevoluciones.jtxtidpasillo.setText(jtlistarentradas.getValueAt(jtlistarentradas.getSelectedRow(), 3).toString());
        EntradasDesdeDevoluciones.jtxtidanaquel.setText(jtlistarentradas.getValueAt(jtlistarentradas.getSelectedRow(), 4).toString());
        EntradasDesdeDevoluciones.jtxtidbin.setText(jtlistarentradas.getValueAt(jtlistarentradas.getSelectedRow(), 5).toString());
        EntradasDesdeDevoluciones.jtxtidproducto.setText(jtlistarentradas.getValueAt(jtlistarentradas.getSelectedRow(), 6).toString());
        Instancias._listarentradas = null;
        this.dispose();
        
        
    }//GEN-LAST:event_jtlistarentradasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListarEntradas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrolPane1;
    private javax.swing.JTable jtlistarentradas;
    // End of variables declaration//GEN-END:variables

    @Override
    public Image getIconImage() {
       Image retValue = Toolkit.getDefaultToolkit().
             getImage(ClassLoader.getSystemResource("Imagenes/usuario.png"));

       return retValue;
    }   
}
