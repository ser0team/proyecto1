/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Ventas;

import C.Funciones.JTextAreaMessages;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class listaproductos {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    
    public void muestraProductos(String filtro, JTable jtable) throws ClassNotFoundException{
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Producto");
            dtm.addColumn("Descripción");
            dtm.addColumn("Precio");
            jtable.setModel(dtm);
            
            String sql="";
            
            if(filtro.equals("")){
                sql="select idproductos, producto, descripcion, precio from productos";
            }else{
                sql="select idproductos, producto, descripcion, precio "
                        + "from productos where producto like CONCAT('"+filtro+"','%_')";
            }
            
            String datos[]= new String[4];
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0] = cc._resultSet().getString(1);
                    datos[1] = cc._resultSet().getString(2);
                    datos[2] = cc._resultSet().getString(3);
                    datos[3] = cc._resultSet().getString(4);
                    dtm.addRow(datos);
                }
            }            
            cc.desconectar();
        }catch(SQLException ex){
            jtm.jTextAreaSQLError("ERROR: 0009", ex.getErrorCode(), ex);
        }
    }
    
}
