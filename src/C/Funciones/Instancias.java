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
import Frames.Ventas.ConsultaVentas;
import Frames.Compras.ConsultaAjustes;
import Frames.Compras.Compras;
import Frames.Compras.ConsultaCompras;
import Frames.Compras.EdicionPrecios;
import Frames.Caja.Caja;
import Frames.Categorias.Categorias;
import Frames.Compras.ReportesCompras;
import Frames.Corte.Corte;
import Frames.Devoluciones.Devoluciones;
import Frames.Listados.ListarProductos;
import Frames.Listados.ListarVentas;
import Frames.Empleados.Empleados;
import Frames.EntradasProducto.EntradasDesdeDevoluciones;
import Frames.EntradasProducto.EntradasProducto;
import Frames.Listados.ListarCompras;
import Frames.Listados.ListarAlmacenes;
import Frames.Listados.ListarAnaqueles;
import Frames.Listados.ListarBins;
import Frames.Listados.ListarPasillos;
import Frames.Menu;
import Frames.Parametros.ListarEmpleados;
import Frames.Parametros.Parametros;
import Frames.Pasillo.Pasillo;
import Frames.Listados.ListaCategorias;
import Frames.Listados.ListaProveedores;
import Frames.Productos.Productos;
import Frames.Proveedor.Proveedores;
import Frames.Reportes.ReporteXFecha;
import Frames.Reportes.Reportes;
import Frames.Ventas.ConsultaVentasXProveedor;
import Frames.Listados.ListaProductos;
import Frames.Listados.ListarEntradas;
import Frames.Listados.ListarProductosXCompra;
import Frames.Login;
import Frames.MovimientosAlmacen.MontosAlmacen;
import Frames.MovimientosAlmacen.MovimientosAlmacen;
import Frames.Parametros.DatosEmpresa;
import Frames.Productos.Prodeshabilitados;
import Frames.Productos.ReportesProductos;
import Frames.Splash.SplashInicio;
import Frames.Ventas.Ventas;
import Frames.Ventas.VentasMiscelaneas;
import Frames.Ventas.ventas_producto;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author jraraujo
 */ 
public class Instancias {
    
    public static Ventas _ventas;
    public static Reportes _reportesventas;
    public static ReporteXFecha _reportesxfecha;
    public static Proveedores _proveedores;
    public static Empleados _empleados;
    public static Categorias _categorias;
    public static Productos _productos;
    public static Compras _compras;
    public static ConsultaCompras _ccompras;
    public static Caja _caja;
    public static Corte _corte;
    public static ConsultaAjustes _ajustes;
    public static EdicionPrecios _edicionprecios;
    public static ListaCategorias _listacategorias;
    public static ListaProveedores _listaproveedores;
    public static VentasMiscelaneas _ventasmiscelaneas;
    public static ListaProductos _listaproductos;
    public static ConsultaVentas _consultaventas;
    public static ConsultaVentasXProveedor _consultasporproveedor;
    public static Menu _menu;
    public static Almacenes _almacenes;
    public static ListarAlmacenes _listaralmacenes;
    public static Pasillo _pasillos;
    public static ListarPasillos _listarpasillos;
    public static Anaqueles _anaqueles;
    public static ListarAnaqueles _listaranaqueles;
    public static Bin _bin;
    public static ListarBins _listarbin; 
    public static Parametros _parametros;
    public static ListarEmpleados _listarempleados;
    public static Devoluciones _devoluciones;
    public static ListarVentas _listarventas;
    public static ListarProductos _listarproductos;
    public static ListarCompras _listarcompras;
    public static ListarProductosXCompra _listarproductosxcompra;
    public static MovimientosAlmacen _movimientosalmacen;
    public static MontosAlmacen _montosalmacen;
    public static DatosEmpresa _datosempresa;
    public static AjustesInventario _ajustesinventarios;
    public static ReportesCompras _reportescompras;
    public static ReportesProductos _reportesproductos;
    public static EntradasProducto _entradasproducto;
    public static SplashInicio _splashinicio;
    public static Login _login;
    public static EntradasDesdeDevoluciones _entddev;
    public static ListarEntradas _listarentradas;
    public static Prodeshabilitados _prodes;
    public static ventas_producto _venprod;
            
