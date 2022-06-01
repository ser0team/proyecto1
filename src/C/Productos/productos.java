/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Productos;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_productos;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class productos {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_productos gs = new gs_productos();
    int cantidad;
    
    public void jbguardar(String producto, String descripcion, String unidad, 
            int idproveedor, String proveedor, String marca, double precio, JDateChooser fechaprecio, 
            int idcategoria, int cantmax, int cantmin, String estatus, int idempleado, int idempresa){
        try{
            
            java.sql.Date fecha_precio = new java.sql.Date(fechaprecio.getDate().getTime());
            
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setProductos(producto);
            gs.setDescripcion(descripcion);
            gs.setUnidad(unidad);   
            gs.setIdproveedor(idproveedor);
            gs.setProveedor(proveedor);
            gs.setMarca(marca);            
            gs.setPrecio(precio);
            gs.setFechaprecio(fecha_precio);           
            gs.setIdcategoria(idcategoria);
            gs.setCantmax(cantmax);
            gs.setCantmin(cantmin);
            gs.setEstatus(estatus);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql="insert into productos(producto, descripcion, unidad, "
                    + "idproveedor, proveedor, marca, precio, fecha_precio_producto,"
                    + "  idcategoria, cantmax, cantmin, estatus, idempleado, idempresa)"
                    + "values('"+gs.getProductos()
                    +"','"+gs.getDescripcion()
                    +"','"+gs.getUnidad()          
                    +"','"+gs.getIdproveedor()
                    +"','"+gs.getProveedor()
                    +"','"+gs.getMarca()
                    +"','"+gs.getPrecio()
                    +"','"+gs.getFechaprecio()                    
                    +"','"+gs.getIdcategoria()
                    +"','"+gs.getCantmax()
                    +"','"+gs.getCantmin()
                    +"','"+gs.getEstatus()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getIdempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert procedure 001"+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int id){
        try{            
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql="delete from productos where idproductos='"+id+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete procedure 002. "+ex.getMessage(), ex);
        }
    }
           
    public void jbmodificar(String producto, String descripcion, String unidad, 
            int idproveedor, String proveedor, String marca, double precio, 
            JDateChooser fecha_precio, int idcategoria, int cantmax, int cantmin,
            String estatus, int idempleado, int idempresa, int idproducto){
        try{
            
            java.sql.Date fechaprecio = new java.sql.Date(fecha_precio.getDate().getTime());
                                    
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setProductos(producto);
            gs.setDescripcion(descripcion);
            gs.setUnidad(unidad);
            gs.setIdproveedor(idproveedor);
            gs.setProveedor(proveedor);
            gs.setMarca(marca);            
            gs.setPrecio(precio);
            gs.setFechaprecio(fechaprecio);                        
            gs.setIdcategoria(idcategoria); 
            gs.setCantmax(cantmax);
            gs.setCantmin(cantmin);
            gs.setEstatus(estatus);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            gs.setIdproducto(idproducto);
            String sql="update productos set producto='"+gs.getProductos()
                    +"', descripcion='"+gs.getDescripcion()
                    +"', unidad='"+gs.getUnidad()
                    +"', idproveedor='"+gs.getIdproveedor()
                    +"', proveedor='"+gs.getProveedor()
                    +"', marca='"+gs.getMarca()
                    +"', precio='"+gs.getPrecio()
                    +"', fecha_precio_producto='"+gs.getFechaprecio()                    
                    +"', idcategoria='"+gs.getIdcategoria()
                    +"', cantmax='"+gs.getCantmax()
                    +"', cantmin='"+gs.getCantmin()
                    +"', estatus='"+gs.getEstatus()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where idproductos='"+gs.getIdproducto()
                    +"' and idempleado='"+gs.getIdempleado()
                    +"' and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update procedure 003. "+ex.getMessage(), ex);
        }
    }
    
    public void obtenProveedores(JTable jtable, String filtro) throws ClassNotFoundException{
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Proveedor");
            dtm.addColumn("Dirección");
            dtm.addColumn("Teléfono");
            jtable.setModel(dtm);
            
            String sql;
            
            if(filtro.equals("")){
                sql="select id, proveedor, direccion, telefono proveedor from proveedores";
            }else{
                sql="select id, proveedor, direccion, telefono proveedor "
                        + "from proveedores where proveedor like CONCAT('%',"+filtro+",'%')";
            }
            
            String[] datos = new String[4];
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){
                jtm.jTextAreaMessage("No se has registrado proveedores");
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0]=cc._resultSet().getString(1);
                    datos[1]=cc._resultSet().getString(2);
                    datos[2]=cc._resultSet().getString(3);
                    datos[3]=cc._resultSet().getString(4);
                    dtm.addRow(datos);
                }
            }            
            cc.desconectar();
        }catch(SQLException ex){
            jtm.jTextAreaSQLError("ERROR: Select procedure 004. "+ex.getMessage(), ex.getErrorCode(), ex);
        }
    }
    
    public void muestraRegistros(JTable jtable, String buscar, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");             
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
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
            jtable.setModel(dtm);
            
            String sql;
            String estatus = "Habilitado";
            
            if(buscar.equals("")){
                sql="select idproductos, producto, descripcion, unidad, idproveedor, "
                        + "proveedor, marca, precio, fecha_precio_producto, "
                        + "idcategoria, cantmax, cantmin from productos "
                        + "where estatus='"+estatus+"' "
                        + "and idempresa='"+idempresa+"'";
            }else{
                sql="select idproductos, producto, descripcion, unidad, idproveedor, "
                        + "proveedor, marca, precio, fecha_precio_producto, "
                        + "idcategoria, cantmax, cantmin "
                        + "from productos where idempresa='"+idempresa+"' "
                        + "and estatus='"+estatus+"' "
                        + "and producto like CONCAT('"+buscar+"','_%_')";
            }
            
            String[] datos = new String[12];
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){                
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0]=cc._resultSet().getString(1);
                    datos[1]=cc._resultSet().getString(2);
                    datos[2]=cc._resultSet().getString(3);
                    datos[3]=cc._resultSet().getString(4);
                    datos[4]=cc._resultSet().getString(5);
                    datos[5]=cc._resultSet().getString(6);
                    datos[6]=cc._resultSet().getString(7);
                    datos[7]=cc._resultSet().getString(8);
                    datos[8]=cc._resultSet().getString(9);
                    datos[9]=cc._resultSet().getString(10);                    
                    datos[10]=cc._resultSet().getString(11);                    
                    datos[11]=cc._resultSet().getString(12);                    
                    dtm.addRow(datos);
                }
            }            
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 005. "+ex.getMessage(), ex);
        }
    }
    
    public void buscarProveedor(JTable jtable, String buscar, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");             
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
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
            jtable.setModel(dtm);
            
            String sql;
            String estatus = "Habilitado";
            
            if(buscar.equals("")){
                sql="select idproductos, producto, descripcion, unidad, idproveedor, "
                        + "proveedor, marca, precio, fecha_precio_producto, "
                        + "idcategoria, cantmax, cantmin from productos "
                        + "where estatus='"+estatus+"' "
                        + "and idempresa='"+idempresa+"'";
            }else{
                sql="select idproductos, producto, descripcion, unidad, idproveedor, "
                        + "proveedor, marca, precio, fecha_precio_producto, "
                        + "idcategoria, cantmax, cantmin "
                        + "from productos where idempresa='"+idempresa+"' "
                        + "and estatus='"+estatus+"' "
                        + "and proveedor like CONCAT('"+buscar+"','_%')";
            }
            
            String[] datos = new String[12];
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){                
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0]=cc._resultSet().getString(1);
                    datos[1]=cc._resultSet().getString(2);
                    datos[2]=cc._resultSet().getString(3);
                    datos[3]=cc._resultSet().getString(4);
                    datos[4]=cc._resultSet().getString(5);
                    datos[5]=cc._resultSet().getString(6);
                    datos[6]=cc._resultSet().getString(7);
                    datos[7]=cc._resultSet().getString(8);
                    datos[8]=cc._resultSet().getString(9);
                    datos[9]=cc._resultSet().getString(10);                    
                    datos[10]=cc._resultSet().getString(11);                    
                    datos[11]=cc._resultSet().getString(12);                    
                    dtm.addRow(datos);
                }
            }            
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 005. "+ex.getMessage(), ex);
        }
    }
    
    public void limpiar(JTextField jtproducto, JTextArea jtdescripcion,
            JComboBox jcbunidad, JTextField jtidproveedor, JTextField jtproveedor,
            JTextField jtmarca, JTextField jtprecio, JDateChooser jdcfecha, 
            JLabel jtfecha, JTextField jtidcategoria, JTextField jtcantmax,
            JTextField jtcantmin){
        try{
            jtproducto.setText("");
            jtdescripcion.setText("");
            jcbunidad.setSelectedIndex(0);
            jtidproveedor.setText("");
            jtproveedor.setText("");
            jtmarca.setText("");
            jtprecio.setText("");
            jdcfecha.setDate(null);
            jtfecha.setText("");            
            jtidcategoria.setText("");            
            jtcantmax.setText("");
            jtcantmin.setText("");            
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning method 006."+ex.getMessage(), ex);
        }
    }
    
   public void mostrarCompras(JTable jtable){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           DefaultTableModel dtm = new DefaultTableModel();
           dtm.addColumn("Id Compra");
           dtm.addColumn("Id Proveedor");
           dtm.addColumn("Proveedor");
           dtm.addColumn("Ticket");
           dtm.addColumn("Observaciónes");
           dtm.addColumn("Fecha");
           dtm.addColumn("Total");
           
           String sql = "select * from compras";
           cc._callablestatement(sql);
           cc._executeProcedureSelect();
           cc._resultSet();
           String data[] = new String[7];
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
               }
               jtable.setModel(dtm);
           }cc.desconectar();           
       }catch(ClassNotFoundException | SQLException ex){
           jtm.jTextAreaError("ERROR: Select Procedure 001."+ex.getMessage(), ex);
       }
   }
   
   public void mostrarProductosXCompra(JTable jtable, String idcompra){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           DefaultTableModel dtm = new DefaultTableModel();
           dtm.addColumn("Id Registro");
           dtm.addColumn("Id Compra");
           dtm.addColumn("Id Producto");
           dtm.addColumn("Producto");
           dtm.addColumn("Cantidad");
           dtm.addColumn("Unidad");
           dtm.addColumn("Precio");
           
           if(idcompra.equals("")){
               jtm.jTextAreaMessage("No se ha seleccionado una compra");
           }else{           
                String sql= "select * from compras_producto where idcompra='"+Integer.parseInt(idcompra)+"'";
                cc._callablestatement(sql);
                cc._executeProcedureSelect();
                cc._resultSet();
                String[] data = new String[7];
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
                        dtm.addRow(data);
                    }
                }jtable.setModel(dtm);                
           }cc.desconectar();
       }catch(ClassNotFoundException | SQLException ex){
           jtm.jTextAreaError("ERROR: Select Prodcedure 001."+ex.getMessage(), ex);
       }
   }    
   
   public void jbmostrarDeshabilitados(JTable jtable, String buscar, int idempresa){
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
           dtm.addColumn("Cant. Max.");
           dtm.addColumn("Cant. Min");
           jtable.setModel(dtm);
            
            String sql;
            String estatus = "Deshabilitado";
            
            if(buscar.equals("")){
                sql="select idproductos, producto, descripcion, unidad, idproveedor, "
                        + "proveedor, marca, precio, fecha_precio_producto, "
                        + "idcategoria, cantmax, cantmin from productos "
                        + "where estatus='"+estatus+"' "
                        + "and idempresa='"+idempresa+"'";
            }else{
                sql="select idproductos, producto, descripcion, unidad, idproveedor, "
                        + "proveedor, marca, precio, fecha_precio_producto, "
                        + "idcategoria, cantmax, cantmin "
                        + "from productos where idempresa='"+idempresa+"' "
                        + "and  estatus='"+estatus+"' "
                        + "and producto like CONCAT('"+buscar+"','_%_')";
            }
            
            String[] datos = new String[12];
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){                
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0]=cc._resultSet().getString(1);
                    datos[1]=cc._resultSet().getString(2);
                    datos[2]=cc._resultSet().getString(3);
                    datos[3]=cc._resultSet().getString(4);
                    datos[4]=cc._resultSet().getString(5);
                    datos[5]=cc._resultSet().getString(6);
                    datos[6]=cc._resultSet().getString(7);
                    datos[7]=cc._resultSet().getString(8);
                    datos[8]=cc._resultSet().getString(9);
                    datos[9]=cc._resultSet().getString(10);                    
                    datos[10]=cc._resultSet().getString(11);                    
                    datos[11]=cc._resultSet().getString(12);                    
                    dtm.addRow(datos);
                }
            }            
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 007. "+ex.getMessage(), ex);
        }
    }
   
   public void jbhabilitarProducto(String estatus, int idproducto){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           gs.setEstatus(estatus);
           gs.setIdproducto(idproducto);
           String sql = "update productos set estatus='"+gs.getEstatus()
                   +"' where idproductos='"+gs.getIdproducto()+"'";
           cc._callablestatement(sql);
           cc._executeProcedure();
           cc.desconectar();
       }catch(ClassNotFoundException ex){
           jtm.jTextAreaError("ERROR: Update Procedure 008."+ex.getMessage(), ex);
       }
   }
}
