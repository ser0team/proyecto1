/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.TreeRenderer;

import C.Funciones.JTextAreaMessages;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author jraraujo
 */
public class UncheckedCustomizeTree {
    
        
    public static boolean checked1, checked2;
    public static boolean renderercheck;
    public static DefaultTreeModel dtm;
    public static DefaultMutableTreeNode root, ventas, regventas, dtm_nuevo, dtm_aniadir, 
            dtm_miscelaneo, dtm_remover, parametros;
    JTextAreaMessages jtm = new JTextAreaMessages();
    
    public void cutomizeTree(JTree jtree){
        try{
           
            root = new DefaultMutableTreeNode("Menu");
            ventas = new DefaultMutableTreeNode("Ventas");
            regventas = new DefaultMutableTreeNode("Registro de Ventas");
                       
            dtm_nuevo = new DefaultMutableTreeNode(new MyTreeNode
                    ("option1", "Nuevo", "multiply"));         
            dtm_aniadir = new DefaultMutableTreeNode(new MyTreeNode
                    ("option2", "Añadir", "multiply.png"));
            dtm_miscelaneo = new DefaultMutableTreeNode(new MyTreeNode
                    ("option3", "Miscelaneo", "multiply.png"));
            dtm_remover = new DefaultMutableTreeNode(new MyTreeNode
                    ("option4", "Remover", "multiply.png"));
            DefaultMutableTreeNode dtm_saldar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option5", "Saldar", "multiply.png"));
            DefaultMutableTreeNode dtm_cancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option6", "Cancelar", "multiply.png"));
            regventas.add(dtm_nuevo);
            regventas.add(dtm_aniadir);
            regventas.add(dtm_miscelaneo);
            regventas.add(dtm_remover);
            regventas.add(dtm_saldar);
            regventas.add(dtm_cancelar);
            DefaultMutableTreeNode consultaVentas = new DefaultMutableTreeNode("Consulta Ventas");
            DefaultMutableTreeNode dtm_nuevaventa = new DefaultMutableTreeNode(new MyTreeNode
                    ("option7", "Nueva Venta", "multiply.png"));
            DefaultMutableTreeNode dtm_cancelarnuevaventa = new DefaultMutableTreeNode(new MyTreeNode
                    ("option8", "Cancelar", "multiply.png"));
            DefaultMutableTreeNode dtm_facturaventa = new DefaultMutableTreeNode(new MyTreeNode
                    ("option9", "Factura", "multiply.png"));
            DefaultMutableTreeNode dtm_buscarventa = new DefaultMutableTreeNode(new MyTreeNode
                    ("option10", "Buscar", "multiply.png"));            
            consultaVentas.add(dtm_nuevaventa);
            consultaVentas.add(dtm_cancelarnuevaventa);
            consultaVentas.add(dtm_facturaventa);
            consultaVentas.add(dtm_buscarventa);
            ventas.add(consultaVentas);
            ventas.add(regventas);
            DefaultMutableTreeNode compras = new DefaultMutableTreeNode("Compras");
            DefaultMutableTreeNode registroCompras = new DefaultMutableTreeNode("Registro de Compras");
            DefaultMutableTreeNode dtm_guardarcompra = new DefaultMutableTreeNode(new MyTreeNode
                    ("option11", "Guardar", "multiply.png"));
            DefaultMutableTreeNode dtm_cancelarcompra = new DefaultMutableTreeNode(new MyTreeNode
                    ("option12", "Cancelar", "multiply.png"));
            DefaultMutableTreeNode dtm_eliminarcompra = new DefaultMutableTreeNode(new MyTreeNode
                    ("option13", "Eliminar", "multiply.png"));            
            DefaultMutableTreeNode dtm_exportarcompra = new DefaultMutableTreeNode(new MyTreeNode
                    ("option14", "Exportar", "multiply.png"));
            DefaultMutableTreeNode dtm_reportecompra = new DefaultMutableTreeNode(new MyTreeNode
                    ("option15", "Reporte", "multiply.png"));
            DefaultMutableTreeNode dtm_compraproveedor = new DefaultMutableTreeNode(new MyTreeNode
                    ("option16", "Proveedor", "multiply.png"));
            DefaultMutableTreeNode dtm_compraagregar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option17", "Agregar", "multiply.png"));
            DefaultMutableTreeNode dtm_compraproducto = new DefaultMutableTreeNode(new MyTreeNode
                    ("option18", "Producto", "multiply.png"));
            DefaultMutableTreeNode dtm_compraalmacen = new DefaultMutableTreeNode(new MyTreeNode
                    ("option19", "Almacen", "multiply.png"));
            DefaultMutableTreeNode dtm_comprapasillo = new DefaultMutableTreeNode(new MyTreeNode
                    ("option20", "Pasillo", "multiply.png"));
            DefaultMutableTreeNode dtm_compraanaquel = new DefaultMutableTreeNode(new MyTreeNode
                    ("option21", "Anaquel", "multiply.png"));
            DefaultMutableTreeNode dtm_comprabin = new DefaultMutableTreeNode(new MyTreeNode
                    ("option22", "Bin", "multiply.png"));
            registroCompras.add(dtm_guardarcompra);
            registroCompras.add(dtm_cancelarcompra);
            registroCompras.add(dtm_eliminarcompra);            
            registroCompras.add(dtm_exportarcompra);
            registroCompras.add(dtm_reportecompra);
            registroCompras.add(dtm_compraproveedor);
            registroCompras.add(dtm_compraagregar);
            registroCompras.add(dtm_compraproducto);
            registroCompras.add(dtm_compraalmacen);
            registroCompras.add(dtm_comprapasillo);
            registroCompras.add(dtm_compraanaquel);
            registroCompras.add(dtm_comprabin);
            DefaultMutableTreeNode concompras = new DefaultMutableTreeNode("Consulta de Compras");
            DefaultMutableTreeNode dtm_conguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option23", "Guardar", "multiply.png"));
            DefaultMutableTreeNode dtm_concancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option24", "Cancelar", "multiply.png"));
            DefaultMutableTreeNode dtm_coneliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option25", "Eliminar", "multiply.png"));
            DefaultMutableTreeNode dtm_conexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option26", "Exportar", "multiply.png"));
            DefaultMutableTreeNode dtm_conreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option27", "Reporte", "multiply.png"));
            DefaultMutableTreeNode dtm_conajuste = new DefaultMutableTreeNode(new MyTreeNode
                    ("option28", "Ajustes", "multiply.png"));
            DefaultMutableTreeNode dtm_conproveedor = new DefaultMutableTreeNode(new MyTreeNode
                    ("option29", "Proveedor", "multiply.png"));
            DefaultMutableTreeNode dtm_conbuscar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option30", "Buscar", "multiply.png"));
            concompras.add(dtm_conguardar);
            concompras.add(dtm_concancelar);
            concompras.add(dtm_coneliminar);
            concompras.add(dtm_conexportar);
            concompras.add(dtm_conreporte);
            concompras.add(dtm_conajuste);
            concompras.add(dtm_conproveedor);
            concompras.add(dtm_conbuscar);
            DefaultMutableTreeNode ediprecios = new DefaultMutableTreeNode("Edición de Precios");
            DefaultMutableTreeNode dtm_ediguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option31", "Guardar", "multiply.png"));
            DefaultMutableTreeNode dtm_edicancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option32", "Cancelar", "multiply.png"));
            DefaultMutableTreeNode dtm_edieliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option33", "Eliminar", "multiply.png"));
            DefaultMutableTreeNode dtm_edimodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option34", "Modificar", "multiply.png"));
            DefaultMutableTreeNode dtm_ediexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option35", "Exportar", "multiply.png"));
            DefaultMutableTreeNode dtm_edireporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option36", "Reporte", "multiply.png"));
            DefaultMutableTreeNode dtm_ediproducto = new DefaultMutableTreeNode(new MyTreeNode
                    ("option37", "Producto", "multiply.png"));
            DefaultMutableTreeNode dtm_ediajuste = new DefaultMutableTreeNode(new MyTreeNode
                    ("option38", "Ajuste", "multiply.png"));
            DefaultMutableTreeNode dtm_ediactualizar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option39", "Actualizar", "multiply.png"));            
            ediprecios.add(dtm_ediguardar);
            ediprecios.add(dtm_edicancelar);
            ediprecios.add(dtm_edieliminar);
            ediprecios.add(dtm_edimodificar);
            ediprecios.add(dtm_ediexportar);
            ediprecios.add(dtm_edireporte);
            ediprecios.add(dtm_ediproducto);
            ediprecios.add(dtm_ediajuste);
            ediprecios.add(dtm_ediactualizar);
            compras.add(registroCompras);
            compras.add(concompras);
            compras.add(ediprecios);
            DefaultMutableTreeNode devoluciones = new DefaultMutableTreeNode("Devoluciónes");
            DefaultMutableTreeNode dtm_devguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option40", "Guardar", "multiply.png"));
            DefaultMutableTreeNode dtm_devcancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option41", "Cancelar", "multiply.png"));
            DefaultMutableTreeNode dtm_develiminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option42", "Eliminar", "multiply.png"));
            DefaultMutableTreeNode dtm_devmodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option43", "Modificar", "multiply.png"));
            DefaultMutableTreeNode dtm_devexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option44", "Exportar", "multiply.png"));
            DefaultMutableTreeNode dtm_devreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option45", "Reporte", "multiply.png"));
            DefaultMutableTreeNode dtm_devventa = new DefaultMutableTreeNode(new MyTreeNode
                    ("option46", "Venta", "multiply.png"));
            DefaultMutableTreeNode dtm_devproducto = new DefaultMutableTreeNode(new MyTreeNode
                    ("option47", "Producto", "multiply.png"));
            DefaultMutableTreeNode dtm_devalmacen = new DefaultMutableTreeNode(new MyTreeNode
                    ("option48", "Almacen", "multiply.png"));
            DefaultMutableTreeNode dtm_devpasillo = new DefaultMutableTreeNode(new MyTreeNode
                    ("option49", "Pasillo", "multiply.png"));
            DefaultMutableTreeNode dtm_devanaquel = new DefaultMutableTreeNode(new MyTreeNode
                    ("option50", "Anaquel", "multiply.png"));
            DefaultMutableTreeNode dtm_devbin = new DefaultMutableTreeNode(new MyTreeNode
                    ("option51", "Bin", "multiply.png"));
            devoluciones.add(dtm_devguardar);
            devoluciones.add(dtm_devcancelar);
            devoluciones.add(dtm_develiminar);
            devoluciones.add(dtm_devmodificar);
            devoluciones.add(dtm_devexportar);
            devoluciones.add(dtm_devreporte);
            devoluciones.add(dtm_devventa);
            devoluciones.add(dtm_devproducto);
            devoluciones.add(dtm_devalmacen);
            devoluciones.add(dtm_devpasillo);
            devoluciones.add(dtm_devanaquel);
            devoluciones.add(dtm_devbin);
            DefaultMutableTreeNode proveedores = new DefaultMutableTreeNode("Proveedores");
            DefaultMutableTreeNode regproveedores = new DefaultMutableTreeNode("Registro de Proveedores");
            DefaultMutableTreeNode dtm_provguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option52", "Guardar", "multiply.png"));
            DefaultMutableTreeNode dtm_provcancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option53", "Cancelar", "multiply.png"));
            DefaultMutableTreeNode dtm_proveliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option54", "Eliminar", "multiply.png"));
            DefaultMutableTreeNode dtm_provmodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option55", "Modificar", "multiply.png"));
            DefaultMutableTreeNode dtm_provexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option56", "Exportar", "multiply.png"));
            DefaultMutableTreeNode dtm_provreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option57", "Reporte", "multiply.png"));
            regproveedores.add(dtm_provguardar);
            regproveedores.add(dtm_provcancelar);
            regproveedores.add(dtm_proveliminar);
            regproveedores.add(dtm_provmodificar);
            regproveedores.add(dtm_provexportar);
            regproveedores.add(dtm_provreporte);
            proveedores.add(regproveedores);
            DefaultMutableTreeNode clasyprod = new DefaultMutableTreeNode("Productos, Clasificación y Movimientos");
            DefaultMutableTreeNode categorias = new DefaultMutableTreeNode("Categorías");
            DefaultMutableTreeNode dtm_catguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option58", "Guardar", "multiply.png"));
            DefaultMutableTreeNode dtm_catcancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option59", "Cancelar", "multiply.png"));
            DefaultMutableTreeNode dtm_cateliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option60", "Eliminar", "multiply.png"));
            DefaultMutableTreeNode dtm_catmodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option61", "Modificar", "multiply.png"));
            DefaultMutableTreeNode dtm_catexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option62", "Exportar", "multiply.png"));
            DefaultMutableTreeNode dtm_catreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option63", "Reporte", "multiply.png"));
            categorias.add(dtm_catguardar);
            categorias.add(dtm_catcancelar);
            categorias.add(dtm_cateliminar);
            categorias.add(dtm_catmodificar);
            categorias.add(dtm_catexportar);
            categorias.add(dtm_catreporte);            
            DefaultMutableTreeNode productos = new DefaultMutableTreeNode("Productos");
            DefaultMutableTreeNode dtm_prodguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option64","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_prodcancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option65","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_prodeliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option66","Eliminar","multiply.png"));
            DefaultMutableTreeNode dtm_prodmodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option67","Modificar","multiply.png"));
            DefaultMutableTreeNode dtm_prodexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option68","Exportar","multiply.png"));
            DefaultMutableTreeNode dtm_prodreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option69","Reporte","multiply.png"));
            DefaultMutableTreeNode dtm_proddeshabilitados = new DefaultMutableTreeNode(new MyTreeNode
                    ("option70","ProductosDeshabilitados","multiply.png"));
            DefaultMutableTreeNode dtm_prodproveedor = new DefaultMutableTreeNode(new MyTreeNode
                    ("option71","Proveedor","multiply.png"));
            DefaultMutableTreeNode dtm_prodcategoria = new DefaultMutableTreeNode(new MyTreeNode
                    ("option72","Categoria","multiply.png"));                                 
            productos.add(dtm_prodguardar);
            productos.add(dtm_prodcancelar);
            productos.add(dtm_prodeliminar);
            productos.add(dtm_prodmodificar);
            productos.add(dtm_prodexportar);
            productos.add(dtm_prodreporte);
            productos.add(dtm_proddeshabilitados);
            productos.add(dtm_prodproveedor);
            productos.add(dtm_prodcategoria);
            DefaultMutableTreeNode entradasproducto = new DefaultMutableTreeNode("Entradas de Producto");
            DefaultMutableTreeNode dtm_entprodguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option73","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_entprodcancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option74","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_entprodeliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option75","Eliminar","multiply.png"));
            DefaultMutableTreeNode dtm_entprodexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option76","Exportar","multiply.png"));
            DefaultMutableTreeNode dtm_entprodreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option77","Reporte","multiply.png"));            
            DefaultMutableTreeNode dtm_entprodcompra = new DefaultMutableTreeNode(new MyTreeNode
                    ("option78","IdCompra","multiply.png"));            
            DefaultMutableTreeNode dtm_entprodidalm = new DefaultMutableTreeNode(new MyTreeNode
                    ("option79","Almacen","multiply.png"));
            DefaultMutableTreeNode dtm_entprodidpas = new DefaultMutableTreeNode(new MyTreeNode
                    ("option80","Pasillo","multiply.png"));
            DefaultMutableTreeNode dtm_entprodidana = new DefaultMutableTreeNode(new MyTreeNode
                    ("option81","Anaquel","multiply.png"));
            DefaultMutableTreeNode dtm_entprodidbin = new DefaultMutableTreeNode(new MyTreeNode
                    ("option82","Bin","multiply.png"));
            DefaultMutableTreeNode dtm_entprodproducto = new DefaultMutableTreeNode(new MyTreeNode
                    ("option83","Producto","multiply.png"));
            DefaultMutableTreeNode dtm_entprodactcant = new DefaultMutableTreeNode(new MyTreeNode
                    ("option84","Actualizar cantidad","multiply.png"));
            entradasproducto.add(dtm_entprodguardar);
            entradasproducto.add(dtm_entprodcancelar);
            entradasproducto.add(dtm_entprodeliminar);
            entradasproducto.add(dtm_entprodexportar);
            entradasproducto.add(dtm_entprodreporte);  
            entradasproducto.add(dtm_entprodcompra);  
            entradasproducto.add(dtm_entprodidalm);
            entradasproducto.add(dtm_entprodidpas);
            entradasproducto.add(dtm_entprodidana);
            entradasproducto.add(dtm_entprodidbin);
            entradasproducto.add(dtm_entprodproducto);
            entradasproducto.add(dtm_entprodactcant);
            DefaultMutableTreeNode movalmacen = new DefaultMutableTreeNode("Movimientos al Almacen");
            DefaultMutableTreeNode dtm_movalmguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option85","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_movalmcancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option86","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_movalmexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option87","Exportar","multiply.png"));
            DefaultMutableTreeNode dtm_movalmreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option88","Reporte","multiply.png"));
            DefaultMutableTreeNode dtm_movalmproducto = new DefaultMutableTreeNode(new MyTreeNode
                    ("option89","Producto","multiply.png"));
            DefaultMutableTreeNode dtm_movalmalmacen = new DefaultMutableTreeNode(new MyTreeNode
                    ("option90","Almacen","multiply.png"));
            DefaultMutableTreeNode dtm_movalmpasillo = new DefaultMutableTreeNode(new MyTreeNode
                    ("option91","Pasillo","multiply.png"));
            DefaultMutableTreeNode dtm_movalmanaquel = new DefaultMutableTreeNode(new MyTreeNode
                    ("option92","Anaquel","multiply.png"));
            DefaultMutableTreeNode dtm_movalmbin = new DefaultMutableTreeNode(new MyTreeNode
                    ("option93","Bin","multiply.png"));            
            movalmacen.add(dtm_movalmguardar);
            movalmacen.add(dtm_movalmcancelar);
            movalmacen.add(dtm_movalmexportar);
            movalmacen.add(dtm_movalmreporte);        
            movalmacen.add(dtm_movalmproducto);
            movalmacen.add(dtm_movalmalmacen);
            movalmacen.add(dtm_movalmpasillo);
            movalmacen.add(dtm_movalmanaquel);
            movalmacen.add(dtm_movalmbin);
            clasyprod.add(categorias);
            clasyprod.add(productos);
            clasyprod.add(entradasproducto);
            clasyprod.add(movalmacen);
            DefaultMutableTreeNode inventarios = new DefaultMutableTreeNode("Inventarios");
            DefaultMutableTreeNode almacenes = new DefaultMutableTreeNode("Almacenes");
            DefaultMutableTreeNode dtm_almguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option94","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_almcancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option95","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_almeliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option96","Eliminar","multiply.png"));
            DefaultMutableTreeNode dtm_almmodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option97","Modificar","multiply.png"));
            DefaultMutableTreeNode dtm_almexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option98","Exportar","multiply.png"));
            DefaultMutableTreeNode dtm_almreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option99","Reporte","multiply.png"));
            almacenes.add(dtm_almguardar);
            almacenes.add(dtm_almcancelar);
            almacenes.add(dtm_almeliminar);
            almacenes.add(dtm_almmodificar);
            almacenes.add(dtm_almexportar);
            almacenes.add(dtm_almreporte);
            DefaultMutableTreeNode pasillos = new DefaultMutableTreeNode("Pasillos");
            DefaultMutableTreeNode dtm_pasguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option100","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_pascancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option101","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_paseliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option102","Eliminar","multiply.png"));
            DefaultMutableTreeNode dtm_pasmodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option103","Modificar","multiply.png"));
            DefaultMutableTreeNode dtm_pasexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option104","Exportar","multiply.png"));
            DefaultMutableTreeNode dtm_pasreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option105","Reporte","multiply.png"));
            DefaultMutableTreeNode dtm_pasalmacen = new DefaultMutableTreeNode(new MyTreeNode
                    ("option106","Almacen","multiply.png"));
            pasillos.add(dtm_pasguardar);
            pasillos.add(dtm_pascancelar);
            pasillos.add(dtm_paseliminar);
            pasillos.add(dtm_pasmodificar);
            pasillos.add(dtm_pasexportar);
            pasillos.add(dtm_pasreporte);
            pasillos.add(dtm_pasalmacen);
            
            DefaultMutableTreeNode anaqueles = new DefaultMutableTreeNode("Anaqueles");
            DefaultMutableTreeNode dtm_anaguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option107","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_anacancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option108","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_anaeliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option109","Eliminar","multiply.png"));
            DefaultMutableTreeNode dtm_anamodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option110","Modificar","multiply.png"));
            DefaultMutableTreeNode dtm_anaexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option111","Exportar","multiply.png"));
            DefaultMutableTreeNode dtm_anareporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option112","Reporte","multiply.png"));
            DefaultMutableTreeNode dtm_anapasillo = new DefaultMutableTreeNode(new MyTreeNode
                    ("option113","Pasillo","multiply.png"));
            anaqueles.add(dtm_anaguardar);
            anaqueles.add(dtm_anacancelar);
            anaqueles.add(dtm_anaeliminar);
            anaqueles.add(dtm_anamodificar);
            anaqueles.add(dtm_anaexportar);
            anaqueles.add(dtm_anareporte);
            anaqueles.add(dtm_anapasillo);
            DefaultMutableTreeNode bines = new DefaultMutableTreeNode("Bines");
            DefaultMutableTreeNode dtm_binesguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option114","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_binescancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option115","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_bineseliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option116","Eliminar","multiply.png"));
            DefaultMutableTreeNode dtm_binesmodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option117","Modificar","multiply.png"));
            DefaultMutableTreeNode dtm_binesexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option118","Exportar","multiply.png"));
            DefaultMutableTreeNode dtm_binesreporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option119","Reporte","multiply.png"));
            DefaultMutableTreeNode dtm_binesanaquel = new DefaultMutableTreeNode(new MyTreeNode
                    ("option120","Anaquel","multiply.png"));
            bines.add(dtm_binesguardar);
            bines.add(dtm_binescancelar);
            bines.add(dtm_bineseliminar);
            bines.add(dtm_binesmodificar);
            bines.add(dtm_binesexportar);
            bines.add(dtm_binesreporte);
            bines.add(dtm_binesanaquel);
            DefaultMutableTreeNode ajustesinventario = new DefaultMutableTreeNode("Ajustes a Inventarios");
            DefaultMutableTreeNode dtm_ajustesguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option129","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_ajustescancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option130","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_ajustesproducto = new DefaultMutableTreeNode(new MyTreeNode
                    ("option131","Producto","multiply.png"));
            ajustesinventario.add(dtm_ajustesguardar);
            ajustesinventario.add(dtm_ajustescancelar);
            ajustesinventario.add(dtm_ajustesproducto);
            inventarios.add(almacenes);
            inventarios.add(pasillos);
            inventarios.add(anaqueles);
            inventarios.add(bines);
            inventarios.add(ajustesinventario);
            DefaultMutableTreeNode finanzas = new DefaultMutableTreeNode("Finanzas");
            DefaultMutableTreeNode corte = new DefaultMutableTreeNode("Corte");
            DefaultMutableTreeNode dtm_calcularcorte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option132","Calcular Corte","multiply.png"));
            DefaultMutableTreeNode dtm_saldarcorte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option133","Saldar Corte","multiply.png"));
            DefaultMutableTreeNode dtm_cancelarcorte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option134","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_reportecorte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option135","Reporte","multiply.png"));
            DefaultMutableTreeNode dtm_buscarcorte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option136","Buscar","multiply.png"));
            DefaultMutableTreeNode dtm_exportarcorte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option137","Exportar","multiply.png"));
            corte.add(dtm_calcularcorte);
            corte.add(dtm_saldarcorte);
            corte.add(dtm_cancelarcorte);
            corte.add(dtm_reportecorte);
            corte.add(dtm_buscarcorte);
            corte.add(dtm_exportarcorte);
            DefaultMutableTreeNode caja = new DefaultMutableTreeNode("Caja");
            DefaultMutableTreeNode dtm_cajaguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option138","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_cajacancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option139","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_cajaeliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option140","Eliminar","multiply.png"));
            DefaultMutableTreeNode dtm_cajamodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option150","Modificar","multiply.png"));
            DefaultMutableTreeNode dtm_cajaexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option151","Exportar","multiply.png"));
            DefaultMutableTreeNode dtm_cajareporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option152","Reporte","multiply.png"));
            caja.add(dtm_cajaguardar);
            caja.add(dtm_cajacancelar);
            caja.add(dtm_cajaeliminar);
            caja.add(dtm_cajamodificar);
            caja.add(dtm_cajaexportar);
            caja.add(dtm_cajareporte);
            finanzas.add(corte);
            finanzas.add(caja);
            parametros = new DefaultMutableTreeNode("Parametros");
            DefaultMutableTreeNode usuarios = new DefaultMutableTreeNode("Registro de Usuarios");
            DefaultMutableTreeNode dtm_usuguardar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option153","Guardar","multiply.png"));
            DefaultMutableTreeNode dtm_usucancelar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option154","Cancelar","multiply.png"));
            DefaultMutableTreeNode dtm_usueliminar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option155","Eliminar","multiply.png"));
            DefaultMutableTreeNode dtm_usumodificar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option156","Modificar","multiply.png"));
            DefaultMutableTreeNode dtm_usuexportar = new DefaultMutableTreeNode(new MyTreeNode
                    ("option157","Exportar","multiply.png"));
            DefaultMutableTreeNode dtm_usureporte = new DefaultMutableTreeNode(new MyTreeNode
                    ("option158","Reporte","multiply.png"));
            usuarios.add(dtm_usuguardar);
            usuarios.add(dtm_usucancelar);
            usuarios.add(dtm_usueliminar);
            usuarios.add(dtm_usumodificar);
            usuarios.add(dtm_usuexportar);
            usuarios.add(dtm_usureporte);
            parametros.add(usuarios);
            root.add(ventas);
            root.add(compras);
            root.add(devoluciones);
            root.add(proveedores);
            root.add(clasyprod);
            root.add(inventarios);
            root.add(finanzas);
            root.add(parametros);
            dtm = new DefaultTreeModel(root);
            jtree.setModel(dtm);
            
        }catch(Exception ex){
            jtm.jTextAreaError("ERROR: Tree error 001."+ex.getMessage(), ex);
        }
                
    }
    
}
