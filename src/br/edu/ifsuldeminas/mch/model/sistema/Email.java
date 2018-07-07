package br.edu.ifsuldeminas.mch.model.sistema;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	  public boolean email(String menssagem, String destinatario,String assunto) {
           Properties props = new Properties();
          
           props.put("mail.smtp.host", "smtp.gmail.com");
           props.put("mail.smtp.socketFactory.port", "465");
           props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
           props.put("mail.smtp.auth", "true");
           props.put("mail.smtp.port", "465");

           Session session = Session.getDefaultInstance(props,
                       new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() 
                            {
                                  return new PasswordAuthentication("intersectteste@gmail.com", "intersect123");
                            }
                       });
           
           session.setDebug(false);
           try {
 
                 Message message = new MimeMessage(session); 
                 message.setFrom(new InternetAddress("intersectteste@gmail.com")); //Remetente

                 Address[] toUser = InternetAddress //Destinat�rio(s)
                            .parse(destinatario);  
                 message.setRecipients(Message.RecipientType.TO, toUser);
                 message.setSubject(assunto);//Assunto
                 message.setText(menssagem);
                 
                 Transport.send(message);
            } catch (MessagingException e) {
            	
                 throw new RuntimeException(e);
                 
           }
           
           return true;
     }
}
