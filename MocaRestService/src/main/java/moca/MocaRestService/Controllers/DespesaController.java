package moca.MocaRestService.Controllers;

import moca.MocaRestService.Domain.Models.Requests.DespesaRequesst;
import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Responses.ExpenseResponse;
import moca.MocaRestService.Domain.Services.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses/")
public class DespesaController {

    @Autowired
    private DespesasService service;

    @PostMapping
    public ExpenseResponse add(@RequestBody DespesaRequesst request){
       return service.add(request);
    }

    @PostMapping("installment")
    public List<ExpenseResponse> add(@RequestBody DespesaParceladaRequest request){
        return service.installmentExpense(request);
    }

    @PatchMapping("{idDespesa}")
    public ExpenseResponse pay(@PathVariable Long idDespesa){
        return service.pay(idDespesa);
    }

    @DeleteMapping("{idDespesa}")
    public boolean delete(@PathVariable Long idDespesa){
        return service.delete(idDespesa);
    }
}
