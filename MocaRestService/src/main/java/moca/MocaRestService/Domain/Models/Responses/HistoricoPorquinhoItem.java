package moca.MocaRestService.Domain.Models.Responses;

import java.time.LocalDate;

public class HistoricoPorquinhoItem {
    private LocalDate data;
    private String descricao;
    private String categoria;
    private double valor;
    private boolean isSaque;

    public HistoricoPorquinhoItem(LocalDate data, String descricao, String categoria, double valor, boolean isSaque) {
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.isSaque = isSaque;
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

    public boolean isSaque() {
        return isSaque;
    }

    public void setSaque(boolean saque) {
        isSaque = saque;
    }
}
