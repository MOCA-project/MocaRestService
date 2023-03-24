package moca.MocaRestService.Controllers;

import moca.MocaRestService.Data.Entities.Cliente;
import moca.MocaRestService.Domain.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients/")
public class ClientController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente add(@RequestBody Cliente request){
        return service.addClient(request);
    }

}
