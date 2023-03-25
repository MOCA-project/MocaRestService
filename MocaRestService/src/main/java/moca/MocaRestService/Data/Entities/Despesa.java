package moca.MocaRestService.Data.Entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Despesa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_despesa")
    private long idDespesa;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "valor")
    private Integer valor;
    @Basic
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "is_paid")
    private Boolean isPaid;
    @Basic
    @Column(name = "is_parcela")
    private Boolean isParcela;
    @Basic
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic
    @Column(name = "id_tipo_despesa")
    private Long idTipoDespesa;

    public long getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(long idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Boolean getParcela() {
        return isParcela;
    }

    public void setParcela(Boolean parcela) {
        isParcela = parcela;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdTipoDespesa() {
        return idTipoDespesa;
    }

    public void setIdTipoDespesa(Long idTipoDespesa) {
        this.idTipoDespesa = idTipoDespesa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return idDespesa == despesa.idDespesa && Objects.equals(descricao, despesa.descricao) && Objects.equals(valor, despesa.valor) && Objects.equals(data, despesa.data) && Objects.equals(isPaid, despesa.isPaid) && Objects.equals(isParcela, despesa.isParcela) && Objects.equals(idCliente, despesa.idCliente) && Objects.equals(idTipoDespesa, despesa.idTipoDespesa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDespesa, descricao, valor, data, isPaid, isParcela, idCliente, idTipoDespesa);
    }
}
