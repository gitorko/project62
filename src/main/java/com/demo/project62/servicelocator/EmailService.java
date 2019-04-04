package com.demo.project62.servicelocator;

/**
 * EmailService
 */
public class EmailService implements MessagingService {
    public String getMessageBody() {
        return "email message";
    }

    public String getServiceName() {
        return "EmailService";
    }

}