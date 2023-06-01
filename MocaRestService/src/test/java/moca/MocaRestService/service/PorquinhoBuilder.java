package moca.MocaRestService.service;

import moca.MocaRestService.Domain.Models.Responses.PorquinhoResponse;
import moca.MocaRestService.Infrastructure.Entities.Porquinho;

public class PorquinhoBuilder {
    private PorquinhoBuilder() {
        throw new IllegalStateException("Classe utilitaria");
    }

    public static PorquinhoResponse criarPorquinho(){
        return new PorquinhoResponse(1l,"Porquinho 1", 100.0, 0.0,false,1);
    }
}
