package com.forum.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by haitang on 2017/6/9.
 */
public class EmailUtils {

    /**
     *
     * @param toEmail
     * @param code
     */
    public static void sendEmail(String toEmail,String code){
        // 收件人电子邮箱
       // String toEmail = "user@cht.com";
        // 发件人电子邮箱
        String fromEmail = "Admin@cht.com";
        // 指定发送邮件的主机为 smtp.cht.com
        String host = "smtp.cht.com";  //邮件服务器
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("localhost", host);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("Admin@cht.com", "123456"); //发件人邮件用户名、密码
            }
        });
        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(fromEmail));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toEmail));
            // Set Subject: 头部头字段
            message.setSubject("来自cht网站的激活邮箱!","UTF-8");
            // 设置消息体
           // message.setText("<h1>来自cht网站的激活邮件,请点击以下链接激活</h1><h3><a href=\"http://localhost:8081/Forum/register\">激活</a></h3>");
            message.setContent("<h1>来自cht网站的激活邮件,请点击以下链接激活</h1><h3><a href=\"http://localhost:8081/Forum/activateUser?code="+code+"\">激活账户</a></h3>","text/html;charset=UTF-8");
            // 发送消息
            Transport.send(message);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    public static void main(String[] args){
        EmailUtils.sendEmail("user@cht.com","aa");
    }
}
