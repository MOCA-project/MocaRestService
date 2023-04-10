package moca.MocaRestService.Controllers;

import moca.MocaRestService.Domain.Autenticacao.UsuarioLoginDTO;
import moca.MocaRestService.Domain.Autenticacao.UsuarioTokenDTO;
import moca.MocaRestService.Domain.Models.Requests.ClienteRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import moca.MocaRestService.Domain.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario/")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @PostMapping("cadastrar")
    public ResponseEntity<ClienteResponse> add(@RequestBody ClienteRequest request){
        var result = service.addClient(request);
        return ResponseEntity.status(201).body(result);
    }

    @PostMapping("login")
    public ResponseEntity<UsuarioTokenDTO> login(@RequestBody UsuarioLoginDTO request){
        UsuarioTokenDTO usuarioToken = service.autenticar(request);
        return ResponseEntity.status(200).body(usuarioToken);
    }

}
