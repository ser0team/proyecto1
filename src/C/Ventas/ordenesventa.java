/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Ventas;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_ordenesventas;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roman Araujo
 */
public class ordenesventa {
    
    JTextAreaMessages jtm = new JTextAreaMessages();
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    gs_ordenesventas gs = new gs_ordenesventas();
    
    public void guardarOV(JDateChooser fecha, String comanda, String mesa, int idusuario, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            java.sql.Date fechaov = new java.sql.Date(fecha.getDate().getTime());
            gs.setFecha(fechaov);
            gs.setComanda(comanda);
            gs.setMesa(mesa);
            gs.setIdusuario(idusuario);
            gs.setIdempresa(idempresa);
            String sql = "insert into ordenes_venta(f_rdnvnt, cmnd, ms, idusuario, idempresa)"
                    + "values('"+gs.getFecha()
                    +"','"+gs.getComanda()
                    +"','"+gs.getMesa()
                    +"','"+gs.getIdusuario()
                    +"','"+gs.getIdempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert procedure 001. "+ex.getMessage(), ex);
        }
    }
    
    public void actualizaEstatus(int estatus, int idov, int idusuario, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setEstatus(estatus);
            gs.setIdusuario(idusuario);
            gs.setIdempresa(idempresa);
            String sql = "update ordenes_venta set stts='"+gs.getEstatus()
                    +"', idusuario='"+gs.getIdusuario()
                    +"' where idorden_venta='"+gs.getIdordenventa()
                    +"' and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update status OV procedure 002. "+ex.getMessage(), ex);
        }
    }
    
    public void sumaPrecios(int idov, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdordenventa(idov);
            gs.setIdempresa(idempresa);
            String sql = "select sum(precio) "
                    + "from ordenes_ventas_platillos "
                    + "where idorden_venta='"+gs.getIdordenventa()
                    + " and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc.desconectar();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Select precio sum procedure 003. "+ex.getMessage(), ex);
        }
    }
    
    public void actualizaTotalOV(double total){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setTotal(total);
            String sql = "update ordenes_venta set ttl='"+gs.getTotal()
                    +"' where idorden_venta='"+gs.getIdordenventa()
                    +"' and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update total OV procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public void limpiarOV(JTextField jtidov, JDateChooser jtfecha, JTextField jtmesa, 
            JTextField jtplatillo, JTextField jtprecio, JTextField jtcantidad, 
            JTextField jtotal){
        try{
            jtidov.setText("");
            jtfecha.setDate(null);
            jtmesa.setText("");
            jtplatillo.setText("");
            jtprecio.setText("");
            jtcantidad.setText("");
            jtotal.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning field values 005. "+ex.getMessage(), ex);
        }
    }
    
    public void eliminarOV(int idov, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdordenventa(idov);
            gs.setIdempresa(idempresa);
            String sql="delete from ordenes_venta where idorden_venta='"+gs.getIdordenventa()
                    +" and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Cleaning field values 005. "+ex.getMessage(), ex);
        }
    }
    
    public void modificarOV(JDateChooser fecha, String comanda, String mesa, int idusuario, int idempresa, int idov){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            java.sql.Date fechaov = new java.sql.Date(fecha.getDate().getTime());
            gs.setFecha(fechaov);
            gs.setComanda(comanda);
            gs.setMesa(mesa);
            gs.setIdusuario(idusuario);
            gs.setIdempresa(idempresa);
            String sql = "update ordenes_venta set f_rdnvnt='"+gs.getFecha()
                    + "', cmnd='"+gs.getComanda()
                    + "', ms='"+gs.getMesa()
                    + "', idusuario='"+gs.getIdusuario()
                    + "', idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update OV procedure values 006. "+ex.getMessage(), ex);
        }
    }
    
    public void mostrar(JTable jtable, String buscar){
        try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           DefaultTableModel dtm = new DefaultTableModel();
           dtm.addColumn("Id OV");
           dtm.addColumn("Fecha");
           dtm.addColumn("Comanda");
           dtm.addColumn("Mesa");
           dtm.addColumn("Estatus");
           dtm.addColumn("Total");
           dtm.addColumn("Id Usuario");
                      
           String sql;
           
           if(buscar.equals("")){
               sql = "select idorden_venta, f_rdnvnt, comanda, ms, stts, ttl, idusuario "
                       + "from ordenes_venta";
           }else{
               sql = "select idorden_venta, f_rdnvnt, comanda, ms, stts, ttl, idusuario "
                       + "from ordenes_venta "
                       + "where idorden_venta like CONCAT('"+buscar+"','_%_')";
           }
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
                   data[6] = cc._resultSet().getString(7);
                   dtm.addRow(data);
               }
               jtable.setModel(dtm);
           }cc.desconectar();           
       }catch(ClassNotFoundException | SQLException ex){
           jtm.jTextAreaError("ERROR: Select Procedure 007."+ex.getMessage(), ex);
       }        
    }
    
    public void agregarPlatillo(int idplatillo, double precio, int cantidad, 
            int idusuario, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdplatillo(idplatillo);
            gs.setPrecio(precio);
            gs.setCantidad(cantidad);
            gs.setIdusuario(idusuario);
            gs.setIdempresa(idempresa);
            String sql = "insert into ordenes_venta_platillo(idplatillo, prc, cntdd, idusuario, idempresa)"
                    + "values('"+gs.getIdplatillo()
                    +"','"+gs.getPrecio()
                    +"','"+gs.getCantidad()
                    +"','"+gs.getIdusuario()
                    +"','"+gs.getIdempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();            
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert data procedure 008."+ex.getMessage(), ex);
        }
    }
    
    public void limpiarPlatillos(JTextField jtplatillos, JTextField jtprecio, JTextField jtcantidad){
        try{
            jtplatillos.setText("");
            jtprecio.setText("");
            jtcantidad.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning value fields 009."+ex.getMessage(), ex);
        }
    }
    
    public void eliminarPlatillo(int idov_platillo, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdordenventa_platillo(idov_platillo);
            gs.setIdempresa(idempresa);
            String sql = "delete from ordenes_venta_platillo "
                    + "where idordenes_venta_platillo='"+gs.getIdordenventa_platillo()
                    + " and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete procedure 010. "+ex.getMessage(), ex);
        }
    }
    
}
