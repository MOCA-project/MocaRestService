package moca.MocaRestService.Controllers;

import moca.MocaRestService.Domain.Models.Requests.DespesaRequesst;
import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Responses.ExpenseResponse;
import moca.MocaRestService.Domain.Services.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas/")
public class DespesaController {

    @Autowired
    private DespesasService service;

    @PostMapping
    public  ResponseEntity<ExpenseResponse> add(@RequestBody DespesaRequesst request){
        var result = service.add(request);
        return ResponseEntity.status(201).body(result);
    }

    @PostMapping("parcelada")
    public ResponseEntity<List<ExpenseResponse>> add(@RequestBody DespesaParceladaRequest request){
        var result =  service.despesaParcelada(request);
        return ResponseEntity.status(201).body(result);
    }

    @PatchMapping("{idDespesa}-pagar")
    public ResponseEntity<ExpenseResponse> pay(@PathVariable Long idDespesa){
        var result =  service.pagar(idDespesa);
        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("{idDespesa}")
    public ResponseEntity<Void> delete(@PathVariable Long idDespesa){
        service.delete(idDespesa);
        return ResponseEntity.status(200).build();
    }
}
