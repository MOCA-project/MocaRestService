package moca.MocaRestService.Controllers;

import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Interfaces.IEmailSenderService;
import moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Models.EmailDetails;
import moca.MocaRestService.CrossCutting.TwilioIntegration.Interfaces.ITwilioService;
import moca.MocaRestService.CrossCutting.TwilioIntegration.Models.SmsSenderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noticacoes/")
public class NotificationController {

    @Autowired
    private ITwilioService twilioService;
    @Autowired
    private IEmailSenderService emailService;

    @PostMapping("sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsSenderRequest request){
        var result =  twilioService.SendSms(request);
        return ResponseEntity.status(201).body(result);
    }

    @PostMapping("email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDetails emailDetails) throws Exception {
        var result =  emailService.sendMail(emailDetails);
        return ResponseEntity.status(201).body(result);
    }
}
