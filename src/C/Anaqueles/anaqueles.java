/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Anaqueles;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_anaqueles;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class anaqueles {
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_anaqueles gs = new gs_anaqueles();
        
    public void jbguardar(String anaquel, String descripcion, int idpasillo, 
            int idempleado, int idempresa){
        try{
            gs.setAnaquel(anaquel);
            gs.setDescripcion(descripcion);
            gs.setIdpasillo(idpasillo);
            gs.setIdempleado(idempleado);
            gs.setIdparametroempresa(idempresa);
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "insert into anaqueles(anaquel, descripcion, pasillo, idempleado, idempresa)"
                    + "values('"+gs.getAnaquel()
                    +"','"+ gs.getDescripcion()
                    +"','"+ gs.getIdpasillo()
                    +"','"+ gs.getIdempleado()
                    +"','"+ gs.getIdparametroempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert Procedure 001."+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtanaquel, JTextArea jtdescripcion, 
            JTextField jtidpasillo){
        try{
            jtanaquel.setText("");
            jtdescripcion.setText("");
            jtidpasillo.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning Fields 002."+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int idanaquel, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "delete from anaqueles where idanaquel='"+idanaquel
                    +"' and idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete Procedure 003."+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(String anaquel, String descripcion, int idpasillo, 
            int idempleado, int idempresa, int idanaquel){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setAnaquel(anaquel);
            gs.setDescripcion(descripcion);
            gs.setIdpasillo(idpasillo);
            gs.setIdempleado(idempleado);
            gs.setIdparametroempresa(idempresa);
            gs.setIdanaquel(idanaquel);
            String sql = "update anaqueles set anaquel='"+gs.getAnaquel()
                    +"', descripcion='"+gs.getDescripcion()
                    +"', idpasillo='"+gs.getIdpasillo()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdparametroempresa()
                    +"' where idanaquel='"+gs.getIdanaquel()
                    +"' and idempresa='"+gs.getIdparametroempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Procedure 004."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarRegistros(JTable jtable, int idpasillo, int idproducto, 
            int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Anaquel");
            dtm.addColumn("Descripción");
            dtm.addColumn("Id Pasillo");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            String sql = "";
            if(idproducto == 0 && idpasillo == 0){
                sql = "select * from anaqueles where idempresa='"+idempresa+"'";
            }if(idproducto !=0 && idpasillo != 0){
                sql = "select anaqueles.idanaquel, "
                        + "anaqueles.anaquel, "
                        + "anaqueles.descripcion,"
                        + "anaqueles.idpasillo,"
                        + "anaqueles.idempleado,"
                        + "anaqueles.idempresa "
                        + "from anaqueles "
                        + "inner join entradasproducto "
                        + "on anaqueles.idpasillo = entradasproducto.idpasillo "
                        + "where anaqueles.idpasillo='"+idpasillo
                        + "' and entradasproducto.idproducto='"+idproducto
                        + "' and anaqueles.idempresa='"+idempresa+"'";
            }else if(idpasillo != 0 && idproducto == 0){
                sql = "select * from anaqueles where idpasillo='"+idpasillo
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
