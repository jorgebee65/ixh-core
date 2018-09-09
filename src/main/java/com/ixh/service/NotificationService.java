package com.ixh.service;

import org.springframework.mail.MailException;

import com.ixh.model.bo.CuponBO;

public interface NotificationService {
	public void sendNotification(CuponBO cuponBO) throws MailException;
}
