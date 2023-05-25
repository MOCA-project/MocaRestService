package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Domain.Helper.Enums.TipoReceitaEnum;
import moca.MocaRestService.Domain.Models.Responses.HistoricoPorquinho;
import moca.MocaRestService.Domain.Models.Responses.HistoricoPorquinhoItem;
import moca.MocaRestService.Infrastructure.Entities.Despesa;
import moca.MocaRestService.Infrastructure.Entities.Porquinho;
import moca.MocaRestService.Infrastructure.Entities.Receita;
import moca.MocaRestService.Infrastructure.Repositories.IClienteRepository;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import moca.MocaRestService.Infrastructure.Repositories.IPorquinhoRepository;
import moca.MocaRestService.Domain.Models.Requests.PorquinhoRequest;
import moca.MocaRestService.Domain.Models.Responses.PorquinhoResponse;
import moca.MocaRestService.Infrastructure.Repositories.IReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class PorquinhoService {

    @Autowired
    private IPorquinhoRepository porquinhoRepository;
    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IDespesasRepository despesasRepository;

    @Autowired
    private IReceitasRepository receitasRepository;

    public PorquinhoResponse addPorquinho (PorquinhoRequest request){
        Porquinho newPorquinho = new Porquinho();

        newPorquinho.setConcluido(request.getConcluido());
        newPorquinho.setIdCliente(request.getIdCliente());
        newPorquinho.setValorFinal(request.getValorFinal());
        newPorquinho.setValorAtual(request.getValorAtual());
        newPorquinho.setNome(request.getNome());

        Porquinho porquinho =  porquinhoRepository.save(newPorquinho);

        return new PorquinhoResponse(
                porquinho.getIdPorquinho(),
                porquinho.getNome(),
                porquinho.getValorFinal(),
                porquinho.getValorAtual(),
                porquinho.getConcluido(),
                porquinho.getIdCliente());

    }

    public List<Porquinho> getAllPorquinhoByIdCliente (Long idCliente){
        return porquinhoRepository.findAllByIdCliente(idCliente);
    }

    public PorquinhoResponse getPorquinhoId (long idCliente, long idPorquinho){
        if (porquinhoRepository.existsById(idPorquinho) && clienteRepository.existsById(idCliente)) {
            Porquinho porquinho = porquinhoRepository.findById(idPorquinho).get();
            return new PorquinhoResponse(
                    porquinho.getIdPorquinho(),
                    porquinho.getNome(),
                    porquinho.getValorFinal(),
                    porquinho.getValorAtual(),
                    porquinho.getConcluido(),
                    porquinho.getIdCliente());
        }
        return null;
    }

    public ResponseEntity<Void> retirarValor(long idCliente, long idPorquinho, double valorRetirar){
        var response = porquinhoRepository.findById(idPorquinho);
        response.ifPresent((Porquinho result) -> {
            result.setValorAtual(result.getValorAtual() - valorRetirar);
            porquinhoRepository.save(result);
        });
        long tipoPorquinhoId = 10;
        var receitaPorquinho = new Receita();
        receitaPorquinho.setValor(valorRetirar);
        receitaPorquinho.setData(LocalDate.now());
        receitaPorquinho.setIdCliente(idCliente);
        receitaPorquinho.setIdTipoReceita(tipoPorquinhoId);
        receitaPorquinho.setDescricao("Saque no porquinho");
        receitaPorquinho.setIdPorquinho(idPorquinho);
        receitasRepository.save(receitaPorquinho);

        return ResponseEntity.status(200).build();
    }

    public ResponseEntity<Void> adicionarValor(long idCliente, long idPorquinho, double valorAdicionar){
        var response = porquinhoRepository.findById(idPorquinho);
        response.ifPresent((Porquinho result) -> {
            result.setValorAtual(result.getValorAtual() + valorAdicionar);
            porquinhoRepository.save(result);
        });
        long tipoPorquinhoId = 11;
        var despesaPorquinho = new Despesa();
        despesaPorquinho.setValor(valorAdicionar);
        despesaPorquinho.setData(LocalDate.now());
        despesaPorquinho.setPaid(true);
        despesaPorquinho.setDescricao("Depósito no porquinho");
        despesaPorquinho.setIdCliente(idCliente);
        despesaPorquinho.setIdTipoDespesa(tipoPorquinhoId);
        despesaPorquinho.setIdPorquinho(idPorquinho);

        despesasRepository.save(despesaPorquinho);

        return ResponseEntity.status(200).build();
    }

    public ResponseEntity<Void> finalizarPorquinho (long idCliente, long idPorquinho){
        var response = porquinhoRepository.findById(idPorquinho);
        response.ifPresent((Porquinho result) -> {
            if (result.getValorAtual() == result.getValorFinal()){
                result.setConcluido(true);
                porquinhoRepository.save(result);
            }
        });
        return ResponseEntity.status(200).build();
    }
    public ResponseEntity<Void> excluirPorquinho(long idCliente, long idPorquinho){
        if (porquinhoRepository.existsById(idPorquinho) && clienteRepository.existsById(idCliente)) {
            porquinhoRepository.deleteById(idPorquinho);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    public double mostrarPorcentagem(long idCliente, long idPorquinho){
        var response = porquinhoRepository.findById(idPorquinho);
        double porcentagem = 0.0;
        if (response.isPresent()) {
            porcentagem = (response.get().getValorAtual() * 100) / response.get().getValorFinal();
        }
        return porcentagem;
    }

    public HistoricoPorquinho getHistorico(long idPorquinho){
        var response = new HistoricoPorquinho();
        var depositos = despesasRepository.getDepositosPorquinho(idPorquinho);
        var saques = receitasRepository.getSaquesPorquinho(idPorquinho);

        for (Despesa deposito :
                depositos) {
            response.add(new HistoricoPorquinhoItem(deposito.getData(), deposito.getDescricao(), "", deposito.getValor(),
                    false));
        }

        for (Receita saque :
                saques) {
            response.add(new HistoricoPorquinhoItem(saque.getData(), saque.getDescricao(), "", saque.getValor(),
                    true));
        }

        return response;
    }
}
