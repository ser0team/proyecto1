/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Proveedores;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_proveedores;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class proveedores {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_proveedores gs = new gs_proveedores();
    
    public void jbguardar(String proveedor, String rfc, String pais, String estado, 
            String municipio, String colonia, String direccion, int codpos, 
            String telefono, int credito, int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setProveedor(proveedor);
            gs.setRfc(rfc);
            gs.setPais(pais);
            gs.setEstado(estado);
            gs.setMunicipio(municipio);
            gs.setColonia(colonia);
            gs.setDireccion(direccion);
            gs.setCodpos(codpos);
            gs.setTelefono(telefono);
            gs.setCredito(credito);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql="insert into proveedores(proveedor, rfc, pais, estado, municipio, "
                    + "colonia, direccion, codpos, telefono, diascredito, idempleado, idempresa)"
                    + "values('"+gs.getProveedor()
                    +"','"+gs.getRfc()
                    +"','"+gs.getPais()
                    +"','"+gs.getEstado()
                    +"','"+gs.getMunicipio()
                    +"','"+gs.getColonia()
                    +"','"+gs.getDireccion()
                    +"','"+gs.getCodpos()
                    +"','"+gs.getTelefono()
                    +"','"+gs.getCredito()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getIdempresa()
                    +"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert procedure 005. "+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtproveedor, JTextField jtrfc, JTextField jtpais, 
            JTextArea jtdireccion, JTextField jtestado, JTextField jtmunicipio, 
            JTextField jtcolonia, JTextField jtcodpos, JTextField jttelefono,
            JTextField jtcredito){
        try{
            jtproveedor.setText("");            
            jtrfc.setText("");
            jtpais.setText("");            
            jtestado.setText("");
            jtmunicipio.setText("");
            jtcolonia.setText("");
            jtdireccion.setText("");
            jtcodpos.setText("");
            jttelefono.setText("");
            jtcredito.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Select procedure 011. "+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int id){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql="delete from proveedores where idProveedor='"+id+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
             jtm.jTextAreaError("ERROR: Insert procedure 006. "+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(String proveedor, String rfc, String pais, String estado, 
            String municipio, String colonia, String direccion, int codpos, 
            String telefono, int credito, int idempleado, int idempresa, int id){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setProveedor(proveedor);            
            gs.setRfc(rfc);
            gs.setPais(pais);
            gs.setEstado(estado);
            gs.setMunicipio(municipio);
            gs.setColonia(colonia);
            gs.setDireccion(direccion);
            gs.setCodpos(codpos);
            gs.setTelefono(telefono);
            gs.setCredito(credito);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            gs.setIdproveedor(id);
            String sql="update proveedores set proveedor='"+gs.getProveedor()
                    +"', rfc='"+gs.getRfc()
                    +"', pais='"+gs.getPais()
                    +"', estado='"+gs.getEstado()
                    +"', municipio='"+gs.getMunicipio()
                    +"', colonia='"+gs.getColonia()
                    +"', direccion='"+gs.getDireccion()
                    +"', codpos='"+gs.getCodpos()
                    +"', telefono='"+gs.getTelefono()
                    +"', diascredito='"+gs.getCredito()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where idproveedor='"+gs.getIdproveedor()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
             jtm.jTextAreaError("ERROR: Update procedure 007. "+ex.getMessage(), ex);
        }
    }    
    
    public void mostrarRegistros(JTable jtable, String buscar){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Proveedor");
            dtm.addColumn("R.F.C.");            
            dtm.addColumn("País");            
            dtm.addColumn("Estado");
            dtm.addColumn("Municipio");
            dtm.addColumn("Colonia");
            dtm.addColumn("Dirección");
            dtm.addColumn("Codigo Postal");
            dtm.addColumn("Teléfono");
            dtm.addColumn("Credito");
            jtable.setModel(dtm);
            
            String sql;
            
            if(buscar.equals("")){
                sql = "select * from proveedores";
            }else{
                sql = "select * from proveedores where proveedor like CONCAT('"+buscar+"','%_')";
            }
            
            String[] datos = new String[11];
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){                
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0] = String.valueOf(cc._resultSet().getInt(1));
                    datos[1] = cc._resultSet().getString(2);
                    datos[2] = cc._resultSet().getString(3);
                    datos[3] = cc._resultSet().getString(4);
                    datos[4] = cc._resultSet().getString(5);
                    datos[5] = cc._resultSet().getString(6);
                    datos[6] = cc._resultSet().getString(7);
                    datos[7] = cc._resultSet().getString(8);
                    datos[8] = cc._resultSet().getString(9);
                    datos[9] = cc._resultSet().getString(10);
                    datos[10] = cc._resultSet().getString(11);
                    dtm.addRow(datos);
                }
                cc.desconectar();
            }
            
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 008. "+ex.getMessage(), ex);
        }
    }
    
    public void listaproveedores(JTable jtable, String buscar){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Proveedor");
            dtm.addColumn("Dirección");            
            dtm.addColumn("Teléfono");
            jtable.setModel(dtm);
            
            String sql;
            
            if(buscar.equals("")){
                sql = "select idproveedor, proveedor, direccion, telefono from proveedores";
            }else{
                sql = "select idproveedor, proveedor, direccion, telefono from proveedores where proveedor like CONCAT('"+buscar+"','%_')";
            }
            
            String[] datos = new String[4];
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){                
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0] = String.valueOf(cc._resultSet().getInt(1));
                    datos[1] = cc._resultSet().getString(2);
                    datos[2] = cc._resultSet().getString(3);
                    datos[3] = cc._resultSet().getString(4);                    
                    dtm.addRow(datos);
                }
                cc.desconectar();
            }
            
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 009. "+ex.getMessage(), ex);
        }
    }
    
    public void jbguardarProveedor_producto(int idproveedor){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "insert into proveedor_producto(idproveedor)values('"+idproveedor+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert producto_proveedor procedure 010. "+ex.getMessage(), ex);
        }
    }
    
    public void ventasporproveedor(JTable jtable, String buscar){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Regsitro");
            dtm.addColumn("Id Venta");
            dtm.addColumn("Id Producto");
            dtm.addColumn("Precio");
            dtm.addColumn("Producto");
            dtm.addColumn("Proveedor");
            
            String sql ="";
            
            if(buscar.equals("")){
                sql = "select venta_producto.idventa_producto, venta_producto.idventa,"
                        + " venta_producto.idproducto, venta_producto.precio_unitario,"
                        + " productos.producto, productos.proveedor "
                        + "from venta_producto inner join productos "
                        + "on venta_producto.idproducto=productos.idproductos";
            }else{
                sql = "select venta_producto.idventa_producto, venta_producto.idventa,"
                        + " venta_producto.idproducto, venta_producto.precio_unitario,"
                        + " productos.producto, productos.proveedor "
                        + "from venta_producto inner join productos "
                        + "on venta_producto.idproducto=productos.idproductos "
                        + "where productos.proveedor like CONCAT('"+buscar+"','%_')";
            }
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String data[] = new String[6];
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
                    dtm.addRow(data);
                }jtable.setModel(dtm);
            }cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 011."+ex.getMessage(), ex);
        }
    }
}
