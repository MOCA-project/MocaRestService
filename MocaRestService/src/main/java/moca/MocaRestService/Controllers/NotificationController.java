package moca.MocaRestService.Controllers;

import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Interfaces.IEmailSenderService;
import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Models.EmailDetails;
import moca.MocaRestService.CrossCutting.TwilioIntegration.Interfaces.ITwilioService;
import moca.MocaRestService.CrossCutting.TwilioIntegration.Models.SmsSenderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification/")
public class NotificationController {

    @Autowired
    private ITwilioService twilioService;
    @Autowired
    private IEmailSenderService emailService;

    @PostMapping("sms")
    public String sendSms(@RequestBody SmsSenderRequest request){
        return twilioService.SendSms(request);
    }

    @PostMapping("email")
    public String sendEmail(@RequestBody EmailDetails emailDetails) throws Exception {
        return emailService.sendMail(emailDetails);
    }
}
