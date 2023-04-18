package moca.MocaRestService.Domain.Mappers;

import moca.MocaRestService.Domain.Models.Requests.ClienteRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import moca.MocaRestService.Infrastructure.Entities.Cliente;

public class ClienteMapper {
    public static Cliente toCliente(ClienteRequest request){
        var cliente = new  Cliente();
        cliente.setEmail(request.getEmail());
        cliente.setNome(request.getNome());
        cliente.setSenha(request.getSenha());
        cliente.setIdPerfil(request.getIdTipoPerfil());
        return cliente;
    }

    public static ClienteResponse toResponse(Cliente cliente){
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getIdPerfil()
        );
    }

}
