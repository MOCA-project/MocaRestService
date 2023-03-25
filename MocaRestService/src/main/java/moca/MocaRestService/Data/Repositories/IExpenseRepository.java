package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpenseRepository extends JpaRepository<Despesa, Long> {
}
