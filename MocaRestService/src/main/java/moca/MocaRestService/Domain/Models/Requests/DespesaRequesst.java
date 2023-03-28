package moca.MocaRestService.Domain.Models.Requests;

import java.util.Date;

public class DespesaRequesst {
    private String descricao;
    private double valor;
    private Date data;
    private boolean isPaid;
    private boolean isParcela;
    private Long idCliente;
    private Long idTipoDespesa;

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

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isParcela() {
        return isParcela;
    }

    public void setParcela(boolean parcela) {
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
}
