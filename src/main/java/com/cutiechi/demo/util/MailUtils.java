package com.cutiechi.demo.util;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.stereotype.Component;

/**
 * 邮件工具类, 使用 Spring Context Support 中的 {@link JavaMailSenderImpl} 和 Java X Mail 发送邮件
 *
 * @author Cutie Chi
 */
@Component
public final class MailUtils {

    /**
     * Mail Sender, Spring 自动注入
     */
    private final MailSender mailSender;

    @Autowired
    public MailUtils (MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * 发送邮件
     *
     * @param mail Simple Mail Message 邮件
     * @return 发送邮件的结果
     */
    public Boolean send (SimpleMailMessage mail) {
        try {
            mailSender.send(mail);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
