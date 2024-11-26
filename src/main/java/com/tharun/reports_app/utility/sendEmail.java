package com.tharun.reports_app.utility;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class sendEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(String subject, String body, String to, File f){

        try{

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body,true);
            mimeMessageHelper.setTo("t.tharun1999@gmail.com");
            mimeMessageHelper.addAttachment("Plans-Info", f);

            javaMailSender.send(mimeMessage);

        }catch(Exception e){
            
        }
    
    return true;
    }

}
