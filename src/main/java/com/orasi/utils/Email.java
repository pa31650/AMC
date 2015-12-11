package com.orasi.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.SentDateTerm;

/**
 * This class is used to send and receive email messages
 * @author michael.simpkins
 *
 */
public class Email {
	//Email Server Properties-----------------------
	public String smtpServer = "mailtrap.io";
	public String imapServer = "mailtrap.io";
	public String pop3Server = "mailtrap.io";
	private int SMTPPort = 465;
	private int IMAPPort = 995;
	private int POP3Port = 1100;
	private String emailUsername = "5254711ebee58d518";
	private String emailPassword = "168b1bb87288b2";
	//---------------------------------------------
	
	static Properties ServerProperties;
	static Session getMailSession;
	
	public Email(){
		ServerProperties = System.getProperties();
		//Setup SMTP
		ServerProperties.put("mail.smtp.host", smtpServer);
		ServerProperties.put("mail.smtp.port", SMTPPort);
		ServerProperties.put("mail.smtp.auth", true);
		ServerProperties.put("mail.smtp.starttls.enable", true);
		//Setup IMAP
		ServerProperties.put("mail.imaps.host", imapServer);
		ServerProperties.put("mail.imaps.port", IMAPPort);
		ServerProperties.put("mail.imaps.auth", true);
		ServerProperties.put("mail.imaps.starttls.enable", true);
		//Setup POP3
		ServerProperties.put("mail.pop3.host", pop3Server);
		ServerProperties.put("mail.pop3.port", POP3Port);
		ServerProperties.put("mail.pop3.auth", true);
		ServerProperties.put("mail.pop3.starttls.enable", true);
	}
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
	    	getMailSession = Session.getInstance(ServerProperties, null);
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
	 * This method attempts to open a email store object using the different protocols
	 * @return Store - The email Store object.
	 * @author michael.simpkins
	 */
	private Store openMailStore(){
		Store store = null;
		getMailSession = Session.getDefaultInstance(ServerProperties, null);
			try{
			store = getMailSession.getStore("imaps");
	        store.connect(imapServer,emailUsername,emailPassword);
			} catch (Exception e1){
				try{
					store = getMailSession.getStore("pop3");
			        store.connect(imapServer,emailUsername,emailPassword);
					} catch (Exception e2){
						e2.printStackTrace();
						return null;
					}
			}	
		return store;
	}
	/**
	 * This Method is used to get all unread e-mails from the server.
	 * @return Message[] - An array of message objects
	 * @author michael.simpkins
	 */
	public Message[] getUnreadEmails(){
		Message[] messages = null;
		Store store = openMailStore();
		
		//Get Unread Emails
        try {
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            //Get unread messages
            messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
			inbox.close(true);
			store.close();
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
		Message[] messages = null;
		Store store = openMailStore();
		//Get Inbox Emails
        try {
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            //Get unread messages
            messages = inbox.search(new SentDateTerm(ComparisonTerm.GT,new Date(new Date().getTime() - minutesAgo * 60 * 1000)));
			inbox.close(true);
			store.close();
        } catch (Exception mex) {
            mex.printStackTrace();
            return null;
        }
        return messages;
	}
	/**
	 * This method retrieves messages sent from a given address.
	 * @param sender String - Email address to search for.
	 * @return Message[] - An array of message objects
	 * @author michael.simpkins
	 */
	public Message[] getEmailsBySender(String sender){
		Message[] messages = null;
		Store store = openMailStore();
		//Get Inbox Emails
        try {
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            //Get unread messages
            messages = inbox.search(new FromTerm(new InternetAddress(sender)));
			inbox.close(true);
			store.close();
        } catch (Exception mex) {
            mex.printStackTrace();
            return null;
        }
        return messages;
	}
	/**
	 * This method will delete multiple message from the inbox.
	 * @param message Message[] - An array of messages to be deleted.
	 * @author michael.simpkins
	 */
	public void deleteMessages(Message[] message){
		for(Message msg:message){
			deleteMessage(msg);
		}
	}
	/**
	 * This method will delete single message from the inbox.
	 * @param message Message - The message to be deleted.
	 * @author michael.simpkins
	 */
	public void deleteMessage(Message message){
		Store store = openMailStore();
		try {
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
			inbox.getMessage(message.getMessageNumber()).setFlag(Flags.Flag.DELETED, true);
			inbox.close(true);
			store.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method deletes all messages from the Inbox folder.
	 * @author michael.simpkins
	 */
	public void ClearInbox(){
		Message[] messages = null;
		Store store = openMailStore();
		//Get Inbox Emails
        try {
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);
            messages = inbox.getMessages();
			inbox.close(true);
			store.close();
        	deleteMessages(messages);
        } catch (Exception mex) {
            mex.printStackTrace();
        }
	}
	
	//Getters and Setters
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