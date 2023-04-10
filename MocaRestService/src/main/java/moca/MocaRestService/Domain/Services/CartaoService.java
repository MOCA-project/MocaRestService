package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Infrastructure.Entities.Cartao;
import moca.MocaRestService.Infrastructure.Repositories.ICartoesRepository;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import moca.MocaRestService.Domain.Models.Requests.CartaoRequest;
import moca.MocaRestService.Domain.Models.Responses.CartaoResponse;
import moca.MocaRestService.Domain.Models.Responses.CartoesHomeCartao;
import moca.MocaRestService.Domain.Models.Responses.CartoesHomeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

    @Autowired
    private ICartoesRepository repository;
    @Autowired
    private IDespesasRepository despesasRepository;

    public CartaoResponse add(CartaoRequest request) {
        var cartao = new Cartao();
        cartao.setIdCorCartao(request.getIdCor());
        cartao.setBandeira(request.getBandeira());
        cartao.setLimite(request.getLimite());
        cartao.setIdTipo(request.getIdTipo());
        cartao.setIdCliente(request.getIdCliente());
        cartao.setApelido(request.getApelido());
        cartao.setVencimento(request.getVencimento());

        var result = repository.save(cartao);

        return new CartaoResponse(result.getIdCartao(), result.getLimite(), result.getIdCliente(), result.getIdTipo(),
                result.getIdCorCartao(), result.getBandeira(), result.getApelido());

    }

    public CartoesHomeResponse get(long idCliente, int mes, int ano) {
        var response = new CartoesHomeResponse();
        var cartoes = repository.findAll();

        for (Cartao cartao : cartoes){
            var gasto = despesasRepository.getGastosCartoes(idCliente, mes, ano,
                    cartao.getIdCartao());
            response.add(new CartoesHomeCartao(
                    cartao.getLimite(),
                    gasto,
                    getPorcentagem(cartao.getLimite(), gasto),
                    cartao.getVencimento(),
                    cartao.getIdCorCartao(),
                    cartao.getBandeira(),
                    cartao.getApelido()
            ));
        }
        return response;
    }

    private static double getPorcentagem(double total, double utilizado){
        double porcentagem =  (utilizado * 100) / total;
        return Math.floor(porcentagem * 100) / 100;
    }
}
