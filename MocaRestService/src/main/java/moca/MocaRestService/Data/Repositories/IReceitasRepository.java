package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceitasRepository extends JpaRepository<Receita, Long> {
    @Query(value = "select  sum(valor) from receita d where d.id_cliente  = ?1 " +
            "and MONTH(d.data) = ?2 " +
            "and YEAR(d.data) = ?3 ",
            nativeQuery = true)
    double getDespesasHome(long idCliente, int mes, int ano);
}
