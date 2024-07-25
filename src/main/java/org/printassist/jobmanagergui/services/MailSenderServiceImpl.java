package org.printassist.jobmanagergui.services;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class MailSenderServiceImpl {

	private static final Properties PROPERTIES = new Properties();
	private static final String USERNAME = "xerox6655@gmx.at";
	private static final String PASSWORD = "gfMe45xhAh9B4Zp";
	private static final String HOST = "mail.gmx.net";
	private static final String PORT = "587";

	static {
		PROPERTIES.put("mail.transport.protocol", "smtp");
		PROPERTIES.put("mail.smtp.host", HOST);
		PROPERTIES.put("mail.smtp.port", PORT);
		PROPERTIES.put("mail.smtp.auth", "true");
		PROPERTIES.put("mail.smtp.starttls.enable", "true");
		PROPERTIES.put("mail.smtp.user", USERNAME);
		PROPERTIES.put("mail.smtp.password", PASSWORD);
		//PROPERTIES.put("mail.smtp.socketFactory.port", "587");
		//PROPERTIES.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	}

	public static void sendPlainTextMail(String from, String to, String subject, List<String> messages, boolean debug) {
		Session session = Session.getInstance(PROPERTIES, new Authenticator()
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(PROPERTIES.getProperty("mail.smtp.user"),
					PROPERTIES.getProperty("mail.smtp.password"));
			}
		});
		session.setDebug(debug);

		try {
			// create a message with headers
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());

			//create message body
			Multipart mp = new MimeMultipart();
			for (String message : messages) {
				MimeBodyPart mbp = new MimeBodyPart();
				mbp.setText(message, "us-ascii");
				mp.addBodyPart(mbp);
			}
			msg.setContent(mp);

			// send the message
			Transport.send(msg);
		} catch (MessagingException mex) {
			mex.printStackTrace();
			Exception ex = null;
			if ((ex = mex.getNextException()) != null) {
				ex.printStackTrace();
			}
		}

	}

}
