/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Caja;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_caja;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class caja {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_caja gs = new gs_caja();
    
    public void jbguardar(double caja, String fecha, int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");     
            
            gs.setCaja(caja);
            gs.setFecha(fecha);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql = "insert into caja(caja, fecha, idempleado, idempresa)"
                    + "values('"+gs.getCaja()
                    +"','"+gs.getFecha()
                    +"','"+gs.getIdempleado()
                    +"','"+gs.getIdempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert procedure 001. "+ex.getMessage(), ex);
        }
    }
    
    public void jbcancelar(JTextField jtcaja){
        try{
            jtcaja.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleanig procedure 002. "+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int idcaja, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            
            gs.setIdcaja(idcaja);
            String sql = "delete from caja where idcaja='"+gs.getIdcaja()
                    +"' and idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete procedure 003. "+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(double caja, String fecha, int idempleado, int idempresa, 
            int idcaja){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
                     
            gs.setCaja(caja);
            gs.setFecha(fecha);
            gs.setIdempleado(idempleado);            
            gs.setIdempresa(idempresa);
            gs.setIdcaja(idcaja);
            String sql = "update caja set caja='"+gs.getCaja()
                    +"', fecha='"+gs.getFecha()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where idcaja='"+gs.getIdcaja()
                    +"' and idempresa='"+gs.getIdempresa()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete procedure 004. "+ex.getMessage(), ex);
        }
    }
    
    public void muestraRegistros(JTable jtable, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel  dtm = new DefaultTableModel();            
            dtm.addColumn("Id");
            dtm.addColumn("Caja");
            dtm.addColumn("Fecha");
            dtm.addColumn("Id Empleado");
            dtm.addColumn("Id Empresa");
            jtable.setModel(dtm);
            
            String sql = "select * from caja where idempresa='"+idempresa+"'";
            
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
                    datos[1] = String.valueOf(cc._resultSet().getDouble(2));
                    datos[2] = cc._resultSet().getString(3);
                    datos[3] = String.valueOf(cc._resultSet().getInt(4));
                    datos[4] = cc._resultSet().getString(5);
                    dtm.addRow(datos);
                }
            }jtable.setModel(dtm);
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 005. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
}