      public void getInstanciaVentas(){
          if(_ventas == null){
              _ventas = new Ventas();
              _ventas.setVisible(true);
          }else{
              _ventas.toFront();
          }
      }  

      public void getInstanciaReporteVentas(){
          if(_reportesventas == null){
              _reportesventas = new Reportes();
              _reportesventas.setVisible(true);
          }else{
              _reportesventas.toFront();
          }
      }
      
      public void getInstanciaReportesXFecha(){
          if(_reportesxfecha == null){
              _reportesxfecha = new ReporteXFecha();
              _reportesxfecha.setVisible(true);
          }else{
              _reportesxfecha.toFront();
          }
      }
      
      public void getInstanciaProveedores(){
          if(_proveedores == null){
              _proveedores = new Proveedores();
              _proveedores.setVisible(true);
          }else{
              _proveedores.toFront();
          }
      }
      
      public void getInstanciaEmpleados(){
          if(_empleados == null){
              _empleados = new Empleados();
              _empleados.setVisible(true);
          }else{
              _empleados.toFront();
          }
      }
      
      public void getInstanciaCategorias() throws SQLException{
          if(_categorias == null){
              _categorias = new Categorias();
              _categorias.setVisible(true);
          }else{
              _categorias.toFront();
          }
      }
      
      public void getInstanciaProductos() throws ClassNotFoundException{
          if(_productos == null){
              _productos = new Productos();
              _productos.setVisible(true);
          }else{
              _productos.toFront();
          }
      }
      
      public void getInstanciaCompras() throws ClassNotFoundException{
          if(_compras == null){
              _compras = new Compras();
              _compras.setVisible(true);
          }else{
              _compras.toFront();
          }
      }
      
      public void getInstanciaConsultaCompras() throws ClassNotFoundException{
          if(_ccompras == null){
              _ccompras = new ConsultaCompras();
              _ccompras.setVisible(true);
          }else{
              _ccompras.toFront();
          }
      }
      
       public void getInstanciaCaja() throws ClassNotFoundException{
          if(_caja == null){
              _caja = new Caja();
              _caja.setVisible(true);
          }else{
              _caja.toFront();
          }
      }
       
      public void getInstanciaCorte() throws ClassNotFoundException{
          if(_corte == null){
              _corte = new Corte();
              _corte.setVisible(true);
          }else{
              _corte.toFront();
          }
      }
      
      public void getInstanciaAjustes(){
          if(_ajustes == null){
              _ajustes = new ConsultaAjustes();
              _ajustes.setVisible(true);
          }else{
              _ajustes.toFront();
          }
      }
      
      public void getInstanciaEdicionPrecios(){
          if(_edicionprecios == null){
              _edicionprecios = new EdicionPrecios();
              _edicionprecios.setVisible(true);
          }else{
              _edicionprecios.toFront();
          }
      }
      
      public void getInstanciaListaCategorias(){
          if(_listacategorias == null){
              try {
                  _listacategorias = new ListaCategorias();
                  _listacategorias.setVisible(true);
              } catch (ClassNotFoundException | SQLException ex) {
                  Logger.getLogger(Instancias.class.getName()).log(Level.SEVERE, null, ex);
              }
          }else{
              _listacategorias.toFront();
          }
      }

