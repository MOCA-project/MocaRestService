package moca.MocaRestService.Domain.Mappers;

import moca.MocaRestService.Domain.Models.Requests.CartaoRequest;
import moca.MocaRestService.Domain.Models.Responses.CartaoResponse;
import moca.MocaRestService.Infrastructure.Entities.Cartao;

import java.util.List;
import java.util.stream.Collectors;

public class CartaoMapper {
    public static CartaoResponse toCartaoResponse(Cartao cartao) {
        return new CartaoResponse(
                cartao.getIdCartao(),
                cartao.getLimite(),
                cartao.getIdCliente(),
                cartao.getIdTipo(),
                cartao.getIdCorCartao(),
                cartao.getBandeira(),
                cartao.getApelido()
        );
    }

    public static List<CartaoResponse> toCartaoResponseList(List<Cartao> cartoes) {
        return cartoes.stream().map(CartaoMapper::toCartaoResponse).collect(Collectors.toList());
    }

    public static Cartao toCartao(CartaoRequest cartaoResponse) {
        Cartao cartao = new Cartao();
        cartao.setLimite(cartaoResponse.getLimite());
        cartao.setIdCliente(cartaoResponse.getIdCliente());
        cartao.setIdTipo(cartaoResponse.getIdTipo());
        cartao.setIdCorCartao(cartaoResponse.getIdCor());
        cartao.setBandeira(cartaoResponse.getBandeira());
        cartao.setApelido(cartaoResponse.getApelido());
        return cartao;
    }

}
