/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Pasillo;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_pasillo;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class pasillo {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_pasillo gs = new gs_pasillo();
    
    public void jbguardar(String pasillo, String descripcion, int idalmacen, 
            int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setPasillo(pasillo);
            gs.setDescripcion(descripcion);  
            gs.setIdalmacen(idalmacen);
            gs.setIdempleado(idempleado);
            gs.setParametroempresa(idempresa);
            String sql = "insert into pasillos(pasillo, descripcion, idalmacen, "
                    + "idempleado, idempresa)"
                    + "values('"+gs.getPasillo()
                    +"','"+ gs.getDescripcion()
                    +"','"+gs.getIdalmacen()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getParametroempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert Procedure 001."+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtpasillo, JTextArea jtdescripcion){
        try{
            jtpasillo.setText("");
            jtdescripcion.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning Fields 002."+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int idpasillo){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "delete from pasillos where idpasillo='"+idpasillo+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("Delete Procedure 003."+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(String pasillo, String descripcion, int idalmacen, 
            int idempleado, int idempresa, int idpasillo){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setPasillo(pasillo);
            gs.setDescripcion(descripcion);
            gs.setIdalmacen(idalmacen);
            gs.setIdempleado(idempleado);
            gs.setParametroempresa(idempresa);
            gs.setIdpasillo(idpasillo);
            
            String sql = "update pasillos set pasillo='"+gs.getPasillo()
                    +"', descripcion='"+gs.getDescripcion()
                    +"', idalmacen='"+gs.getIdalmacen()
                    +"', idempleado='"+gs.getIdempleado()
                    +"' where idpasillo='"+gs.getIdpasillo()+"' "                   
                    +"and idempresa='"+gs.getParametroempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Procedure 004."+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void mostrarRegistros(JTable jtable,  int idalmacen, int idproducto, 
            int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Pasillo");
            dtm.addColumn("Descripción");
            dtm.addColumn("Id Almacen");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            
            String sql = "";   
           
            if(idproducto == 0 && idalmacen == 0){
                sql = "select idpasillo, pasillo, descripcion, idalmacen, idempleado, idempresa "
                        + "from pasillos where idempresa='"+idempresa+"'"; 
            }if(idproducto != 0 && idalmacen != 0){
                sql = "select pasillos.idpasillo, "
                        + "pasillos.pasillo, "
                        + "pasillos.descripcion, "
                        + "pasillos.idalmacen, "
                        + "pasillos.idempleado, "
                        + "pasillos.idempresa "                        
                        + "from pasillos "
                        + "inner join entradasproducto "
                        + "on pasillos.idalmacen = entradasproducto.idalmacen "
                        + "where pasillos.idalmacen='"+idalmacen
                        + "' and entradasproducto.idproducto='"+idproducto
                        + "' and pasillos.idempresa='"+idempresa+"'";
            }else if(idalmacen != 0 && idproducto == 0){                       
                sql = "select idpasillo, pasillo, descripcion, idalmacen, idempleado, idempresa "
                    + "from pasillos where idalmacen='"+idalmacen
                    +"' and idempresa='"+idempresa+"'";
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
                }
                jtable.setModel(dtm);
            }cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 005."+ex.getMessage(), ex);
        }
    }    
}
