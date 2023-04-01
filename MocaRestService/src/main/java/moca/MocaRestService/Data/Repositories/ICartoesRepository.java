package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartoesRepository extends JpaRepository<Cartao, Long> {
    List<Cartao> findByIdCliente(long idCliente);
}
