/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.faculdade.projetopoo.services;

import java.util.Base64;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Diego
 */
public class EmailService {
    
    public static void sendEmail(
                                 String title,
                                 String[] destinatarios,
                                 String text){
        Properties props = new Properties();
        
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        //host
        props.put("mail.smtp.host", "smtp.gmail.com");
        //porta
        props.put("mail.smtp.port", "465");
        
        Authenticator autenticador = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("isshinhardmode@gmail.com",descriptografia("dWVrcGJ0ampwcmlidnlmZg=="));
            }
        };

        try {
            Session session = Session.getInstance(props, autenticador );
            Message msg = new MimeMessage(session);
            
            InternetAddress[] address = new InternetAddress[destinatarios.length];
            for (int x = 0; x< destinatarios.length; x++){
                address[x] = new InternetAddress(destinatarios[x].replaceAll(" ", ""));
            }
//            address[destinatarios.length] = new InternetAddress("isshinhardmode@gmail.com");

            msg.setFrom(new InternetAddress("isshinhardmode@gmail.com"));
            msg.addRecipients(Message.RecipientType.TO, address );
            msg.setSubject(title);

            MimeBodyPart texto = new MimeBodyPart();
            texto.setContent(text,"text/html");

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(texto);
//            for(String path: pathArquivo){
//                if (path != ""){
//                    MimeBodyPart arquivo = new MimeBodyPart();
//
//                    FileDataSource fds = new FileDataSource(path);
//                    arquivo.setDataHandler(new DataHandler(fds));
//                    arquivo.setFileName(fds.getName());
//                    mp.addBodyPart(arquivo);
//                }
//            } 
            msg.setContent(mp);
            Transport.send(msg);
            
        } catch (AddressException ex) {
            System.out.println("br.com.lopesecia.gp.api.ApiEnvioEmail.sendEmail() AddressException\n"+ex);
        } catch (MessagingException ex) {
            System.out.println("br.com.lopesecia.gp.api.ApiEnvioEmail.sendEmail() MessagingException\n"+ex);
        }
    }
    
    public static String criptografia(String valor){
        return new String(Base64.getEncoder().encode(valor.getBytes()));
    }
    
    public static String descriptografia(String valor){
        return new String(Base64.getDecoder().decode(valor.getBytes()));
    }
    
}
