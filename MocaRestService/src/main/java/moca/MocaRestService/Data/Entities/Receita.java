package moca.MocaRestService.Data.Entities;


import java.util.Objects;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receita {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receita")

    private long idReceita;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "valor")
    private double valor;
    @Basic
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic
    @Column(name = "id_tipo_receita")
    private Long idTipoReceita;

    public long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(long idReceita) {
        this.idReceita = idReceita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdTipoReceita() {
        return idTipoReceita;
    }

    public void setIdTipoReceita(Long idTipoReceita) {
        this.idTipoReceita = idTipoReceita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return idReceita == receita.idReceita && Objects.equals(descricao, receita.descricao) && Objects.equals(valor, receita.valor) && Objects.equals(data, receita.data) && Objects.equals(idCliente, receita.idCliente) && Objects.equals(idTipoReceita, receita.idTipoReceita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReceita, descricao, valor, data, idCliente, idTipoReceita);
    }
}
