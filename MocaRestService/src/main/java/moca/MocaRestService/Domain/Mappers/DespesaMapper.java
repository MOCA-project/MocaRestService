package moca.MocaRestService.Domain.Mappers;

import moca.MocaRestService.Domain.Helper.Enums.TipoDespesaEnum;
import moca.MocaRestService.Domain.Models.Requests.DespesaRequesst;
import moca.MocaRestService.Domain.Models.Responses.DespesaResponse;
import moca.MocaRestService.Infrastructure.Entities.Despesa;

import java.util.ArrayList;
import java.util.List;

public class DespesaMapper {
    public static Despesa toDespesa(DespesaRequesst request){
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
        return despesa;
    }

    public static DespesaResponse toResponse(Despesa response){
        return new DespesaResponse(
                response.getIdDespesa(),
                response.getDescricao(),
                response.getValor(),
                response.getData(),
                response.getPaid(),
                response.getParcela(),
                response.getIdCliente(),
                TipoDespesaEnum.getByID(response.getIdTipoDespesa().intValue()));
    }

    public static List<DespesaResponse> toResponseList(List<Despesa> result) {
        List<DespesaResponse> responseList = new ArrayList<>();
        for (Despesa despesa : result) {
            DespesaResponse response = new DespesaResponse(
                    despesa.getIdDespesa(),
                    despesa.getDescricao(),
                    despesa.getValor(),
                    despesa.getData(),
                    despesa.getPaid(),
                    despesa.getParcela(),
                    despesa.getIdCliente(),
                    TipoDespesaEnum.getByID(despesa.getIdTipoDespesa().intValue())
            );
            responseList.add(response);
        }
        return responseList;
    }
}
