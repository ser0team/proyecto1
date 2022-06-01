/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.TreeRenderer;

import Frames.Parametros.Parametros;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author jraraujo
 */
public class UncheckedNodeTreeCellRenderer extends DefaultTreeCellRenderer{
    
ImageIcon iconcheck, iconopen, iconclosed, iconxmarc, iconready;
JLabel background;
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree,
      Object value,boolean sel,boolean expanded,boolean leaf,
      int row,boolean hasFocus) {
        Component component = 
                super.getTreeCellRendererComponent(tree, value, sel, expanded, 
                        leaf, row, hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
          if(node.isLeaf()){
            MyTreeNode myTreeNode = (MyTreeNode) node.getUserObject();
            setText(myTreeNode.getValue());              
            if(sel){                 
                myTreeNode.setIcon(Parametros.icon);
                System.out.println("Imagen seleccionada: "+myTreeNode.getIcon());
                iconcheck = new ImageIcon(this.getClass().getResource("/Imagenes/checklist.png"));
                setIcon(iconcheck);               
            }else if(!sel){
                
            }
        }else if(!node.isLeaf()){                           
            iconopen = new ImageIcon(this.getClass().getResource("/Imagenes/ofolder.png"));            
            iconclosed = new ImageIcon(this.getClass().getResource("/Imagenes/folder.png"));            
            setClosedIcon(iconclosed);
            setOpenIcon(iconopen);
        }        
        return component;
    }
    
}
