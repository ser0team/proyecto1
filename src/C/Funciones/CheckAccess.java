/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Funciones;

import Frames.AjustesInventario.AjustesInventario;
import Frames.Almacenes.Almacenes;
import Frames.Anaqueles.Anaqueles;
import Frames.Bin.Bin;
import Frames.Caja.Caja;
import Frames.Categorias.Categorias;
import Frames.Compras.Compras;
import Frames.Compras.ConsultaCompras;
import Frames.Compras.EdicionPrecios;
import Frames.Corte.Corte;
import Frames.Devoluciones.Devoluciones;
import Frames.Empleados.Empleados;
import Frames.EntradasProducto.EntradasProducto;
import Frames.MovimientosAlmacen.MovimientosAlmacen;
import Frames.Pasillo.Pasillo;
import Frames.Productos.Productos;
import Frames.Proveedor.Proveedores;
import Frames.Ventas.ConsultaVentas;
import java.sql.SQLException;

/**
 *
 * @author jraraujo
 */
public class CheckAccess {
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    
    public void revisarAccesosAjusteInventario(int idusuario)
    {
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("aj_Guardar")){
                    AjustesInventario.jmacciones.setEnabled(true);
                    AjustesInventario.jbguardar.setEnabled(true);
                    AjustesInventario.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("aj_Cancelar")){
                    AjustesInventario.jbcancelar.setEnabled(true);
                    AjustesInventario.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("aj_Producto")){
                    AjustesInventario.jbproducto.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 001."+ex.getMessage(), ex);
            
        }
    }
    
    public void revisarAccesosAlmacen(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("al_Guardar")){
                    Almacenes.jmacciones.setEnabled(true);
                    Almacenes.jbguardar.setEnabled(true);
                    Almacenes.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("al_Cancelar")){
                    Almacenes.jbcancelar.setEnabled(true);
                    Almacenes.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("al_Eliminar")){
                    Almacenes.jbeliminar.setEnabled(true);
                    Almacenes.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("al_Modificar")){
                    Almacenes.jbmodificar.setEnabled(true);
                    Almacenes.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("al_Exportar")){
                    Almacenes.jbexportar.setEnabled(true);
                    Almacenes.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("al_Reporte")){
                    Almacenes.jbreporte.setEnabled(true);
                    Almacenes.jmreporte.setEnabled(true);
                    Almacenes.jmi_reporte.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 007."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosAnaquel(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("an_Guardar")){
                    Anaqueles.jmacciones.setEnabled(true);
                    Anaqueles.jbguardar.setEnabled(true);
                    Anaqueles.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("an_Cancelar")){
                    Anaqueles.jbcancelar.setEnabled(true);
                    Anaqueles.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("an_Eliminar")){
                    Anaqueles.jbeliminar.setEnabled(true);
                    Anaqueles.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("an_Modificar")){
                    Anaqueles.jbmodificar.setEnabled(true);
                    Anaqueles.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("an_Exportar")){
                    Anaqueles.jbexportar.setEnabled(true);
                    Anaqueles.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("an_Reporte")){
                    Anaqueles.jbreporte.setEnabled(true);
                    Anaqueles.jmreporte.setEnabled(true);
                    Anaqueles.jmi_reporte.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("an_Pasillo")){
                    Anaqueles.jbpasillo.setEnabled(true);                    
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 009."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosBin(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("bn_Guardar")){
                    Bin.jmacciones.setEnabled(true);
                    Bin.jbguardar.setEnabled(true);
                    Bin.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("bn_Cancelar")){
                    Bin.jbcancelar.setEnabled(true);
                    Bin.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("bn_Eliminar")){
                    Bin.jbeliminar.setEnabled(true);
                    Bin.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("bn_Modificar")){
                    Bin.jbmodificar.setEnabled(true);
                    Bin.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("bn_Exportar")){
                    Bin.jbexportar.setEnabled(true);
                    Bin.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("bn_Reporte")){
                    Bin.jmreporte.setEnabled(true);
                    Bin.jbreporte.setEnabled(true);
                    Bin.jmi_reporte.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("bn_Anaquel")){
                    Bin.jbanaquel.setEnabled(true);                    
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 010."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosCaja(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("cj_Guardar")){
                    Caja.jmacciones.setEnabled(true);
                    Caja.jbguardar.setEnabled(true);
                    Caja.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cj_Cancelar")){
                    Caja.jbcancelar.setEnabled(true);
                    Caja.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cj_Eliminar")){
                    Caja.jbeliminar.setEnabled(true);
                    Caja.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cj_Modificar")){
                    Caja.jbmodificar.setEnabled(true);
                    Caja.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cj_Exportar")){
                    Caja.jbexportar.setEnabled(true);
                    Caja.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cj_Reporte")){
                    Caja.jbreporte.setEnabled(true);
                    Caja.jmreporte.setEnabled(true);
                    Caja.jmireporte.setEnabled(true);
                
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 010."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosCategorias(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("cl_Guardar")){                    
                    Categorias.jbguardar.setEnabled(true);
                    Categorias.jmacciones.setEnabled(true);
                    Categorias.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cl_Cancelar")){
                    Categorias.jbcancelar.setEnabled(true);
                    Categorias.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cl_Eliminar")){
                    Categorias.jbeliminar.setEnabled(true);
                    Categorias.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cl_Modificar")){
                    Categorias.jbmodificar.setEnabled(true);
                    Categorias.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cl_Exportar")){
                    Categorias.jbexportar.setEnabled(true);
                    Categorias.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cl_Reporte")){
                    Categorias.jbreporte.setEnabled(true);
                    Categorias.jmreportes.setEnabled(true);
                    Categorias.jmi_reporte.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 005."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosCompras(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("com_Guardar")){
                    Compras.jmacciones.setEnabled(true);
                    Compras.jbguardar.setEnabled(true);
                    Compras.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("com_Cancelar")){
                    Compras.jbcancelar.setEnabled(true);
                    Compras.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("com_Eliminar")){
                    Compras.jbeliminar.setEnabled(true);
                    Compras.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("com_Exportar")){
                    Compras.jbexportar.setEnabled(true);                    
                }if(cc._resultSet().getString(1).equals("com_Reporte")){
                    Compras.jbreporte.setEnabled(true);
                    Compras.jmreportes.setEnabled(true);
                    Compras.jmi_reporte.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("com_Proveedor")){
                    Compras.jbcproveedor.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("com_Agregar")){
                    Compras.jbagregar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("com_Producto")){
                    Compras.jbproducto.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 002."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosConsultaCompras(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("cc_Guardar")){                    
                    ConsultaCompras.jbguardar.setEnabled(true);
                    ConsultaCompras.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cc_Cancelar")){
                    ConsultaCompras.jbcancelar.setEnabled(true);
                    ConsultaCompras.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cc_Eliminar")){
                    ConsultaCompras.jbeliminar.setEnabled(true);
                    ConsultaCompras.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cc_Exportar")){
                    ConsultaCompras.jbexportar.setEnabled(true);
                    ConsultaCompras.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cc_Reporte")){
                    ConsultaCompras.jbreporte.setEnabled(true);
                    ConsultaCompras.jmi_reporte.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cc_Proveedor")){
                    ConsultaCompras.jbproveedor.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cc_Buscar")){
                    ConsultaCompras.jbbuscar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cc_Ajustes")){
                    ConsultaCompras.jmajustes.setEnabled(true);
                    ConsultaCompras.jmi_precio.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 003."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosEdicionPrecios(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("ep_Guardar")){
                    EdicionPrecios.jbguardar.setEnabled(true);
                    EdicionPrecios.jmacciones.setEnabled(true);
                    EdicionPrecios.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ep_Cancelar")){
                    EdicionPrecios.jbcancelar.setEnabled(true);
                    EdicionPrecios.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ep_Eliminar")){
                    EdicionPrecios.jbeliminar.setEnabled(true);
                    EdicionPrecios.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ep_Modificar")){
                    EdicionPrecios.jbmodificar.setEnabled(true);
                    EdicionPrecios.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ep_Exportar")){
                    EdicionPrecios.jbexportar.setEnabled(true);
                    EdicionPrecios.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ep_Reporte")){
                    EdicionPrecios.jbreporte.setEnabled(true);
                    EdicionPrecios.jmi_reporteajustes.setEnabled(true);
                    EdicionPrecios.jmi_reportecompras.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ep_Ajustes")){
                    EdicionPrecios.jmajustes.setEnabled(true);
                    EdicionPrecios.jmi_ajustes.setEnabled(true);
                    EdicionPrecios.jmi_modajustes.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ep_Producto")){
                    EdicionPrecios.jbproducto.setEnabled(true);
                }            
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 003."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesoCorte(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("ct_Ccorte")){
                    Corte.jbcorte.setEnabled(true);
                    Corte.jmi_calcular.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ct_Scorte")){
                    Corte.jbcerrarcorte.setEnabled(true);
                    Corte.jmi_saldarcorte.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 003."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosDevoluciones(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("dv_Guardar")){
                    Devoluciones.jmacciones.setEnabled(true);
                    Devoluciones.jbguardar.setEnabled(true);
                    Devoluciones.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Cancelar")){
                    Devoluciones.jbcancelar.setEnabled(true);
                    Devoluciones.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Eliminar")){
                    Devoluciones.jbeliminar.setEnabled(true);
                    Devoluciones.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Modificar")){
                    Devoluciones.jbmodificar.setEnabled(true);
                    Devoluciones.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Exportar")){
                    Devoluciones.jbexportar.setEnabled(true);
                    Devoluciones.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Reporte")){
                    Devoluciones.jbreporte.setEnabled(true);
                    Devoluciones.jmreporte.setEnabled(true);
                    Devoluciones.jmi_reporte.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Venta")){
                    Devoluciones.jbidventa.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Producto")){
                    Devoluciones.jbidproducto.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Almacen")){
                    Devoluciones.jbidalmacen.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Pasillo")){
                    Devoluciones.jbidpasillo.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Anaquel")){
                    Devoluciones.jbidanaquel.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("dv_Bin")){
                    Devoluciones.jbidbin.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 003."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosEmpleados(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("em_Guardar")){
                    Empleados.jmacciones.setEnabled(true);
                    Empleados.jbguardar.setEnabled(true);
                    Empleados.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("em_Cancelar")){
                    Empleados.jbcancelar.setEnabled(true);
                    Empleados.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("em_Eliminar")){
                    Empleados.jbeliminar.setEnabled(true);
                    Empleados.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("em_Modificar")){
                    Empleados.jbmodificar.setEnabled(true);
                    Empleados.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("em_Exportar")){
                    Empleados.jbexportar.setEnabled(true);
                    Empleados.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("em_Reporte")){
                    Empleados.jbreportes.setEnabled(true);
                    Empleados.jmreportes.setEnabled(true);
                    Empleados.jmi_reporte.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 003."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosMontosAlmacen(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                
            }
        }catch(Exception ex){
            
        }
    }
    
    public void revisarAccesosMovimientosAlmacen(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
               if(cc._resultSet().getString(1).equals("movalm_Guardar")){
                   MovimientosAlmacen.jbguardar.setEnabled(true);
                   MovimientosAlmacen.jmacciones.setEnabled(true);
                   MovimientosAlmacen.jmi_guardar.setEnabled(true);
               }if(cc._resultSet().getString(1).equals("movalm_Cacelar")){
                   MovimientosAlmacen.jbcancelar.setEnabled(true);
                   MovimientosAlmacen.jmi_cancelar.setEnabled(true);
               }if(cc._resultSet().getString(1).equals("movalm_Exportar")){
                   MovimientosAlmacen.jbexportar.setEnabled(true);
                   MovimientosAlmacen.jmi_exportar.setEnabled(true);
               }if(cc._resultSet().getString(1).equals("movalm_Reporte")){
                   MovimientosAlmacen.jbreporte.setEnabled(true);
               }if(cc._resultSet().getString(1).equals("movalm_Producto")){
                   MovimientosAlmacen.jbproducto.setEnabled(true);
               }if(cc._resultSet().getString(1).equals("movalm_Almacen")){
                   MovimientosAlmacen.jbalmacen.setEnabled(true);
                   MovimientosAlmacen.jborigen_almacen.setEnabled(true);
               }if(cc._resultSet().getString(1).equals("movalm_Pasillo")){
                   MovimientosAlmacen.jbpasillo.setEnabled(true);
                   MovimientosAlmacen.jborigen_pasillo.setEnabled(true);
               }if(cc._resultSet().getString(1).equals("movalm_Anaquel")){
                   MovimientosAlmacen.jbanaquel.setEnabled(true);
                   MovimientosAlmacen.jborigen_anaquel.setEnabled(true);
               }if(cc._resultSet().getString(1).equals("movalm_Bin")){
                   MovimientosAlmacen.jbbin.setEnabled(true);
                   MovimientosAlmacen.jborigen_bin.setEnabled(true);
               }   
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 003."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosPasillo(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("ps_Guardar")){
                    Pasillo.jbguardar.setEnabled(true);
                    Pasillo.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ps_Cancelar")){
                    Pasillo.jbcancelar.setEnabled(true);
                    Pasillo.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ps_Eliminar")){
                    Pasillo.jbeliminar.setEnabled(true);
                    Pasillo.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ps_Modificar")){
                    Pasillo.jbmodificar.setEnabled(true);
                    Pasillo.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ps_Exportar")){
                    Pasillo.jbexportar.setEnabled(true);
                    Pasillo.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ps_Reporte")){
                    Pasillo.jbreporte.setEnabled(true);
                    Pasillo.jmi_reporte.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ps_Almacen")){
                    Pasillo.jbalmacen.setEnabled(true);                    
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 008."+ex.getMessage(), ex);
        }
    }
           
    public void revisarAccesosConsultaVentas(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("cven_NuevaVenta")){
                    ConsultaVentas.jbnuevaventa.setEnabled(true);
                    ConsultaVentas.jmacciones.setEnabled(true);
                    ConsultaVentas.jmi_nuevasventas.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cven_Cancelar")){
                    ConsultaVentas.jbcancelar.setEnabled(true);
                    ConsultaVentas.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("cven_Buscar")){
                    ConsultaVentas.jbbuscar.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 001."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosVentas(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("c_Guardar")){
                    Compras.jbguardar.setEnabled(true);
                    Compras.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("c_Cancelar")){
                    Compras.jbcancelar.setEnabled(true);
                    Compras.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("c_Eliminar")){
                    Compras.jbeliminar.setEnabled(true);
                    Compras.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("c_Exportar")){
                    Compras.jbexportar.setEnabled(true);                    
                }if(cc._resultSet().getString(1).equals("c_Reporte")){
                    Compras.jbreporte.setEnabled(true);
                    Compras.jmi_reporte.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("c_Proveedor")){
                    Compras.jbcproveedor.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("c_Agregar")){
                    Compras.jbagregar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("c_Producto")){
                    Compras.jbproducto.setEnabled(true);                
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 002."+ex.getMessage(), ex);
        }
    }   
    
    public void revisarAccesosProveedores(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("pv_Guardar")){
                    Proveedores.jbguardar.setEnabled(true);
                    Proveedores.jmacciones.setEnabled(true);
                    Proveedores.jmi_guardar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pv_Cancelar")){
                    Proveedores.jbcancelar.setEnabled(true);
                    Proveedores.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pv_Eliminar")){
                    Proveedores.jbeliminar.setEnabled(true);
                    Proveedores.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pv_Modificar")){
                    Proveedores.jbmodificar.setEnabled(true);
                    Proveedores.jmi_modificar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pv_Exportar")){
                    Proveedores.jbexportar.setEnabled(true);
                    Proveedores.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pv_Reporte")){
                    Proveedores.jbreporte.setEnabled(true);
                    Proveedores.jmreportes.setEnabled(true);
                    Proveedores.jmi_reporte.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 004."+ex.getMessage(), ex);
        }
    }   
     
    public void revisarAccesosProductos(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("pr_Guardar")){
                    Productos.jbguardar.setEnabled(true);
                    Productos.jmacciones.setEnabled(true);
                    Productos.jmi_guardar.setEnabled(true);                   
                }if(cc._resultSet().getString(1).equals("pr_Cancelar")){
                    Productos.jbcancelar.setEnabled(true);
                    Productos.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pr_Eliminar")){
                    Productos.jbeliminar.setEnabled(true);
                    Productos.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pr_Modificar")){
                    Productos.jbmodificar.setEnabled(true);
                    Productos.jmi_modificar.setEnabled(true);
                    Productos.jtproductos.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pr_Exportar")){
                    Productos.jbexportar.setEnabled(true);
                    Productos.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pr_Reporte")){
                    Productos.jbreporte.setEnabled(true);
                    Productos.jmreportes.setEnabled(true);
                    Productos.jmi_reporte.setEnabled(true);
                    Productos.jmi_repprodalm.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pr_Proveedor")){
                    Productos.jbproveedor.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pr_Categoria")){
                    Productos.jbcategoria.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("pr_ProductosDeshabilitados")){
                    Productos.jbdeshabilitados.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 006."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesosEntradaProductos(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                if(cc._resultSet().getString(1).equals("ent_Guardar")){
                    EntradasProducto.jbguardar.setEnabled(true);
                    EntradasProducto.jmacciones.setEnabled(true);
                    EntradasProducto.jmi_guardar.setEnabled(true);                   
                }if(cc._resultSet().getString(1).equals("ent_Cancelar")){
                    EntradasProducto.jbcancelar.setEnabled(true);
                    EntradasProducto.jmi_cancelar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ent_Eliminar")){
                    EntradasProducto.jbeliminar.setEnabled(true);
                    EntradasProducto.jmi_eliminar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ent_Exportar")){
                    EntradasProducto.jbexportar.setEnabled(true);
                    EntradasProducto.jmi_exportar.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ent_Reporte")){
                    EntradasProducto.jbreporte.setEnabled(true);
                    EntradasProducto.jmreporte.setEnabled(true);
                    EntradasProducto.jmi_reporte.setEnabled(true);
                    Productos.jmi_repprodalm.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ent_Compra")){
                    EntradasProducto.jbidcompra.setEnabled(true);                
                }if(cc._resultSet().getString(1).equals("ent_Almacen")){
                    EntradasProducto.jbalmacen.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ent_Pasillo")){
                    EntradasProducto.jbpasillo.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ent_Anaquel")){
                    EntradasProducto.jbanaquel.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ent_Bin")){
                    EntradasProducto.jbbin.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ent_Producto")){
                    EntradasProducto.jbproducto.setEnabled(true);
                }if(cc._resultSet().getString(1).equals("ent_ActCant")){
                    EntradasProducto.jbguardarcantidad.setEnabled(true);
                    EntradasProducto.jbmodificar.setEnabled(true);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Review Rol 006."+ex.getMessage(), ex);
        }
    }
    
}
