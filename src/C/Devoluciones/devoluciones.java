/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Devoluciones;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_devoluciones;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class devoluciones {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_devoluciones gs = new gs_devoluciones();
    
    public void jbguardar(int idventa, int idproducto, JDateChooser jdcfecha, 
            String razon, int idalmacen, int idpasillo, int idanaquel, int idbin,
            int idempleado, int idempresa){
        try{
            
            java.sql.Date fecha = new java.sql.Date(jdcfecha.getDate().getTime());
            
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdventa(idventa);
            gs.setIdproducto(idproducto);
            gs.setFecha(fecha);
            gs.setRazon(razon);
            gs.setIdalmacen(idalmacen);
            gs.setIdpasillo(idpasillo);
            gs.setIdanaquel(idanaquel);
            gs.setIdbin(idbin);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql = "insert into devoluciones(idventa, idproducto, fecha, razon, "
                    + "idalmacen, idpasillo, idanaquel, idbin, idempleado, idempresa)"
                    + "values('"+gs.getIdventa()
                    +"','"+gs.getIdproducto()
                    +"','"+gs.getFecha()
                    +"','"+gs.getRazon()
                    +"','"+gs.getIdalmacen()
                    +"','"+gs.getIdpasillo()
                    +"','"+gs.getIdanaquel()
                    +"','"+gs.getIdbin()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getIdempresa()
                    +"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaMessage("ERROR: Insert Procedure 001."+ex.getMessage());
        }
    }
    
    public void jbcancelar(JTextField jtidventa, JTextField jtidproducto, JDateChooser jdcfecha, 
            JTextArea jtrazon, JTextField jtalmacen, JTextField jtpasillo, JTextField jtanaquel,
            JTextField jtbin){
        try{
            jtidventa.setText("");
            jtidproducto.setText("");
            jdcfecha.setDate(null);
            jtrazon.setText("");
            jtalmacen.setText("");
            jtpasillo.setText("");
            jtanaquel.setText("");
            jtbin.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning Fields 002."+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int id, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "delete from devoluciones where iddevolucion='"+id
                    +"' and idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete Procedure 003"+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(int idventa, int idproducto, JDateChooser jdcfecha, 
            String razon, int idalmacen, int idpasillo, int idanaquel, int idbin, 
            int idempleado, int idempresa, int iddevolucion){
        try{
            java.sql.Date fecha = new java.sql.Date(jdcfecha.getDate().getTime());
            
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdventa(idventa);
            gs.setIdproducto(idproducto);
            gs.setFecha(fecha);
            gs.setRazon(razon);            
            gs.setIdalmacen(idalmacen);
            gs.setIdpasillo(idpasillo);
            gs.setIdanaquel(idanaquel);
            gs.setIdbin(idbin);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            gs.setIddevolucion(iddevolucion);
            String sql = "update devoluciones set idventa='"+gs.getIdventa()
                    +"', idproducto='"+gs.getIdproducto()
                    +"', fecha='"+gs.getFecha()
                    +"', razon='"+gs.getRazon()
                    +"', idalmacen='"+gs.getIdalmacen()
                    +"', idpasillo='"+gs.getIdpasillo()
                    +"', idanaquel='"+gs.getIdbin()
                    +"', idbin='"+gs.getIdbin()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where iddevolucion='"+gs.getIddevolucion()
                    +"' and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Procedure 004."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarDevoluciones(JTable jtable, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Devolución");
            dtm.addColumn("Id Venta");
            dtm.addColumn("Id Producto");
            dtm.addColumn("Fecha");
            dtm.addColumn("Razón");
            dtm.addColumn("Id Almacen");
            dtm.addColumn("Id Pasillo");
            dtm.addColumn("Id Anaquel");
            dtm.addColumn("Id Bin");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            
            String sql = "select * from devoluciones where idempresa='"+idempresa+"'";
            
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] data = new String[11];
            if(cc._resultSet().first() == false){
                jtable.setEnabled(true);
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
            jtm.jTextAreaError("ERROR: Select Procedure 005."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarVentas(JTable jtable, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Venta");
            dtm.addColumn("Forma de Pago");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Fecha de Venta");
            dtm.addColumn("Hora de Venta");
            
            String sql = "select * from ventas where idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String data[] = new String[5];
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
                    dtm.addRow(data);
                }
                jtable.setModel(dtm);
            }cc.desconectar();
            
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 006."+ex.getMessage(), ex);
        }
    }
    
    public void muestraProductos(JTable jtable, int idventa, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Id Venta");
            dtm.addColumn("Id Producto");
            dtm.addColumn("Producto");
            dtm.addColumn("Precio Unitario");
            
            String sql = "select venta_producto.idventa_producto, "
                    + "venta_producto.idventa, "
                    + "venta_producto.idproducto, "
                    + "productos.producto,"
                    + "venta_producto.precio_unitario "
                    + "from venta_producto "
                    + "inner join productos "
                    + "on venta_producto.idproducto = productos.idproductos "
                    + "where venta_producto.idventa='"+idventa
                    +"' and venta_producto.idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String data[] = new String[5];
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
                    dtm.addRow(data);
                }
                jtable.setModel(dtm);
            }cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 007."+ex.getMessage(), ex);
        }
    }
    
}
