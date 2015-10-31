package com.shin.pay.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author gaoshiliang
 * @Date 15/10/27.
 */
public class Email {
    private static final Logger logger = LoggerFactory.getLogger(Email.class);

    private static Properties properties = null;

    public static final String OPERATORS = "OPERATORS.EMAILLIST";

    static {
        Resource resource = new ClassPathResource("email.properties");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        try {
            properties = PropertiesLoaderUtils.loadProperties(encodedResource.getResource());
        } catch (IOException e) {
            logger.error(" IOException:", e);
        }
    }

    private static boolean Email(String[] sendTo, String subject, String text) {
        try {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setHost(properties.getProperty("ACCOUNT.HOST"));

            MimeMessage msg = javaMailSender.createMimeMessage();

            MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");
            messageHelper.setTo(sendTo);
            messageHelper.setFrom(properties.getProperty("ACCOUNT.EMAIL.ADDRESS"));
            messageHelper.setSubject(subject);
            messageHelper.setText(text);

            javaMailSender.setUsername(properties.getProperty("ACCOUNT.USERNAME"));
            javaMailSender.setPassword(properties.getProperty("ACCOUNT.PASSWORD"));

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.timeout", "25000");
            javaMailSender.setJavaMailProperties(properties);
            javaMailSender.send(msg);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean sendEmail(String toAddr,String subject,String text){
        String list = properties.getProperty(toAddr);
        String[] toAddrs=list.split(",");
        return Email(toAddrs,subject,text);
    }
}
