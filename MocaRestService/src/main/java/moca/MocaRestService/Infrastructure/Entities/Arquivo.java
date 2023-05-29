package moca.MocaRestService.Infrastructure.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arquivo")
    private long idArquivo;
    @Basic
    @Column(name = "situacao")
    private String situacao;

    @Basic
    @Column(name = "dataArquivo")
    private LocalDate dataArquivo;
    @Basic
    @Column(name = "descricao")
    private String descricao;

    @Basic
    @Column(name = "categoria")
    private String categoria;

    @Basic
    @Column(name = "valor")
    private Double valor;

    @Basic
    @Column(name = "id_cliente")
    private Long idCliente;

    public long getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataArquivo() {
        return dataArquivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataArquivo(LocalDate dataArquivo) {
        this.dataArquivo = dataArquivo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}