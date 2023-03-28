package moca.MocaRestService.Controllers;

import moca.MocaRestService.Domain.Models.Responses.HomeResponse;
import moca.MocaRestService.Domain.Services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/")
public class HomeController {

    @Autowired
    private HomeService service;
    @GetMapping("{idCliente}/{mes}/{ano}")
    public HomeResponse getHome(@PathVariable long idCliente,
                                @PathVariable int mes,
                                @PathVariable int ano){
        return service.getHome(idCliente, mes, ano);
    }
}
