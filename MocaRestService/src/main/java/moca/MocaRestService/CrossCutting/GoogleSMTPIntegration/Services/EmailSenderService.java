package moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Services;


import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Interfaces.IEmailSenderService;
import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Utils.HtmlHelper;
import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import moca.MocaRestService.Domain.Services.ClienteService;
import moca.MocaRestService.Infrastructure.Entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class EmailSenderService implements IEmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    ClienteService clienteService;
    @Value("${spring.mail.username}") private String username;
    @Value("${spring.mail.host}") private String host;
    @Value("${spring.mail.password}") private String password;
    @Value("${spring.mail.port}") private int port;

    @Async
    public void sendMail() throws Exception {
        var clientes = clienteService.getAll();
        List<String> emails = new ArrayList<>();
        for(Cliente cliente : clientes){
            if (LocalDate.now().minusDays(3).isAfter(cliente.getUltimoAcesso())){
                emails.add(cliente.getEmail());
            }
        }

        // Agendar o envio dos emails com intervalo de 5 segundos entre cada envio
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Iterator<String> iterator = emails.iterator();

        Runnable sendEmailTask = new Runnable() {
            @Override
            public void run() {
                if (iterator.hasNext()) {
                    String email = iterator.next();
                    try {
                        // Cria um novo MimeMessage para cada email
                        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
                        messageHelper.setFrom(username);
                        messageHelper.setTo(email);
                        messageHelper.setSubject("Lembrete - MOCA");
                        messageHelper.setText(HtmlHelper.getEmailHtml(), true);
                        javaMailSender.send(mimeMessage);
                        System.out.println("Enviou");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new CustomException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                } else {
                    executorService.shutdown();
                }
            }
        };

        executorService.scheduleAtFixedRate(sendEmailTask, 0, 5, TimeUnit.SECONDS);

        // Aguarda todas as threads terminarem de enviar os emails
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }
}
