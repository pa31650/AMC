package com.orasi.utils;

import org.testng.annotations.Test;

public class EmailTest {

  @Test
  public void test() {
	  Email email = new Email();
	  //email.Send("michael.simpkins@orasi.com","Test Email","It worked.");
	  email.configureSMTPProperties(465, true, true);
	  email.configurePOP3Properties(1100, true, true);
	  email.setEmailUsername("5254711ebee58d518");
	  email.setEmailPassword("168b1bb87288b2");
	  email.Send("tester@test.com","Test 1","It worked.");
	  email.Receive();
  }
}
