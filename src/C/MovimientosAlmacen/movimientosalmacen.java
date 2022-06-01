/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.MovimientosAlmacen;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_movimientosalmacen;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class movimientosalmacen {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_movimientosalmacen gs = new gs_movimientosalmacen();
    
    public void jbguardar(int idalmacen, int idpasillo, int idanaquel, int idbin,
            int idproducto, int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdalmacen(idalmacen);
            gs.setIdpasillo(idpasillo);
            gs.setIdanaquel(idanaquel);
            gs.setIdbin(idbin);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            gs.setIdproducto(idproducto);
            String sql = "update productos set idalmacen='"+gs.getIdalmacen()
                    + "', idpasillo='"+gs.getIdpasillo()
                    + "', idanaquel='"+gs.getIdanaquel()
                    + "', idbin='"+gs.getIdbin()
                    + "' where idproducto='"+gs.getIdproducto()+"' "
                    + "and iempresa='"+gs.getIdempresa()+"'";
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Wharehouse Procedure 001."+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtidproducto, JTextField jtproducto, JTextField jtalmacen,
            JTextField jtpasillo, JTextField jtanaquel, JTextField jtbin){
        try{
            jtidproducto.setText("");
            jtproducto.setText("");
            jtalmacen.setText("");
            jtpasillo.setText("");
            jtanaquel.setText("");
            jtbin.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning Method 002."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarUbicacionProductos(JTable jtable, String buscar, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Entrada");
            dtm.addColumn("Id Compra");
            dtm.addColumn("Id Almacen");
            dtm.addColumn("Id Pasillo");
            dtm.addColumn("Id Anaquel");
            dtm.addColumn("Id Bin");
            dtm.addColumn("Id Producto");
            dtm.addColumn("Id Producto");
            dtm.addColumn("Cantidad");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            
            String sql = "";
            
            if(buscar.equals("")){
                sql = "select entradasproducto.identradaproducto, "
                        + "entradasproducto.idcompra, "
                        + "entradasproducto.idalmacen, "
                        + "entradasproducto.idpasillo, "
                        + "entradasproducto.idanaquel, "
                        + "entradasproducto.idbin, "
                        + "entradasproducto.idproducto, "
                        + "productos.producto, "
                        + "entradasproducto.cant, "
                        + "entradasproducto.idempleado, "
                        + "entradasproducto.idempresa "
                        + "from entradasproducto "
                        + "inner join productos "
                        + "on productos.idproductos = entradasproducto.idproducto "
                        + "where entradasproducto.idempresa='"+idempresa+"'";
            }else{
                sql = "select entradasproducto.identradaproducto, "
                        + "entradasproducto.idcompra, "
                        + "entradasproducto.idalmacen, "
                        + "entradasproducto.idpasillo, "
                        + "entradasproducto.idanaquel, "
                        + "entradasproducto.idbin, "
                        + "entradasproducto.idproducto, "
                        + "productos.producto, "
                        + "entradasproducto.cant, "
                        + "entradasproducto.idempleado, "
                        + "entradasproducto.idempresa "
                        + "from entradasproducto "
                        + "inner join productos "
                        + "on productos.idproductos = entradasproducto.idproducto "
                        +"where producto like CONCAT('"+buscar+"','%_') "
                        + "and entradasproducto.idempresa='"+idempresa+"'";
            }
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] data = new String[11];
            if(cc._resultSet().first() == false){
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    data[0] = cc._resultSet().getString(1);
                    data[1] = cc._resultSet().getString(2);
                    data[2] = cc._resultSet().getString(3);
                    data[3] = cc._resultSet().getString(4);
                    data[4] = cc._resultSet().getString(5);
                    data[5] = cc._resultSet().getString(6);
                    data[6] = cc._resultSet().getString(7);
                    data[7] = cc._resultSet().getString(8);
                    data[8] = cc._resultSet().getString(9);
                    data[9] = cc._resultSet().getString(10);
                    data[10] = cc._resultSet().getString(11);
                    dtm.addRow(data);
                }
                jtable.setModel(dtm);
            }cc.desconectar();
            
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 003."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarAlmacenes(JList jlist, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select * from almacenes where idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){
                dlm.addElement("No exiten almacenes");
            }else{
                dlm.addElement(cc._resultSet().getString(1)+": "
                        +cc._resultSet().getString(2)+": "
                        +cc._resultSet().getString(3));
            }
            jlist.setModel(dlm);
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure Wharehouse List Model 001."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarPasillos(JList jlist, int idalmacen){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select idpasillo, pasillo, descripcion from pasillos where idalmacen='"+idalmacen+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                dlm.addElement(cc._resultSet().getString(1)+": "
                        +cc._resultSet().getString(2)+": "
                        +cc._resultSet().getString(3));              
            }
            jlist.setModel(dlm);
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure Holloway List Model 002."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarAnaqueles(JList jlist, int idpasillo){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select idanaquel, anaquel, descripcion from anaqueles where idpasillo='"+idpasillo+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                dlm.addElement(cc._resultSet().getString(1)+": "
                        +cc._resultSet().getString(2)+": "
                        +cc._resultSet().getString(3));
            }
            jlist.setModel(dlm);
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure Shel List Model 003."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarbin(JList jlist, int idanaquel){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select idbin, bin, descripcion from bin where idanaquel='"+idanaquel+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                dlm.addElement(cc._resultSet().getString(1)+": "
                        +cc._resultSet().getString(2)+": "
                        +cc._resultSet().getString(3));
            }
            jlist.setModel(dlm);
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure Shel List Model 003."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarProductos(JList jlist, int idbin){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultListModel dlm = new DefaultListModel();
            String sql = "select idproductos, producto, descripcion from productos where idbin='"+idbin+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                dlm.addElement(cc._resultSet().getString(1)+": "
                        +cc._resultSet().getString(2)+": "
                        +cc._resultSet().getString(3));
            }
            jlist.setModel(dlm);
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure Shell List Model 003."+ex.getMessage(), ex);
        }
    }
    
    public void contarProductos(int idbin, JTextField jtproductos){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "titan");
            String sql = "select count productos from productos where idbin='"+idbin+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                jtproductos.setText(cc._resultSet().getString(1));
            }
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Count Procedure 004."+ex.getMessage(), ex);
        }
    }
    
    public void sumaInversion(int idbin, JTextField jtinversion){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select sum(precio) from compras_producto where idproducto in"
                    + "(select idproducto from productos where idbin='"+idbin+"')'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                jtinversion.setText(cc._resultSet().getString(1));
            }
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Sum Procedure 005."+ex.getMessage(), ex);
        }
    }
    
    public void muestraProductos(JTable jtable, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Producto");
            dtm.addColumn("Producto");
            dtm.addColumn("Descripción");
            dtm.addColumn("Unidad");
            dtm.addColumn("Id Proveedor");
            dtm.addColumn("Proveedor");
            dtm.addColumn("Marca");
            dtm.addColumn("Precio");
            dtm.addColumn("Fecha");
            dtm.addColumn("Id Categoria");
            dtm.addColumn("Cant. Max");
            dtm.addColumn("Cant. Min");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            
            String sql = "Select * from productos where idempresa='"+idempresa+"'";            
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String data[] = new String[14];
            if(cc._resultSet().first() == false){
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    data[0] = cc._resultSet().getString(1);
                    data[1] = cc._resultSet().getString(2);
                    data[2] = cc._resultSet().getString(3);
                    data[3] = cc._resultSet().getString(4);
                    data[4] = cc._resultSet().getString(5);
                    data[5] = cc._resultSet().getString(6);
                    data[6] = cc._resultSet().getString(7);
                    data[7] = cc._resultSet().getString(8);
                    data[8] = cc._resultSet().getString(9);
                    data[9] = cc._resultSet().getString(10);
                    data[10] = cc._resultSet().getString(11);
                    data[11] = cc._resultSet().getString(12);
                    data[12] = cc._resultSet().getString(13);
                    data[13] = cc._resultSet().getString(14);
                    dtm.addRow(data);
                }jtable.setModel(dtm);
            }cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 005."+ex.getMessage(), ex);
        }
    }
    
}
