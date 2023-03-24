package moca.MocaRestService.CrossCutting.TwilioIntegration.Services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import moca.MocaRestService.CrossCutting.TwilioIntegration.Interfaces.ITwilioService;
import moca.MocaRestService.CrossCutting.TwilioIntegration.Models.SmsSenderRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService  implements ITwilioService {
    @Value("${twilio.account.sid}") private String ACCOUNT_SID;
    @Value("${twilio.auth.token}") private String AUTH_TOKEN;

    @Override
    public String SendSms(SmsSenderRequest request) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(request.getTo()),
                        new com.twilio.type.PhoneNumber("+12677622210"),
                        request.getMessage())
                .create();

        return message.getSid();
    }
}
