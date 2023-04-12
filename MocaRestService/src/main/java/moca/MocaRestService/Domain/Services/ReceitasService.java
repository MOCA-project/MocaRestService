package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import moca.MocaRestService.Infrastructure.Entities.Receita;
import moca.MocaRestService.Infrastructure.Repositories.IReceitasRepository;
import moca.MocaRestService.Domain.Models.Requests.ReceitaRequest;
import moca.MocaRestService.Domain.Models.Responses.ReceitaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;

@Service
public class ReceitasService {
    @Autowired
    private IReceitasRepository repository;

    public ReceitaResponse add(ReceitaRequest request){
        var receita = new Receita();
        receita.setData(request.getData());
        receita.setDescricao(request.getDescricao());
        receita.setValor(request.getValor());
        receita.setIdCliente(request.getIdCliente());
        receita.setIdTipoReceita(request.getIdTipoReceita());


        var result = repository.save(receita);

        return new ReceitaResponse(
                result.getIdReceita(),
                result.getDescricao(),
                result.getValor(),
                result.getData(),
                result.getIdCliente(),
                result.getIdTipoReceita()
        );
    }

    public List<ReceitaResponse> postReceitaFixa(ReceitaRequest request) {
        // Adiciona a mesma receita para os próximos 12 meses
        List<ReceitaResponse> response = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            var receita = new Receita();
            receita.setDescricao(request.getDescricao());
            receita.setData(request.getData().plusMonths(i));
            receita.setIdTipoReceita(request.getIdTipoReceita());
            receita.setValor(request.getValor());
            receita.setIdCliente(request.getIdCliente());
            var result = repository.save(receita);
            response.add(new ReceitaResponse(result.getIdReceita(),
                    result.getDescricao(), result.getValor(), result.getData(),
                    result.getIdCliente(), result.getIdTipoReceita()));
        }
        return response;
    }

    public void removeReceita(long idDespesa) {
        var receita = repository.findById(idDespesa);
        if (receita.isPresent())
            repository.deleteById(idDespesa);

        throw new CustomException("Despesa não encontrada", HttpStatus.NOT_FOUND);
    }
}