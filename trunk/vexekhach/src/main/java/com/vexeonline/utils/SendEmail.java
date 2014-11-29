package com.vexeonline.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public void sendEmail(String emailRecive, String subject, String body)
			throws Exception {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");

		Session sessionMail = Session.getDefaultInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"tungnt620@gmail.com", "y15V4S3#WwH#pkE5e692");
					}
				});
		Message message = new MimeMessage(sessionMail);
		message.setFrom(new InternetAddress("tungnt620@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailRecive));
		message.setSubject(subject);
		message.setText(body);
		Transport.send(message);
	}
}
