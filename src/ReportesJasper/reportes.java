/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportesJasper;

import C.Funciones.JTextAreaMessages;
import com.toedter.calendar.JDateChooser;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jraraujo
 */
public class reportes {
    
    JasperCompileManager jcm = null;    
    JasperReport jr = null;
    JasperPrint jp = null;
    Map<String,Object> parametro = null;
    HashMap hm = null;
    JasperViewer jv = null;        
    String imagen="Imagenes/toro.png";
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    
    public void EmisionReporteVentasGenerales(String ruta, String nombre) throws JRException{
        try{
            
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<String,Object>();
            parametro.clear();
            parametro.put("logo", imagen);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteGeneralVentas.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Ventas]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Sales General Report. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
     public void EmisionReporteVentasGeneralesXFecha(String ruta, String nombre,
             JDateChooser fechade, JDateChooser fechahasta) throws JRException{
        try{
            
            java.sql.Date _fechade = new java.sql.Date(fechade.getDate().getTime());
            java.sql.Date _fechahasta = new java.sql.Date(fechahasta.getDate().getTime());
            
            System.out.println(_fechade);
            System.out.println(_fechahasta);
            
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("fechade", _fechade);
            parametro.put("fechahasta", _fechahasta);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteGeneralVentasPorFecha.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Ventas Por Fecha]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Sales General Report. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
     
    public void EmisionReporteDeCortes(String ruta, String nombre, int idempresa) throws JRException{
        try{
            
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<String,Object>();
            parametro.clear();
            parametro.put("idempresa", idempresa);
            parametro.put("logo", imagen);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeCortes.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Cortes]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Earnings General Report. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
          
    public void EmisionReporteDeProductos(String ruta, String nombre, int idempresa) throws JRException{
        try{
            
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<String,Object>();
            parametro.clear();
            parametro.put("idempresa", idempresa);
            parametro.put("logo", imagen);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeProductos.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Productos]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Cash General Report. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeProductosPorAlmacen(String ruta, String nombre, int idempresa) throws JRException{
        try{
            
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<String,Object>();
            parametro.clear();
            parametro.put("idempresa", idempresa);
            parametro.put("logo", imagen);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeProductosPorAlmacen.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Productos por Almacen]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Cash General Report. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeCategorias(String ruta, String nombre, int idempresa) throws JRException{
        try{
            
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<String,Object>();
            parametro.clear();
            parametro.put("idempresa", idempresa);
            parametro.put("logo", imagen);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeCategorias.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Categorias]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Category General Report. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
            
    public void EmisionReporteDeProveedores(String ruta, String nombre, int idempresa) throws JRException{
        try{
            
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<String,Object>();
            parametro.clear();
            parametro.put("idempresa", idempresa);
            parametro.put("logo", imagen);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeProveedores.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Proveedores]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Supplier General Report. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeCompras(String ruta, String nombre, int idempresa) throws JRException{
        try{
            
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("idempresa", idempresa);
            parametro.put("logo", imagen);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeCompras.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Compras]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeComprasXFecha(String ruta, String nombre, 
            JDateChooser jdcfechade, JDateChooser jdcfechahasta) throws JRException{
        try{
            
            java.sql.Date _fechade = new java.sql.Date(jdcfechade.getDate().getTime());
            System.out.println(_fechade);
            java.sql.Date _fechahasta = new java.sql.Date(jdcfechahasta.getDate().getTime());
            
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("fechade", _fechade);
            parametro.put("fechahasta", _fechahasta);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeCompras.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Compras Por Fecha]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeAlmacenes(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeAlmacenes.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Almacenes]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDePasillos(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDePasillos.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Pasillos]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeAnaqueles(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeAnaqueles.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Anaqueles]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeBin(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeBines.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Bines]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeCaja(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeCaja.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Caja]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteEdicionPrecios(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeEdiciónPrecios.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Edición de Precios]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeAjustes(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteDeAjustes.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte General de Edición de Ajustes]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeFactura(String ruta, String nombre, 
            int idempresa, int idventa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa); 
            parametro.put("idventa", idventa);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Factura.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte de Edición de Factura]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
    public void EmisionReporteDeEntradasDeProducto(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);             
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("EntradaDeProductos.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte de Edición de Entradas De Productos]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
     public void EmisionReporteDeEmpleados(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);             
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("EntradaDeEmpleados.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte de Edición de Empleados]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
     
     public void EmisionReporteDevoluciones(String ruta, String nombre, 
            int idempresa) throws JRException{
        try{           
                       
            jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource(ruta+nombre));
            parametro = new HashMap<>();
            parametro.clear();
            parametro.put("logo", imagen);
            parametro.put("idempresa", idempresa);             
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr,parametro,cc.conexionMySql("127.0.0.1", "3306", "root", "tittan"));								
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("EntradaDevoluciones.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            JasperViewer ver=new JasperViewer(jasperPrint,false);
            ver.setTitle("MARENGO[Reporte de Edición de Devoluciones]");
            ver.setVisible(true);
            ver.setDefaultCloseOperation(0);           
            exp.exportReport();                    
            cc.desconectar();            
        }catch(ClassNotFoundException | JRException ex){
            jtm.jTextAreaError("ERROR: Purchase General Report By Date. 3004-2073. "+ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }
    
}
