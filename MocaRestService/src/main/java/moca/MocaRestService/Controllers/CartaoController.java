package moca.MocaRestService.Controllers;

import moca.MocaRestService.Domain.Models.Requests.CartaoRequest;
import moca.MocaRestService.Domain.Models.Responses.CartaoResponse;
import moca.MocaRestService.Domain.Models.Responses.CartoesHomeResponse;
import moca.MocaRestService.Domain.Services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartoes/")
public class CartaoController {
    @Autowired
    private CartaoService service;

    @PostMapping
    public ResponseEntity<CartaoResponse> add(@RequestBody CartaoRequest request){
        var result = service.add(request);
        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("{idCliente}/{mes}/{ano}")
    public ResponseEntity<CartoesHomeResponse> get(@PathVariable long idCliente,
                                                  @PathVariable int mes,
                                                  @PathVariable int ano){
        var result = service.get(idCliente, mes, ano);
        return ResponseEntity.status(200).body(result);
    }
}
