/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UUID;

import C.Funciones.JTextAreaMessages;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author jraraujo
 */
public class enviaruuid {
    C.Conexion.Conexion cc = new C.Conexion.Conexion();   
    JTextAreaMessages jtm = new JTextAreaMessages();        
    uuid codreg = new uuid();
    String datainfo;
    
    
    public enviaruuid(){
        
    }
    
    public void enviarNotificacion(){
        datainfo=codreg.generarUUID();        
        Properties props = new Properties();
        // Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        // TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");
        // Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port","587");
        // Nombre del usuario
        props.setProperty("mail.smtp.user", "registro.ttlm@gmail.com");
        // Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");
        //Con esto estamos en disposición de obtener nuestra instancia de Session.
        Session session;
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    public PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("registro.ttlm@gmail.com", "registroTTlm2020$!");
                    }
                });
        try { 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("registro.ttlm@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("registro.ttlm@gmail.com"));
            message.setSubject("Notificacion de USO UUID");
            message.setText(datainfo);
 
            Transport.send(message);
            System.out.println("Notificación enviada");
 
        } catch (MessagingException e) {            
            jtm.jTextAreaError("ERROR: Information ERROR 4014. "+e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
    
}
