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
public class UncheckedCustomizeJTMenu {
    
        
    public static boolean checked1, checked2;
    public static boolean renderercheck;
    public static DefaultTreeModel dtm;
    public static DefaultMutableTreeNode root, ventas, regventas, repventas, compras,
            regcompras, concompras, ediprecios, devoluciones, regdevoluciones, proveedores,
            regproveedores, procasmov, categorias, productos, entradasproducto, movimientos, inventarios,
            almacenes, pasillos, anaqueles, bin, ajustesinventario, finanzas, corte, caja,
            parametros, regusuarios, empresas, roles;
    JTextAreaMessages jtm = new JTextAreaMessages();
    
    public void cutomizeTree(JTree jtree){
        try{
           
            root = new DefaultMutableTreeNode("Menu");
            ventas = new DefaultMutableTreeNode("Ventas");
            regventas = new DefaultMutableTreeNode("Registro de Ventas");
            repventas = new DefaultMutableTreeNode("Reporte de Ventas");
            ventas.add(regventas);
            ventas.add(repventas);
            
            compras = new DefaultMutableTreeNode("Compras");
            regcompras = new DefaultMutableTreeNode("Registro de Compras");
            concompras = new DefaultMutableTreeNode("Consulta de Compras");
            ediprecios = new DefaultMutableTreeNode("Edición de Precios");
            compras.add(regcompras);
            compras.add(concompras);
            compras.add(ediprecios);
            
            devoluciones = new DefaultMutableTreeNode("Devoluciones");
            regdevoluciones = new DefaultMutableTreeNode("Registro de Devoluciones");
            devoluciones.add(regdevoluciones);
            
            proveedores =  new DefaultMutableTreeNode("Proveedores");
            regproveedores = new DefaultMutableTreeNode("Registro de Proveedores");
            proveedores.add(regproveedores);
            
            procasmov = new DefaultMutableTreeNode("Productos, Casificación y Movimientos");
            categorias = new DefaultMutableTreeNode("Categorias");
            productos = new DefaultMutableTreeNode("Productos");
            entradasproducto = new DefaultMutableTreeNode("Entradas de Producto");
            movimientos = new DefaultMutableTreeNode("Movimientos al Almacen");
            procasmov.add(categorias);
            procasmov.add(productos);
            procasmov.add(entradasproducto);
            procasmov.add(movimientos);
            
            inventarios = new DefaultMutableTreeNode("Inventarios");
            almacenes = new DefaultMutableTreeNode("Almacenes");
            pasillos = new DefaultMutableTreeNode("Pasillos");
            anaqueles = new DefaultMutableTreeNode("Anaqueles");
            bin = new DefaultMutableTreeNode("Bines");
            ajustesinventario = new DefaultMutableTreeNode("Ajustes a Inventarios");
            inventarios.add(almacenes);
            inventarios.add(pasillos);
            inventarios.add(anaqueles);
            inventarios.add(bin);
            inventarios.add(ajustesinventario);
            
            finanzas = new DefaultMutableTreeNode("Finanzas");
            corte = new DefaultMutableTreeNode("Corte");
            caja = new DefaultMutableTreeNode("Caja");
            finanzas.add(corte);
            finanzas.add(caja);
            
            parametros = new DefaultMutableTreeNode("Parametros");
            regusuarios = new DefaultMutableTreeNode("Registro de Usuarios");
            empresas = new DefaultMutableTreeNode("Empresas");
            roles = new DefaultMutableTreeNode("Roles");
            parametros.add(regusuarios);
            parametros.add(empresas);
            parametros.add(roles);
                        
            root.add(ventas);
            root.add(compras);
            root.add(devoluciones);
            root.add(proveedores);
            root.add(procasmov);
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
