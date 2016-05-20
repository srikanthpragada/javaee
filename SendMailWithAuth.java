import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// program to send a message with HTML content

class MyAuthenticator extends Authenticator {
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
	       return new PasswordAuthentication("admin@st.com","admin");
	}
}

public class SendMailWithAuth {

	public static void main(String[] argv) {
		String to = "student@st.com";
		String subject = "HTML Message with authentication";
		String from = "admin@st.com";

		try {
			Properties props = System.getProperties();
			// Get a Session object
			Session session = Session.getDefaultInstance(props, new MyAuthenticator());
			 

			// construct the message
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

			/*
			 * msg.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc
			 * ,false)); msg.setRecipients(Message.RecipientType.BCC,
			 * InternetAddress.parse(bcc,false));
			 */
			msg.setDataHandler(new DataHandler(
					"<html><h1>Simple Message</h1></html>", // String
					"text/html") // MIME
			);
			msg.setSentDate(new Date());
			msg.setSubject(subject);

			// send message
			Transport.send(msg);

			System.out.println("\nMail was sent successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of main

} // end of sendhtml

