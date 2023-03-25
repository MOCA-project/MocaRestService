package moca.MocaRestService.Data.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tp_despesa", schema = "dbo", catalog = "moca")
public class TpDespesa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tp_despesa")
    private long idTpDespesa;
    @Basic
    @Column(name = "descricao")
    private String descricao;

    public long getIdTpDespesa() {
        return idTpDespesa;
    }

    public void setIdTpDespesa(long idTpDespesa) {
        this.idTpDespesa = idTpDespesa;
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
        TpDespesa tpDespesa = (TpDespesa) o;
        return idTpDespesa == tpDespesa.idTpDespesa && Objects.equals(descricao, tpDespesa.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTpDespesa, descricao);
    }
}
