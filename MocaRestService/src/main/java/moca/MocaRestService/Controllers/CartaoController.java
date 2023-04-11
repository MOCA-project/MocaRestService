package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import moca.MocaRestService.Domain.Models.Requests.CartaoRequest;
import moca.MocaRestService.Domain.Models.Responses.CartaoResponse;
import moca.MocaRestService.Domain.Models.Responses.CartoesHomeResponse;
import moca.MocaRestService.Domain.Services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cartões", description = "Grupo de requisições de cartões")
@RestController
@RequestMapping("api/cartoes/")
public class CartaoController {
    @Autowired
    private CartaoService service;

    @Operation(summary = "Adicionar um cartão na base de dados", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PostMapping
    public ResponseEntity<CartaoResponse> add(@RequestBody CartaoRequest request){
        var result = service.add(request);
        return ResponseEntity.status(201).body(result);
    }

    @Operation(summary = "Retorna os dados para a página dos cartões do cliente", responses = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping("{idCliente}/{mes}/{ano}")
    public ResponseEntity<CartoesHomeResponse> get(@PathVariable long idCliente,
                                                  @PathVariable int mes,
                                                  @PathVariable int ano){
        var result = service.get(idCliente, mes, ano);
        return ResponseEntity.status(200).body(result);
    }
}
