/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.AjustesInventario;

import C.Funciones.JTextAreaMessages;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class ajustesinventario {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    int cantact, idalmacenes;
    
    public int obtenCantidadActual(int idproducto, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select cant from entradasproducto "
                    + "where idproductos='"+idproducto
                    +"' and idempresa='"+idempresa+"'";
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
    
    public void actualizaInventario(int idproducto, int cantidad, int idalmacen,
            int idpasillo, int idanaquel, int idbin, int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "update entradasproducto set cant='"+(cantact+cantidad)
                    +"' where idproductos='"+idproducto
                    +"' and idalmacen='"+idalmacen
                    +"' and idpasillo='"+idpasillo
                    +"' and idanaquel='"+idanaquel
                    +"' and idbin='"+idbin
                    +"' and idempleado='"+idempleado
                    +"' and idempresa'"+idempresa;
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Procedure 001."+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtidproducto, JTextField jtproducto, 
            JComboBox jtidalmacen, JComboBox jtidpasillo, JComboBox jtidanaquel, 
            JComboBox jtidbin, JTextField jtcantidad){
        try{
            jtidproducto.setText("");
            jtproducto.setText("");
            jtidalmacen.setSelectedIndex(0);
            jtidpasillo.setSelectedIndex(0);
            jtidanaquel.setSelectedIndex(0);
            jtidbin.setSelectedIndex(0);
            jtcantidad.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning Fields 002."+ex.getMessage(), ex);
        }
    }
    
    public void selecAlmacenes(JComboBox jcalmacenes, int idproducto, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select idalmacen, almacen from entradasproducto where idproducto='"+idproducto
                    +"' and idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                jcalmacenes.addItem(cc._resultSet().getString(1)+" - "+cc._resultSet().getString(2));
            }
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 001."+ex.getMessage(), ex);
        }
    }
    
    public void selecPasillo(JComboBox jcpasillos, int idalmacen, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select idpasillo, pasillo from pasillos where idalmacen='"+idalmacen
                    +"' and idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                jcpasillos.addItem(cc._resultSet().getString(1)+" - "+cc._resultSet().getString(2));
            }
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 002."+ex.getMessage(), ex);
        }
    }
    
    public void selectAnaquel(JComboBox jcanaqueles, int idpasillo, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select idanaquel from anaqueles where idpasillo='"+idpasillo
                    +"' idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                jcanaqueles.addItem(cc._resultSet().getString(1)+" - "+cc._resultSet().getString(2));
            }
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 003."+ex.getMessage(), ex);
        }
    }
    
    public void selectBin(JComboBox jcbines, int idanaquel, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select idbin, bin from bin where idanaquel='"+idanaquel
                    +"' idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                jcbines.addItem(cc._resultSet().getString(1)+" - "+cc._resultSet().getString(2));
            }
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 004."+ex.getMessage(), ex);
        }
    }
    
    public void consultaCantidades(JTable jtable, String buscar, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();            
            dtm.addColumn("Id Producto");
            dtm.addColumn("Producto");
            dtm.addColumn("Cantidad Actual");
            dtm.addColumn("Id Almacen");
            dtm.addColumn("Id Anaquel");
            dtm.addColumn("Id bin");
            
            String sql = "";
            
            if(buscar.equals("")){
                sql = "select entradasproducto.idproducto, productos.producto, "
                        + "entradasproducto.cant, entradasproducto.idalmacen, "
                        + "entradasproducto.idpasillo, entradasproducto.idanaquel, "
                        + "entradasproducto.idbin from entradasproducto "
                        + "inner join productos "
                        + "on entradasproducto.idproducto = productos.idproductos "
                        + "where entradasproducto.idempresa='"+idempresa+"'";
            }else{
                sql = "select entradasproducto.idproducto, productos.producto, "
                        + "entradasproducto.cant, entradasproducto.idalmacen, "
                        + "entradasproducto.idpasillo, entradasproducto.idanaquel, "
                        + "entradasproducto.idbin from entradasproducto "
                        + "inner join productos "
                        + "on entradasproducto.idproducto = productos.idproductos "
                        + "where producto like CONCAT('%',"+buscar+",'%')"
                        + " and entradasproducto.idempresa='"+idempresa+"'";
            }
            
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] data = new String[7];
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
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 005"+ex.getMessage(), ex);
        }
    }
    
}
