package moca.MocaRestService.Infrastructure.Repositories;

import moca.MocaRestService.Infrastructure.Entities.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArquivoRepository extends JpaRepository<Arquivo, Long> {

}
