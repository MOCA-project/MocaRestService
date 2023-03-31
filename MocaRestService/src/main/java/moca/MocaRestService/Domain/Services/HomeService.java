package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Cartao;
import moca.MocaRestService.Data.Repositories.ICartoesRepository;
import moca.MocaRestService.Data.Repositories.IDespesasRepository;
import moca.MocaRestService.Data.Repositories.IReceitasRepository;
import moca.MocaRestService.Domain.Models.Responses.CartaoHome;
import moca.MocaRestService.Domain.Models.Responses.HomeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {
    @Autowired
    private IDespesasRepository despesasRepository;
    @Autowired
    private IReceitasRepository receitasRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ICartoesRepository cartoesRepository;
    public HomeResponse getHome(long idCliente, int mes, int ano){
        var home = new HomeResponse();

        double despesasPagas = despesasRepository.getDespesasPagas(idCliente, mes, ano);
        double despesas = despesasRepository.getDespesas(idCliente, mes, ano);
        double receitas = receitasRepository.getReceitasMes(idCliente, mes, ano);
        double despesasCartao = despesasRepository.getDespesasCartao(idCliente, mes, ano);

        List<Cartao> cartoes = cartoesRepository.findByIdCliente(idCliente);
        List<CartaoHome> cartoesHome = new ArrayList<>();
        for (Cartao cartao : cartoes){
            cartoesHome.add(new CartaoHome(cartao.getIdTipo()));
        }

        home.setDespesas(despesas);
        home.setReceita(receitas);
        home.setSaldo(receitas - despesasPagas);
        home.setDespesaCartao(despesasCartao);
        home.setCartoes(cartoesHome);

        return home;
    }
}
