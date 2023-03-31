package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceitasRepository extends JpaRepository<Receita, Long> {
    @Query(value = "select coalesce(sum(r.valor), 0) from Receita r where r.idCliente  = ?1 " +
            "and MONTH(r.data) = ?2 " +
            "and YEAR(r.data) = ?3 ")
    double getReceitasMes(long idCliente, int mes, int ano);
}
