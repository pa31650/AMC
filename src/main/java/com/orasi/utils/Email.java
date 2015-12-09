package com.orasi.utils;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SentDateTerm;

/**
 * This class is used to send and receive email messages
 * @author michael.simpkins
 *
 */
public class Email {
	public String smtpServer = "mailtrap.io";
	public String imapServer = "mailtrap.io";
	public String pop3Server = "mailtrap.io";
	public String emailUsername = "";
	public String emailPassword = "";
	
	static Properties SMTPServerProperties;
	static Properties IMAPServerProperties;
	static Properties POP3ServerProperties;
	static Session getMailSession;
	
	/**
	 * Method for sending emails using the SMTP server
	 * @param toAddress String - The Email address the message will be sent to.
	 * @param subjectLine String - The Subject Line of the email.
	 * @param messageBody String - The body of the email.  Supports basic html formatting.
	 * @return boolean - Whether or not the email was sent.
	 * @author michael.simpkins
	 */
	public boolean Send(String toAddress,String subjectLine,String messageBody){
		
    	Transport transport = null;
		try {
	    	getMailSession = Session.getInstance(SMTPServerProperties, null);
			transport = getMailSession.getTransport("smtp");
	        transport.connect(smtpServer,emailUsername,emailPassword);
		} catch (Exception e1) {
				e1.printStackTrace();
		}
        
        try {
            Message msg = new MimeMessage(getMailSession);
            msg.setFrom(new InternetAddress(emailUsername, "Orasi Selenium"));
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(toAddress, "User"));
            msg.setSubject(subjectLine);
            msg.setSentDate(new Date());
            msg.setContent(messageBody, "text/html");
            
            transport.sendMessage(msg,msg.getAllRecipients());
            transport.close();
        } catch (AddressException e) {
        	e.printStackTrace();
        	return false;
        } catch (MessagingException e) {
        	e.printStackTrace();
        	return false;
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This Method is used to get all unread e-mails from the server.
	 * @return Message[] - An array of message objects
	 * @author michael.simpkins
	 */
	public Message[] getUnreadEmails(){
		
		Store store = null;
		Message[] messages = null;
		//Create connection
		try {
			getMailSession = Session.getDefaultInstance(IMAPServerProperties, null);
			store = getMailSession.getStore("imaps");
	        store.connect(imapServer,emailUsername,emailPassword);
		} catch (Exception e) {
			try {
				getMailSession = Session.getDefaultInstance(POP3ServerProperties, null);
				store = getMailSession.getStore("pop3");
				store.connect(pop3Server,emailUsername,emailPassword);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		//Get Unread Emails
        try {
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            //Get unread messages
            messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        } catch (Exception mex) {
            mex.printStackTrace();
            return null;
        }
        return messages;
	}
	/**
	 * This Method is used to get all e-mails sent in the last x minutes.
	 * @param minutesAgo int - The number of minutes in the past you wish to retrieve e-mails for.
	 * @return Message[] - An array of message objects
	 * @author michael.simpkins
	 */
	public Message[] getEmailsByTime(int minutesAgo){
		
		Store store = null;
		Message[] messages = null;
		//Create connection
		try {
			getMailSession = Session.getDefaultInstance(IMAPServerProperties, null);
			store = getMailSession.getStore("imaps");
	        store.connect(imapServer,emailUsername,emailPassword);
		} catch (Exception e) {
			try {
				getMailSession = Session.getDefaultInstance(POP3ServerProperties, null);
				store = getMailSession.getStore("pop3");
				store.connect(pop3Server,emailUsername,emailPassword);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	        
		}
		//Get Inbox Emails
        try {
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            //Get unread messages
            messages = inbox.search(new SentDateTerm(ComparisonTerm.GT,new Date(new Date().getTime() - minutesAgo * 60 * 1000)));

        } catch (Exception mex) {
            mex.printStackTrace();
            return null;
        }
        return messages;
	}
	/**
	 * The Method is used to configure the SMTP connection settings
	 * @param port Int - The port to connect to (eg. 25,465,587) 
	 * @param auth Boolean - If the server requires user to authenticate before sending a message. (Usually true)
	 * @param tlsEnabled Boolean - Whether to enable TLS 
	 * @author michael.simpkins
	 */
	public void configureSMTPProperties(int port, boolean auth, boolean tlsEnabled){
		SMTPServerProperties = System.getProperties();
		SMTPServerProperties.put("mail.smtp.host", smtpServer);
		SMTPServerProperties.put("mail.smtp.port", port);
		SMTPServerProperties.put("mail.smtp.auth", auth);
		SMTPServerProperties.put("mail.smtp.starttls.enable", tlsEnabled);
	}
	/**
	 * The Method is used to configure the IMAP connection settings
	 * @param port Int - The port to connect to (eg. 25,465,587) 
	 * @param auth Boolean - If the server requires user to authenticate before sending a message. (Usually true)
	 * @param tlsEnabled Boolean - Whether to enable TLS 
	 * @author michael.simpkins
	 */
	public void configureIMAPProperties(int port, boolean auth, boolean tlsEnabled){
		IMAPServerProperties = System.getProperties();
		IMAPServerProperties.put("mail.imaps.host", imapServer);
		IMAPServerProperties.put("mail.imaps.port", port);
		IMAPServerProperties.put("mail.imaps.auth", auth);
		IMAPServerProperties.put("mail.imaps.starttls.enable", tlsEnabled);
	}
	/**
	 * The Method is used to configure the POP3 connection settings
	 * @param port Int - The port to connect to (eg. 25,465,587) 
	 * @param auth Boolean - If the server requires user to authenticate before sending a message. (Usually true)
	 * @param tlsEnabled Boolean - Whether to enable TLS 
	 * @author michael.simpkins
	 */
	public void configurePOP3Properties(int port, boolean auth, boolean tlsEnabled){
		POP3ServerProperties = System.getProperties();
		POP3ServerProperties.put("mail.pop3.host", pop3Server);
		POP3ServerProperties.put("mail.pop3.port", "1100");
		POP3ServerProperties.put("mail.pop3.auth", auth);
		POP3ServerProperties.put("mail.pop3.starttls.enable", tlsEnabled);
	}
	//Getters and Setters
	public String getSMTPServer(){
		return this.smtpServer;
	}
	public String getIMAPServer(){
		return this.imapServer;
	}
	public String getPOP3Server(){
		return this.pop3Server;
	}
	public void setSMTPServer(String newServer){
		this.smtpServer = newServer;
	}
	public void setIMAPServer(String newServer){
		this.imapServer = newServer;
	}
	public void setPOP3Server(String newServer){
		this.pop3Server = newServer;
	}
	public String getEmailAddress(){
		return this.emailUsername;
	}
	public void setEmailUsername(String newUsername){
		this.emailUsername = newUsername;
	}
	public void setEmailPassword(String newPassword){
		this.emailPassword = newPassword;
	}
}