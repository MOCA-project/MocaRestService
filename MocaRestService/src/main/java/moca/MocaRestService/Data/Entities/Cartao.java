package moca.MocaRestService.Data.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Objects;

@Entity
public class Cartao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cartao")
    private long idCartao;
    @Basic
    @Column(name = "saldo")
    private double saldo;
    @Basic
    @Column(name = "limite")
    private double limite;
    @Basic
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic
    @Column(name = "id_tipo")
    private Long idTipo;

    public long getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(long idCartao) {
        this.idCartao = idCartao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartao cartao = (Cartao) o;
        return idCartao == cartao.idCartao && Objects.equals(saldo, cartao.saldo) && Objects.equals(limite, cartao.limite) && Objects.equals(idCliente, cartao.idCliente) && Objects.equals(idTipo, cartao.idTipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCartao, saldo, limite, idCliente, idTipo);
    }
}
