package moca.MocaRestService.Domain.Models.Responses;

import java.util.List;

public class HomeResponse {
    private double saldo;
    private double receita;
    private double despesas;
    private double despesaCartao;
    private List<CartaoHome> cartoes;
    private GraficoReceitas graficoReceitas;
    private GraficoDespesas graficoDespesas;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getReceita() {
        return receita;
    }

    public void setReceita(double receita) {
        this.receita = receita;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }

    public double getDespesaCartao() {
        return despesaCartao;
    }

    public void setDespesaCartao(double despesaCartao) {
        this.despesaCartao = despesaCartao;
    }

    public List<CartaoHome> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<CartaoHome> cartoes) {
        this.cartoes = cartoes;
    }

    public GraficoReceitas getGraficoReceitas() {
        return graficoReceitas;
    }

    public void setGraficoReceitas(GraficoReceitas graficoReceitas) {
        this.graficoReceitas = graficoReceitas;
    }

    public GraficoDespesas getGraficoDespesas() {
        return graficoDespesas;
    }

    public void setGraficoDespesas(GraficoDespesas graficoDespesas) {
        this.graficoDespesas = graficoDespesas;
    }
}

