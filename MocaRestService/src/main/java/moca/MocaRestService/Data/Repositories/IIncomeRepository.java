package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIncomeRepository extends JpaRepository<Receita, Integer> {
}
