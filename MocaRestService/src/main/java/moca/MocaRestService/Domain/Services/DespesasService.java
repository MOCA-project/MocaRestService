package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Despesa;
import moca.MocaRestService.Data.Repositories.IDespesasRepository;
import moca.MocaRestService.Domain.Models.Requests.DespesaRequesst;
import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Responses.ExpenseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DespesasService {
    @Autowired
    private IDespesasRepository expenseRepository;
    @Autowired
    private ClienteService clienteService;

    public ExpenseResponse add(DespesaRequesst request){
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

    public ExpenseResponse pay(Long idDespesa){
        // Atualizando a despesa
        var response = expenseRepository.findById(idDespesa);
        response.ifPresent((Despesa result) -> {
            result.setPaid(true);
            expenseRepository.save(result);
        });

        return new ExpenseResponse(
                response.get().getIdDespesa(),
                response.get().getDescricao(),
                response.get().getValor(),
                response.get().getData(),
                response.get().getPaid(),
                response.get().getParcela(),
                response.get().getIdCliente(),
                response.get().getIdTipoDespesa());

    }

    public List<ExpenseResponse> installmentExpense(DespesaParceladaRequest request){
        List<ExpenseResponse> result = new ArrayList<>();
        for (int i = 0; i < request.getParcelas(); i++) {
            Despesa despesa = new Despesa();
            despesa.setData(request.getData()); // Incrementar mes
            despesa.setDescricao(request.getDescricao());
            despesa.setIdTipoDespesa(request.getIdTipoDespesa());
            despesa.setPaid(false);
            despesa.setParcela(true);
            despesa.setIdCliente(request.getIdCliente());
            despesa.setValor(request.getValor() / request.getParcelas());
            var response = expenseRepository.save(despesa);
            result.add(new ExpenseResponse(
                    response.getIdDespesa(),
                    response.getDescricao(),
                    response.getValor(),
                    response.getData(),
                    response.getPaid(),
                    response.getParcela(),
                    response.getIdCliente(),
                    response.getIdTipoDespesa()));
        }
        return result;
    }

    public boolean delete(Long idDespesa){
        var response = expenseRepository.findById(idDespesa);
        if (response.isPresent()) {
            expenseRepository.deleteById(idDespesa);
            return true;
        }
        else return false;
    }
}
