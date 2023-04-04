package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Cartao;
import moca.MocaRestService.Data.Entities.Despesa;
import moca.MocaRestService.Data.Entities.Receita;
import moca.MocaRestService.Data.Repositories.ICartoesRepository;
import moca.MocaRestService.Data.Repositories.IDespesasRepository;
import moca.MocaRestService.Data.Repositories.IReceitasRepository;
import moca.MocaRestService.Domain.Models.Responses.*;
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
        var despesasLista = despesasRepository.getDespesasLista(idCliente, mes, ano);
        List<Cartao> cartoes = cartoesRepository.findByIdCliente(idCliente);
        var receitasLista = receitasRepository.getReceitasMesLista(idCliente, mes, ano);

        List<CartaoHome> cartoesHome = new ArrayList<>();
        for (Cartao cartao : cartoes){
            cartoesHome.add(new CartaoHome(cartao.getBandeira(), cartao.getIdCorCartao(), cartao.getApelido()));
        }

        home.setGraficoDespesas(getGraficosDespesa(despesasLista));
        home.setGraficoReceitas(getGraficosReceitas(receitasLista));
        home.setDespesas(despesas);
        home.setReceita(receitas);
        home.setSaldo(receitas - despesasPagas);
        home.setDespesaCartao(despesasCartao);
        home.setCartoes(cartoesHome);

        return home;
    }

    private GraficoDespesas getGraficosDespesa(List<Despesa> despesas){
        double moradia = 0;
        double alimentacao = 0;
        double transporte = 0;
        double saude = 0;
        double educacao = 0;
        double lazer = 0;
        double vestuario = 0;
        double dividas = 0;
        double impostos = 0;
        double outros = 0;
        for (Despesa despesa : despesas) {
            switch (despesa.getIdTipoDespesa().toString()){
                case "1": moradia += despesa.getValor();
                    break;
                case "2": alimentacao += despesa.getValor();
                    break;
                case "3": transporte += despesa.getValor();
                    break;
                case "4": saude += despesa.getValor();
                    break;
                case "5": educacao += despesa.getValor();
                    break;
                case "6": lazer += despesa.getValor();
                    break;
                case "7": vestuario += despesa.getValor();
                    break;
                case "8": dividas += despesa.getValor();
                    break;
                case "9": impostos += despesa.getValor();
                    break;
                case "10":outros += despesa.getValor();
                    break;
            }
        }
        var response = new GraficoDespesas();
        var total = moradia + alimentacao + transporte + saude + educacao + lazer + vestuario + dividas + impostos + outros;

        if (moradia > 0){
            var indiceMoradia = new IndiceGrafico("Moradia", getPorcentagem(total, moradia));
            response.add(indiceMoradia);
        }
        if (alimentacao > 0 ){
            var indiceAlimentacao = new IndiceGrafico("Alimentação", getPorcentagem(total, alimentacao));
            response.add(indiceAlimentacao);
        }
        if (transporte > 0){
            var indiceTransporte = new IndiceGrafico("Transporte", getPorcentagem(total, transporte));
            response.add(indiceTransporte);
        }
        if (saude > 0){
            var indice = new IndiceGrafico("Saúde", getPorcentagem(total, saude));
            response.add(indice);
        }
        if (educacao > 0){
            var indice = new IndiceGrafico("Educação", getPorcentagem(total, educacao));
            response.add(indice);
        }
        if (lazer > 0){
            var indice = new IndiceGrafico("Lazer", getPorcentagem(total, lazer));
            response.add(indice);
        }
        if (vestuario > 0){
            var indice = new IndiceGrafico("Vestuário", getPorcentagem(total, vestuario));
            response.add(indice);
        }
        if (dividas > 0){
            var indice = new IndiceGrafico("Dívidas", getPorcentagem(total, dividas));
            response.add(indice);
        }
        if (impostos > 0){
            var indice = new IndiceGrafico("Impostos", getPorcentagem(total, impostos));
            response.add(indice);
        }
        if (outros > 0){
            var indice = new IndiceGrafico("Outros", getPorcentagem(total, outros));
            response.add(indice);
        }

        return response;
    }

    private GraficoReceitas getGraficosReceitas(List<Receita> receitas){
        double salario = 0;
        double rendimento = 0;
        double vendas = 0;
        double freelance = 0;
        double aluguel = 0;
        double ajuda = 0;
        double reembolso = 0;
        double premios = 0;
        double outros = 0;

        for (Receita receita : receitas){
            switch (receita.getIdTipoReceita().toString()){
                case "1": salario += receita.getValor();
                break;
                case "2": rendimento += receita.getValor();
                    break;
                case "3": vendas += receita.getValor();
                    break;
                case "4": freelance += receita.getValor();
                    break;
                case "5": aluguel += receita.getValor();
                    break;
                case "6": ajuda += receita.getValor();
                    break;
                case "7": reembolso += receita.getValor();
                    break;
                case "8": premios += receita.getValor();
                    break;
                case "9": outros += receita.getValor();
                    break;
            }
        }
        var response = new GraficoReceitas();
        var total = salario + rendimento + vendas + freelance + aluguel + ajuda + reembolso + premios + outros;

        if (salario > 0){
            var indice = new IndiceGrafico("Salário", getPorcentagem(total, salario));
            response.add(indice);
        }
        if (rendimento > 0){
            var indice = new IndiceGrafico("Rendimentos", getPorcentagem(total, rendimento));
            response.add(indice);
        }
        if (freelance > 0){
            var indice = new IndiceGrafico("Freelance", getPorcentagem(total, freelance));
            response.add(indice);
        }
        if (ajuda > 0){
            var indice = new IndiceGrafico("Ajuda financeira", getPorcentagem(total, ajuda));
            response.add(indice);
        }
        if (reembolso > 0){
            var indice = new IndiceGrafico("Reembolso", getPorcentagem(total, reembolso));
            response.add(indice);
        }
        if (premios > 0){
            var indice = new IndiceGrafico("Prémios", getPorcentagem(total, premios));
            response.add(indice);
        }
        if (outros > 0){
            var indice = new IndiceGrafico("Outros", getPorcentagem(total, outros));
            response.add(indice);
        }

        return response;
    }

    private double getPorcentagem(double total, double valor){
        double porcentagem =  (valor * 100) / total;
        return Math.floor(porcentagem * 100) / 100;
    }
}
