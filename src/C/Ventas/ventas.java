/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Ventas;

import C.Funciones.JTextAreaMessages;
import Frames.Ventas.ConsultaVentas;
import Frames.Ventas.Ventas;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class ventas {
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    GetSet.gs_ventas gs = new GetSet.gs_ventas();        
    int numeroventa, cantact;
    public static boolean verificacionCaja;
    double result;
        
    public int btn_nuevo(JTextField jtnumeroventa) throws ClassNotFoundException{
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql="select max(idventa) as ultimaventa from ventas";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){
                System.out.println("Aún no se han hecho ventas");
                numeroventa = 1;
                jtnumeroventa.setText(String.valueOf(numeroventa));
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    numeroventa = cc._resultSet().getInt(1) + 1;  
                    jtnumeroventa.setText(String.valueOf(numeroventa));
                }
            }
        }catch(SQLException ex){
            jtm.jTextAreaSQLError("ERROR: Ha ocurrido un error. 0001"+ex.getMessage(), ex.getErrorCode(), ex);
        }
        return numeroventa;
    }
    
    public void btn_guardarVenta(String forma_pago, String fechaventa, String horaventa,
            int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");            
            gs.setForma_pago(forma_pago);            
            gs.setFechaventa(fechaventa);
            gs.setHoraventa(horaventa);  
            gs.setIdusuario(idempleado);
            gs.setIdempresa(idempresa);
            String sql="insert into ventas"
                    + "(forma_pago,"                     
                    + "fechaventa,"
                    + "horaventa,"  
                    + "idempleado,"
                    + "idempresa)"
                    + "values"
                    + "('"+gs.getForma_pago()                    
                    +"','"+gs.getFechaventa()
                    +"','"+gs.getHoraventa()
                    +"','"+gs.getIdusuario()
                    +"','"+gs.getIdempresa()
                    +"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert procedure 002. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void jbguardarventaproducto(int idventa, int idproducto, String descripcion, 
            double precio, int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdventa(idventa);
            gs.setIdproducto(idproducto);
            gs.setDescripcion(descripcion);
            gs.setPreciounitario(precio);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql="insert into venta_producto(idventa,"
                    + "idproducto, "
                    + "descripcion, "
                    + "precio_unitario,"
                    + "idempleado,"
                    + "idempresa)"
                    + "values('"+gs.getIdventa()
                    +"','"+gs.getIdproducto()
                    +"','"+gs.getDescripcion()
                    +"','"+gs.getPreciounitario()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getIdempresa()
                    +"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert procedure 003. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void jbguardartotales(int idventa, double total, double pago, double cambio,
            int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdventa(idventa);
            gs.setTotal(total);
            gs.setPago(pago);
            gs.setCambio(cambio);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql="insert into totales("
                    + "idventa, "
                    + "total, "
                    + "pago,"
                    + "cambio,"
                    + "idempleado,"
                    + "idempresa)"
                    + "values('"+gs.getIdventa()
                    +"','"+gs.getTotal()
                    +"','"+gs.getPago()
                    +"','"+gs.getCambio()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getIdempresa()
                    +"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert procedure 003. "+ex.getMessage(), ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean verificarCaja(){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           
            String sql = "select caja from caja where fecha='"+Ventas.jtxtfecha.getText()+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                result = Double.parseDouble(cc._resultSet().getString(1));
                System.out.println(result);
                if(String.valueOf(result).equals("")){
                    verificacionCaja = false;
                }else{                
                    verificacionCaja = true;
                }
            }
            cc.desconectar();
        }catch(HeadlessException | ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
        return verificacionCaja;
    }
    
    public void muestraVentasXFecha(JDateChooser fechade, JDateChooser fechahasta,
            JTable jtable){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");                               
            
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Venta");
            dtm.addColumn("Forma Pago");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Fecha Venta");
            dtm.addColumn("Total");
            jtable.setModel(dtm);
            
            String sql = "";
            
            if(fechade.getDate()==null || fechahasta.getDate() == null){
                sql = "select ventas.idventa, ventas.forma_pago, ventas.idempleado, "
                    + "ventas.fechaventa, totales.total "
                    + "from ventas " 
                    + "inner join totales "
                    + "on ventas.idventa = totales.idventa";                    
            }else{
                java.sql.Date fde = new java.sql.Date(fechade.getDate().getTime());
                java.sql.Date fhasta = new java.sql.Date(fechahasta.getDate().getTime());   
                sql = "select ventas.idventa, ventas.forma_pago, ventas.idempleado, "
                    + "ventas.fechaventa, totales.total "
                    + "from ventas " 
                    + "inner join totales "
                    + "on ventas.idventa = totales.idventa "
                    + "where ventas.fechaventa between '"+fde+"' and '"+fhasta+"'";
            }
            
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String datos[] = new String[5];
            while(cc._resultSet().next()){                
                datos[0] = cc._resultSet().getString(1);
                datos[1] = cc._resultSet().getString(2);
                datos[2] = cc._resultSet().getString(3);
                datos[3] = cc._resultSet().getString(4);
                datos[4] = cc._resultSet().getString(5);
                dtm.addRow(datos);
            }            
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 002. "+ex.getMessage(), ex);
        }
    }
    
    public void mostrarVentas(JTable jtable, String jdcdesde, 
            String jdchasta){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Venta");
            dtm.addColumn("Formas de Pago");            
            dtm.addColumn("Fecha Venta");
            dtm.addColumn("Hora Venta");
            dtm.addColumn("Total");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            
            String sql;
            if(jdcdesde.equals("") || jdchasta.equals("")){
                sql = "select ventas.idventa, ventas.forma_pago,"
                        + "ventas.fechaventa, ventas.horaventa,"                       
                        + "totales.total,"
                        + "ventas.idempleado, ventas.idempresa "
                        + "from ventas inner join totales "
                        + "on ventas.idventa = totales.idventa";
            }else{            
                java.sql.Date _fde = new java.sql.Date(ConsultaVentas.jdcdesde.getDate().getTime());
                java.sql.Date _fhasta = new java.sql.Date(ConsultaVentas.jdchasta.getDate().getTime());

                sql = "select ventas.idventa, ventas.forma_pago,"
                        + "ventas.fechaventa, ventas.horaventa,"                       
                        + "totales.total,"
                        + "ventas.idempleado, ventas.idempresa "
                        + "from ventas inner join totales "
                        + "on ventas.idventa = totales.idventa"
                        + " where ventas.fechaventa between '"+_fde+"' and '"+_fhasta+"'";
            }
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] datos = new String[7];
            while(cc._resultSet().next()){                
                datos[0] = cc._resultSet().getString(1);
                datos[1] = cc._resultSet().getString(2);
                datos[2] = cc._resultSet().getString(3);
                datos[3] = cc._resultSet().getString(4);
                datos[4] = cc._resultSet().getString(5);
                datos[5] = cc._resultSet().getString(6);
                datos[6] = cc._resultSet().getString(7);
                dtm.addRow(datos);
            }            
            jtable.setModel(dtm);
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 003. "+ex.getMessage(), ex);
        }
    }
    
    public void total(JTable jtable, JTextField jtxttotal){
        try{
            double t = 0;
            double p = 0;
            
            if(jtable.getRowCount() > 0){
                for(int i = 0; i < jtable.getRowCount(); i++){
                    p = Double.parseDouble(jtable.getValueAt(i, 4).toString());
                    t += p;
                }
                jtxttotal.setText(String.valueOf(t));
            }      
        }catch(NumberFormatException ex){
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public void totalConsultaVentas(JTable jtable, JTextField jtxttotal){
        try{
            double t = 0;
            double p = 0;
            
            if(jtable.getRowCount() > 0){
                for(int i = 0; i < jtable.getRowCount(); i++){
                    p = Double.parseDouble(jtable.getValueAt(i, 5).toString());
                    t += p;
                }
                jtxttotal.setText(String.valueOf(t));
            }      
        }catch(NumberFormatException ex){
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public void ttotal(JTable jtable, JTextField jtxttotal){
        try{
            double t = 0;
            double p = 0;
            
            if(jtable.getRowCount() > 0){
                for(int i = 0; i < jtable.getRowCount(); i++){
                    p = Double.parseDouble(jtable.getValueAt(i, 2).toString());
                    t += p;
                }
                jtxttotal.setText(String.valueOf(t));
            }      
        }catch(NumberFormatException ex){
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public void pago(JTable jtable, JTextField jtxttotal){
        try{
            double t = 0;
            double p = 0;
            
            if(jtable.getRowCount() > 0){
                for(int i = 0; i < jtable.getRowCount(); i++){
                    p = Double.parseDouble(jtable.getValueAt(i, 3).toString());
                    t += p;
                }
                jtxttotal.setText(String.valueOf(t));
            }      
        }catch(NumberFormatException ex){
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public void cambio(JTable jtable, JTextField jtxttotal){
        try{
            double t = 0;
            double p = 0;
            
            if(jtable.getRowCount() > 0){
                for(int i = 0; i < jtable.getRowCount(); i++){
                    p = Double.parseDouble(jtable.getValueAt(i, 4).toString());
                    t += p;
                }
                jtxttotal.setText(String.valueOf(t));
            }      
        }catch(NumberFormatException ex){
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public void muestraTotales(JTable jtable){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Id Venta");
            dtm.addColumn("Total");
            dtm.addColumn("Pago");
            dtm.addColumn("Cambio");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            
            String sql = "select * from totales";            
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
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public int obtenCantidadActual(int idproducto){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select cant from entradasproducto where idproducto='"+idproducto+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                    if(cc._resultSet().getString(1) == null 
                            || cc._resultSet().getInt(1) == 0
                            || cc._resultSet().getString(1).startsWith("-")){
                    jtm.jTextAreaMessage("La cantidad es mayor a las existencias");
                }else{
                    cantact = cc._resultSet().getInt(1);
                    System.out.println(cantact);                       
                }             
            }cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure Quantity 005."+ex.getMessage(), ex);
        }
        return cantact;
    }
    
    public void restaProducto(int idproducto){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "update entradasproducto set cant='"+(cantact-1)
                    +"' where idproducto='"+idproducto+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Procedure 006."+ex.getMessage(), ex);
        }
    }
    
    public void sumaProducto(int idproducto){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "update entradasproducto set cant='"+(cantact+1)
                    +"' where idproducto='"+idproducto+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Procedure 007."+ex.getMessage(), ex);
        }
    }
    
    public void muestraProductos(JTable jtable, int idventa, int idcompania){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           DefaultTableModel dtm = new DefaultTableModel();
           dtm.addColumn("Id Registro");
           dtm.addColumn("Id Venta");
           dtm.addColumn("Id Producto"); 
           dtm.addColumn("Producto"); 
           dtm.addColumn("Descripción");
           dtm.addColumn("Precio Unitario");
           
           String sql = "";
           
           if(String.valueOf(idventa).equals("")){
                sql = "select venta_producto.idventa_producto,"
                   + "venta_producto.idventa, venta_producto.idproducto,"
                   + "productos.producto, venta_producto.descripcion, "
                   + "venta_producto.precio_unitario"
                   + " from venta_producto inner join productos "
                   + "on venta_producto.idproducto = productos.idproductos"
                   + " where venta_producto.idempresa='"+idcompania+"'";               
           }else{           
                sql = "select venta_producto.idventa_producto,"
                   + "venta_producto.idventa, venta_producto.idproducto,"
                   + "productos.producto, venta_producto.descripcion, "
                   + "venta_producto.precio_unitario"
                   + " from venta_producto inner join productos "
                   + "on venta_producto.idproducto = productos.idproductos"
                   + " where venta_producto.idempresa='"+idcompania+"' and idventa like CONCAT('%',"+idventa+",'%')";
           }
           cc._callablestatement(sql);
           cc._executeProcedureSelect();
           cc._resultSet();
           String[] data = new String[5];
           while(cc._resultSet().next()){
               data[0] = cc._resultSet().getString(1);
               data[1] = cc._resultSet().getString(2);
               data[2] = cc._resultSet().getString(3);
               data[3] = cc._resultSet().getString(4);   
               data[4] = cc._resultSet().getString(5);                  
               dtm.addRow(data);
           }
           jtable.setModel(dtm);
           cc.desconectar();                   
       }catch(ClassNotFoundException | SQLException ex){
           jtm.jTextAreaError("ERROR: Select Procedure 008."+ex.getMessage(), ex);
       }
   }    
    
   public void muestraVentaProductos(JTable jtable, int idcompania){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           DefaultTableModel dtm = new DefaultTableModel();
           dtm.addColumn("Id Registro");
           dtm.addColumn("Id Venta");
           dtm.addColumn("Id Producto"); 
           dtm.addColumn("Producto"); 
           dtm.addColumn("Descripción");
           dtm.addColumn("Precio Unitario");
           
           String sql = "select "
                   + "venta_producto.idventa_producto,"
                   + "venta_producto.idventa, "
                   + "venta_producto.idproducto,"
                   + "productos.producto, "
                   + "venta_producto.descripcion,"
                   + "venta_producto.precio_unitario"                   
                   + " from venta_producto inner join productos "
                   + "on venta_producto.idproducto = productos.idproductos"
                   + " where venta_producto.idempresa='"+idcompania+"'";
           cc._callablestatement(sql);
           cc._executeProcedureSelect();
           cc._resultSet();
           String[] data = new String[6];
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
           cc.desconectar();                   
       }catch(ClassNotFoundException | SQLException ex){
           jtm.jTextAreaError("ERROR: Select Procedure 008."+ex.getMessage(), ex);
       }
   }  
   
   public void totalVentasProductos(JTable jtable, JTextField jtxttotal){
        try{
            double t = 0;
            double p = 0;
            
            if(jtable.getRowCount() > 0){
                for(int i = 0; i < jtable.getRowCount(); i++){
                    p = Double.parseDouble(jtable.getValueAt(i, 4).toString());
                    t += p;
                }
                jtxttotal.setText(String.valueOf(t));
            }      
        }catch(NumberFormatException ex){
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
    }
    
}


