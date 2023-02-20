package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Cartao;
import moca.MocaRestService.Data.Repositories.ICardRepository;

public class CardService {
    private final ICardRepository cardRepository;

    public CardService(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

}
