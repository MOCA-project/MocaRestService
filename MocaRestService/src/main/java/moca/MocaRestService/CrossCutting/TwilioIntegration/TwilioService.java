package moca.MocaRestService.CrossCutting.TwilioIntegration;

import com.twilio.Twilio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class TwilioService  implements ITwilioService{
    private final String ACCOUNT_SID = "ACfc50e4937c46f8778c82cd04dbc613f2";
    private final String AUTH_TOKEN = "b11e61ddf7a9283a1df7d15108af9b80";

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
