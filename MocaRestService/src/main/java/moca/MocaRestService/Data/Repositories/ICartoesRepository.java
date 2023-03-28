package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartoesRepository extends JpaRepository<Cartao, Long> {
    List<Cartao> findByIdCliente(long idCliente);
}
