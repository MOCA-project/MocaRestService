package moca.MocaRestService.Controllers;

import moca.MocaRestService.Data.Entities.Porquinho;
import moca.MocaRestService.Domain.Models.Requests.PorquinhoRequest;
import moca.MocaRestService.Domain.Models.Responses.PorquinhoResponse;
import moca.MocaRestService.Domain.Services.PorquinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/porquinhos/")
public class PorquinhoController {

    @Autowired
    PorquinhoService service;

    @PostMapping
    public PorquinhoResponse add(@RequestBody PorquinhoRequest request){
        return service.addPorquinho(request);
    }

    @GetMapping
    public List<Porquinho> get(){
        return service.getAllPorquinho();
    }

    @GetMapping("/{idCliente}/{idPorquinho}")
    public PorquinhoResponse getPorquinho(@PathVariable long idCliente, @PathVariable long idPorquinho){
        return service.getPorquinhoId(idCliente, idPorquinho);
    }

    @PutMapping("/adicionarValor/{idCliente}/{idPorquinho}/{valorAdicionar}")
    public ResponseEntity<Void> adicionarValor (@PathVariable long idCliente, @PathVariable long idPorquinho,
                                                @PathVariable double valorAdicionar){
        return service.adicionarValor(idCliente,idPorquinho, valorAdicionar);
    }

    @PutMapping("/retirarValor/{idCliente}/{idPorquinho}/{valorRetirar}")
    public ResponseEntity<Void> retirarValor (@PathVariable long idCliente, @PathVariable long idPorquinho,
                                              @PathVariable double valorRetirar){
        return service.retirarValor(idCliente, idPorquinho, valorRetirar);
    }

    @DeleteMapping("/{idCliente}/{idPorquinho}/")
    public ResponseEntity<Void> excluirPorquinho (@PathVariable long idCliente, @PathVariable long idPorquinho){
        return service.excluirPorquinho(idCliente, idPorquinho);
    }

    //porcentagem

    @PutMapping("/finalizarPorquinho/{idCliente}/{idPorquinho}")
    public ResponseEntity<Void> finalizarPorquinho (@PathVariable long idCliente, @PathVariable long idPorquinho){
        return service.finalizarPorquinho(idCliente,idPorquinho);
    }
}