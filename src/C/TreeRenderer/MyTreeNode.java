/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.TreeRenderer;

/**
 *
 * @author jraraujo
 */
public class MyTreeNode {
    
    private String id, value, icon;
    
    public MyTreeNode(){
        
    }

    public MyTreeNode(String id, String nombre, String imagen) {
        super();
        this.id = id;
        this.value = nombre;
        this.icon = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
}
