/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Parametros;

import C.Funciones.JTextAreaMessages;
import GetSet.gs_parametros;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author jraraujo
 */
public class parametros {
    
    C.Conexion.Conexion cc = new C.Conexion.Conexion();
    JTextAreaMessages jtm = new JTextAreaMessages();
    gs_parametros gs = new gs_parametros();    
    JLabel node;
    public static String rol;
    
    public void jbguardar(int idusuario, String nombre, int idempresa){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            gs.setIdusuario(idusuario);
            gs.setNombre(nombre);
            gs.setIdempresa(idempresa);
            String sql = "insert into roles_usuario(idusuario, rol, idempresa)"
                    + "values('"+gs.getIdusuario()
                    +"','"+gs.getNombre()
                    +"','"+gs.getIdempresa()
                    +"')";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();            
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("Insert Procedure 001."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarEmpleados(JTable jtable, String buscar){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Id");
            dtm.addColumn("Nombre");
            dtm.addColumn("Paterno");
            dtm.addColumn("Materno");
            dtm.addColumn("Usuario");
            dtm.addColumn("Rol");
            
            String sql ="";
            if(buscar.equals("")){
                sql="select idempleado, nombre, paterno, materno, usuario, rol from empleados";
            }else{
                sql="select idempleado, nombre, paterno, materno, usuario, rol from empleados "
                        + "where nombre like CONCAT('"+buscar+"','%_')";
            }
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String data[] = new String[6];
            if(cc._resultSet().first() == false){
                jtable.setEnabled(false);
            }else{
                cc._resultSet().beforeFirst();
                while(cc._resultSet().next()){
                    data[0] = cc._resultSet().getString(1);
                    data[1] = cc._resultSet().getString(2);
                    data[2] = cc._resultSet().getString(3);
                    data[3] = cc._resultSet().getString(4);
                    data[4] = cc._resultSet().getString(5);
                    data[5] = cc._resultSet().getString(6);
                    dtm.addRow(data);
                }
                jtable.setModel(dtm);
            }cc.desconectar();            
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Procedure 002."+ex.getMessage(), ex);
        }
    }
    
    public void revisarAccesos(int idusuario, JTree jtree){
        jtree.addTreeSelectionListener((TreeSelectionEvent e) -> {
            try {
                System.out.println(e.getPath().getLastPathComponent());
                
                cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
                String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
                cc._callablestatement(sql);
                cc._executeProcedureSelect();
                cc._resultSet();
                
                while(cc._resultSet().next()){
                    if(cc._resultSet().getString(1).equals("v_jbnuevo")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ven_Nuevo")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("v_jbaniadir")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ven_Añadir")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("v_jbmiscelaneos")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ven_Miscelaneo")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("v_jbremover")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ven_Remover")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("v_jbsaldar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ven_Saldar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("v_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ven_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }                    
                    if(cc._resultSet().getString(1).equals("cv_jbnuevaventa")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cve_Nuevas Ventas")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("cv_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cve_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("cv_jbbuscar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cve_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("c_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("c_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                                                
                    }
                    if(cc._resultSet().getString(1).equals("c_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }
                    if(cc._resultSet().getString(1).equals("c_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("c_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                        
                    }if(cc._resultSet().getString(1).equals("c_jbproveedor")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Proveedor")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("c_jbagregar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Agregar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("c_jbproducto")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Producto")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("c_jbalmacen")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Almacen")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("c_jbpasillo")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Pasillo")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("c_jbanaquel")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Anaquel")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("c_jbbin")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("com_Bin")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cc_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cco_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cc_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cco_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                        
                    }if(cc._resultSet().getString(1).equals("cc_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cco_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cc_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cco_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cc_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cco_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cc_jbprecios")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cco_Ajustes")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cc_jbproveedor")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cco_Proveedor")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cc_jbbuscar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cco_Buscar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("ep_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("edi_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("ep_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("edi_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                        
                    }if(cc._resultSet().getString(1).equals("ep_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("edi_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ep_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("edi_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ep_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("edi_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                                  
                    }if(cc._resultSet().getString(1).equals("ep_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("edi_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ep_jbproducto")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("edi_Producto")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ep_jbajustes")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("edi_Ajuste")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("ep_jbactualizar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("edi_Actualizar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_exportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                                  
                    }if(cc._resultSet().getString(1).equals("dv_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_jbventa")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Venta")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                                  
                    }if(cc._resultSet().getString(1).equals("dv_jbproducto")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Producto")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_jbalmacen")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Almacen")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_jbpasillo")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Pasillo")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_jbanaquel")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Anaquel")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("dv_jbbin")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("dev_Bin")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pv_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prov_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                                  
                    }if(cc._resultSet().getString(1).equals("pv_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prov_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pv_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prov_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pv_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prov_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pv_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prov_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pv_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prov_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("cl_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cat_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("cl_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cat_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("cl_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cat_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("cl_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cat_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("cl_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cat_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("cl_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("cat_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pr_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prod_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                                  
                    }if(cc._resultSet().getString(1).equals("pr_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prod_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pr_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prod_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pr_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prod_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pr_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prod_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("pr_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("prod_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("al_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("alm_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("al_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("alm_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                                  
                    }if(cc._resultSet().getString(1).equals("al_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("alm_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("al_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("alm_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("al_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("alm_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("al_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("alm_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                                  
                    }if(cc._resultSet().getString(1).equals("ps_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("pas_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ps_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("pas_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ps_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("pas_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ps_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("pas_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ps_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("pas_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ps_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("pas_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("ps_jbalmacen")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("pas_Almacen")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("an_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ana_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });          
                    }if(cc._resultSet().getString(1).equals("an_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ana_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("an_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ana_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("an_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ana_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("an_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ana_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("an_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ana_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("an_jbpasillo")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("ana_Pasillo")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("bn_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("bin_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });                        
                    }if(cc._resultSet().getString(1).equals("bn_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("bin_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("bn_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("bin_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("bn_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("bin_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("bn_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("bin_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("bn_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("bin_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("bn_jbanaquel")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("bin_Anaquel")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("ct_jbccorte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("fin_CalcularCorte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("ct_jbscorte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("fin_SaldarCorte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cj_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("caj_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cj_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("caj_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cj_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("caj_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cj_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("caj_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cj_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("caj_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("cj_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("caj_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("em_jbguardar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("emp_Guardar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("em_jbcancelar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("emp_Cancelar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("em_jbeliminar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("emp_Eliminar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("em_jbmodificar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("emp_Modificar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("em_jbexportar")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("emp_Exportar")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }if(cc._resultSet().getString(1).equals("em_jbreporte")){
                        jtree.setCellRenderer(new DefaultTreeCellRenderer(){
                        @Override
                        public Component getTreeCellRendererComponent(JTree tree,Object value,
                            boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){              
                                
                                node = (JLabel)super.getTreeCellRendererComponent(tree,value,false,
                                  false,true,row,false);
                                                
                                node.setForeground(node.getText().equals("emp_Reporte")?Color.RED:Color.BLACK);         
                            
                            return node;
                        }
                        
                      });
                    }                    
                }   
            } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(parametros.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        });
    }
    
    public String jbremover(int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            while(cc._resultSet().next()){
                rol = cc._resultSet().getString(1);
            }
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Rol Procedure 001."+ex.getMessage(), ex);
        }
        return rol;
    }
    
    public void eliminarRol(int id){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            String sql = "delete from roles_usuario where idusuario='"+id+"'";
            cc._callablestatement(sql);
            cc._executeProcedure();
            cc.desconectar();
        }catch(ClassNotFoundException ex){
            jtm.jTextAreaError("ERROR: Delete Procedure 003."+ex.getMessage(), ex);
        }
    }
    
    public void mostrarRoles(JTable jlista, int idusuario){
        try{
            cc.conexionMySql("127.0.0.1", "3306", "root", "tittan");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Controles Asignados");
            String sql = "select rol from roles_usuario where idusuario='"+idusuario+"'";
            cc._callablestatement(sql);
            cc._executeProcedureSelect();
            cc._resultSet();
            String[] data = new String[1];
            while(cc._resultSet().next()){
                 data[0] = (cc._resultSet().getString(1));
                 dtm.addRow(data);
            }
            jlista.setModel(dtm);
        }catch(ClassNotFoundException | SQLException ex){
            jtm.jTextAreaError("ERROR: Select Rol Procedure 001."+ex.getMessage(), ex);
        }        
    }    
    
}
