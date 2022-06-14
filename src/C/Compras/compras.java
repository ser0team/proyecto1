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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jraraujo
 */
public class compras {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_compras gs = new gs_compras();
    int idcompra;
    TableRowSorter trsFiltro;
    
    public void jbguardar(int idproveedor, String proveedor, JDateChooser fechacom, String observaciones, 
           double total, int idusuario, int idempresa, int idempleado, String ticket){
        try{                                    
            cc.conexionMySql("127.0.0.1", "3306", "root", "Root.12!");
            
            java.sql.Date date = new java.sql.Date(fechacom.getDate().getTime());
            
            gs.setIdproveedor(idproveedor);
            gs.setProveedor(proveedor);
            gs.setFechacom(date);
            gs.setObservaciones(observaciones);
            gs.setTotal(total);
            gs.setIdusuario(idusuario); 
            gs.setIdempresa(idempresa);
            gs.setIdempleado(idempleado);
            gs.setTicket(ticket);
            String sql = "insert into compras(idproveedor"
                    + ", proveedor"
                    + ", fechacom"
                    + ", observaciones)"
                    + ", total"
                    + ", idusuario"
                    + ", idempresa)"
                    + ", idempleado)"
                     + ", ticket)"
                    + "values('"+gs.getIdproveedor()
                    +"','"+gs.getProveedor()
                    +"','"+gs.getFechacom()
                    +"','"+gs.getObservaciones()
                    +"','"+gs.getTotal()
                    +"','"+gs.getIdusuario()
                    +"','"+gs.getIdempresa()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getTicket()
                    +"')";                
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();            
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert procedure 001. "+ex.getMessage(), ex);
        }
    }
    
