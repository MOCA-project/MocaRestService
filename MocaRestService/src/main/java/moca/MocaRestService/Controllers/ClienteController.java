package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import moca.MocaRestService.Domain.Autenticacao.UsuarioLoginDTO;
import moca.MocaRestService.Domain.Autenticacao.UsuarioTokenDTO;
import moca.MocaRestService.Domain.Models.Requests.ClienteRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import moca.MocaRestService.Domain.Services.ClienteService;
import moca.MocaRestService.Infrastructure.Entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuários", description = "Grupo de requisições de usuário")
@RestController
@RequestMapping("api/usuarios/")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Operation(summary = "Cadastra um usuário na base de dados", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PostMapping("cadastrar")
    public ResponseEntity<ClienteResponse> add(@RequestBody ClienteRequest request){
        var result = service.addClient(request);
        return ResponseEntity.status(201).body(result);
    }

    @Operation(summary = "Realiza login de um usuário", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PostMapping("login")
    public ResponseEntity<UsuarioTokenDTO> login(@RequestBody UsuarioLoginDTO request){
        UsuarioTokenDTO usuarioToken = service.autenticar(request);
        return ResponseEntity.status(200).body(usuarioToken);
    }

    @Operation(summary = "Retorna todos os usuários cadastrados na base de dados", responses = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        var result = service.getAll();
        return ResponseEntity.status(200).body(result);
    }

}
