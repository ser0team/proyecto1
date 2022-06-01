/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Reportes;

import C.Funciones.Instancias;
import C.Funciones.f_ExportarExcel;
import C.Ventas.ventas;
import ReportesJasper.reportes;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author jraraujo
 */
public class ReporteXFecha extends javax.swing.JFrame {

    ventas ven = new ventas();
    reportes rep = new reportes();
    Border border, margin;
    JFileChooser SelectArchivo;  
    File archivo;
    /**
     * Creates new form ReporteXFecha
     */
    public ReporteXFecha() {
        initComponents();
        this.setLocationRelativeTo(null);
        jdcde.setDate(null);
        jdchasta.setDate(null);
        ven.muestraVentasXFecha(jdcde, jdchasta, jtventas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdcde = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jdchasta = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtventas = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jbquery = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbcancelar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jbvista = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jbexportar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbsalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(Color.decode("#C70039")
        );

        jLabel1.setText("De:");

        jdcde.setDateFormatString("yyyy-MM-dd");

        jLabel2.setText("Hasta:");

        jdchasta.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcde, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdchasta, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdchasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jdcde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jtventas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jtventas.setForeground(new java.awt.Color(0, 153, 153));
        jtventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Venta", "Forma Pago", "Id Empleado", "Fecha venta", "Total"
            }
        ));
        jScrollPane1.setViewportView(jtventas);

        jToolBar1.setRollover(true);

        jbquery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        jbquery.setBorder(null);
        jbquery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbquery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbqueryMouseClicked(evt);
            }
        });
        jbquery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbqueryActionPerformed(evt);
            }
        });
        jToolBar1.add(jbquery);
        jToolBar1.add(jSeparator1);

        jbcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remove.png"))); // NOI18N
        jbcancelar.setFocusable(false);
        jbcancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbcancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbcancelar);
        jToolBar1.add(jSeparator5);

        jbvista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/files.png"))); // NOI18N
        jbvista.setBorder(null);
        jbvista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbvista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbvistaMouseClicked(evt);
            }
        });
        jbvista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbvistaActionPerformed(evt);
            }
        });
        jToolBar1.add(jbvista);
        jToolBar1.add(jSeparator2);

        jbexportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/excel.png"))); // NOI18N
        jbexportar.setBorder(null);
        jbexportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbexportar.setFocusable(false);
        jbexportar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbexportar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbexportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbexportarMouseClicked(evt);
            }
        });
        jbexportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbexportarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbexportar);
        jToolBar1.add(jSeparator3);

        jbsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        jbsalir.setBorder(null);
        jbsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbsalir.setFocusable(false);
        jbsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbsalirMouseClicked(evt);
            }
        });
        jToolBar1.add(jbsalir);

        jMenuBar1.setBackground(Color.decode("#A80030")
        );

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Ventas");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem1.setText("Por fecha");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Todo");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Exportar");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator4);

        jMenuItem4.setText("Salir");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Reporte");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem2.setText("Reporte");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        Instancias._reportesxfecha = null;
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jbqueryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbqueryMouseClicked

         ven.muestraVentasXFecha(jdcde, jdchasta, jtventas);
        
    }//GEN-LAST:event_jbqueryMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        ven.muestraVentasXFecha(jdcde, jdchasta, jtventas);        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jbvistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbvistaMouseClicked

         try {
            rep.EmisionReporteVentasGeneralesXFecha("/ReportesJasper/", "ReporteVentasGeneralXFecha.jasper",
                    jdcde, jdchasta);
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ReporteXFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbvistaMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

       f_ExportarExcel fexpex = new f_ExportarExcel();
       fexpex.exportarExcel(jtventas);
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jbexportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbexportarMouseClicked

       f_ExportarExcel fexpex = new f_ExportarExcel();
       fexpex.exportarExcel(jtventas);
        
    }//GEN-LAST:event_jbexportarMouseClicked

    private void jbsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbsalirMouseClicked

        Instancias._reportesxfecha = null;
        this.dispose();
        
    }//GEN-LAST:event_jbsalirMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

         try {
            rep.EmisionReporteVentasGeneralesXFecha("/ReportesJasper/", "ReporteVentasGeneralXFecha.jasper",
                    jdcde, jdchasta);
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ReporteXFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        ven.muestraVentasXFecha(null, null, jtventas);   
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jbqueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbqueryActionPerformed

         ven.muestraVentasXFecha(jdcde, jdchasta, jtventas);       
        
    }//GEN-LAST:event_jbqueryActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed

         ven.muestraVentasXFecha(null, null, jtventas);
        
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void jbvistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbvistaActionPerformed

        
         try {
            rep.EmisionReporteVentasGeneralesXFecha("/ReportesJasper/", "ReporteVentasGeneralXFecha.jasper",
                    jdcde, jdchasta);
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ReporteXFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbvistaActionPerformed

    private void jbexportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbexportarActionPerformed

        f_ExportarExcel fexpex = new f_ExportarExcel();
       fexpex.exportarExcel(jtventas);
        
    }//GEN-LAST:event_jbexportarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReporteXFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteXFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteXFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteXFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ReporteXFecha().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JMenu jMenu1;
    public static javax.swing.JMenu jMenu2;
    public static javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JMenuItem jMenuItem3;
    public static javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JMenuItem jMenuItem5;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JToolBar.Separator jSeparator1;
    public static javax.swing.JToolBar.Separator jSeparator2;
    public static javax.swing.JToolBar.Separator jSeparator3;
    public static javax.swing.JPopupMenu.Separator jSeparator4;
    public static javax.swing.JToolBar.Separator jSeparator5;
    public static javax.swing.JToolBar jToolBar1;
    public static javax.swing.JButton jbcancelar;
    public static javax.swing.JButton jbexportar;
    public static javax.swing.JButton jbquery;
    public static javax.swing.JButton jbsalir;
    public static javax.swing.JButton jbvista;
    public static com.toedter.calendar.JDateChooser jdcde;
    public static com.toedter.calendar.JDateChooser jdchasta;
    public static javax.swing.JTable jtventas;
    // End of variables declaration//GEN-END:variables

    
     @Override
    public Image getIconImage() {
       Image retValue = Toolkit.getDefaultToolkit().
             getImage(ClassLoader.getSystemResource("Imagenes/usuario.png"));

       return retValue;
    }
}
