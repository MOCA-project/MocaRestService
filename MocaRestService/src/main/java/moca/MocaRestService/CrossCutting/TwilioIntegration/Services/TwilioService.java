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
                            GetLembrete())
                    .create();

            return message.getStatus().toString();
        }catch (ApiException ex){
            throw new CustomException(ex.getMessage(), HttpStatus.valueOf(ex.getStatusCode()));
        }
    }

    public static String GetLembrete(){
        return "Sabemos o quão difícil é organizar suas finanças, por isso queremos te ajudar! \\nNão se esqueça de cadastrar seus gastos em nossa plataforma. \\nRegistrar todas as despesas é fundamental para ter uma visão clara de suas finanças e poder tomar decisões mais inteligentes. \\nAproveite todas as funcionalidades da MOCA. \\n\\nConte conosco!";
    }
}
