package moca.MocaRestService.Controllers;

import moca.MocaRestService.Domain.Models.Responses.ExtratoResponse;
import moca.MocaRestService.Domain.Models.Responses.HomeResponse;
import moca.MocaRestService.Domain.Services.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extrato/")
public class ExtratoController {

    @Autowired
    ExtratoService service;
    @GetMapping("{idCliente}/{mes}/{ano}")
    public ResponseEntity<ExtratoResponse> get(@PathVariable long idCliente,
                                              @PathVariable int mes,
                                              @PathVariable int ano){
        var result =  service.get(idCliente, mes, ano);
        return ResponseEntity.status(200).body(result);
    }

}
