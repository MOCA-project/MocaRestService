package moca.MocaRestService.service;

import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import moca.MocaRestService.Domain.Models.Responses.PorquinhoResponse;

public class ClienteBuilder {

    private ClienteBuilder() {
        throw new IllegalStateException("Classe utilitaria");
    }

    public static ClienteResponse criarCliente(){
        return new ClienteResponse(1l,"Novo cliente", "cliente@email.com",1,"11959168156",true,true);
    }

}
