/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Parametros;

import C.Funciones.JTextAreaMessages;
import C.Licencia.licencia;
import GetSet.gs_datosempresa;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jraraujo
 */
public class datosempresa {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    C.Conexion.ConexionRemota ccr = new C.Conexion.ConexionRemota();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_datosempresa gs = new gs_datosempresa();
    public static boolean cnregistro;
    String rfc, _licencia;
    
    public void jbguardar(String razon, String rfc, String pais, String estado,
            String municipio, String colonia, String direccion, String noext, 
            String noint, String codpos, String telefono, String correo, String pagina){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setRazon(razon);
            gs.setRfc(rfc);
            gs.setPais(pais);
            gs.setEstado(estado);
            gs.setMunicipio(municipio);
            gs.setColonia(colonia);
            gs.setDireccion(direccion); //Campo de calle
            gs.setNoext(noext);
            gs.setNoint(noint);
            gs.setCodpos(codpos);
            gs.setTelefono(telefono);
            gs.setCorreo(correo);
            gs.setPagina(pagina);
            String sql = "insert into empresas(rznscl, rfc, ps, std, "
                    + "mncp, cdps, cln, cll, nmrxtrr, nmrntrr, tlfn, crr, "
                    + "pgn)values('"+gs.getRazon()
                    +"','"+gs.getRfc()
                    +"','"+gs.getPais()
                    +"','"+gs.getEstado()
                    +"','"+gs.getMunicipio()                    
                    +"','"+gs.getCodpos()
                    +"','"+gs.getColonia()
                    +"','"+gs.getDireccion() //Campo de calle
                    +"','"+gs.getNoext()
                    +"','"+gs.getNoint()                    
                    +"','"+gs.getTelefono()
                    +"','"+gs.getCorreo()
                    +"','"+gs.getPagina()+"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert Procedure 001."+ex.getMessage(), ex);
        }    
    }
    
    public void jbcancelar(JTextField jtrazon, JTextField jtrfc, JTextField jtpais, 
            JTextField jtestado, JTextField jtmunicipio, JTextField jtcolonia, 
            JTextField jtdireccion, JTextField jtnoext, JTextField jtnoint, JTextField jtcodpos,
            JTextField jttelefono, JTextField jtcorreo, JTextField jtpagina){
        try{
            jtrazon.setText("");
            jtrfc.setText("");
            jtpais.setText("");
            jtestado.setText("");
            jtmunicipio.setText("");
            jtcolonia.setText("");
            jtdireccion.setText("");
            jtnoext.setText("");
            jtnoint.setText("");
            jtcodpos.setText("");
            jttelefono.setText("");
            jtcorreo.setText("");
            jtpagina.setText("");
            
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Cleaning Fields 002."+ex.getMessage(), ex);
        }            
    }
    
    public void jbeliminar(int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "delete from empresas where idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete Procedure 003."+ex.getMessage(), ex);
        }
    }
    
    public void jbmodificar(String razon, String rfc, String pais, String estado,
            String municipio, String codpos, String colonia, String calle, String noext, 
            String noint,  String telefono, String correo, String pagina, int jtidrazon){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setRazon(razon);
            gs.setRfc(rfc);
            gs.setPais(pais);
            gs.setEstado(estado);
            gs.setMunicipio(municipio);
            gs.setCodpos(codpos);
            gs.setColonia(colonia);
            gs.setDireccion(calle);
            gs.setNoext(noext);
            gs.setNoint(noint);            
            gs.setTelefono(telefono);
            gs.setCorreo(correo);
            gs.setPagina(pagina);
            
            String sql = "update empresas set rznscl='"+gs.getRazon()
                    +"', rfc='"+gs.getRfc()
                    +"', ps='"+gs.getPais()
                    +"', std='"+gs.getEstado()
                    +"', mncp='"+gs.getMunicipio()
                    +"', cdps='"+gs.getCodpos()
                    +"', cln='"+gs.getColonia()
                    +"', cll='"+gs.getDireccion()
                    +"', nmrntrr='"+gs.getNoext()
                    +"', nmrntrr='"+gs.getNoint()                    
                    +"', tlfn='"+gs.getTelefono()
                    +"', crr='"+gs.getCorreo()
                    +"', pgn='"+gs.getPagina()
                    +"' where idempresa='"+gs.getIdrazon()+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Insert Procedure 004."+ex.getMessage(), ex);
        }    
    }
    
    public void mostrarEmpresas(JTable jtable){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Empresa");
            dtm.addColumn("Razón Social");
            dtm.addColumn("R.F.C.");
            dtm.addColumn("Pais");
            dtm.addColumn("Estado");
            dtm.addColumn("Municipio");
            dtm.addColumn("Codigo Postal");
            dtm.addColumn("Calle");
            dtm.addColumn("No. ext");
            dtm.addColumn("No. Int");            
            dtm.addColumn("Teléfono");
            dtm.addColumn("Correo");
            dtm.addColumn("Pagina");
            
            String sql = "select * from empresas";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] data = new String[14];
            if(cc._resultSet().first() == false){
                jtm.jTextAreaMessage("No hay empresas registradas");
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    data[0] = cc._resultSet().getString(1);
                    data[1] = cc._resultSet().getString(2);
                    data[2] = cc._resultSet().getString(3);
                    data[3] = cc._resultSet().getString(4);
                    data[4] = cc._resultSet().getString(5);
                    data[5] = cc._resultSet().getString(6);
                    data[6] = cc._resultSet().getString(7);
                    data[7] = cc._resultSet().getString(8);
                    data[8] = cc._resultSet().getString(9);
                    data[9] = cc._resultSet().getString(10);
                    data[10] = cc._resultSet().getString(11);
                    data[11] = cc._resultSet().getString(12);
                    data[12] = cc._resultSet().getString(13);
                    data[13] = cc._resultSet().getString(14);
                    dtm.addRow(data);
                }jtable.setModel(dtm);
            }cc.desconectar();           
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 005."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarEmpresasLogin(JTable jtable){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id Empresa");
            dtm.addColumn("Razón Social");
            dtm.addColumn("R.F.C.");
                        
            String sql = "select idempresa, rznscl, rfc from empresas";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] data = new String[3];
            if(cc._resultSet().first() == false){
                jtm.jTextAreaMessage("No hay empresas registradas");
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    data[0] = cc._resultSet().getString(1);
                    data[1] = cc._resultSet().getString(2);
                    data[2] = cc._resultSet().getString(3);                    
                    dtm.addRow(data);
                }jtable.setModel(dtm);
            }cc.desconectar();
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 005."+ex.getMessage(), ex);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    
    public void registraProducto(String razonsocial, String rfc, String uuid, 
            String hrdwr, String prcssr_sn, String prcssr_id, String prcssr_ct, 
            String lcnc, int cntd){
        try{
            ccr.conexionMySql();
            
            gs.setRazon(razonsocial);
            gs.setRfc(rfc);
            gs.setUuid(uuid);
            gs.setHardware(hrdwr);
            gs.setProcessor_sn(prcssr_sn);
            gs.setProcessor_id(prcssr_id);
            gs.setProcessor_ct(prcssr_ct);
            gs.setLcnc(lcnc);
            gs.setCntd(cntd);
            String sql = "insert into himawari_registro(rznscl, rfc, uuid, "
                    + "hrdwr, prcssr_sn, prcssr_id, prcssr_ct, lcnc, cntd)"
                    + "values('"+gs.getRazon()
                    +"','"+gs.getRfc()
                    +"','"+gs.getUuid()
                    +"','"+gs.getHardware()
                    +"','"+gs.getProcessor_sn()
                    +"','"+gs.getProcessor_id()
                    +"','"+gs.getProcessor_ct()
                    +"','"+gs.getLcnc()
                    +"','"+gs.getCntd()+"')";
            ccr._callablestatement(sql);
            ccr._executeProcedure();
            ccr.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Connection Error: "+ex.getMessage(), ex);
        }
    }
    
    public String obtenRFC(int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rfc from empresas where idempresa='"+idempresa+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            if(cc._resultSet().first() == false){
                jtm.jTextAreaMessage("Not rfc exitence 0202.");
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    rfc = cc._resultSet().getString(1);
                }
            }
            
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Connection ERROR 0202."+ex.getMessage(), ex);
        }
        return rfc;
    }
    
    public boolean obtenRegistro(String lcnc){
        try{
            ccr.conexionMySql();
            String sql = "Select himawari_registro.id,"
                    + "himawari_registro.rznscl,"
                    + "himawari_registro.rfc,"
                    + "himawari_registro.uuid,"
                    + "himawari_registro.hrdwr,"
                    + "himawari_registro.prcssr_sn,"
                    + "himawari_registro.prcssr_id,"
                    + "himawari_registro.prcssr_ct, "
                    + "himawari_registro.lcnc,"
                    + "himawari_registro.cntd "
                    + "from himawari_registro "
                    + "where himawari_registro.lcnc='"+lcnc
                    +"' and rfc='"+rfc+"'";
                    ccr._callablestatement(sql);
                    ccr._executeProcedureSelect();
                    ccr._resultSet();
                    if(ccr._resultSet().first() == false){
                        jtm.jTextAreaMessage("ERROR: HIMAWARI POS, Connection could not started. Service Null Connection");
                        ccr.desconectar();
                        cnregistro = false;
                    }else{
                        ccr._resultSet().beforeFirst();
                        while(ccr._resultSet().next()){
//                            String id = cc._resultSet().getString(1);
//                            String rzs = cc._resultSet().getString(2);
//                            String rfc = cc._resultSet().getString(3);
//                            String uuid = cc._resultSet().getString(4);
//                            String hrdwr = cc._resultSet().getString(5);
//                            String prcssr_sn = cc._resultSet().getString(6);
//                            String prcssr_id = cc._resultSet().getString(7);
//                            String prcssr_ct = cc._resultSet().getString(8);
                            _licencia = ccr._resultSet().getString(9);
//                            int cntd = cc._resultSet().getInt(10);                             
                        }    
                        if(_licencia.equals(lcnc)){
                            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
                            ccr.desconectar();
                            cnregistro = true;
                        }else{
                            jtm.jTextAreaMessage("Invalid Licence");
                        }
                    }
                   
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Connection error. 0101."+ex.getMessage(), ex);
            ex.printStackTrace();
        }
        return cnregistro;
    }            
    
    public void actualizaEstadoCC(int cntd){
        try{
            ccr.conexionMySql();
            String sql = "update himawari_registro set cntd='"+cntd
                    +"' where lcnc='"+licencia._LICENCIA+"'";
            ccr._callablestatement(sql);
            ccr._executeProcedure();
            ccr.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Update Activation 1010."+ex.getMessage(), ex);
        }
    }
    
}
