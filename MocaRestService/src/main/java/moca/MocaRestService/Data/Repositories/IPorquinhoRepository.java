package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Porquinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPorquinhoRepository extends JpaRepository <Porquinho, Long> {

}
