package moca.MocaRestService.Controllers;

import lombok.AllArgsConstructor;
import moca.MocaRestService.Data.Entities.Cliente;
import moca.MocaRestService.Domain.Services.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clients/")
public class ClientController {

    private final ClientService service;

    @GetMapping()
    public List<Cliente> GetAll(){
        return service.GetAll();
    }
}
