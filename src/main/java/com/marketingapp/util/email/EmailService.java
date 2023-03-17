package com.marketingapp.util.email;

public interface EmailService {
	
	public void sendEmail(String to, String subject, String message);
}
