package moca.MocaRestService.Data.Repositories;

import moca.MocaRestService.Data.Entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDespesasRepository extends JpaRepository<Despesa, Long> {
    @Query(value = "select  sum(valor) from despesa d where d.id_cliente  = ?1 " +
            "and d.is_paid = 0 " +
            "and MONTH(d.data) = ?2 " +
            "and YEAR(d.data) = ?3 ",
            nativeQuery = true)
     double getDespesasHome(long idCliente, int mes, int ano);

    @Query(value = "select  sum(valor) from despesa d where d.id_cliente  = ?1 " +
            "and MONTH(d.data) = ?2 " +
            "and YEAR(d.data) = ?3 " +
            "and d.is_cartao = 1 ",
            nativeQuery = true)
    double getDespesasCartaoHome(long idCliente, int mes, int ano);
}
