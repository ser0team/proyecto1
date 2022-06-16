/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Corte;

import C.Funciones.JTextAreaMessages;
import Frames.Corte.Corte;
import GetSet.gs_corte;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class corte {
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    public static double caja, corte, cortefinal, total, compras;
    gs_corte gs = new gs_corte();
    
    public void obtenerCaja(JDateChooser fecha, JTextField jlcaja, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            java.sql.Date fcaja = new java.sql.Date(fecha.getDate().getTime());
            String sql = "Select caja.caja from caja where caja.fechacorte='"+fcaja
                    +"' and caja.idempresa='"+idempresa+"'";

            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();

            while(cc._resultSet().next()){       
                jlcaja.setText(cc._resultSet().getString(1));                
                caja = cc._resultSet().getDouble(1);
                System.out.println(String.valueOf("Caja: "+caja));
            }            
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 001. "+ex.getMessage(), ex);
        }
    }
    
    public void obtenCompras(JDateChooser jdcfecha, JTextField jlcompras, int idempresa){
         try{
             cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
             
             java.sql.Date _fecha = new java.sql.Date(jdcfecha.getDate().getTime());
             
             gs.setFechacom(_fecha);
             String sql = "select compras.total from compras where compras.fechacom='"+gs.getFechacom()
                     +"' and compras.idempresa='"+idempresa+"'";
             cc._callablestatement(sql);
             cc._executeProcedureSelect();
             cc._resultSet();
             if(cc._resultSet().first() == false){
                 jlcompras.setText("0.00");
             }else{
                 cc._resultSet().beforeFirst();
                 while(cc._resultSet().next()){
                     jlcompras.setText(cc._resultSet().getString(1));
                     compras = Double.parseDouble(cc._resultSet().getString(1));
                 }
             }cc.desconectar();
         }catch(ClassNotFoundException | SQLException ex){
             jtm.jTextAreaError("ERROR: Select procedure 006. "+ex.getMessage(), ex);
         }
    }
    
    public void obtenerTotal(JDateChooser fecha, JTextField jltotal, 
            JTextField jlcorte, JTextField jlcompras, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"); 
            java.sql.Date ftotal = new java.sql.Date(fecha.getDate().getTime());
            System.out.println(ftotal);               

            String sql = "select totales.idventa, totales.total, ventas.fechaventa from totales " +
            "inner join ventas on totales.idventa = totales.idventa where ventas.fechaventa='"+ftotal
                    +"' and totales.idempresa='"+idempresa+"'";

            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();

            while(cc._resultSet().next()){             
                jltotal.setText(cc._resultSet().getString(2));                    
                total = cc._resultSet().getDouble(2);
                System.out.println(total);
            }
            System.out.println(compras);
            if(String.valueOf(compras).equals("0.0")){
                cortefinal = total;
            }else if(!String.valueOf(compras).equals("0.0")){
                corte = caja+=compras;
                cortefinal = total -= corte;
            }
                                   
            jlcorte.setText(String.valueOf(cortefinal));
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 002. "+ex.getMessage(), ex);
        }
    }
    
    public void cerrarcorte(double corte, JDateChooser fechacorte, int idusuario, 
            int idempresa){
        try{
            java.sql.Date fecha = new java.sql.Date(fechacorte.getDate().getTime());
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"); 
            gs.setCorte(corte);
            gs.setFechacorte(fecha);
            gs.setIdusuario(idusuario);
            gs.setIdempresa(idempresa);
            String sql = "insert into cortes(corte, "
                    + "fecha_corte, "
                    + "idusuario,"
                    + "idempresa)values('"+gs.getCorte()
                    +"','"+gs.getFechacorte()
                    +"','"+gs.getIdusuario()
                    +"','"+gs.getIdempresa()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert procedure 003. "+ex.getMessage(), ex);
        }
    }
    
    public void muestraCortes(JTable jtable, String de, String hasta, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"); 
            
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Corte");
            dtm.addColumn("Fecha");
            dtm.addColumn("Id Usuario");
            dtm.addColumn("Id Empresa");
            jtable.setModel(dtm);
            
            String sql = "";
            
            if(de.equals("") || hasta.equals("")){
                sql = "select * from cortes";
            }else{
                java.sql.Date _de = new java.sql.Date(Corte.jdcde.getDate().getTime());
                java.sql.Date _hasta = new java.sql.Date(Corte.jdchasta.getDate().getTime());
                
                sql = "select * from cortes where fechacorte between '"+_de+"' and '"+_hasta
                        +"' idempresa='"+idempresa+"'";
            }
            
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String datos[] = new String[5];
            if(cc._resultSet().first() == false){
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    datos[0] = cc._resultSet().getString(1);
                    datos[1] = cc._resultSet().getString(2);
                    datos[2] = cc._resultSet().getString(3);
                    datos[3] = cc._resultSet().getString(4);
                    datos[4] = cc._resultSet().getString(5);
                    dtm.addRow(datos);
                }
                cc.desconectar();
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 004. "+ex.getMessage(), ex);
        }
    }
    
     public void filtrarCorteFecha(JTable jtable, JDateChooser fechade, 
             JDateChooser fechahasta, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"); 
            DefaultTableModel  dtm = new DefaultTableModel();
            dtm.addColumn("Id Corte");
            dtm.addColumn("Corte");
            dtm.addColumn("Fecha Corte");
            dtm.addColumn("Id Empleado");
            jtable.setModel(dtm);
            
            String sql = "";
            if(fechade.getDate() == null || fechahasta.getDate() == null){
                sql = "select * from cortes where idempresa='"+idempresa+"'";
            }else{
                java.sql.Date _fde = new java.sql.Date(fechade.getDate().getTime());
                java.sql.Date _fhasta = new java.sql.Date(fechahasta.getDate().getTime());

                sql = "select * from cortes where fechacorte between '"+_fde+"' and '"+_fhasta
                        +"' idempresa='"+idempresa+"'";
            }
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] datos = new String[4];
            while(cc._resultSet().next()){                
                datos[0] = cc._resultSet().getString(1);
                datos[1] = cc._resultSet().getString(2);
                datos[2] = cc._resultSet().getString(3);
                datos[3] = cc._resultSet().getString(4);
                dtm.addRow(datos);
            }            
            cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select procedure 005. "+ex.getMessage(), ex);
        }
    }    
}