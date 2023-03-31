package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Porquinho;
import moca.MocaRestService.Data.Repositories.IClienteRepository;
import moca.MocaRestService.Data.Repositories.IPorquinhoRepository;
import moca.MocaRestService.Domain.Models.Requests.PorquinhoRequest;
import moca.MocaRestService.Domain.Models.Responses.PorquinhoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PorquinhoService {

    @Autowired
    private IPorquinhoRepository porquinhoRepository;
    @Autowired
    private IClienteRepository clienteRepository;

    public PorquinhoResponse addPorquinho (PorquinhoRequest request){
        Porquinho newPorquinho = new Porquinho();

        //nova classe do banco, id é automatico
        newPorquinho.setConcluido(request.getConcluido());
        newPorquinho.setIdCliente(request.getIdCliente());
        //newPorquinho.setIdObj(request.getIdObj());
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

    public List<Porquinho> getAllPorquinho (){
        return porquinhoRepository.findAll();
    }

    public PorquinhoResponse getPorquinhoId (long idCliente, long idPorquinho){
        if (porquinhoRepository.existsById(idPorquinho) && clienteRepository.existsById(idCliente)) {
            Porquinho porquinho = porquinhoRepository.getReferenceById(idPorquinho);
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
        if (porquinhoRepository.existsById(idPorquinho) && clienteRepository.existsById(idCliente)){
            Porquinho porquinho = porquinhoRepository.getReferenceById(idPorquinho);
            porquinho.setValorAtual(porquinho.getValorAtual() - valorRetirar);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity<Void> adicionarValor(long idCliente, long idPorquinho, double valorAdicionar){
        if (porquinhoRepository.existsById(idPorquinho) && clienteRepository.existsById(idCliente)){
            Porquinho porquinho = porquinhoRepository.getReferenceById(idPorquinho);
            porquinho.setValorAtual(porquinho.getValorAtual() + valorAdicionar);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity<Void> excluirPorquinho(long idCliente, long idPorquinho){
        if (porquinhoRepository.existsById(idPorquinho) && clienteRepository.existsById(idCliente)) {
            porquinhoRepository.deleteById(idPorquinho);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }
}
