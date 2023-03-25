package moca.MocaRestService.Data.Entities;

import jakarta.persistence.*;

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
    private Integer valorFinal;
    @Basic
    @Column(name = "valor_atual")
    private Integer valorAtual;
    @Basic
    @Column(name = "is_concluido")
    private Boolean isConcluido;
    @Basic
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic
    @Column(name = "id_obj")
    private Long idObj;

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

    public Integer getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Integer valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Integer getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Integer valorAtual) {
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

    public Long getIdObj() {
        return idObj;
    }

    public void setIdObj(Long idObj) {
        this.idObj = idObj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Porquinho porquinho = (Porquinho) o;
        return idPorquinho == porquinho.idPorquinho && Objects.equals(nome, porquinho.nome) && Objects.equals(valorFinal, porquinho.valorFinal) && Objects.equals(valorAtual, porquinho.valorAtual) && Objects.equals(isConcluido, porquinho.isConcluido) && Objects.equals(idCliente, porquinho.idCliente) && Objects.equals(idObj, porquinho.idObj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPorquinho, nome, valorFinal, valorAtual, isConcluido, idCliente, idObj);
    }
}
