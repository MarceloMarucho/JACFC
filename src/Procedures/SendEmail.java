/******************************************************************************
 *
 * Original Author: Esteban Valderrama
 * Description: This class contains the send an email.
 *
 *****************************************************************************/

package Procedures;

import Classes.Utilities;
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
   
/******************************************************************************
 *
 * Procedure Name: send_mail_Attachment
 * Original Author: Esteban Valderrama
 * Description: This method sends the email with attachment.
 * 
 * Calling Arguments:
 *     Name         -> from
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains the email address csdfts.comphys@gmail.com.
 *
 *     Name         -> to
 *     Input/Output -> I
 *     Type         -> String[]
 *     Description  -> Contains the email addresses csdfts.comphys@gmail.com and developer's.
 * 
 *     Name         -> subject
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains subject for email.
 * 
 *     Name         -> message
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains email message.
 * 
 *     Name         -> attachment
 *     Input/Output -> I
 *     Type         -> File
 *     Description  -> Contains file to be send.
 * 
 *     Name         -> attahcmentPath
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains path for the file.
 * 
 * Return Value:
 *     Name         -> -         
 *     Type         -> Boolean
 *     Description  -> It is TRUE is the email has been sent successfully, otherwise FALSE.
 *
 * Local Variables:
 *     Name         -> host 
 *     Type         -> String
 *     Description  -> mail host smtp.gmail.com.
 * 
 *     Name         -> props
 *     Type         -> Properties
 *     Description  -> email connection properties.
 * 
 *     Name         -> session    
 *     Type         -> Session
 *     Description  -> Initiates the session/process to send the email.
 * 
 *     Name         -> mimeMessage
 *     Type         -> MimeMessage
 *     Description  -> Allows to start a message in the email session.
 * 
 *     Name         -> toAddress
 *     Type         -> InternetAddress[]
 *     Description  -> Array that contains the email addresses.
 * 
 *     Name         -> messageBodyPart
 *     Type         -> BodyPart
 *     Description  -> Instance to set the email message.
 * 
 *     Name         -> Multipart
 *     Type         -> multipart
 *     Description  -> Instance to set the multipart email (email message and attachment).
 * 
 *     Name         -> source
 *     Type         -> DataSource
 *     Description  -> Contains the data file to be send it.
 * 
 *     Name         -> transport
 *     Type         -> Transport
 *     Description  -> Provides the connection to the mail server and account.
 * 
 * Global Variables:
 *     Name         -> emailSent
 *     Type         -> Boolean
 *     Origin       -> Utilities
     Description  -> It is TRUE is the email has been sent successfully, otherwise FALSE.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param from
     * @param password
     * @param to
     * @param subject
     * @param message
     * @param attachment
     * @param attachmentPath
     * @return 
 *****************************************************************************/
    public static boolean send_mail_Attachment(String from, String password, 
                                              String to[], String subject, 
                                              String message, File attachment, 
                                              String attachmentPath){
        
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth","true");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage mimeMessage = new MimeMessage(session);
 
        try {
            mimeMessage.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++){
                toAddress[i] = new InternetAddress(to[i]);
            }
            for (InternetAddress toAddres : toAddress) {
                mimeMessage.addRecipient(RecipientType.TO, toAddres);
            }
            mimeMessage.setSubject(subject);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(message);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachment);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(attachmentPath);
            multipart.addBodyPart(messageBodyPart);
            mimeMessage.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            Utilities.setEmailSent((Boolean) true);
            return true;
        } catch (MessagingException me) {
        }
        return false;
    }

/******************************************************************************
 *
 * Procedure Name: send_mail_noAttachment
 * Original Author: Esteban Valderrama
 * Description: This method sends the email with attachment.
 * 
 * Calling Arguments:
 *     Name         -> from
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains the email address csdfts.comphys@gmail.com.
 *
 *     Name         -> to
 *     Input/Output -> I
 *     Type         -> String[]
 *     Description  -> Contains the email addresses csdfts.comphys@gmail.com and developer's.
 * 
 *     Name         -> subject
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains subject for email.
 * 
 *     Name         -> message
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains email message.
 * 
 * Return Value:
 *     Name         -> -         
 *     Type         -> Boolean
 *     Description  -> It is TRUE is the email has been sent successfully, otherwise FALSE.
 *
 * Local Variables:
 *     Name         -> host 
 *     Type         -> String
 *     Description  -> mail host smtp.gmail.com.
 * 
 *     Name         -> props
 *     Type         -> Properties
 *     Description  -> email connection properties.
 * 
 *     Name         -> session    
 *     Type         -> Session
 *     Description  -> Initiates the session/process to send the email.
 * 
 *     Name         -> mimeMessage
 *     Type         -> MimeMessage
 *     Description  -> Allows to start a message in the email session.
 * 
 *     Name         -> toAddress
 *     Type         -> InternetAddress[]
 *     Description  -> Array that contains the email addresses.
 * 
 *     Name         -> source
 *     Type         -> DataSource
 *     Description  -> Contains the data file to be send it.
 * 
 *     Name         -> transport
 *     Type         -> Transport
 *     Description  -> Provides the connection to the mail server and account.
 * 
 * Global Variables:
 *     Name         -> emailSent
 *     Type         -> Boolean
 *     Origin       -> Utilities
     Description  -> It is TRUE is the email has been sent successfully, otherwise FALSE.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param from
     * @param password
     * @param to
     * @param subject
     * @param message
     * @return 
 *****************************************************************************/
    public static boolean send_mail_noAttachment(String from, String password, 
                                                String to[], String subject, 
                                                String message){
        
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth","true");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage mimeMessage = new MimeMessage(session);
 
        try {
            mimeMessage.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++){
                toAddress[i] = new InternetAddress(to[i]);
            }
            for (InternetAddress toAddres : toAddress) {
                mimeMessage.addRecipient(RecipientType.TO, toAddres);
            }
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            Utilities.setEmailSent((Boolean) true);
            return true;
        } catch (MessagingException me) {
        }
        return false;
    }
}