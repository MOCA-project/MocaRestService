package moca.MocaRestService.Controllers;

import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Requests.ReceitaRequest;
import moca.MocaRestService.Domain.Models.Responses.ExpenseResponse;
import moca.MocaRestService.Domain.Models.Responses.ReceitaResponse;
import moca.MocaRestService.Domain.Services.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes/")
public class ReceitaController {

    @Autowired
    private ReceitasService service;

    @PostMapping
    public ReceitaResponse add(@RequestBody ReceitaRequest request){
        return service.add(request);
    }

//    @DeleteMapping("{idReceita}")
//    public boolean delete(@PathVariable Long idReceita){
//        return service.delete(idReceita);
//    }
}
