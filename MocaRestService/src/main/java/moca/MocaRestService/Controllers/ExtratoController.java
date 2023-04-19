package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import moca.MocaRestService.Domain.Models.Responses.ExtratoResponse;
import moca.MocaRestService.Domain.Services.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Tag(name = "Extrato", description = "Grupo de requisições de extrato")
@RestController
@RequestMapping("api/extrato/")
public class ExtratoController {

    @Autowired
    ExtratoService service;

    @Operation(summary = "Retorna o extrato do cliente referente a data solicitada", responses = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping("{idCliente}/{mes}/{ano}")
    public ResponseEntity<ExtratoResponse> get(@PathVariable long idCliente,
                                              @PathVariable int mes,
                                              @PathVariable int ano){
        var result =  service.get(idCliente, mes, ano);
        return ResponseEntity.status(200).body(result);
    }

    @Operation(summary = "Retorna o extrato do cliente em formato CSV", responses = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping("arquivo/{idCliente}/{mes}/{ano}")
    public Void getCsv (@PathVariable long idCliente,
                        @PathVariable int mes,
                        @PathVariable int ano){

    List<ExtratoResponse> listaExtrato = Collections.singletonList(service.get(idCliente, mes, ano));

    return service.gravaArquivoCsv(listaExtrato,"extrato");
    }

}
