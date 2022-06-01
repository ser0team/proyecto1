/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Compras;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_compras;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class ajusteprecios {
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_compras gs = new gs_compras();
    int compraseleccionada;
    
    public void muestraProductos(JTable jtable, String buscar, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("IdCompras_Producto");
            dtm.addColumn("IdCompra");
            dtm.addColumn("IdProducto");
            dtm.addColumn("Producto");
            dtm.addColumn("Cantidad Ajuste");
            dtm.addColumn("Unidad");
            dtm.addColumn("Precio");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            jtable.setModel(dtm);
            
            String sql = "";
            if(buscar.equals("")){
                sql = "select * from compras_producto where idempresa='"+idempresa+"'";
            }else{
                sql = "select * from compras_producto where producto like CONCAT('"+buscar+"','%_') "
                        + "and idempresa='"+idempresa+"'";
            }
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] datos = new String[9];
            if(cc._resultSet().first() == false){
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0] = cc._resultSet().getString(1);
                    datos[1] = cc._resultSet().getString(2);
                    datos[2] = cc._resultSet().getString(3);
                    datos[3] = cc._resultSet().getString(4);
                    datos[4] = cc._resultSet().getString(5);
                    datos[5] = cc._resultSet().getString(6);
                    datos[6] = cc._resultSet().getString(7);      
                    datos[7] = cc._resultSet().getString(8);
                    datos[8] = cc._resultSet().getString(9);      
                    dtm.addRow(datos);
                }
            }cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 001. "+ex.getMessage(), ex);
        }
    }
    
    public void jbguardar(int idproducto, String producto, int cantidad,
            String unidad, double precio, int idcompra_producto, int idempleado, 
            int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            compraseleccionada = idcompra_producto;
            gs.setIdproducto(idproducto);
            gs.setProducto(producto);
            gs.setCantidad(cantidad);
            gs.setUnidad(unidad);
            gs.setPrecio(precio);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            gs.setIdcompra(idcompra_producto);            
            String sql = "update compras_producto set idproducto='"+gs.getIdproducto()
                    +"', producto='"+gs.getProducto()
                    +"', cantidad='"+gs.getCantidad()
                    +"', unidad='"+gs.getUnidad()
                    +"', precio='"+gs.getPrecio()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where idcompras_producto='"+gs.getIdcompra()
                    +"' and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update procedure 001. "+ex.getMessage(), ex);
        }
    }
    
    public void ajusteCompras(String razon_ajuste, double cantidad_ajuste,
            String tipo_ajuste, JDateChooser jdcfecha, int idempleado, 
            int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            
            java.sql.Date fechaajuste = new java.sql.Date(jdcfecha.getDate().getTime());
            
            gs.setRazon_ajuste(razon_ajuste);
            gs.setCantidad_ajuste(cantidad_ajuste);
            gs.setTipo_ajuste(tipo_ajuste);
            gs.setFecha_ajuste(fechaajuste);
            gs.setIdcompra(compraseleccionada);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql = "insert into ajustes_compras(razon_ajuste, cantidad_ajuste, "
                    + "tipo_ajuste, fecha_ajuste, idcompras_producto, idempleado, "
                    + "idempresa)"
                    + "values('"+gs.getRazon_ajuste()
                    +"','"+gs.getCantidad_ajuste()
                    +"','"+gs.getTipo_ajuste()                    
                    +"','"+gs.getFecha_ajuste()
                    +"','"+gs.getIdcompra()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getIdempresa()
                    +"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert Procedure 002. "+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtxtidproducto, JTextField jtxtproducto, 
            JTextField jtxtcantidad, JTextField jtxtunidad, JTextField jtxtprecio,
            JTextArea jtxtrazonajuste, JTextField jtxtcantidadajuste, 
            JCheckBox jcktipoajuste, JDateChooser jdcfechaajuste){
        try{
            jtxtidproducto.setText("");
            jtxtproducto.setText("");
            jtxtcantidad.setText("");
            jtxtunidad.setText("");
            jtxtprecio.setText("");
            jtxtrazonajuste.setText("");
            jtxtcantidadajuste.setText("");
            jcktipoajuste.setSelected(false);
            jdcfechaajuste.setDate(null);            
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning fields 002. "+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int idcompra_producto, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdcompra(idcompra_producto);
            gs.setIdempresa(idempresa);
            String sql = "delete from compras_producto where idcompras_producto='"+gs.getIdcompra()
                    +"' and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete procedure 003. "+ex.getMessage(), ex);
        }
    }
    
    public void muestraAjustes(JTable jtable, String buscar, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Ajuste");
            dtm.addColumn("Razón Ajuste");
            dtm.addColumn("Cantidad ajustada");
            dtm.addColumn("Tipo de ajuste");
            dtm.addColumn("Fecha Ajuste");
            dtm.addColumn("Id Compra Producto");
            dtm.addColumn("Id Producto");
            dtm.addColumn("Producto");
            
            jtable.setModel(dtm);
            
            String sql = "";
            if(buscar.equals("")){
                sql = "select ajustes_compras.idajustes_compras, ajustes_compras.razon_ajuste,"
                        + " ajustes_compras.cantidad_ajuste, ajustes_compras.tipo_ajuste,"
                        + " ajustes_compras.fecha_ajuste, ajustes_compras.idcompras_producto,"
                        + " compras_producto.idproducto, compras_producto.producto"
                        + " from ajustes_compras inner join compras_producto "
                        + " on ajustes_compras.idcompras_producto = compras_producto.idcompras_producto "
                        + "where idempresa='"+idempresa+"'";
            }else{
                sql = "select ajustes_compras.idajustes_compras, ajustes_compras.razon_ajuste, ajustes_compras.cantidad_ajuste,"
                        + " ajustes_compras.cantidad_ajuste, ajustes_compras.tipo_ajuste,"
                        + " ajustes_compras.fecha_ajuste, ajustes_compras.idcompras_producto,"
                        + " compras_producto.idcompras_producto, compras_producto.idproducto, compras_producto.producto"
                        + " from ajustes_compras inner join compras_producto "
                        + " on ajustes_compras.idcompras_producto = compras_producto.idcompras_producto "
                        + "where compras_producto.producto like CONCAT('"+buscar+"','%_') "
                        + "and idempresa='"+idempresa+"'";
            }
            
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] datos = new String[8];
            while(cc._resultSet().next()){
                datos[0] = cc._resultSet().getString(1);
                datos[1] = cc._resultSet().getString(2);
                datos[2] = cc._resultSet().getString(3);
                datos[3] = cc._resultSet().getString(4);
                datos[4] = cc._resultSet().getString(5);
                datos[5] = cc._resultSet().getString(6);
                datos[6] = cc._resultSet().getString(7);
                datos[7] = cc._resultSet().getString(8);                
                dtm.addRow(datos);
            }
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(int idproducto, String producto, int cantidad, String unidad, 
            double precio, int idempleado, int idempresa, int idcompraproducto){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdproducto(idproducto);
            gs.setProducto(producto);
            gs.setCantidad(cantidad);
            gs.setUnidad(unidad);
            gs.setPrecio(precio);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            gs.setIdcompra(idcompraproducto);
            String sql = "update compras_producto set idproducto='"+gs.getIdproducto()
                    +"', producto='"+gs.getProducto()
                    +"', cantidad='"+gs.getCantidad()
                    +"', unidad='"+gs.getUnidad()
                    +"', precio='"+gs.getPrecio()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where idcompras_producto='"+gs.getIdcompra()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update adjustment procedure 006. "+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificarAjustes(String razonajuste, double cantidadajuste, String tipoajuste, 
            JDateChooser fechaajuste, int idcompras_producto, int idempleado, 
            int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            
            java.sql.Date fecha_ajuste = new java.sql.Date(fechaajuste.getDate().getTime());
            
            gs.setRazon_ajuste(razonajuste);
            gs.setCantidad_ajuste(cantidadajuste);
            gs.setTipo_ajuste(tipoajuste);
            gs.setFecha_ajuste(fecha_ajuste);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            gs.setIdcompra(idcompras_producto);
            String sql = "update ajustes_compras set razon_ajuste='"+gs.getRazon_ajuste()
                    +"', cantidad_ajuste='"+gs.getCantidad_ajuste()
                    +"', tipo_ajuste='"+gs.getTipo_ajuste()
                    +"', fecha_ajuste='"+gs.getFecha_ajuste()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where idcompras_producto='"+gs.getIdcompra()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update adjustment procedure 006. "+ex.getMessage(), ex);
        }
    }
    
    public void filtraAjustes(JTable jtable, String buscar){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Ajuste");
            dtm.addColumn("Razón Ajuste");
            dtm.addColumn("Cantidad ajustada");
            dtm.addColumn("Tipo de Ajuste");
            dtm.addColumn("Fecha");
            dtm.addColumn("Id Compra");
            dtm.addColumn("Id Producto");
            dtm.addColumn("Producto");
            jtable.setModel(dtm);
            
            String sql = "";
            
            if(buscar.equals("")){
                sql = "select * from ajustes";
            }else{
                sql = "select * from ajustes_compras where producto like CONCAT('"+buscar+"','%_')";
            }
            
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] datos = new String[8];
            if(cc._resultSet().first() == false){
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0] = cc._resultSet().getString(1);
                    datos[1] = cc._resultSet().getString(2);
                    datos[2] = cc._resultSet().getString(3);
                    datos[3] = cc._resultSet().getString(4);
                    datos[4] = cc._resultSet().getString(5);
                    datos[5] = cc._resultSet().getString(6);
                    datos[6] = cc._resultSet().getString(7);
                    datos[7] = cc._resultSet().getString(8);
                    dtm.addRow(datos);
                }                
            }cc.desconectar();
            
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR:  Select procedure 007. "+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelarAjuste(JTextField jtidcompraproducto, JTextArea jtrazonajuste,
            JTextField jtcantidadajuste, JCheckBox jchktipoajuste, JDateChooser jdfecha){
        try{
            jtidcompraproducto.setText("");
            jtrazonajuste.setText("");
            jtcantidadajuste.setText("");
            jchktipoajuste.setSelected(false);
            jdfecha.setDate(new Date());
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR:  Cleaning Fields 008."+ex.getMessage(), ex);
        }
    }    
    
    public void total(JTable jtable, JTextField jttotal){
        try{
            double p = 0;
            double t = 0;
            
            if(jtable.getRowCount() > 0){
                for(int i = 0; i < jtable.getRowCount(); i++){
                    p = Double.parseDouble(jtable.getValueAt(i, 6).toString());
                    t += p;
                }
                jttotal.setText(String.valueOf(t));
            }
        }catch(NumberFormatException ex){
            jtm.jTextAreaError("ERROR: Select procedure 009. "+ex.getMessage(), ex);
        }
    }
    
}
