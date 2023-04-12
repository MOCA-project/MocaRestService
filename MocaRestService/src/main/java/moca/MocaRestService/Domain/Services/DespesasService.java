package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Domain.Helper.CustomException;
import moca.MocaRestService.Infrastructure.Entities.Despesa;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import moca.MocaRestService.Domain.Models.Requests.DespesaRequesst;
import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Responses.ExpenseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        despesa.setCartao(request.getIsCartao());
        despesa.setIdCartao(request.getIdCartao());

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

    public ExpenseResponse pagar(Long idDespesa){
        var despesa = expenseRepository.findById(idDespesa);
        if (despesa.isPresent()){
            despesa.get().setPaid(true);
            expenseRepository.save(despesa.get());
        }
        else
            throw new CustomException("Desesa não encontrada", HttpStatus.NOT_FOUND);

        return new ExpenseResponse(
                despesa.get().getIdDespesa(),
                despesa.get().getDescricao(),
                despesa.get().getValor(),
                despesa.get().getData(),
                despesa.get().getPaid(),
                despesa.get().getParcela(),
                despesa.get().getIdCliente(),
                despesa.get().getIdTipoDespesa());
    }

    public List<ExpenseResponse> despesaParcelada(DespesaParceladaRequest request){
        List<ExpenseResponse> result = new ArrayList<>();
        for (int i = 0; i < request.getParcelas(); i++) {
            var dataFutura = request.getData().plusMonths(i);
            Despesa despesa = new Despesa();
            despesa.setData(dataFutura); // Incrementar mes
            despesa.setDescricao(request.getDescricao());
            despesa.setIdTipoDespesa(request.getIdTipoDespesa());
            despesa.setPaid(false);
            despesa.setParcela(true);
            despesa.setIdCliente(request.getIdCliente());
            despesa.setValor(request.getValor() / request.getParcelas());
            despesa.setCartao(true);
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

    public void delete(Long idDespesa){
        var response = expenseRepository.findById(idDespesa);
        if (response.isPresent()) {
            expenseRepository.deleteById(idDespesa);
        }
        throw new CustomException("Despesa não encontrada", HttpStatus.NOT_FOUND);
    }
}
