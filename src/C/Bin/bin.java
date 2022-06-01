/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Bin;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_bin;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class bin {
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_bin gs = new gs_bin();
    
    public void jbguardar(String bin, String descripcion, int idanaquel, int idempleado,
            int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setBin(bin);
            gs.setDescripcion(descripcion);
            gs.setIdanaquel(idanaquel);
            gs.setIdempleado(idempleado);
            gs.setIdparametroempresa(idempresa);
            String sql = "insert into bins(bin, descripcion, idanaquel, idempleado, "
                    + "idempresa)"
                    + "values('"+gs.getBin()
                    +"','"+ gs.getDescripcion()
                    +"','"+ gs.getIdanaquel()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getIdparametroempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert Procedure 001."+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtbin, JTextArea jtdescripcion, JTextField jtidanaquel){
        try{
            jtbin.setText("");
            jtdescripcion.setText("");
            jtidanaquel.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning Fields 002."+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int idbin, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "delete from bins where idbin='"+idbin
                    +"' and idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete Procedure 003."+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(String bin, String descripcion, int idanaquel, 
            int idempleado, int idempresa, int idbin){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setBin(bin);
            gs.setDescripcion(descripcion);
            gs.setIdanaquel(idanaquel);
            gs.setIdempleado(idempleado);
            gs.setIdparametroempresa(idempresa);
            gs.setIdbin(idbin);            
            String sql = "update bins set bin='"+gs.getBin()
                    +"', descripcion='"+gs.getDescripcion()
                    +"', idnanaquel='"+gs.getIdanaquel()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdparametroempresa()
                    +"' where idbin='"+gs.getIdbin()
                    +"' and idempresa='"+gs.getIdparametroempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Procedure 004."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarRegistros(JTable jtable, int idanaquel, int idproducto, 
            int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Bin");
            dtm.addColumn("Descripción");
            dtm.addColumn("Id Anaquel");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            String sql = "";
            if(idproducto == 0 && idanaquel == 0){
                sql = "select * from bin where idempresa='"+idempresa+"'";
            }if(idproducto != 0 && idanaquel != 0){
                sql = "select bin.idbin, "
                        + "bin.bin, "
                        + "bin.descripcion, "
                        + "bin.idanaquel, "
                        + "bin.idempleado, "
                        + "bin.idempresa "
                        + "from bin "
                        + "inner join entradasproducto "
                        + "on bin.idanaquel = entradasproducto.idbin "
                        + "where bin.idanaquel='"+idanaquel
                        + "' and entradasproducto.idproducto='"+idproducto
                        + "' and bin.idempresa='"+idempresa+"'";
            }else if(idanaquel != 0 && idproducto == 0){
                sql = "select * from anaqueles where idanaquel='"+idanaquel
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
