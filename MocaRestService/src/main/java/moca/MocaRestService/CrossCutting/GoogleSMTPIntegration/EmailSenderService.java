package moca.MocaRestService.CrossCutting.GoogleSMTPIntegration;

import moca.MocaRestService.Domain.Interfaces.IEmailSenderService;
import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Models.EmailDetails;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailSenderService implements IEmailSenderService {
    @Autowired private JavaMailSender javaMailSender;
    @Autowired private ResourceLoader resourceLoader;
    @Value("${spring.mail.username}") private String username;
    @Value("${spring.mail.host}") private String host;
    @Value("${spring.mail.password}") private String password;
    @Value("${spring.mail.port}") private int port;

    public void sendMail(EmailDetails details) throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

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
            messageHelper.setTo(details.getRecipient());
            messageHelper.setSubject(details.getSubject());
            messageHelper.setText(getHtml(), true);
            mailSender.send(mimeMessage);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    private String getHtml() throws IOException {
        InputStream inputStream = resourceLoader.getResource("classpath:path/to/EmailTemplate.html").getInputStream();
        String html = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        return html;
    }
}
