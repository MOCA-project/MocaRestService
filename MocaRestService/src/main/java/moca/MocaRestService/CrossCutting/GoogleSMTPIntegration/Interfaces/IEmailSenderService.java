package moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Interfaces;


import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Models.EmailDetails;

public interface IEmailSenderService {
    String sendMail(EmailDetails details) throws Exception;
}
