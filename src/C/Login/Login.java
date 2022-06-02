/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Login;

import C.Funciones.JTextAreaMessages;
import C.Conexion.Conexion;
import C.Funciones.Instancias;
import static Frames.Login.jtcont;
import Frames.Menu;
import Frames.Parametros.Parametros;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jraraujo
 */
public class Login {
    
    JTextAreaMessages jtm = new JTextAreaMessages();
    Conexion cc = new Conexion();
    GetSet.gs_login gs = new GetSet.gs_login();
    Instancias inst = new Instancias();
    public static int _idusu;
    public static String cont, _usu;
    public boolean valorusuario, valorcontrasenia, usuariocomun, registroempresa;    
    Frames.Login _login;
    
    public boolean verificaUsuario(String usuario, String contrasenia, String acceso){
        if(usuario.equals("")||contrasenia.equals("")){
            jtm.jTextAreaMessage("ERROR: Usuario o contraseña invalida");
            valorusuario = false;
            System.exit(0);          
        }else if(usuario.equals("Administrador") && acceso.equals("adm")){
            if(obtenAdministrador(contrasenia) == true){
                valorusuario = true;
                valorcontrasenia = true;               
                Menu.idusu = 1000;                
                Menu.usu = "Administrador"; 
                Menu.rol = "Administrador"; 
                inst.getInstanciasDatosEmpresa();
                registroempresa = true;
                if(_login != null){
                    _login.dispose();
                }
            }            
        }else if(usuario.equals("Administrador")&& acceso.equals("usu")){
            if(obtenUsuario(usuario, contrasenia) == true){
                valorusuario = true;                                             
            }else{
                System.exit(0);
            }
        }else if(!usuario.equals("Administrador") && acceso.equals("usu")){
            if(obtenUsuario(usuario, contrasenia)){
                valorusuario = true;
                usuariocomun = true;
                Parametros.valorusuario = usuariocomun;
            }else{
                System.exit(0);
            }
        }
        return valorusuario;
    }
    
    private boolean obtenAdministrador(String contra_){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql="select cntrsn from administrador";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){
                jtm.jTextAreaMessage("ERROR: Contrasenia. 0003");
                return false;
            }else if(cc._resultSet().first() ==  true){
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){                    
                    cont = cc._resultSet().getString(1);
                    if(contra_.equals(cont)){
                        return true;                    
                    }else{
                        jtm.jTextAreaMessage("ERROR: Usuario o contraseña incorrectos. 0006");
                        return false;                        
                    }
                }
            }cc.desconectar();
        }catch(SQLException ex){
            jtm.jTextAreaSQLError("ERROR:"+ex.getMessage()+". 0007", ex.getErrorCode(), ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean obtenUsuario(String usuario, String contrasenia){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql="select idusuario, sr, rl from usuarios where usuario='"+usuario+"'";
            cc._callablestatement(sql);            
            cc._executeProcedureSelect();
            if(cc._resultSet().first()==false){
                jtm.jTextAreaMessage("ERROR: usuario o contraseña invalidos");
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    _idusu = cc._resultSet().getInt(1);
                    Menu.idusu = _idusu;
                    gs.setIdusuario(_idusu);
                    _usu = cc._resultSet().getString(2);
                    Menu.usu = _usu;
                    System.out.println("_usu: "+_usu);
                    gs.setUsuario(_usu);
                    Menu.rol = cc._resultSet().getString(3);
                    if(_usu.equals(usuario)){
                        obtencontraseniaUsuario(usuario, contrasenia);   
                        valorusuario = true;
                    }else{
                        jtm.jTextAreaMessage("ERROR: Usuario o contraseña incorrectos. 0007");
                        valorusuario = false;
                    }
                }
            }cc.desconectar();
        }catch(SQLException ex){
            jtm.jTextAreaSQLError("ERROR:"+ex.getMessage()+". 0004", ex.getErrorCode(), ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorusuario;
    }
    
    public boolean obtencontraseniaUsuario(String usuario, String contra){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql="select cntrsn from usuarios where sr='"+usuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first()==false){
                jtm.jTextAreaMessage("ERROR: usuario o contraseña invalidos");
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    cont = cc._resultSet().getString(1);
                    char[] charcont = jtcont.getPassword();
                    String strcont = new String(charcont);
                    if(strcont.equals(cont)){
                        valorcontrasenia = true;                        
                    }else{
                        valorcontrasenia = false;
                    }
                }
            }cc.desconectar();
        }catch(SQLException ex){
            jtm.jTextAreaSQLError("ERROR:"+ex.getMessage()+". 0005", ex.getErrorCode(), ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorcontrasenia;
    }
    
}
