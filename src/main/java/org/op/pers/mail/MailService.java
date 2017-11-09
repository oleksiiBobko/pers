package org.op.pers.mail;

public interface MailService {
    public void sendMail(String from, String to, String subject, String body);
}
