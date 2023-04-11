package moca.MocaRestService.Infrastructure.Repositories;

import moca.MocaRestService.Infrastructure.Entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReceitasRepository extends JpaRepository<Receita, Long> {
    @Query(value = "select coalesce(sum(r.valor), 0) from Receita r where r.idCliente  = ?1 " +
            "and MONTH(r.data) = ?2 " +
            "and YEAR(r.data) = ?3 ")
    double getReceitasMes(long idCliente, int mes, int ano);

    @Query(value = "select r from Receita r where r.idCliente  = ?1 " +
            "and MONTH(r.data) = ?2 " +
            "and YEAR(r.data) = ?3 ")
    List<Receita> getReceitasMesLista(long idCliente, int mes, int ano);
}
