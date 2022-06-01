/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Categorias;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_categorias;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class categorias {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_categorias gs = new gs_categorias();
    
    public void jbguardar(String categoria, String descripcion, int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setCategoria(categoria);
            gs.setDescripcion(descripcion);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql = "insert into categorias(categoria, descripcion, idempleado, idempresa)"
                    + "values('"+gs.getCategoria()
                    +"','"+gs.getDescripcion()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getIdempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Save procedure 001. "+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtcategoria, JTextArea jtdescripcion){
        try{
            jtcategoria.setText("");
            jtdescripcion.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Save procedure 002. "+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int id, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setId(id);
            String sql = "delete from categorias where idcategoria='"+gs.getId()
                    +"' and idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Save procedure 003. "+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(String categoria, String descripcion, int idempleado, 
            int idempresa, int id){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setCategoria(categoria);
            gs.setDescripcion(descripcion);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            gs.setId(id);
            String sql = "update categorias  set categoria='"+gs.getCategoria()
                    +"', descripcion='"+gs.getDescripcion()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where idcategoria='"+gs.getId()
                    +"' and idempresa='"+gs.getIdempresa()+"'";
                    
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Save procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public void muestraRegistros(JTable jtable, String buscar) throws SQLException{
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Categoria");
            dtm.addColumn("Descripción");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            jtable.setModel(dtm);
            
            String sql="";
            
            if(buscar.equals("")){
                sql = "select * from categorias";
            }else{
                sql = "select * from categorias where categoria like CONCAT('%',"+buscar+",'%')";
            }
            
            String[] datos = new String[5];
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
                    dtm.addRow(datos);
                }
            }
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Select procedure 005. "+ex.getMessage(), ex);
        }
    }   
    
    public void muestraCategorias(JTable jtable, String buscar) throws SQLException{
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Categoria");            
            jtable.setModel(dtm);
            
            String sql="";
            
            if(buscar.equals("")){
                sql = "select idcategoria, categoria from categorias";
            }else{
                sql = "select idcategoria, categoria from categorias where categoria like CONCAT('"+buscar+"','%_')";
            }
            String[] datos = new String[2];
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
                    dtm.addRow(datos);
                }
            }
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Select procedure 005. "+ex.getMessage(), ex);
        }
    }
}
