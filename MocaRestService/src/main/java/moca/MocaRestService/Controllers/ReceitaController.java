package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import moca.MocaRestService.Domain.Models.Requests.PatchReceitaRequest;
import moca.MocaRestService.Domain.Models.Requests.ReceitaRequest;
import moca.MocaRestService.Domain.Models.Responses.ReceitaResponse;
import moca.MocaRestService.Domain.Services.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Receitas", description = "Grupo de requisições de receitas")
@RestController
@RequestMapping("api/receitas/")
public class ReceitaController {

    @Autowired
    private ReceitasService service;

    @Operation(summary = "Cadastra uma receita comum na base de dados", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PostMapping
    public ResponseEntity<ReceitaResponse> add(@RequestBody ReceitaRequest request){
        var result =  service.add(request);
        return ResponseEntity.status(201).body(result);
    }

    @Operation(summary = "Cadastra uma receita fixa na base de dados", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PostMapping("fixa")
    public ResponseEntity<List<ReceitaResponse>> addFixa(@RequestBody ReceitaRequest request){
        var result = service.postReceitaFixa(request);
        return ResponseEntity.status(201).body(result);
    }

    @Operation(summary = "Remove uma receita na base de dados", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    @DeleteMapping("{idDespesa}")
    public ResponseEntity<Void> delete(@PathVariable long idDespesa){
        service.removeReceita(idDespesa);
        return ResponseEntity.status(200).build();
    }

    @Operation(summary = "Retorna os detalhes das receitas ", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    @GetMapping("{idCliente}/{mes}/{ano}")
    public ResponseEntity<List<ReceitaResponse>> delete(@PathVariable long idCliente,
                                       @PathVariable int mes,
                                       @PathVariable int ano){
        var result = service.get(idCliente, mes, ano);
        return ResponseEntity.status(200).body(result);
    }

    @Operation(summary = "Editar a receita ", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    @PatchMapping("{idReceita}")
    public ResponseEntity<ReceitaResponse> edit(@PathVariable long idReceita, @RequestBody PatchReceitaRequest request){
        var result = service.edit(idReceita, request);
        return ResponseEntity.status(200).body(result);
    }
}
