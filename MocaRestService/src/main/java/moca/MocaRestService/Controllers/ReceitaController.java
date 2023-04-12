package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Requests.ReceitaRequest;
import moca.MocaRestService.Domain.Models.Responses.ExpenseResponse;
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
}
