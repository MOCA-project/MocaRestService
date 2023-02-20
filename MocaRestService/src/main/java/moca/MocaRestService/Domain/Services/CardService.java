package moca.MocaRestService.Domain.Services;

import lombok.AllArgsConstructor;
import moca.MocaRestService.Data.Repositories.ICardRepository;

@AllArgsConstructor
public class CardService {
    private final ICardRepository cardRepository;

}
