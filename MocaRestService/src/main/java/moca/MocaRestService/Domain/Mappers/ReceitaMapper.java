package moca.MocaRestService.Domain.Mappers;

import moca.MocaRestService.Domain.Models.Requests.ReceitaRequest;
import moca.MocaRestService.Domain.Models.Responses.ReceitaResponse;
import moca.MocaRestService.Infrastructure.Entities.Receita;

public class ReceitaMapper {
    public static ReceitaResponse toResponse(Receita receita) {
        return new ReceitaResponse(
                receita.getIdReceita(),
                receita.getDescricao(),
                receita.getValor(),
                receita.getData(),
                receita.getIdCliente(),
                receita.getIdTipoReceita()
        );
    }

    public static Receita toEntity(ReceitaRequest request) {
        Receita receita = new Receita();
        receita.setData(request.getData());
        receita.setDescricao(request.getDescricao());
        receita.setValor(request.getValor());
        receita.setIdCliente(request.getIdCliente());
        receita.setIdTipoReceita(request.getIdTipoReceita());
        return receita;
    }
}
