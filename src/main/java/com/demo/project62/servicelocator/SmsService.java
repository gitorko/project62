package com.demo.project62.servicelocator;

/**
 * EmailService
 */
public class SmsService implements MessagingService {
    public String getMessageBody() {
        return "sms message";
    }

    public String getServiceName() {
        return "SmsService";
    }

}