package moca.MocaRestService.Controllers;

import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Requests.ReceitaRequest;
import moca.MocaRestService.Domain.Models.Responses.ExpenseResponse;
import moca.MocaRestService.Domain.Models.Responses.ReceitaResponse;
import moca.MocaRestService.Domain.Services.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas/")
public class ReceitaController {

    @Autowired
    private ReceitasService service;

    @PostMapping
    public ResponseEntity<ReceitaResponse> add(@RequestBody ReceitaRequest request){
        var result =  service.add(request);
        return ResponseEntity.status(201).body(result);
    }
}
