/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import C.Funciones.JTextAreaMessages;

/**
 *
 * @author jraraujo
 */
public class Conexion {
    
    public Conexion(){
       
    }
            
    public static Connection conexion=null;
    /*String database = "tittan4.0";
    String host = "127.0.0.1";
    String puerto = "3306";
    String user = "root";
    String passwd= "rooter";*/
    String zoneDateTime = "?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";    
    CallableStatement sp=null;
    ResultSet rs=null;
    JTextAreaMessages jtm = new JTextAreaMessages();            
    
    public Connection verificaConexionMySql(String host, String puerto, String user, char[] passwd)throws ClassNotFoundException{
        try{
            String strpassword = String.valueOf(passwd);
            Class<?> forName = Class.forName("com.mysql.cj.jdbc.Driver");            
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://"
                    +host+":"+puerto+"/"+"taurus"+zoneDateTime,user, strpassword);
            System.out.println(conexion);
            System.out.println("Conexion establecida con exito");            
        }
        catch(SQLException _ex){
            jtm.jTextAreaSQLError(_ex.getMessage(),_ex.getErrorCode(), _ex);
        }
        return conexion;
    }
    
    public Connection conexionMySql(String host, String puerto, String user, String passwd)throws ClassNotFoundException{
        try{
            Class<?> forName = Class.forName("com.mysql.cj.jdbc.Driver");            
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://"
                    +host+":"+puerto+"/"+"mydb"+zoneDateTime,user, passwd);
            System.out.println(conexion);
            System.out.println("Conexion establecida con exito");
            
        }
        catch(SQLException _ex){
            jtm.jTextAreaSQLError(_ex.getMessage(),_ex.getErrorCode(), _ex);            
        }
        return conexion;
    }    
    
    public CallableStatement _callablestatement(String _SQL){
        try {
            sp=conexion.prepareCall(_SQL);
        } catch (SQLException _ex) {
            System.out.println(_ex.getMessage());
            jtm.jTextAreaSQLError(_ex.getMessage(), _ex.getErrorCode(), _ex);
        }
        return sp;
    }
    
    public CallableStatement _executeProcedureSelect(){
        try{            
            sp.executeQuery();
        }catch(SQLException _ex){
            jtm.jTextAreaSQLError(_ex.getMessage(),_ex.getErrorCode(), _ex);
        }
        return sp;
    }
    
    public CallableStatement _executeProcedure(){
        try{            
            sp.executeUpdate();   
            //jtm.jTextAreaMessage("Proceso ejecutado con exito");
        }
        catch(SQLException _ex){
            jtm.jTextAreaSQLError(_ex.getMessage(),_ex.getErrorCode(), _ex);            
        }
        return sp;        
    }
    
    public CallableStatement _executeProcedureLogIn(){
        try{                        
            sp.executeUpdate();               
        }
        catch(SQLException _ex){
            jtm.jTextAreaSQLError(_ex.getMessage(),_ex.getErrorCode(), _ex);            
        }
        return sp;        
    }
    
    public ResultSet _resultSet(){
        try{
            rs = sp.getResultSet();
        }catch(SQLException _ex){
            jtm.jTextAreaError(_ex.getMessage(), _ex);
        }
        return rs;
    }
    
    public void desconectar(){
        conexion=null;
        System.out.println("Desconectado");
    }
    
}
