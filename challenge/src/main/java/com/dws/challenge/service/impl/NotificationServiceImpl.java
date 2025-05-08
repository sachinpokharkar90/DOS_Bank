package com.dws.challenge.service.impl;

import com.dws.challenge.service.NotificationService;

public class NotificationServiceImpl implements NotificationService {

	@Override
	public void sendNotification(Long id, String amount) {

		// COde to send Email using SMTP

		System.out.println("Your account==" + id + "has been debited by " + amount + " for the transfer.");

	}

}
