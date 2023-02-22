/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author aazañero
 */
public class EnviarCorreo {
    private static String emailorigen = "sistemasfesepsa2023@gmail.com";
    private static String psswdrgmail = "urtifcnhenmltypr";
    private String emaildestino = "";
    private String asunto = "";
    private String contenido = "";
    
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    
    public void enviar(String correodestino,String correoasunto,String correocontenido){
        emaildestino = correodestino;
        asunto = correoasunto;
        contenido = correocontenido;
        mProperties = new Properties();
        crearCorreo();
        enviarCorreo();
    }
    
    private void crearCorreo(){
        
        
        mProperties.put("mail.smtp.host","smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust","smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable","true");
        mProperties.setProperty("mail.smtp.port","587");
        mProperties.setProperty("mail.smtp.user",emailorigen);
        mProperties.setProperty("mail.smtp.ssl.protocols","TLSv1.2");
        mProperties.setProperty("mail.smtp.auth","true");
        
        mSession = Session.getDefaultInstance(mProperties);
        
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailorigen));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emaildestino));
            mCorreo.setSubject(asunto);
            mCorreo.setText(contenido,"ISO-8859-1","html");
        } catch (AddressException ex) {
            System.out.println(ex.toString());
        }catch(MessagingException ey){
            System.out.println(ey.toString());
        }
        
    }
    
    
    
    private void enviarCorreo(){
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailorigen,psswdrgmail);
            mTransport.sendMessage(mCorreo,mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            
            JOptionPane.showMessageDialog(null,"Correo Enviado");
        } catch (NoSuchProviderException ex) {
            System.out.println(ex.toString());
        } catch(MessagingException ey){
            System.out.println(ey.toString());
        }
    }
    
}


