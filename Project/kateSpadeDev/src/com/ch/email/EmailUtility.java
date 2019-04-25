package com.ch.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.ch.utils.PropertyUtil;

public class EmailUtility implements com.ch.ksd.utils.constants.FileConstants {
	public static void sendEmail(String subject, String body) {
		final String username = "Chautomailer@chtsinc.com";
		final String password = "Test@12345$";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("AutomationReports@chtsinc.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(PropertyUtil.getConfigValue(EMAILS)));
			message.setSubject(subject);
			message.setText(body);
			message.setContent(body, "text/html;charset=gb2312");

			Transport.send(message);

			System.out.println("Sent Sucessfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void sendFile(String subject, String body, String folder, String fileName) {
		String from = "Chautomailer@chtsinc.com";
		final String username = "Chautomailer@chtsinc.com";
		final String password = "Test@12345$";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("slingutla@chtsinc.com" + "," + PropertyUtil.getConfigValue(EMAILS)));

			message.setSubject(subject);

			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText(body);
			messageBodyPart.setContent(body, "text/html;charset=gb2312");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);

			messageBodyPart = new MimeBodyPart();
			String filename = folder;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
