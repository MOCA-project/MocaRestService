package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Receita;
import moca.MocaRestService.Data.Repositories.IReceitasRepository;
import moca.MocaRestService.Domain.Models.Requests.ReceitaRequest;
import moca.MocaRestService.Domain.Models.Responses.ReceitaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}