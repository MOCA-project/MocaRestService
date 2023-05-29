package moca.MocaRestService.Infrastructure.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Porquinho {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_porquinho")
    private long idPorquinho;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "valor_final")
    private double valorFinal;
    @Basic
    @Column(name = "valor_atual")
    private double valorAtual;
    @Basic
    @Column(name = "is_concluido")
    private Boolean isConcluido;
    @Basic
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic
    @Column(name = "id_icone")
    private int idIcone;


    public long getIdPorquinho() {
        return idPorquinho;
    }

    public void setIdPorquinho(long idPorquinho) {
        this.idPorquinho = idPorquinho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Boolean getConcluido() {
        return isConcluido;
    }

    public void setConcluido(Boolean concluido) {
        isConcluido = concluido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdIcone() {
        return idIcone;
    }

    public void setIdIcone(int idIcone) {
        this.idIcone = idIcone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Porquinho porquinho = (Porquinho) o;
        return idPorquinho == porquinho.idPorquinho && Objects.equals(nome, porquinho.nome) && Objects.equals(valorFinal, porquinho.valorFinal) && Objects.equals(valorAtual, porquinho.valorAtual) && Objects.equals(isConcluido, porquinho.isConcluido) && Objects.equals(idCliente, porquinho.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPorquinho, nome, valorFinal, valorAtual, isConcluido, idCliente);
    }
}
