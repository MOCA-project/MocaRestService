package moca.MocaRestService.Controllers;

import moca.MocaRestService.Domain.Models.Requests.CartaoRequest;
import moca.MocaRestService.Domain.Models.Responses.CartaoResponse;
import moca.MocaRestService.Domain.Models.Responses.CartoesHomeResponse;
import moca.MocaRestService.Domain.Services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards/")
public class CartaoController {
    @Autowired
    private CartaoService service;

    @PostMapping
    public CartaoResponse add(@RequestBody CartaoRequest request){
        return service.add(request);
    }

    @GetMapping("{idCliente}/{mes}/{ano}")
    public CartoesHomeResponse get(@PathVariable long idCliente,
                                   @PathVariable int mes,
                                   @PathVariable int ano){
        return service.get(idCliente, mes, ano);
    }
}
