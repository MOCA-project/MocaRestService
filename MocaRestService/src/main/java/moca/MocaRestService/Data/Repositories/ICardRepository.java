package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardRepository extends JpaRepository<Cartao, Integer> {
}
