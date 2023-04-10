package moca.MocaRestService.Data.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tp_cartao", schema = "dbo", catalog = "moca")
public class TpCartao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tp_cartao")
    private long idTpCartao;
    @Basic
    @Column(name = "descricao")
    private String descricao;

    public long getIdTpCartao() {
        return idTpCartao;
    }

    public void setIdTpCartao(long idTpCartao) {
        this.idTpCartao = idTpCartao;
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
        TpCartao tpCartao = (TpCartao) o;
        return idTpCartao == tpCartao.idTpCartao && Objects.equals(descricao, tpCartao.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTpCartao, descricao);
    }
}
