package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import moca.MocaRestService.Domain.Mappers.ClienteMapper;
import moca.MocaRestService.Domain.Mappers.DespesaMapper;
import moca.MocaRestService.Infrastructure.Entities.Despesa;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import moca.MocaRestService.Domain.Models.Requests.DespesaRequesst;
import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Responses.DespesaResponse;
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

    public DespesaResponse add(DespesaRequesst request){
        var despesa = DespesaMapper.toDespesa(request);

        var result = expenseRepository.save(despesa);

        return DespesaMapper.toResponse(result);
    }

    public DespesaResponse pagar(Long idDespesa){
        var despesa = expenseRepository.findById(idDespesa);
        if (despesa.isPresent()){
            despesa.get().setPaid(true);
            expenseRepository.save(despesa.get());
        }
        else
            throw new CustomException("Desesa não encontrada", HttpStatus.NOT_FOUND);

        return DespesaMapper.toResponse(despesa.get());
    }

    public List<DespesaResponse> despesaParcelada(DespesaParceladaRequest request){
        List<DespesaResponse> response = new ArrayList<>();
        List<Despesa> despesas = new ArrayList<>();
        for (int i = 0; i < request.getParcelas(); i++) {
            var dataFutura = request.getData().plusMonths(i);
            Despesa despesa = new Despesa();
            despesa.setData(dataFutura);
            despesa.setDescricao(request.getDescricao());
            despesa.setIdTipoDespesa(request.getIdTipoDespesa());
            despesa.setPaid(false);
            despesa.setParcela(true);
            despesa.setIdCliente(request.getIdCliente());
            despesa.setValor(request.getValor() / request.getParcelas());
            despesa.setCartao(true);
            despesa.setIdCartao(request.getIdCartao());
            despesas.add(despesa);
        }
        var result = expenseRepository.saveAll(despesas);
        return DespesaMapper.toResponseList(result);
    }

    public void delete(Long idDespesa){
        var response = expenseRepository.findById(idDespesa);
        if (response.isPresent()) {
            expenseRepository.deleteById(idDespesa);
        }
        throw new CustomException("Despesa não encontrada", HttpStatus.NOT_FOUND);
    }
}
