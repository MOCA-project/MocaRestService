package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Despesa;
import moca.MocaRestService.Data.Repositories.IExpenseRepository;
import moca.MocaRestService.Domain.Models.Requests.ExpenseRequest;
import moca.MocaRestService.Domain.Models.Responses.ExpenseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    @Autowired
    private IExpenseRepository expenseRepository;

    public ExpenseResponse add(ExpenseRequest request){
        Despesa despesa = new Despesa();
        despesa.setData(request.getData());
        despesa.setDescricao(request.getDescricao());
        despesa.setIdTipoDespesa(request.getIdTipoDespesa());
        despesa.setPaid(request.isPaid());
        despesa.setParcela(request.isParcela());
        despesa.setIdCliente(request.getIdCliente());
        despesa.setValor(request.getValor());

        var response = expenseRepository.save(despesa);

        return new ExpenseResponse(
                response.getIdDespesa(),
                response.getDescricao(),
                response.getValor(),
                response.getData(),
                response.getPaid(),
                response.getParcela(),
                response.getIdCliente(),
                response.getIdTipoDespesa());
    }
}
