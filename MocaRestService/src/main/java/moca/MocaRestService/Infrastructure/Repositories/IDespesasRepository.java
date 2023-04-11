package moca.MocaRestService.Infrastructure.Repositories;

import moca.MocaRestService.Infrastructure.Entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDespesasRepository extends JpaRepository<Despesa, Long> {
    @Query(value = "select coalesce( sum(d.valor), 0) from Despesa d where d.idCliente  = ?1 " +
            "and d.isPaid = true " +
            "and MONTH(d.data) = ?2 " +
            "and YEAR(d.data) = ?3 ")
     double getDespesasPagas(long idCliente, int mes, int ano);
    @Query(value = "select coalesce( sum(d.valor), 0) from Despesa d where d.idCliente  = ?1 " +
            "and MONTH(d.data) = ?2 " +
            "and YEAR(d.data) = ?3 ")
    double getDespesas(long idCliente, int mes, int ano);

    @Query(value = "select coalesce( sum(d.valor), 0) from Despesa d where d.idCliente  = ?1 " +
            "and MONTH(d.data) = ?2 " +
            "and YEAR(d.data) = ?3 " +
            "and d.isCartao = true ")
    double getDespesasCartao(long idCliente, int mes, int ano);
    @Query(value = "select d from Despesa d where d.idCliente  = ?1 " +
            "and MONTH(d.data) = ?2 " +
            "and YEAR(d.data) = ?3 ")
    List<Despesa> getDespesasLista(long idCliente, int mes, int ano);

    @Query(value = "select coalesce( sum(d.valor), 0) from Despesa d where d.idCliente  = ?1 " +
            "and MONTH(d.data) = ?2 " +
            "and YEAR(d.data) = ?3 " +
            "and d.isCartao = true " +
            "and d.idCartao = ?4")
    double getGastosCartoes(long idCliente, int mes, int ano, long idCartao);
}
