/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import Clases.EnviarCorreo;
import Clases.GenerarLog;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class prueba extends javax.swing.JFrame {

    private static String emailorigen = "sistemasfesepsa2023@gmail.com";
    private static String psswdrgmail = "urtifcnhenmltypr";
    private String emaildestino = "";
    private String asunto = "";
    private String contenido = "";
    
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    
    public prueba() {
        initComponents();
        mProperties = new Properties();
    }
    
    public void crearCorreo(){
        emaildestino = "a.azanero@fesepsa.pe";
        asunto = "Prueba envio automatico";
        contenido = "Esta es una prueba enviado desde Java";
        
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
    
    public void enviarCorreo(){
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
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EnviarCorreo envio = new EnviarCorreo();
        envio.enviar("a.azanero@fesepsa.pe", "Prueba asunto", "Prueba Contenido");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
