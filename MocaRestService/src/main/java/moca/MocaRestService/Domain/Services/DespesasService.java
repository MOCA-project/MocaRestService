package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import moca.MocaRestService.Domain.Helper.GenericTypes.PilhaObj;
import moca.MocaRestService.Domain.Mappers.DespesaMapper;
import moca.MocaRestService.Domain.Models.Requests.PatchDespesaRequest;
import moca.MocaRestService.Infrastructure.Entities.Despesa;
import moca.MocaRestService.Infrastructure.Repositories.ICartoesRepository;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import moca.MocaRestService.Domain.Models.Requests.DespesaRequesst;
import moca.MocaRestService.Domain.Models.Requests.DespesaParceladaRequest;
import moca.MocaRestService.Domain.Models.Responses.DespesaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DespesasService {
    @Autowired
    private IDespesasRepository expenseRepository;
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ICartoesRepository cartoesRepository;

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
            throw new CustomException("Despesa não encontrada", HttpStatus.NOT_FOUND);

        return DespesaMapper.toResponse(despesa.get());
    }

    public List<DespesaResponse> despesaParcelada(DespesaParceladaRequest request){
        List<DespesaResponse> response = new ArrayList<>();
        List<Despesa> despesas = new ArrayList<>();
        var exists = cartoesRepository.existsCartaoByIdCartaoAndIdCliente(request.getIdCartao(), request.getIdCliente());
        if (!exists)
            throw new CustomException("Este cliente não possui um cartão com esse ID", HttpStatus.NOT_FOUND);

        for (int i = 0; i < request.getParcelas(); i++) {
            var dataFutura = request.getData().plusMonths(i);
            Despesa despesa = new Despesa();
            despesa.setData(dataFutura);
            despesa.setDescricao(request.getDescricao());
            despesa.setIdTipoDespesa(request.getIdTipoDespesa());
            despesa.setPaid(true);
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
        if (response.isPresent())
            expenseRepository.deleteById(idDespesa);
        else
            throw new CustomException("Despesa não encontrada", HttpStatus.NOT_FOUND);

    }

    public DespesaResponse despesaFixa(DespesaRequesst request) {
        PilhaObj<Despesa> pilhaDespesas = new PilhaObj<>(12);
        LocalDate data = request.getData();

        for (int i = 0; i < 12; i++) {
            Despesa despesa = DespesaMapper.toDespesa(request);
            despesa.setData(data.plusMonths(i));
            pilhaDespesas.push(despesa);
        }

        List<Despesa> despesas = new ArrayList<>();
        while (!pilhaDespesas.isEmpty()) {
            Despesa despesa = pilhaDespesas.pop();
            despesas.add(despesa);
        }

        List<Despesa> despesasSalvas = expenseRepository.saveAll(despesas);
        Despesa despesaSalva = despesasSalvas.get(0);

        return DespesaMapper.toResponse(despesaSalva);
    }

    public List<DespesaResponse> get(long idCliente, int mes, int ano) {
        var despesas = expenseRepository.getDespesasLista(idCliente, mes, ano);

        return DespesaMapper.toResponseList(despesas);

    }

    public DespesaResponse edit(long idDespesa, PatchDespesaRequest request) {
        var despesaOpt = expenseRepository.findById(idDespesa);
        var despesa = despesaOpt.get();

        if (request.getDescricao() != null)
            despesa.setDescricao(request.getDescricao());

        if (request.getData() != null)
            despesa.setData(request.getData());

        if (request.getValor() != null)
            despesa.setValor(request.getValor());

        var despesaeditada = expenseRepository.save(despesa);

        return DespesaMapper.toResponse(despesaeditada);
    }
}
