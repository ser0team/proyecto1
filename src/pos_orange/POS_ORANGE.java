/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_orange;

import C.Funciones.Instancias;
import C.Licencia.verificarlicencia;
import Frames.Licencia.Licencia;

/**
 *
 * @author jraraujo
 */
public class POS_ORANGE {              
        
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        Instancias inst = new Instancias();
        verificarlicencia vl = new verificarlicencia();
        vl.leerLicencia();
        if(vl.leerLicencia() == false || verificarlicencia._licencia.equals("")){
            Licencia lic = new Licencia();
            lic.setVisible(true);
        }else{
            inst.getInstanciasSplashInicio();
        }
    }    
}
