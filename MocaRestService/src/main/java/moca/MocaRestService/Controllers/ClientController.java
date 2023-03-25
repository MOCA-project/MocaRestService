package moca.MocaRestService.Controllers;

import moca.MocaRestService.Data.Entities.Cliente;
import moca.MocaRestService.Domain.Models.Requests.ClienteRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import moca.MocaRestService.Domain.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients/")
public class ClientController {

    @Autowired
    private ClienteService service;


    @PostMapping
    public ClienteResponse add(@RequestBody ClienteRequest request){
        return service.addClient(request);
    }

    @GetMapping
    public List<Cliente> get(){
        return service.getAll();
    }


}
