package moca.MocaRestService.CrossCutting.GoogleSMTPIntegration;

public interface IEmailSenderService {
    String sendMail(EmailDetails details) throws Exception;
}
