package com.jin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class TaskApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("您好");
        message.setText("测试邮件发送");
        message.setTo("flyterren@163.com");
        message.setFrom("flyterren@163.com");
        mailSender.send(message);
    }
}
