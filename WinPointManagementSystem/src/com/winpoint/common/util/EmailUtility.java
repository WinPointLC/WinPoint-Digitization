package com.winpoint.common.util;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {

	public void sendEmail(ArrayList<String> listOfEmailIds, String emailSubject, String emailMessage) {
		
		for(String email : listOfEmailIds) {
    		System.out.println(email);
    	}
		
		
		Address [] emailAddress = new Address[listOfEmailIds.size()];
		int count = 0;
		for(String email : listOfEmailIds) {
			try {
				emailAddress[count] = new InternetAddress(email);
				count++;
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
				String host = "smtp.gmail.com";
				String user="winpointlc@gmail.com";//Your E-mail-Id
				String pass="winpoint@123";      //your e-mail account password

				String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
//				String to = "dixitabhishek239@gmail.com"; //recipient E-mail-Id
				String from = "dixitabhishek2392@gmail.com"; // Your E-mail Id
				
				
				String subject = emailSubject;
				String messageText = emailMessage;
				
				/*
				 * Launch of new Batch for . . . course
				 * 
				 * */
//				String subject ="Launch of a new Batch for the "+courseName+" course";
				
				/*
				 * 
				 * 1. courseName
				 * 2. StartDate
				 * 3. Timing
				 * 4. contact Details 
				 * win point learning team.
				 * 
				 * */
				
//				String messageText = "Hello,"
//						+ "New "+courseName+" batch is going start from "+startDate+" in the "+timeSlotsName+"";
				boolean sessionDebug = true;
			
			
				Properties props = System.getProperties();
				props.put("mail.host", host);
				props.put("mail.transport.protocol.", "smtp");
				props.put("mail.smtp.auth", "true");
				//props.put("mail.smtp.", "true");
				props.put("mail.smtp.port", "465");//port number 465 for Secure (SSL) and we can also            use port no 587 for Secure (TLS)
				props.put("mail.smtp.socketFactory.fallback", "false");
				props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			
			
				Session mailSession = Session.getDefaultInstance(props, null);
				mailSession.setDebug(sessionDebug);
			
				Transport transport = null;
				Message msg = new MimeMessage(mailSession);
				try {
					
						System.out.println("A");
						msg.setFrom(new InternetAddress(from));
						System.out.println("B");
//						InternetAddress[] address = {new InternetAddress(to)};
						System.out.println("C");
						msg.setRecipients(Message.RecipientType.TO, emailAddress);
						System.out.println("D");
						msg.setSubject(subject);
						System.out.println("E");
						msg.setContent(messageText, "text/html");
						System.out.println("F");
						
					
						transport = mailSession.getTransport("smtp");
						System.out.println("4");
						transport.connect(host, user, pass);
					
						System.out.println("3");
						
				      transport.sendMessage(msg, msg.getAllRecipients());
				      System.out.println("Send Success");
				      boolean WasEmailSent = true; // assume it was sent
				      transport.close();

				 }
				 catch (Exception err) {
					 System.out.println("1");
					 boolean WasEmailSent = false; 
			     }
				
				
				
				
//				try {
//					transport.close();
//				} catch (MessagingException e) {
//					// TODO Auto-generated catch block
//					System.out.println("2");
//					e.printStackTrace();
//				}
		}
				
	
	
}
