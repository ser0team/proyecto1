/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Empleados;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_empleados;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class empleados {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm =  new JTextAreaMessages();
    gs_empleados gs = new gs_empleados();
    
    public void jbguardar(String nombre, String paterno, String materno,
            JDateChooser fnacimiento, String direccion, String telefono,
            String correo, int estatus, String rol, String usuario, String contrasenia, 
            int idempleado, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            
            java.sql.Date fenacimiento = new java.sql.Date(fnacimiento.getDate().getTime());
                        
            gs.setNombre(nombre);
            gs.setPaterno(paterno);
            gs.setMaterno(materno);
            gs.setFnacimiento(fenacimiento);
            gs.setDireccion(direccion);                    
            gs.setTelefono(telefono);
            gs.setCorreo(correo);
            gs.setEstatus(estatus);
            gs.setRol(rol);
            gs.setUsuario(usuario);
            gs.setContrasenia(contrasenia);
            gs.setIdusuario(idempleado);
            gs.setIdcompania(idempresa);
            String sql="insert into empleados("
                    + "nmbr,"
                    + "ptrn,"
                    + "mtrn,"
                    + "f_ncmnt,"
                    + "drccn,"                    
                    + "tlfn,"
                    + "crr,"
                    + "stts,"
                    + "rl,"
                    + "sr,"
                    + "cntrsn,"
                    + "idusuario,"
                    + "idempresa)values('"+gs.getNombre()
                    +"','"+gs.getPaterno()
                    +"','"+gs.getMaterno()
                    +"','"+gs.getFnaciemiento()
                    +"','"+gs.getDireccion()
                    +"','"+gs.getTelefono()
                    +"','"+gs.getCorreo()
                    +"','"+gs.getEstatus()
                    +"','"+gs.getRol()
                    +"','"+gs.getUsuario()
                    +"','"+gs.getContrasenia()
                    +"','"+gs.getIdusuario()
                    +"','"+gs.getIdcompania()
                    +"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert employee 001. "+ex.getMessage(), ex);
        }
    }
    
    public void jbeliminar(int id, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdempleado(id);
            gs.setIdcompania(idempresa);
            String sql="delete from empleados where idempleado='"+gs.getIdempleado()
                    +"' and idempresa='"+gs.getIdcompania()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete employee 002. "+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(String nombre, String paterno, String materno,
            Date fnacimiento, String direccion, String telefono,
            String correo, int estatus, String rol, String usuario, String contrasenia, 
            int idusuario, int idempresa, int idempleado){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
                
            gs.setNombre(nombre);
            gs.setPaterno(paterno);
            gs.setMaterno(materno);
            gs.setFnacimiento(fnacimiento);
            gs.setDireccion(direccion);
            gs.setTelefono(telefono);
            gs.setCorreo(correo);
            gs.setEstatus(estatus);
            gs.setRol(rol);
            gs.setUsuario(usuario);
            gs.setContrasenia(contrasenia);
            gs.setIdusuario(idusuario);
            gs.setIdcompania(idempresa);
            gs.setIdempleado(idempleado);
            
            String sql="update empleados set nmbr='"+gs.getNombre()
                    +"',ptrn='"+gs.getPaterno()
                    +"',mtrn='"+gs.getMaterno()
                    +"',f_ncmnt='"+gs.getFnaciemiento()
                    +"',drccn='"+gs.getDireccion()
                    +"',tlfn='"+gs.getTelefono()
                    +"',crr='"+gs.getCorreo()
                    +"',stts='"+gs.getEstatus()
                    +"',rl='"+gs.getRol()
                    +"',usuario='"+gs.getUsuario()
                    +"',cntrsn='"+gs.getContrasenia()
                    +"',idusuario='"+gs.getIdusuario()
                    +"',idempresa='"+gs.getIdcompania()
                    +"' where idempleado='"+gs.getIdempleado();
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete employee 003. "+ex.getMessage(), ex);
        }
    }

    public void muestraRegistros(JTable jtable, String buscar, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Nombre");
            dtm.addColumn("Paterno");
            dtm.addColumn("Materno");
            dtm.addColumn("F. Nacimiento");
            dtm.addColumn("F. Registro");
            dtm.addColumn("Usuario");
            dtm.addColumn("Rol"); 
            dtm.addColumn("Id Empresa");
            jtable.setModel(dtm);
            
            String sql="";
            
            if(buscar.equals("")){
                sql = "select idempleado, nombre, paterno, materno, fnacimiento, "
                        + "fregistro, usuario, rol, idempresa "
                        + "from empleados "
                        + "where idempresa='"+idempresa+"'";
            }else{
                sql = "select idempleado, nombre, paterno, materno, fnacimiento, "
                        + "fregistro, usuario, rol, idempresa from empleados where empleado "
                        + "like CONCAT('"+buscar+"','%_') and idempresa='"+idempresa+"'";
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
                    datos[0] = String.valueOf(cc._resultSet().getInt(1));
                    datos[1] = cc._resultSet().getString(2);
                    datos[2] = cc._resultSet().getString(3);
                    datos[3] = cc._resultSet().getString(4);
                    datos[4] = cc._resultSet().getString(5);
                    datos[5] = cc._resultSet().getString(6);
                    datos[6] = cc._resultSet().getString(7);
                    datos[7] = cc._resultSet().getString(8);
                    datos[8] = cc._resultSet().getString(9);
                    dtm.addRow(datos);
                }
                cc.desconectar();
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Delete employee 004. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }   
    
    public void limpiar(JTextField jtnombre, JTextField jtpaterno, JTextField jtmaterno,
            JDateChooser jdcnacimiento, JTextField jtdireccion, JTextField jttelefono,
            JTextField jtcorreo, JCheckBox jchkestatus, JComboBox jcbrol){
        try{
            jtnombre.setText("");
            jtpaterno.setText("");
            jtmaterno.setText("");
            jdcnacimiento.setDate(null);
            jtdireccion.setText("");
            jttelefono.setText("");
            jtcorreo.setText("");
            jchkestatus.setSelected(false);
            jcbrol.setSelectedIndex(0);
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning values 005. "+ex.getMessage(), ex);
        }
    }        
    
    public void mostrarRoles(JComboBox jcbox){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            while(cc._resultSet().next()){
                jcbox.addItem(cc._resultSet().getString(1));
            }
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Select procedure 006."+ex.getMessage(), ex);
        } catch (SQLException ex) {
            Logger.getLogger(empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
