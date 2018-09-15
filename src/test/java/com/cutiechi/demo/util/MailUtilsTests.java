package com.cutiechi.demo.util;

import com.cutiechi.demo.ApplicationTests;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 测试邮件工具类
 *
 * @author Cutie Chi
 */
class MailUtilsTests extends ApplicationTests {

    @Autowired
    private MailUtils mailUtils;

    /**
     * 测试发送邮件
     */
    @Test
    void testSend () {

        // 定义 Simple Mail Message 对象
        SimpleMailMessage mail = new SimpleMailMessage();

        // 为 Simple Mail Message 对象设置收件人
        mail.setTo("superchijinpeng@gmail.com");

        // 为 Simple Mail Message 对象设置发件人
        mail.setFrom("Cute Shoes 客服<noreply@cutie.ooo>");

        // 为 Simple Mail Message 对象设置主题
        mail.setSubject("Cute Shoes 注册验证");

        // 为 Simple Mail Message 对象设置内容
        mail.setText("这是一条测试邮件！");

        // 发送邮件
        Boolean sendResult = mailUtils.send(mail);

        // 测试邮件是否发送成功
        assertTrue(sendResult);
    }
}
