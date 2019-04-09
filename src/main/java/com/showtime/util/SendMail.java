package com.showtime.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static void send(String address, String content) throws AddressException, MessagingException {
		String from = "1031557588@qq.com";

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议
		props.setProperty("mail.smtp.host", "smtp.qq.com"); // 发件人的邮箱的 SMTP服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 请求认证，参数名称与具体实现有关

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		// 发件人
		message.setFrom(new InternetAddress(from));
		// 收件人
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
		// 发送日期
		message.setSentDate(new Date());
		// 主题
		message.setSubject("验证码");
		// 正文
		message.setText("验证码：" + content);
		// 保存并生成邮件
		message.saveChanges();
		session.setDebug(true);
		Transport transport = session.getTransport("smtp");
		// 授权码
		transport.connect(from, "bvmajezwpyqrbeje");
		// 发送，message.getAllRecipients()获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
}
