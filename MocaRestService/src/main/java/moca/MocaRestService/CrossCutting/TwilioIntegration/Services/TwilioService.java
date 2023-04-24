package moca.MocaRestService.CrossCutting.TwilioIntegration.Services;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import moca.MocaRestService.CrossCutting.TwilioIntegration.Interfaces.ITwilioService;
import moca.MocaRestService.CrossCutting.TwilioIntegration.Models.SmsSenderRequest;
import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TwilioService  implements ITwilioService {
    @Value("${twilio.account.sid}") private String ACCOUNT_SID;
    @Value("${twilio.auth.token}") private String AUTH_TOKEN;
    @Value("${sms.lembrete}") private String lembreteMsg;
    @Value("${sms.limite}") private String limiteMsg;

    @Override
    public String SendSms(SmsSenderRequest request) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        }catch (ApiException ex){
            throw new CustomException(ex.getMessage(), HttpStatus.valueOf(ex.getStatusCode()));
        }

        try {
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber("+55" + request.getDestinatario()),
                            new com.twilio.type.PhoneNumber("+12677622210"),
                            lembreteMsg)
                    .create();

            return message.getStatus().toString();
        }catch (ApiException ex){
            throw new CustomException(ex.getMessage(), HttpStatus.valueOf(ex.getStatusCode()));
        }
    }

    public void enviarAvisoLimite(String destinatario) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        }catch (ApiException ex){
            throw new CustomException(ex.getMessage(), HttpStatus.valueOf(ex.getStatusCode()));
        }

        try {
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber("+55" + destinatario),
                            new com.twilio.type.PhoneNumber("+12677622210"),
                            limiteMsg)
                    .create();

        }catch (ApiException ex){
            throw new CustomException(ex.getMessage(), HttpStatus.valueOf(ex.getStatusCode()));
        }
    }
}
