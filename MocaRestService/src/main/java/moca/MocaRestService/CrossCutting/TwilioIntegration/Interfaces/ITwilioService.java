package moca.MocaRestService.CrossCutting.TwilioIntegration.Interfaces;

import moca.MocaRestService.CrossCutting.TwilioIntegration.Models.SmsSenderRequest;
import org.springframework.stereotype.Service;

@Service
public interface ITwilioService {
    String SendSms(SmsSenderRequest request);
}
