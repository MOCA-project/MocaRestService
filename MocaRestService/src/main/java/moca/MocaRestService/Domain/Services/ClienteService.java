package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Cliente;
import moca.MocaRestService.Data.Repositories.IClienteRepository;
import moca.MocaRestService.Domain.Models.Requests.ClienteRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    public ClienteResponse addClient(ClienteRequest request){
        //cliente = classe do banco (entidade)
        Cliente newCliente = new Cliente();

        //nova classe do banco, id é automatico
        newCliente.setEmail(request.getEmail());
        newCliente.setSenha(request.getSenha());
        newCliente.setIdPerfil(request.getIdTipoPerfil());
        newCliente.setNome(request.getNome());

        Cliente cliente =  clienteRepository.save(newCliente);

        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getIdPerfil());
    }

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

}
