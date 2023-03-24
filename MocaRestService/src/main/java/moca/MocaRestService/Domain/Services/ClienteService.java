package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Cliente;
import moca.MocaRestService.Data.Repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;


    public Cliente addClient(Cliente request){
        return clienteRepository.save(request);
    }

}
