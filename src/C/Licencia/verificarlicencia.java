/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C.Licencia;

import C.Funciones.Instancias;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jraraujo
 */
public class verificarlicencia {
    
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean valida = false;
    public static String _licencia;
    Instancias inst = new Instancias();
    
    public boolean leerLicencia(){
        try{
            archivo = new File("C:\\ProgramData\\Fenix\\Archivos\\licenciaFX.txt");
            if(!archivo.exists()){
                valida = false;
            }else{
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);            

                String line;
                while((line = br.readLine())!=null){
                    _licencia = line;
                    valida = true;
                    return valida;                  
                }
            }                
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
                if( null != fr){
                    fr.close();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }        
        return valida;
    }    
    
    public void crearArchivo(){
        try{
            String ruta = "C:\\ProgramData\\Fenix\\Archivos\\licenciaFX.txt";
            String linea = licencia._LICENCIA;
            
            File file = new File(ruta);
            if(!file.exists()){
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(linea);
            bw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void abreSplash(){
        try{
            if(_licencia.equals(licencia._LICENCIA)){
                inst.getInstanciasSplashInicio();
            }
        }catch(ClassNotFoundException | InterruptedException ex){
            ex.printStackTrace();
        }
    }
    
}
