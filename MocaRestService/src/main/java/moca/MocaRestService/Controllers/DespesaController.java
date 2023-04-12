package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import moca.MocaRestService.Domain.Models.Requests.DespesaRequesst;
import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Responses.DespesaResponse;
import moca.MocaRestService.Domain.Services.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Despesas", description = "Grupo de requisições de despesas")
@RestController
@RequestMapping("api/despesas/")
public class DespesaController {

    @Autowired
    private DespesasService service;

    @Operation(summary = "Cadastra uma despesa comum na base de dados", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PostMapping
    public  ResponseEntity<DespesaResponse> add(@RequestBody DespesaRequesst request){
        var result = service.add(request);
        return ResponseEntity.status(201).body(result);
    }

    @Operation(summary = "Cadastra uma despesa parcelada na base de dados", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PostMapping("parcelada")
    public ResponseEntity<List<DespesaResponse>> add(@RequestBody DespesaParceladaRequest request){
        var result =  service.despesaParcelada(request);
        return ResponseEntity.status(201).body(result);
    }

    @Operation(summary = "Realiza o pagamento de uma despesa na base de dados", responses = {
            @ApiResponse(responseCode = "200")
    })
    @PatchMapping("pagar/{idDespesa}")
    public ResponseEntity<DespesaResponse> pay(@PathVariable Long idDespesa){
        var result =  service.pagar(idDespesa);
        return ResponseEntity.status(200).body(result);
    }

    @Operation(summary = "Remove uma despesa na base de dados", responses = {
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("{idDespesa}")
    public ResponseEntity<Void> delete(@PathVariable Long idDespesa){
        service.delete(idDespesa);
        return ResponseEntity.status(200).build();
    }
}
