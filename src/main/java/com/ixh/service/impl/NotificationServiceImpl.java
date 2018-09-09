package com.ixh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ixh.model.bo.CuponBO;
import com.ixh.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(CuponBO cuponBO) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(cuponBO.getUser().getEmail());
		mail.setFrom("jorgebee65@gmail.com");
		mail.setSubject("Tu Cupón");
		mail.setText("Tu cupón es: "+cuponBO.getCode());
		javaMailSender.send(mail);
	}
	
}
