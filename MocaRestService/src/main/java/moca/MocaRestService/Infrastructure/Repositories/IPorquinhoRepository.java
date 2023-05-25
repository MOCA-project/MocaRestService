package moca.MocaRestService.Infrastructure.Repositories;

import moca.MocaRestService.Infrastructure.Entities.Porquinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPorquinhoRepository extends JpaRepository <Porquinho, Long> {

    List<Porquinho> findAllByIdCliente(Long idCliente);
}
