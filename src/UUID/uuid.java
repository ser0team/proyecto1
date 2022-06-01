/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UUID;

import C.Licencia.licencia;
import Frames.Login;
import Frames.Menu;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author jraraujo
 */
public class uuid {
    
    public static String OS, HDWR, PROCESSOR, COMPSYS, VENDOR, PROCESSORSN, PROCESSORID, 
            DATAINFO;
    public static int _CONECTADO;
    public static int processors;
     
     public uuid(){
                
     }
     
     public String generarUUID() {
        SystemInfo systeminfo = new SystemInfo();        
        OperatingSystem operatingsystem = systeminfo.getOperatingSystem();        
        OS = operatingsystem.toString();
        System.out.println(OS);
        
        HardwareAbstractionLayer hardwareabstractionlayer = systeminfo.getHardware();
        HDWR = hardwareabstractionlayer.toString();
        System.out.println(HDWR);
        
        CentralProcessor centralprocessor = hardwareabstractionlayer.getProcessor();
        PROCESSOR = centralprocessor.toString();
        System.out.println(PROCESSOR);
        
        ComputerSystem computersystem = hardwareabstractionlayer.getComputerSystem();
        COMPSYS = computersystem.toString();
        System.out.println(COMPSYS);
        
        VENDOR = operatingsystem.getManufacturer();
        System.out.println(VENDOR);
        
        PROCESSORSN = computersystem.getSerialNumber();
        System.out.println(PROCESSORSN);
        
        PROCESSORID = centralprocessor.getIdentifier();
        System.out.println(PROCESSORID);
        
        processors = centralprocessor.getLogicalProcessorCount();
                
        DATAINFO = "OperatingSystem: "+OS+"\n"+"Hardware: "+HDWR+"\n"+"Processor: "+PROCESSOR
                +"\n"+"ComputerSystem: "+COMPSYS+"\n"+"Vendor: "+VENDOR+"\n"
                +"Processor SN: "+PROCESSORSN+"\n"+"Processor ID: "+PROCESSORID+"\n"
                +"ProcessorsCount: "+processors+"\nLicencia: "+licencia._LICENCIA;
        System.out.println("UUID: "+DATAINFO+"\n"+"Conectado: "+Menu.CONECTADO);
                
        return "UUID: "+DATAINFO+"\n"+"Conectado: "+Menu.CONECTADO; 
    }    
    
}
