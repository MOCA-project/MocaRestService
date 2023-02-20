package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Cliente, Integer> {

}
