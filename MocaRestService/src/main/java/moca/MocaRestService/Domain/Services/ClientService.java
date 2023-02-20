package moca.MocaRestService.Domain.Services;

import lombok.AllArgsConstructor;
import moca.MocaRestService.Data.Entities.Cliente;
import moca.MocaRestService.Data.Repositories.IClientRepository;

import java.util.List;

@AllArgsConstructor
public class ClientService {

    private final IClientRepository clientRepository;

    public List<Cliente> GetAll(){
        return  clientRepository.findAll();
    }
}
