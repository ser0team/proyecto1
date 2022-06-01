/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.AjustesInventario;

import C.AjustesInventario.ajustesinventario;
import C.Funciones.CheckAccess;
import C.Funciones.Instancias;
import C.Funciones.JTextAreaMessages;
import Frames.Listados.ListaProductos;
import Frames.Menu;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.table.JTableHeader;

/**
 *
 * @author jraraujo
 */
public class AjustesInventario extends javax.swing.JFrame {

    Instancias inst = new Instancias();
    ajustesinventario aju = new ajustesinventario();
    CheckAccess chk = new CheckAccess();
    int index_almacen, index_pasillo, index_anaquel, index_bin;
    JTableHeader th;
    JTextAreaMessages jtm = new JTextAreaMessages();
    /**
     * Creates new form AjustesInventario
     */
    public AjustesInventario() {
        initComponents();
        this.setLocationRelativeTo(null);
        chk.revisarAccesosAjusteInventario(Menu.idusu);
        aju.consultaCantidades(jtproductos, "", Menu.idcompania);
        th = jtproductos.getTableHeader();
        th.setBackground(Color.decode("#66535A"));
        th.setForeground(Color.WHITE);
        jtproductos.setDefaultEditor(Object.class, null);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jbguardar = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jbcancelar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jLabel6 = new javax.swing.JLabel();
        jtxtbuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbsalir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproductos = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbproducto = new javax.swing.JButton();
        jtxtidproducto = new javax.swing.JTextField();
        jtxtproducto = new javax.swing.JTextField();
        jcalmacenes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcpasillos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcanaqueles = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jcbines = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtxtcantidad = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmacciones = new javax.swing.JMenu();
        jmi_guardar = new javax.swing.JMenuItem();
        jmi_cancelar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Himawari[Ajustes al inventario]");
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setRollover(true);

        jbguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/diskette.png"))); // NOI18N
        jbguardar.setBorder(null);
        jbguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbguardar.setEnabled(false);
        jbguardar.setFocusable(false);
        jbguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbguardar);
        jToolBar1.add(jSeparator6);

        jbcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remove.png"))); // NOI18N
        jbcancelar.setBorder(null);
        jbcancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbcancelar.setEnabled(false);
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

        jLabel6.setText("Buscar Producto:");
        jToolBar1.add(jLabel6);

        jtxtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyReleased(evt);
            }
        });
        jToolBar1.add(jtxtbuscar);
        jToolBar1.add(jSeparator1);

        jbsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        jbsalir.setBorder(null);
        jbsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbsalir.setFocusable(false);
        jbsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });
        jToolBar1.add(jbsalir);
        jToolBar1.add(jSeparator2);

        jtproductos.setAutoCreateRowSorter(true);
        jtproductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), Color.decode("#C70039"))); // NOI18N
        jtproductos.setForeground(new java.awt.Color(0, 102, 102));
        jtproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Producto", "Cantidad Actual", "Almacen", "Pasillo", "Anaquel", "Bin", "Id Empleado", "Id Empresa"
            }
        ));
        jScrollPane1.setViewportView(jtproductos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(Color.decode("#C70039"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);

        jbproducto.setText("Producto:");
        jbproducto.setEnabled(false);
        jbproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbproductoActionPerformed(evt);
            }
        });

        jcalmacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcalmacenesActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Almacenes:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pasillos:");

        jcpasillos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcpasillosActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Anaqueles:");

        jcanaqueles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcanaquelesActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Bines:");

        jPanel2.setBackground(Color.decode("#C70039"));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nueva Cantidad:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcalmacenes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcpasillos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jbproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtidproducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbines, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcanaqueles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbproducto)
                    .addComponent(jtxtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcalmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcpasillos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcanaqueles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        jTabbedPane1.addTab("Ajustes al Inventario", jPanel1);

        jmacciones.setText("Acciones");
        jmacciones.setEnabled(false);

        jmi_guardar.setText("Guardar");
        jmi_guardar.setEnabled(false);
        jmi_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_guardarActionPerformed(evt);
            }
        });
        jmacciones.add(jmi_guardar);

        jmi_cancelar.setText("Cancelar");
        jmi_cancelar.setEnabled(false);
        jmi_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_cancelarActionPerformed(evt);
            }
        });
        jmacciones.add(jmi_cancelar);

        jMenuBar1.add(jmacciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbproductoActionPerformed
        
        ListaProductos.whoisselected = "ajustesproducto";
        inst.getInstanciaListaProductos();
        aju.selecAlmacenes(jcalmacenes, 
                Integer.parseInt(jtxtidproducto.getText()),
                Menu.idcompania);
        index_almacen = jcalmacenes.getSelectedIndex();
        
    }//GEN-LAST:event_jbproductoActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed

        Instancias._ajustesinventarios = null;
        this.dispose();        
        
    }//GEN-LAST:event_jbsalirActionPerformed

    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed

        if(jtxtidproducto.getText().equals("") 
                || jtxtcantidad.getText().equals("")
                || String.valueOf(index_almacen).equals("") 
                || String.valueOf(index_almacen).equals("")
                || String.valueOf(index_anaquel).equals("")
                || String.valueOf(index_bin).equals("")){
            jtm.jTextAreaMessage("Existen campos vacios");
        }else{
            aju.obtenCantidadActual(Integer.parseInt(jtxtidproducto.getText()), Menu.idcompania);
            aju.actualizaInventario(Integer.parseInt(jtxtidproducto.getText()), 
                    Integer.parseInt(jtxtcantidad.getText()), index_almacen, 
                    index_pasillo, 
                    index_anaquel, 
                    index_bin,
                    Menu.idusu,
                    Menu.idcompania);
            jcalmacenes.setSelectedIndex(0);
            jcpasillos.setSelectedIndex(0);
            jcanaqueles.setSelectedIndex(0);
            jcbines.setSelectedIndex(0);
        }
        
    }//GEN-LAST:event_jbguardarActionPerformed

    private void jcalmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcalmacenesActionPerformed

        aju.selecPasillo(jcpasillos, index_almacen, Menu.idcompania);        
        index_pasillo = jcpasillos.getSelectedIndex();
        
    }//GEN-LAST:event_jcalmacenesActionPerformed

    private void jcpasillosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcpasillosActionPerformed

        aju.selectAnaquel(jcanaqueles, index_pasillo, Menu.idcompania);
        index_anaquel = jcanaqueles.getSelectedIndex();
        
    }//GEN-LAST:event_jcpasillosActionPerformed

    private void jcanaquelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcanaquelesActionPerformed

        aju.selectBin(jcbines, index_anaquel, Menu.idcompania);
        index_bin = jcbines.getSelectedIndex();
        
    }//GEN-LAST:event_jcanaquelesActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed

        aju.jbcancelar(jtxtidproducto, jtxtproducto, jcalmacenes, jcpasillos, 
                jcanaqueles, jcbines, jtxtcantidad);
        
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        Instancias._ajustesinventarios = null;
        
    }//GEN-LAST:event_formWindowClosing

    private void jtxtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyReleased

        aju.consultaCantidades(jtproductos, jtxtbuscar.getText(), Menu.idcompania);
        
    }//GEN-LAST:event_jtxtbuscarKeyReleased

    private void jmi_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_guardarActionPerformed

         if(jtxtidproducto.getText().equals("") 
                || jtxtcantidad.getText().equals("")
                || String.valueOf(index_almacen).equals("") 
                || String.valueOf(index_almacen).equals("")
                || String.valueOf(index_anaquel).equals("")
                || String.valueOf(index_bin).equals("")){
            jtm.jTextAreaMessage("Existen campos vacios");
        }else{
            aju.obtenCantidadActual(Integer.parseInt(jtxtidproducto.getText()), Menu.idcompania);
            aju.actualizaInventario(Integer.parseInt(jtxtidproducto.getText()), 
                    Integer.parseInt(jtxtcantidad.getText()), index_almacen, 
                    index_pasillo, 
                    index_anaquel, 
                    index_bin,
                    Menu.idusu,
                    Menu.idcompania);
            aju.jbcancelar(jtxtidproducto, jtxtproducto, jcalmacenes, jcpasillos, 
                jcanaqueles, jcbines, jtxtcantidad);
        }
        
    }//GEN-LAST:event_jmi_guardarActionPerformed

    private void jmi_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_cancelarActionPerformed

        aju.jbcancelar(jtxtidproducto, jtxtproducto, jcalmacenes, jcpasillos, 
                jcanaqueles, jcbines, jtxtcantidad);
        
    }//GEN-LAST:event_jmi_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(AjustesInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AjustesInventario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JButton jbcancelar;
    public static javax.swing.JButton jbguardar;
    public static javax.swing.JButton jbproducto;
    public static javax.swing.JButton jbsalir;
    private javax.swing.JComboBox<String> jcalmacenes;
    private javax.swing.JComboBox<String> jcanaqueles;
    private javax.swing.JComboBox<String> jcbines;
    private javax.swing.JComboBox<String> jcpasillos;
    public static javax.swing.JMenu jmacciones;
    public static javax.swing.JMenuItem jmi_cancelar;
    public static javax.swing.JMenuItem jmi_guardar;
    private javax.swing.JTable jtproductos;
    private javax.swing.JTextField jtxtbuscar;
    private javax.swing.JTextField jtxtcantidad;
    public static javax.swing.JTextField jtxtidproducto;
    public static javax.swing.JTextField jtxtproducto;
    // End of variables declaration//GEN-END:variables

     @Override
    public Image getIconImage() {
       Image retValue = Toolkit.getDefaultToolkit().
             getImage(ClassLoader.getSystemResource("Imagenes/usuario.png"));

       return retValue;
    } 
}
