package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Notificações", description = "Grupo de requisições de notificações")
@RestController
@RequestMapping("api/notificacoes/")
public class NotificacoesController {

    @Autowired
    private ITwilioService twilioService;
    @Autowired
    private IEmailSenderService emailService;

    @Operation(summary = "Envia um SMS com o lembrete de cadastro de despesas", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PostMapping("sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsSenderRequest request){
        var result =  twilioService.SendSms(request);
        return ResponseEntity.status(201).body(result);
    }

    @Operation(summary = "Envia um e-mail com o lembrete de cadastro de despesas", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PostMapping("email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDetails emailDetails) throws Exception {
        var result =  emailService.sendMail(emailDetails);
        return ResponseEntity.status(201).body(result);
    }
}
