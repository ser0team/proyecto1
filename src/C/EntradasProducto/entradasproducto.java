/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.EntradasProducto;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_entradasproducto;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class entradasproducto {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_entradasproducto gs = new gs_entradasproducto();
    int cantidad, cantmin, cantact;
    
     public int obtenCantAct(int idcompra, int idproducto, int idalmacen, 
             int idpasillo, int idanaquel, int idbin, int idempresa){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           String sql = "select cant from entradasproducto "
                   + "where idcompra='"+idcompra
                   + "' and idproducto='"+idproducto
                   + "' and idalmacen='"+idalmacen
                   + "' and idpasillo='"+idpasillo
                   + "' and idanaquel='"+idanaquel
                   + "' and idbin='"+idbin
                   + "' and idempresa='"+idempresa+"'";
           cc._callablestatement(sql);
           cc._executeProcedureSelect();
           cc._resultSet();
           while(cc._resultSet().next()){
               cantidad = cc._resultSet().getInt(1);
           }
       }catch(ClassNotFoundException | NumberFormatException | SQLException ex){
           jtm.jTextAreaError("ERROR: Select Procedure 007."+ex.getMessage(), ex);
       }
       return cantidad;
   }
   
   public void updateCantidad(int idcompra, int idalmacen, int idpasillo, int idanaquel, 
           int idbin, int idproducto, int cant, int idempleado, int idempresa, 
           int identradaproducto){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           gs.setIdcompra(idcompra);
           gs.setIdalmacen(idalmacen);
           gs.setIdpasillo(idpasillo);
           gs.setIdanaquel(idanaquel);
           gs.setIdbin(idbin);
           gs.setIdproducto(idproducto);
           gs.setCant(cant);
           gs.setIdempleado(idempleado);
           gs.setIdempresa(idempresa);
           gs.setIdentradaproducto(identradaproducto);
           String sql = "update entradasproducto set idcompra='"+gs.getIdcompra()
                   +"', idalmacen='"+gs.getIdalmacen()
                   +"', idpasillo='"+gs.getIdpasillo()
                   +"', idanaquel='"+gs.getIdanaquel()
                   +"', idbin='"+gs.getIdbin()
                   +"', idproducto='"+gs.getIdproducto()
                   + "', cant='"+(cantidad+gs.getCant())
                   +"', idempleado='"+gs.getIdempleado()
                   +"', idempresa='"+gs.getIdempresa()
                   +"' where identradaproducto='"+gs.getIdentradaproducto()
                   +"' and idproducto='"+idproducto                  
                   +"' and idempresa='"+idempresa+"'";
           cc._callablestatement(sql);
           cc._executeProcedure();
           cc.desconectar();
       }catch(ClassNotFoundException | NumberFormatException ex){
           jtm.jTextAreaError("ERROR: Update Quantity 008."+ex.getMessage(), ex);
       }
   }   
   
   public void limpiarEntradas(JTextField jtidcompra, JTextField jtidalmacen, 
           JTextField jtidanaquel,  JTextField jtidpasillo,
           JTextField jtidbin, JTextField jtidproducto, JTextField jtxtcant,
           JDateChooser jdcfecha, JTextArea jtcomentarios){
       jtidcompra.setText("");       
       jtidproducto.setText("");
       jtidalmacen.setText("");
       jtidanaquel.setText("");
       jtidpasillo.setText("");
       jtidbin.setText("");
       jdcfecha.setDate(null);
       jtcomentarios.setText("");
   }
   
   public void mostrarEntradas(JTable jtable, int idempresa){
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
           dtm.addColumn("Producto");
           dtm.addColumn("Cantidad");
           dtm.addColumn("Fecha. Entrada");
           dtm.addColumn("Comentario");
           dtm.addColumn("Id Empleado");
           dtm.addColumn("Id Empresa");
           
           String sql = "select entradasproducto.identradaproducto, "
                   + "entradasproducto.idcompra,"
                   + "entradasproducto.idalmacen,"
                   + "entradasproducto.idpasillo,"
                   + "entradasproducto.idanaquel,"
                   + "entradasproducto.idbin,"
                   + "entradasproducto.idproducto,"
                   + "productos.producto,"
                   + "entradasproducto.cant,"
                   + "entradasproducto.fechaentrada,"
                   + "entradasproducto.comentarios,"
                   + "entradasproducto.idempleado,"
                   + "entradasproducto.idempresa "
                   + "from entradasproducto "
                   + "inner join productos "
                   + "on entradasproducto.idproducto=productos.idproductos "
                   + "where entradasproducto.idempresa='"+idempresa+"'";
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
           jtm.jTextAreaError("ERROR: Select Procedure 004."+ex.getMessage(), ex);
       }
   }
   
    public void jbguardar(int idcompra, int idalmacen, int idpasillo, int idanaquel, 
           int idbin, int idproducto, int cant, Date jdcfecha, String comentarios, 
           int idempleado, int idempresa){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           gs.setIdcompra(idcompra);           
           gs.setIdalmacen(idalmacen);
           gs.setIdpasillo(idpasillo);
           gs.setIdanaquel(idanaquel);
           gs.setIdbin(idbin);
           gs.setIdproducto(idproducto);
           gs.setCant(cant);
           gs.setFechaentrada(jdcfecha);
           gs.setComentarios(comentarios);
           gs.setIdempleado(idempleado);
           gs.setIdempresa(idempresa);
           String sql = "insert into entradasproducto(idcompra, idalmacen, idpasillo, "
                   + "idanaquel, idbin, idproducto, cant, fechaentrada, comentarios, "
                   + "idempleado, idempresa)"
                   + "values('"+gs.getIdcompra()                   
                   +"','"+gs.getIdalmacen()
                   +"','"+gs.getIdpasillo()
                   +"','"+gs.getIdanaquel()
                   +"','"+gs.getIdbin()
                   +"','"+gs.getIdproducto()
                   +"','"+gs.getCant()
                   +"','"+gs.getFechaentrada()
                   +"','"+gs.getComentarios()
                   +"','"+gs.getIdempleado()
                   +"','"+gs.getIdempresa()+"')";
           cc._callablestatement(sql);
           cc._executeProcedure();
           cc.desconectar();
       }catch(ClassNotFoundException ex){
           jtm.jTextAreaError("ERROR: Insert Procedure 005."+ex.getMessage(), ex);
       }
   }
    
    public void jbmodificar(int idcompra, int idalmacen, int idpasillo, int idanaquel, 
           int idbin, int idproducto, int cant, Date jdcfecha, String comentarios, 
           int idempleado, int idempresa, int identrada){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           gs.setIdcompra(idcompra);           
           gs.setIdalmacen(idalmacen);
           gs.setIdpasillo(idpasillo);
           gs.setIdanaquel(idanaquel);
           gs.setIdbin(idbin);
           gs.setIdproducto(idproducto);
           gs.setCant(cant);
           gs.setFechaentrada(jdcfecha);
           gs.setComentarios(comentarios);
           gs.setIdempleado(idempleado);
           gs.setIdempresa(idempresa);
           gs.setIdentradaproducto(identrada);
           String sql = "update entradasproducto set idcompra='"+gs.getIdcompra()
                   +"', idalmacen='"+gs.getIdalmacen()
                   +"', idpasillo='"+gs.getIdpasillo()
                   +"', idanaquel='"+gs.getIdanaquel()
                   +"', idbin='"+gs.getIdbin()
                   +"', idproducto='"+gs.getIdproducto()
                   +"', cant='"+gs.getCant()
                   +"', fechaentrada='"+gs.getFechaentrada()
                   +"', comentarios='"+gs.getComentarios()
                   +"', idempleado='"+gs.getIdempleado()
                   +"', idempresa='"+gs.getIdempresa()
                   +"' where identradaproducto='"+gs.getIdentradaproducto()+"'";                   
           cc._callablestatement(sql);
           cc._executeProcedure();
           cc.desconectar();
       }catch(ClassNotFoundException ex){
           jtm.jTextAreaError("ERROR: Insert Procedure 005."+ex.getMessage(), ex);
       }
   }
   
   public void jbeliminar(int identradaproducto, int idempresa){
       try{
           cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
           String sql = "delete from entradasproductos where identradaproducto='"+identradaproducto
                   +"' and idempresa='"+idempresa+"'";
           cc._callablestatement(sql);
           cc._executeProcedure();
           cc.desconectar();
       }catch(ClassNotFoundException ex){
           jtm.jTextAreaError("ERROR: Delete Procedure 006."+ex.getMessage(), ex);
       }
   }

    public int obtenerMin() throws SQLException{
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select productos.cantmin, entradasproducto.cant from productos inner join entradasproducto "
                    + "on productos.idproductos = entradasproducto.idproducto";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){
                jtm.jTextAreaMessage("imposible identificar minimos. "
                        + "No existen valores para comparar");
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    cantmin = Integer.parseInt(cc._resultSet().getString(1));
                    cantact = Integer.parseInt(cc._resultSet().getString(2));                
                }
            }if(cantact < cantmin){
                jtm.jTextAreaMessage("Existen minimos para resultir en tus almacenes. Revisa tus cantidades");                                
            }
            cc.desconectar();
        } catch (ClassNotFoundException ex) {
            jtm.jTextAreaError("ERROR: 007."+ex.getMessage(), ex);
        }
        return cantmin;
    } 
}
