package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.CrossCutting.TwilioIntegration.Services.TwilioService;
import moca.MocaRestService.Domain.Mappers.CartaoMapper;
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
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TwilioService twilioService;

    public CartaoResponse add(CartaoRequest request) {
        var cartao = CartaoMapper.toCartao(request);

        var result = repository.save(cartao);

        return CartaoMapper.toCartaoResponse(result);
    }

    public CartoesHomeResponse get(long idCliente, int mes, int ano) {
        clienteService.foundClienteOrThrow(idCliente);
        var response = new CartoesHomeResponse();
        var cartoes = repository.findByIdCliente(idCliente);

        for (Cartao cartao : cartoes){
            var gasto = despesasRepository.getGastosCartoesTotal(idCliente, cartao.getIdCartao());
            response.add(new CartoesHomeCartao(
                    cartao.getLimite(),
                    gasto,
                    getPorcentagem(cartao.getLimite(), gasto),
                    cartao.getVencimento(),
                    cartao.getIdCorCartao(),
                    cartao.getBandeira(),
                    cartao.getApelido(),
                    cartao.getIdCartao()
            ));
        }
        return response;
    }

    private static double getPorcentagem(double total, double utilizado){
        double porcentagem =  (utilizado * 100) / total;
        return Math.floor(porcentagem * 100) / 100;
    }
}
