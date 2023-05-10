package moca.MocaRestService.Domain.Models.Requests;

import java.time.LocalDate;

public class PatchReceitaRequest {
    private String descricao;
    private Double valor;
    private LocalDate data;

    public PatchReceitaRequest(String descricao, double valor, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
