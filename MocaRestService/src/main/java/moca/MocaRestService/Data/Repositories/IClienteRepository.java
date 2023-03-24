package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
