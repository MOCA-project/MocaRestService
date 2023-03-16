package moca.MocaRestService.CrossCutting.TwilioIntegration;

import org.springframework.stereotype.Service;

@Service
public interface ITwilioService {
    String SendSms(SmsSenderRequest request);
}
