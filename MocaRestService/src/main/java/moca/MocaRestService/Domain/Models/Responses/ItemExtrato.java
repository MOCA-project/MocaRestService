package moca.MocaRestService.Domain.Models.Responses;

import java.time.LocalDate;

public class ItemExtrato {
    private String situacao;
    private LocalDate data;
    private String descricao;
    private String categoria;
    private double valor;
    private Long idDespesa;
    private Long idReceita;

    public ItemExtrato() {
    }

    public ItemExtrato(String situacao, LocalDate data, String descricao, String categoria, double valor, Long idDespesa, Long idReceita) {
        this.situacao = situacao;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.idDespesa = idDespesa;
        this.idReceita = idReceita;
    }

    public Long getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Long idDespesa) {
        this.idDespesa = idDespesa;
    }

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
