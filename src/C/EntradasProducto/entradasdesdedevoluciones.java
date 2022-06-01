/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.EntradasProducto;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_entradasdevoluciones;
import java.sql.SQLException;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jraraujo
 */
public class entradasdesdedevoluciones {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_entradasdevoluciones gs = new gs_entradasdevoluciones();    
    int cantidad;
    
    public void jbguardar(int idcompra, int idalmacen, int idpasillo, int idanaquel, 
            int idbin, int idproducto, int cant, String comentarios, int idempleado, 
            int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdcompra(idcompra);
            gs.setIdalmacen(idalmacen);
            gs.setIdpasillo(idpasillo);
            gs.setIdanaquel(idanaquel);
            gs.setIdbin(idbin);
            gs.setIdproducto(idproducto);
            gs.setCant(cant);
            gs.setComentarios(comentarios);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql = "insert into entradasproducto(idcompra, idalmacen, idpasillo, "
                    + "idanaquel, idbin, idproducto, cant, comentarios, idempleado, idempresa"
                    + "values('"+gs.getIdcompra()
                    + "','"+gs.getIdalmacen()
                    + "','"+gs.getIdpasillo()
                    + "','"+gs.getIdanaquel()
                    + "','"+gs.getIdbin()
                    + "','"+gs.getIdproducto()
                    + "','"+gs.getCant()
                    + "','"+gs.getComentarios()
                    + "','"+gs.getIdempleado()
                    + "','"+gs.getIdempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert Procedure 001."+ex.getMessage(), ex);
        }            
    }
    
    public void jbcancelar(JTextField jtidentrada, JTextField jtcompras, JTextField jtidalmacen, 
            JTextField jtidpasillo, JTextField jtidanaquel, JTextField jtidbin, 
            JTextField jtidproducto, JTextField jtcantidad, JTextArea jtcomentarios){
        try{
            jtidentrada.setText("");
            jtcompras.setText("");
            jtidalmacen.setText("");
            jtidpasillo.setText("");
            jtidanaquel.setText("");
            jtidbin.setText("");
            jtidproducto.setText("");
            jtcantidad.setText("");
            jtcomentarios.setText("");
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning Fields 002."+ex.getMessage(), ex);
        }
    }
    
    public int obtenCantidad(int identradaproducto, int idalmacen, int idpasillo, 
            int idanaquel, int idbin, int idproducto){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select cant from entradasproducto "
                    + "where identradaproducto='"+identradaproducto
                    + " and idalmacen='"+idalmacen
                    + " and idpasillo='"+idpasillo
                    + " and idanaquel='"+idanaquel
                    + " and idbin='"+idbin
                    + " and idproducto='"+idproducto+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                cantidad = Integer.parseInt(cc._resultSet().getString(1));
            }
        }catch(ClassNotFoundException | NumberFormatException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 003."+ex.getMessage(), ex);
        }
        return cantidad;
    }
    
    public void jbmodificar(int idcompra, int idalmacen, int idpasillo, int idanaquel, 
            int idbin, int idproducto, int cant, String comentarios, int idempleado, 
            int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdcompra(idcompra);
            gs.setIdalmacen(idalmacen);
            gs.setIdpasillo(idpasillo);
            gs.setIdanaquel(idanaquel);
            gs.setIdbin(idbin);
            gs.setIdproducto(idproducto);
            gs.setCant(cant);
            gs.setComentarios(comentarios);
            gs.setIdempleado(idempleado);
            gs.setIdempresa(idempresa);
            String sql = "update entradasproducto set cantidad='"+(cantidad+gs.getCant())
                    +"', comentarios='"+gs.getComentarios()
                    +"', idempleado='"+gs.getIdempleado()
                    +"', idempresa='"+gs.getIdempresa()
                    +"' where idcompra='"+gs.getIdcompra()
                    +"' and idalmacen='"+gs.getIdalmacen()
                    +"' and idpasillo='"+gs.getIdpasillo()
                    +"' and idanaquel='"+gs.getIdanaquel()
                    +"' and idbin='"+gs.getIdbin()
                    +"' and idproducto='"+gs.getIdproducto()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: UpdateProcedure 004."+ex.getMessage(), ex);
        }
    }
    
    
}
