package moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Services;


import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Interfaces.IEmailSenderService;
import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Models.EmailDetails;
import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Utils.HtmlHelper;
import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailSenderService implements IEmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String username;
    @Value("${spring.mail.host}") private String host;
    @Value("${spring.mail.password}") private String password;
    @Value("${spring.mail.port}") private int port;

    public String sendSimpleMail(EmailDetails details)
    {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(username);
            mailMessage.setTo(details.getDestinatario());
            mailMessage.setText("<h1> Oi </h1>");
            mailMessage.setSubject(details.getAssunto());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    public String sendMail(EmailDetails details) throws Exception {

        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", Boolean.TRUE);
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", Boolean.TRUE);
        properties.put("mail.smtp.starttls.required", Boolean.TRUE);
        properties.put("mail.smtp.ssl.enable", Boolean.FALSE);
        properties.put("mail.test-connection", Boolean.TRUE);
        properties.put("mail.debug", Boolean.TRUE);

        mailSender.setJavaMailProperties(properties);

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            messageHelper.setFrom(username);
            messageHelper.setTo(details.getDestinatario());
            messageHelper.setSubject(details.getAssunto());
            messageHelper.setText(HtmlHelper.getEmailHtml(), true);
            mailSender.send(mimeMessage);
            return "Email enviado com sucesso";
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
