package com.orasi.utils;

import javax.mail.Message;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmailTest {

	Email email = new Email();
	  
	@Test
	public void SendEmail() {
		int msgBeforeCount = email.getEmailsBySender(email.emailUsername).length;
		email.Send("michael.simpkins@orasi.com","Test 1","It worked.");
		Message[] messages = email.getEmailsBySender(email.emailUsername);
		Assert.assertTrue(messages.length>msgBeforeCount);
		}
	  
	@Test
	public void DeleteEmails(){
		email.Send("michael.simpkins@orasi.com","Test 1","It worked.");
		Message[] messages = email.getEmailsByTime(5);
		email.deleteMessages(messages);
		messages = email.getEmailsByTime(5);
		Assert.assertTrue(messages.length==0);
	}
	
	@BeforeClass
	public void ConfigureEmailServers(){
		email.configureSMTPProperties(465, true, true);
		email.configurePOP3Properties(1100, true, true); 
		email.ClearInbox();
	}
}