    public int obtenerCompra(int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");            
            String sql = "select max(idcompra) as ultimacompra from compras "
                    + "where idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                idcompra = Integer.parseInt(cc._resultSet().getString(1));
            }
        }catch(ClassNotFoundException | NumberFormatException | SQLException ex){
            jtm.jTextAreaError("ERROR: @@Identity procedure 004 "+ex.getMessage(), ex);
        }
        return idcompra;
    }
    
    public void jbguardarProductos(int idCompra, int idproducto, String producto, 
            int cantidad, String unidad, double precio, int idusuario, int idempresa, String ticket){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdcompra(idCompra);            
            gs.setIdproducto(idproducto);
            gs.setProducto(producto);
            gs.setCantidad(cantidad);
            gs.setUnidad(unidad);
            gs.setPrecio(precio);  
            gs.setIdusuario(idusuario); 
            gs.setIdempresa(idempresa);
            gs.setTicket(ticket);
            String sql = "insert into compras_producto(idcompra, idproducto, producto, "
                    + "cantidad, unidad, precio, idempleado, idempresa)"
                    + "values('"+gs.getIdcompra()                    
                    +"','"+gs.getIdproducto()
                    +"','"+gs.getProducto()
                    +"','"+gs.getCantidad()
                    +"','"+gs.getUnidad()
                    +"','"+gs.getPrecio()
                    +"','"+gs.getIdusuario()
                    +"','"+gs.getIdempresa()
                    +"','"+gs.getTicket()
                    +"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Limit 1 procedure 005 "+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtxtproveedor,
            JTextField jtxtproducto, JTextField jtxtprecio, JTextField jtxtcantidad,
            JTextField jtxtunidad, JTextArea jtxtobservaciones, JDateChooser jdcfecha,
            JTextField jltotal, JTextField jtxtticket){
        try{
            jtxtproveedor.setText("");
            jtxtproducto.setText("");
            jtxtprecio.setText("");
            jtxtcantidad.setText("");
            jtxtunidad.setText("");
            jtxtobservaciones.setText("");
            jdcfecha.setDate(null);
            jltotal.setText("0.00");
            jtxtticket.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cancel procedure 006. "+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(JTable jtable, JLabel jltotal){
        try{
            int row = jtable.getSelectedRow();
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.removeRow(row);
            
            double t = 0;
            double p = 0;
            
            if(jtable.getRowCount() > 0){
                for(int i = 0; i < jtable.getRowCount(); i++){
                    p = Double.parseDouble(jtable.getValueAt(1, 5).toString());
                    t += p;
                }
                jltotal.setText(String.valueOf(t));
            }
        }catch(NumberFormatException ex){
            jtm.jTextAreaError("ERROR: Remove row 007. "+ex.getMessage(), ex);
        }
    }
    
    public void muestraCompras(JTable jtable, String buscar, JDateChooser jdcde, 
            JDateChooser jdchasta, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Compra");
            dtm.addColumn("Id Proveedor");
            dtm.addColumn("Proveedor");
            dtm.addColumn("Fecha");
            dtm.addColumn("Observaciónes");
            dtm.addColumn("Total");  
            dtm.addColumn("Usuario");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            dtm.addColumn("Ticket");
            jtable.setModel(dtm);
            
            String sql;
            
            if(buscar.equals("")){
                sql = "select * from compras where idempresa='"+idempresa+"'";
            }else if(!buscar.equals("")){
                sql = "select * from compras where proveedor like CONCAT('"+buscar+"','%_') "
                        + "and idempresa='"+idempresa+"'";
            }else if(jdcde.getDate() == null || jdchasta.getDate() == null){
                sql = "select * from compras where idempresa='"+idempresa+"'";
            }else{
               java.sql.Date _de = new java.sql.Date(jdcde.getDate().getTime());
               java.sql.Date _hasta = new java.sql.Date(jdchasta.getDate().getTime());
               sql = "select * from compras where fecha between '"+_de+"' and '"+_hasta+"' and idempresa='"+idempresa+"'";                
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
                    datos[9] = cc._resultSet().getString(10);
                    dtm.addRow(datos);
                }
            }cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 008. "+ex.getMessage(), ex);
        }
    }
    
   public void actualizarCompra(int idproveedor, String proveedor, JDateChooser jdcfecha,
           String observaciones, int idempleado, int idempresa, String ticket, 
           int idcompra){
       try{
           
           java.sql.Date date = new java.sql.Date(jdcfecha.getDate().getTime());
           DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
           String fechacom = df.format(date);
           
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           gs.setIdproveedor(idproveedor);
           gs.setProveedor(proveedor);
           gs.setFechacom(date);
           gs.setObservaciones(observaciones);
           gs.setIdempleado(idempleado);
           gs.setIdempresa(idempresa);
           gs.setTicket(ticket);
           gs.setIdcompra(idcompra);           
           String sql = "update compras set idproveedor='"+gs.getIdproveedor()
                   +"', proveedor='"+gs.getProveedor()
                   +"', fechacom='"+gs.getFechacom()
                   +"', observaciones='"+gs.getObservaciones()
                   +"', idempleado='"+gs.getIdempleado()
                   +"', idempresa='"+gs.getIdempresa()
                   +"', ticket='"+gs.getTicket()
                   +"' where idcompra='"+gs.getIdcompra()
                   +"' and idempresa='"+gs.getIdempresa()+"'";
           cc._callablestatement(sql);
           cc._executeProcedure();
           cc.desconectar();
       }catch(ClassNotFoundException ex){
           jtm.jTextAreaError("ERROR: Update procedure 009. "+ex.getMessage(), ex);
       }           
    }
   
   public void jbcancelarCompra(JTextField jtxtproveedor, 
           JTextArea jtxtobservaciones, JDateChooser jdcfecha, JTextField jtxtticket){
       try{
           jtxtproveedor.setText("");
           jtxtobservaciones.setText("");
           jdcfecha.setDate(null);
           jtxtticket.setText("");
       }catch(Exception ex){
           jtm.jTextAreaError("ERROR: Clean procedure 010. "+ex.getMessage(), ex);
       }
   }  
   
   public void jbmodificar(int idproveedor, String proveedor, 
           String observaciones, JDateChooser jdcfecha, int idempleado, int idempresa, String ticket,
           int idcompra){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           
           java.sql.Date _fecha = new java.sql.Date(jdcfecha.getDate().getTime());
           
           gs.setIdproveedor(idproveedor);
           gs.setProveedor(proveedor);
           gs.setObservaciones(observaciones);
           gs.setFechacom(_fecha);
           gs.setIdempleado(idempleado);
           gs.setIdempresa(idempresa);
           gs.setTicket(ticket);
           gs.setIdcompra(idcompra);
           String sql = "update compras set idproveedor='"+gs.getIdproveedor()
                   +"', proveedor='"+gs.getProveedor()
                   +"', observaciones='"+gs.getObservaciones()
                   +"', fechacom='"+gs.getFechacom()
                   +"', idempleado='"+gs.getIdempleado()
                   +"', idempresa='"+gs.getIdempresa()
                   +"', ticket='"+gs.getTicket()
                   +" where idcompra='"+gs.getIdcompra()
                   +"' and idempresa='"+gs.getIdempresa()+"'";
           cc._callablestatement(sql);
           cc._executeProcedure();
           cc.desconectar();
       }catch(ClassNotFoundException ex){
           jtm.jTextAreaError("ERROR: Update procedure 011. "+ex.getMessage(), ex);
       }       
   }
   
   public void jbeliminar(int idcompra, int idempresa){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           gs.setIdcompra(idcompra);
           gs.setIdempresa(idempresa);
           String sql = "delete from compras where idcompra='"+gs.getIdcompra()
                   +"' and idempresa='"+gs.getIdempresa()+"'";
           cc._callablestatement(sql);
           cc._executeProcedure();
           cc.desconectar();
       }catch(ClassNotFoundException ex){
           jtm.jTextAreaError("ERROR: Delete procedure 012. "+ex.getMessage(), ex);
       }       
   }
   
   public void filtraCompras(JTable jtable, String buscar){
       DefaultTableModel dtm = new DefaultTableModel();
       dtm = (DefaultTableModel) jtable.getModel();
       TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dtm);
       jtable.setRowSorter(tr);
       tr.setRowFilter(RowFilter.regexFilter(buscar, 1));        
       jtable.setModel(dtm);
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
           jtm.jTextAreaError("ERROR: Select procedure 013. "+ex.getMessage(), ex);
       }
    }   
   
}
