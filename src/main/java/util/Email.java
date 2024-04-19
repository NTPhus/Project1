package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;

public class Email {
	//email: ntipi0810@gmail.com
	//password: perj uwfk gbzz ofjg
	static final String from  = "ntipi0810@gmail.com";
	static final String password = "perj uwfk gbzz ofjg";
	public static boolean sendEmail(String to,String tieuDe, String noidung) {
		//Properties: Khai bao cac thuoc tinh
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP HOST
		props.put("mail.smtp.port", "587"); //TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		//create Authenticator
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
		};
		// Phiên làm việc
		Session session = Session.getInstance(props, auth);
			
		//gửi mail
		MimeMessage msg = new MimeMessage(session);
		
		try {
			//Kiểu nội dung
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			
			//Người gửi
			msg.setFrom(from);
			
			//Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			
			//tiêu đề email
			msg.setSubject(tieuDe);
			
			//Quy định ngày gửi
			msg.setSentDate(new Date());
			
			//Quy định email nhận phản hồi
			//msg.setReplyTo(InternetAddress.parse(from, false);
			
			//Nội dung
			msg.setContent(noidung, "text/HTML; charset=UTF-8");
			
			//gửi email
			Transport.send(msg);
			System.out.println("Gửi mail thành công");
			return true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("gặp lỗi trong quá trình gửi mail");
			return false;
		}
	}
	
	public static void main(String[] args) {
		Email.sendEmail("phu444080@gmail.com", "Tieu de", "noi Dung");
	}
}
