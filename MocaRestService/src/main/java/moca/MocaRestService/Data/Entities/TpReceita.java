package moca.MocaRestService.Data.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tp_receita", schema = "dbo", catalog = "moca")
public class TpReceita {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tp_receita")
    private long idTpReceita;
    @Basic
    @Column(name = "descricao")
    private String descricao;

    public long getIdTpReceita() {
        return idTpReceita;
    }

    public void setIdTpReceita(long idTpReceita) {
        this.idTpReceita = idTpReceita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TpReceita tpReceita = (TpReceita) o;
        return idTpReceita == tpReceita.idTpReceita && Objects.equals(descricao, tpReceita.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTpReceita, descricao);
    }
}