      public void getInstanciaListaProveedores(){
          if(_listaproveedores == null){
              try {
                  _listaproveedores = new ListaProveedores();
                  _listaproveedores.setVisible(true);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Instancias.class.getName()).log(Level.SEVERE, null, ex);
              }
          }else{
              _listaproveedores.toFront();
          }          
      }
      
      public void getInstaciaVentasMiscelaneas(){
          if(_ventasmiscelaneas == null){
              _ventasmiscelaneas = new VentasMiscelaneas();
              _ventasmiscelaneas.setVisible(true);
          }else{
              _ventasmiscelaneas.toFront();
          }
      }
      
      public void getInstanciaListaProductos(){
          if(_listaproductos == null){
              try {
                  _listaproductos = new ListaProductos();
                  _listaproductos.setVisible(true);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Instancias.class.getName()).log(Level.SEVERE, null, ex);
              }
          }else{
              _listaproductos.toFront();
          }
      }    
      
      public void getInstanciaConsultaVentas(){
          if(_consultaventas == null){
              _consultaventas = new ConsultaVentas();
              _consultaventas.setVisible(true);
          }else{
              _consultaventas.toFront();
          }
      }    
       
       public void getInstanciaConsultaVentasXProveedor(){
          if(_consultasporproveedor == null){
              _consultasporproveedor = new ConsultaVentasXProveedor();
              _consultasporproveedor.setVisible(true);
          }else{
              _consultasporproveedor.toFront();
          }
      }  
       
       public void getInstanciaMenuMin() throws SQLException{
          if(_menu == null){              
             _menu = new Menu();                                 
             _menu.setExtendedState(0);
             _menu.setSize(new Dimension(571, 505));             
             _menu.setLocationRelativeTo(null);             
             SwingUtilities.updateComponentTreeUI(_menu);             
             _menu.invalidate();              
             _menu.validate();
             _menu.repaint();            
             _menu.setLocationRelativeTo(null);  
             _menu.setVisible(true);  
             _menu.pack();
          }else{
              _menu.toFront();
          }
      }     
       
      public void getInstanciasAlmacenes(){
          if(_almacenes == null){
              _almacenes = new Almacenes();
              _almacenes.setVisible(true);
          }else{
              _almacenes.toFront();
          }
      }
      
      public void getInstanciasListarAlmacenes(){
          if(_listaralmacenes == null){
              _listaralmacenes = new ListarAlmacenes();
              _listaralmacenes.setVisible(true);
          }else{
              _listaralmacenes.toFront();
          }
      }
      
      public void getInstanciasPasillos(){
          if(_pasillos == null){
              _pasillos = new Pasillo();
              _pasillos.setVisible(true);
          }else{
              _pasillos.toFront();
          }
      }
      
      public void getInstanciasListarPasillos(){
          if(_listarpasillos == null){
              _listarpasillos = new ListarPasillos();
              _listarpasillos.setVisible(true);
          }else{
              _listarpasillos.toFront();
          }
      }
      
      public void getInstanciasAnaqueles(){
          if(_anaqueles == null){
              _anaqueles = new Anaqueles();
              _anaqueles.setVisible(true);
          }else{
              _anaqueles.toFront();
          }
      }
      
      public void getInstanciasListarAnaqueles(){
          if(_listaranaqueles == null){
              _listaranaqueles = new ListarAnaqueles();
              _listaranaqueles.setVisible(true);
          }else{
              _listaranaqueles.toFront();
          }
      }
      
      public void getInstanciasBin(){
          if(_bin == null){
              _bin = new Bin();
              _bin.setVisible(true);
          }else{
              _bin.toFront();
          }
      }
      
      public void getInstanciasListarBin(){
          if(_listarbin == null){
              _listarbin = new ListarBins();
              _listarbin.setVisible(true);
          }else{
              _listarbin.toFront();
          }
      }
      
      public void getInstanciasParametros(){
          if(_parametros == null){
              _parametros = new Parametros();
              _parametros.setVisible(true);
          }else{
              _parametros.toFront();
          }
      }
      
      public void getInstanciasListarEmpleados(){
          if(_listarempleados == null){
              _listarempleados = new ListarEmpleados();
              _listarempleados.setVisible(true);
          }else{
              _listarempleados.toFront();
          }
      }
      
      public void getInstanciasDevoluciones(){
          if(_devoluciones == null){
              _devoluciones = new Devoluciones();
              _devoluciones.setVisible(true);
          }else{
              _devoluciones.toFront();
          }
      }
      
      public void getInstanciasListarVentas(){
          if(_listarventas == null){
              _listarventas = new ListarVentas();
              _listarventas.setVisible(true);
          }else{
              _listarventas.toFront();
          }
      }
      
      public void getInstanciasListarProductos(){
          if(_listarproductos == null){
              _listarproductos = new ListarProductos();
              _listarproductos.setVisible(true);
          }else{
              _listarproductos.toFront();
          }
      }
      
      public void getInstanciasListarCompras(){
          if(_listarcompras == null){
              _listarcompras = new ListarCompras();
              _listarcompras.setVisible(true);
          }else{
              _listarcompras.toFront();
          }
      }
      
      public void getInstanciasListarProductosXCompra(){
          if(_listarproductosxcompra == null){
              _listarproductosxcompra = new ListarProductosXCompra();
              _listarproductosxcompra.setVisible(true);
          }else{
              _listarproductosxcompra.toFront();
          }
      }
      
      public void getInstanciasMovimientosAlmacen(){
          if(_movimientosalmacen == null){
              _movimientosalmacen = new MovimientosAlmacen();
              _movimientosalmacen.setVisible(true);
          }else{
              _movimientosalmacen.toFront();
          }
      }
      
      public void getInstanciasMontosAlmacen(){
          if(_montosalmacen == null){
              _montosalmacen = new MontosAlmacen();
              _montosalmacen.setVisible(true);
          }else{
              _montosalmacen.toFront();
          }
      }
      
      public void getInstanciasDatosEmpresa(){
          if(_datosempresa == null){
              _datosempresa = new DatosEmpresa();
              _datosempresa.setVisible(true);
          }else{
              _datosempresa.toFront();
          }
      }
      
      public void getInstanciasAjustesInventario(){
          if(_ajustesinventarios == null){
              _ajustesinventarios = new AjustesInventario();
              _ajustesinventarios.setVisible(true);
          }else{
              _ajustesinventarios.toFront();
          }
      }
      
      public void getInstanciasReportesCompras(){
          if(_reportescompras == null){
              _reportescompras = new ReportesCompras();
              _reportescompras.setVisible(true);
          }else{
              _reportescompras.toFront();
          }
      }
      
      public void getInstanciasReportesProductos(){
          if(_reportesproductos == null){
              _reportesproductos = new ReportesProductos();
              _reportesproductos.setVisible(true);
          }else{
              _reportesproductos.toFront();
          }
      }
      
      public void getInstanciasEntradaProducto(){
          if(_entradasproducto == null){
              _entradasproducto = new EntradasProducto();
              _entradasproducto.setVisible(true);
          }else{
              _entradasproducto.toFront();
          }
      }
      
      public void getInstanciasSplashInicio() throws InterruptedException, ClassNotFoundException{
          if(_splashinicio == null){
              _splashinicio = new SplashInicio();
              _splashinicio.setVisible(true);
          }else{
              _splashinicio.toFront();
          }
      }
      
       public void getInstanciasLogIn(){
          if(_login == null){
              _login = new Login();
              _login.setVisible(true);
          }else{
              _login.toFront();
          }
      }
       
       public void getInstanciasEntradasDesdeDevoluciones(){
          if(_entddev == null){
              _entddev = new EntradasDesdeDevoluciones();
              _entddev.setVisible(true);
          }else{
              _entddev.toFront();
          }
      }
       
       public void getInstanciaListarEntradas(){
          if(_listarentradas == null){
              _listarentradas = new ListarEntradas();
              _listarentradas.setVisible(true);
          }else{
              _listarentradas.toFront();
          }
      }
       
      public void getInstanciasProductosDeshabilitados(){
          if(_prodes == null){
              _prodes = new Prodeshabilitados();
              _prodes.setVisible(true);
          }else{
              _prodes.toFront();
          }
      }
      
      public void getInstanciasVentasProductos(){
          if(_venprod == null){
              _venprod = new ventas_producto();
              _venprod.setVisible(true);
          }else{
              _venprod.toFront();
          }
      }
      
}
