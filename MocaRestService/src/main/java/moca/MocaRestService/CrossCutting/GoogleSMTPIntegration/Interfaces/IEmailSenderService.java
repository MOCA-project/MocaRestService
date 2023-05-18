package moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Interfaces;

public interface IEmailSenderService {
    void sendMail() throws Exception;
}
