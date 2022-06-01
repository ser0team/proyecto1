/*rara
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Listados;

import C.Funciones.Instancias;
import C.Ventas.listaproductos;
import C.Ventas.ventas;
import Frames.AjustesInventario.AjustesInventario;
import Frames.Compras.Compras;
import Frames.Compras.EdicionPrecios;
import Frames.Ventas.Ventas;
import Frames.Ventas.VentasMiscelaneas;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author jraraujo
 */
public class ListaProductos extends javax.swing.JFrame {

    listaproductos lp = new listaproductos();   
    ventas ven = new ventas();
    public static String whoisselected; 
    JTableHeader th;
    /**
     * Creates new form ListaProductos
     * @throws java.lang.ClassNotFoundException
     */
    public ListaProductos() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        jtproductos.setDefaultEditor(Object.class, null);
        th = jtproductos.getTableHeader();
        th.setBackground(Color.decode("#66535A"));
        th.setForeground(Color.WHITE);
        lp.muestraProductos(jtbuscar.getText(), jtproductos);
        
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
        jLabel1 = new javax.swing.JLabel();
        jtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Himawari[Consulta de Productos]");
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setRollover(true);

        jLabel1.setText("Buscar:");
        jToolBar1.add(jLabel1);

        jtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtbuscarKeyTyped(evt);
            }
        });
        jToolBar1.add(jtbuscar);

        jtproductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), Color.decode("#C70039"))); // NOI18N
        jtproductos.setForeground(new java.awt.Color(0, 102, 102));
        jtproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Producto", "Descripción", "Precio"
            }
        ));
        jtproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtproductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtproductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbuscarKeyTyped

        try {
            lp.muestraProductos(jtbuscar.getText(), jtproductos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jtbuscarKeyTyped

    private void jtproductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtproductosMouseClicked

        switch (whoisselected) {
            case "ventasaniadir":
                {
                    int id = Integer.parseInt(ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 0).toString());
                    String producto = ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 1).toString();
                    String descripcion = ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 2).toString();
                    double precio = Double.parseDouble(ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 3).toString());
                    System.out.println(producto);
                    DefaultTableModel dtm = (DefaultTableModel) Ventas.jtableventas.getModel();
                    String[] datos = {String.valueOf(id), producto, descripcion, String.valueOf(precio)};
                    dtm.addRow(datos);
                    double t = 0;
                    double p = 0;
                    if(Ventas.jtableventas.getRowCount() > 0){
                        for(int i = 0; i < Ventas.jtableventas.getRowCount(); i++){
                            p = Double.parseDouble(Ventas.jtableventas.getValueAt(i, 3).toString());
                            t += p;
                        }
                        Ventas.jtxttotal.setText(String.valueOf(t));
                    }       
                    ven.obtenCantidadActual(id);
                    ven.restaProducto(id);                    
                }
                break;
            case "ventasmiscelaneas":
                {
                    VentasMiscelaneas.id = Integer.parseInt(ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 0).toString());
                    String producto = ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 1).toString();
                    VentasMiscelaneas.jtxtproducto.setText(producto);
                    Instancias._listaproductos = null;
                    this.dispose();
                    break;
                }
            case "comprasproductos":
                {
                    Compras.idproducto = Integer.parseInt(ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 0).toString());
                    String producto = ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 1).toString();
                    Compras.jtxtproducto.setText(producto);
                    break;
                }
            case "edicionproducto":
                {
                    int idproducto = Integer.parseInt(ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 0).toString());
                    String producto = ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 1).toString();
                    EdicionPrecios.jtxtidproducto.setText(String.valueOf(idproducto));
                    EdicionPrecios.jtxtproducto.setText(producto);
                    break;
                }
            case "ajustesproducto":
                {
                    int idproducto = Integer.parseInt(ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 0).toString());
                    String producto = ListaProductos.jtproductos.getValueAt(ListaProductos.jtproductos.getSelectedRow(), 1).toString();
                    AjustesInventario.jtxtidproducto.setText(String.valueOf(idproducto));
                    AjustesInventario.jtxtproducto.setText(producto);                    
                    break;
                }
            default:
                break;
        }
        
    }//GEN-LAST:event_jtproductosMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        Instancias._listaproductos = null;
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ListaProductos().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListaProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jtbuscar;
    public static javax.swing.JTable jtproductos;
    // End of variables declaration//GEN-END:variables

    @Override
    public Image getIconImage() {
       Image retValue = Toolkit.getDefaultToolkit().
             getImage(ClassLoader.getSystemResource("Imagenes/usuario.png"));

       return retValue;
    }
    
}
