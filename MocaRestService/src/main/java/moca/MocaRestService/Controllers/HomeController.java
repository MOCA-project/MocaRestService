package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import moca.MocaRestService.Domain.Models.Responses.HomeResponse;
import moca.MocaRestService.Domain.Services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Home", description = "Grupo de requisições de home")
@RestController
@RequestMapping("api/home/")
public class HomeController {

    @Autowired
    private HomeService service;

    @Operation(summary = "Retorna os dados da Home", responses = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping("{idCliente}/{mes}/{ano}")
    public ResponseEntity<HomeResponse> getHome(@PathVariable long idCliente,
                                               @PathVariable int mes,
                                               @PathVariable int ano){
        var result =  service.getHome(idCliente, mes, ano);
        return ResponseEntity.status(200).body(result);
    }
}
