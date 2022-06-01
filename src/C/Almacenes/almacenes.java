/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Almacenes;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_almacenes;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class almacenes {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_almacenes gs = new gs_almacenes();
    
    public void jbguardar(String almacen, String descripcion, int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setAlmacen(almacen);
            gs.setDescripcion(descripcion);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql = "insert into almacenes(almacen, descripcion, idempleado, idempresa)"
                    + "values('"+gs.getAlmacen()
                    +"','"+ gs.getDescripcion()
                    +"','"+ gs.getIdempleado()
                    +"','"+ gs.getIdempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert Procedure 001."+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtalmacen, JTextArea jtdescripcion){
        try{
            jtalmacen.setText("");
            jtdescripcion.setText("");
            
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning Fields 002."+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int idalmacen, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "delete from almacenes where idalmacen='"+idalmacen
                    +"' and idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete Procedure. 003."+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(String almacen, String descripcion, int idempleado, 
            int idempresa, int idalmacen){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setAlmacen(almacen);
            gs.setDescripcion(descripcion);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            gs.setIdalmacen(idalmacen);
            String sql = "update almacenes set almacen='"+gs.getAlmacen()
                    +"', descripcion='"+gs.getDescripcion()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where idalmacen='"+gs.getIdalmacen()
                    +"' and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Procedure .004"+ex.getMessage(), ex);
        }
    }
    
    public void mostrarRegistros(JTable jtable, int idproducto, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Almacen");
            dtm.addColumn("Descripción");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            
            String sql = "";
            if(idproducto == 0){
                sql = "select * from almacenes where idempresa='"+idempresa+"'";
            }else{
                sql = "select * from almacenes where idproducto='"+idproducto+"' "
                        + "and idempresa='"+idempresa+"'";                
            }
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
            jtm.jTextAreaError("Select procedure 005."+ex.getMessage(), ex);
        }
    }
    
}
