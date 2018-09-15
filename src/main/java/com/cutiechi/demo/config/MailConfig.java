package com.cutiechi.demo.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * 邮件配置类
 *
 * @author Cutie Chi
 */
@Configuration
@PropertySource("classpath:mail.properties")
public class MailConfig {

    /**
     * 主机
     */
    @Value("${host}")
    private String host;

    /**
     * 端口号
     */
    @Value("${port}")
    private Integer port;

    /**
     * 发件邮箱
     */
    @Value("${user}")
    private String username;

    /**
     * 授权码
     */
    @Value("${password}")
    private String password;

    /**
     * Debug 日志
     */
    @Value("${debug}")
    private String debug;

    /**
     * SMTP Socket Factory Class
     */
    @Value("${smtp.socketFactory.class}")
    private String smtpSocketFactoryClass;

    /**
     * 鉴权
     */
    @Value("${smtp.auth}")
    private String smtpAuth;

    /**
     * TLS 加密
     */
    @Value("${smtp.starttls.enable}")
    private String smtpStartTlsEnable;

    /**
     * SSL
     */
    @Value("${smtp.ssl.enable}")
    private String smtpSslEnable;

    /**
     * Mail Sender Bean 配置方法
     *
     * @return Mail Sender Bean
     */
    @Bean
    public MailSender mailSender () {

        // 定义 Java Mail Properties 对象
        Properties javaMailProperties = new Properties();

        // 添加 SMTP Socket Factory Class 配置到 Java Mail Properties 对象
        javaMailProperties.setProperty("mail.smtp.socketFactory.class", smtpSocketFactoryClass);

        // 添加鉴权配置到 Java Mail Properties 对象
        javaMailProperties.setProperty("mail.smtp.auth", smtpAuth);

        // 添加 TLS 加密配置到 Java Mail Properties 对象
        javaMailProperties.setProperty("mail.smtp.starttls.enable", smtpStartTlsEnable);

        // 添加 Debug 日志配置到 Java Mail Properties 对象
        javaMailProperties.setProperty("mail.debug", debug);

        // 添加 SSL 配置到 Java Mail Properties 对象
        javaMailProperties.setProperty("mail.smtp.ssl.enable", smtpSslEnable);

        // 定义 Java Mail Sender 实现对象
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        // 为 Java Mail Sender 实现对象设置主机
        mailSender.setHost(host);

        // 为 Java Mail Sender 实现对象设置端口
        mailSender.setPort(port);

        // 为 Java Mail Sender 实现对象设置发件邮箱
        mailSender.setUsername(username);

        // 为 Java Mail Sender 实现对象设置密码
        mailSender.setPassword(password);

        // 为 Java Mail Sender 实现对象设置 Java Mail Properties
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }
}
