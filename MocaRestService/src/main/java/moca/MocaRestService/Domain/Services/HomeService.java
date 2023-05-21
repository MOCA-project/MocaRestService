package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Domain.Helper.Enums.TipoDespesaEnum;
import moca.MocaRestService.Domain.Helper.Enums.TipoReceitaEnum;
import moca.MocaRestService.Infrastructure.Entities.Cartao;
import moca.MocaRestService.Infrastructure.Entities.Despesa;
import moca.MocaRestService.Infrastructure.Entities.Porquinho;
import moca.MocaRestService.Infrastructure.Entities.Receita;
import moca.MocaRestService.Infrastructure.Repositories.ICartoesRepository;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import moca.MocaRestService.Infrastructure.Repositories.IPorquinhoRepository;
import moca.MocaRestService.Infrastructure.Repositories.IReceitasRepository;
import moca.MocaRestService.Domain.Models.Responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HomeService {
    @Autowired
    private IDespesasRepository despesasRepository;
    @Autowired
    private IReceitasRepository receitasRepository;
    @Autowired
    private ICartoesRepository cartoesRepository;

    @Autowired
    private IPorquinhoRepository porquinhoRepository;
    public HomeResponse getHome(long idCliente, int mes, int ano){
        var home = new HomeResponse();

        var despesasLista = despesasRepository.getDespesasLista(idCliente, mes, ano);

        var cartoes = cartoesRepository.findByIdCliente(idCliente);

        var receitasLista = receitasRepository.getReceitasMesLista(idCliente, mes, ano);

        var porquinhos = porquinhoRepository.findAllByIdCliente(idCliente);

        double despesasPagas = despesasLista.stream()
                .filter(despesa -> despesa.getPaid())
                .mapToDouble(Despesa::getValor)
                .sum();

        double despesas = despesasLista.parallelStream()
                .mapToDouble(Despesa::getValor)
                .sum();

        double receitas = receitasLista.parallelStream()
                .mapToDouble(Receita::getValor)
                .sum();

        double despesasCartao = despesasLista.parallelStream()
                .filter(despesa -> despesa.isCartao())
                .mapToDouble(Despesa::getValor)
                .sum();

        List<CartaoHome> cartoesHome = new ArrayList<>();
        for (Cartao cartao : cartoes){
            cartoesHome.add(new CartaoHome(cartao.getBandeira(), cartao.getIdCorCartao(), cartao.getApelido()));
        }

        List<PorquinhoResponse> porquinhoHome = new ArrayList<>();
        for (Porquinho porquinho : porquinhos){
            porquinhoHome.add(new PorquinhoResponse(porquinho.getIdPorquinho(),
                    porquinho.getNome(), porquinho.getValorFinal(), porquinho.getValorAtual(),
                    porquinho.getConcluido(), porquinho.getIdCliente()));
        }


        home.setGraficoDespesas(getGraficosDespesa(despesasLista));
        home.setGraficoReceitas(getGraficosReceitas(receitasLista));
        home.setDespesas(despesas);
        home.setReceita(receitas);
        home.setSaldo(receitas - despesasPagas);
        home.setDespesaCartao(despesasCartao);
        home.setCartoes(cartoesHome);
        home.setPorquinhos(porquinhoHome);
        return home;
    }

    private GraficoDespesas getGraficosDespesa(List<Despesa> despesas) {
        Map<Long, Double> acumuladores = despesas.stream()
                .collect(Collectors.groupingBy(despesa -> despesa.getIdTipoDespesa(),
                        Collectors.summingDouble(despesa -> despesa.getValor())));

        GraficoDespesas response = new GraficoDespesas();
        double total = acumuladores.values().stream().mapToDouble(Double::doubleValue).sum();
        acumuladores.forEach((idTipoDespesa, valor) -> {
            if (valor > 0) {
                String nomeCategoria = TipoDespesaEnum.getByID(idTipoDespesa.intValue());
                IndiceGrafico indice = new IndiceGrafico(nomeCategoria, getPorcentagem(total, valor));
                response.add(indice);
            }
        });
        return response;
    }

    private GraficoReceitas getGraficosReceitas(List<Receita> receitas) {
        Map<Long, Double> acumuladores = receitas.parallelStream()
                .collect(Collectors.groupingBy(receita -> receita.getIdTipoReceita(),
                        Collectors.summingDouble(receita -> receita.getValor())));

        GraficoReceitas response = new GraficoReceitas();
        double total = acumuladores.values().parallelStream().mapToDouble(Double::doubleValue).sum();
        acumuladores.forEach((idTipoReceita, valor) -> {
            if (valor > 0) {
                String nomeCategoria = TipoReceitaEnum.getByID(idTipoReceita.intValue());
                IndiceGrafico indice = new IndiceGrafico(nomeCategoria, getPorcentagem(total, valor));
                response.add(indice);
            }
        });
        return response;
    }

    private double getPorcentagem(double total, double valor){
        double porcentagem =  (valor * 100) / total;
        return Math.floor(porcentagem * 100) / 100;
    }
}
