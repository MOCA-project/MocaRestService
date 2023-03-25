package moca.MocaRestService.Domain.Models.Responses;

import java.util.Date;

public class ExpenseResponse {
    private long idDespesa;
    private String descricao;
    private double valor;
    private Date data;
    private Boolean isPaid;
    private Boolean isParcela;
    private Long idCliente;
    private Long idTipoDespesa;

    public ExpenseResponse(long idDespesa, String descricao, double valor, Date data, Boolean isPaid, Boolean isParcela, Long idCliente, Long idTipoDespesa) {
        this.idDespesa = idDespesa;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.isPaid = isPaid;
        this.isParcela = isParcela;
        this.idCliente = idCliente;
        this.idTipoDespesa = idTipoDespesa;
    }

    public long getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(long idDespesa) {
        this.idDespesa = idDespesa;
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

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Boolean getParcela() {
        return isParcela;
    }

    public void setParcela(Boolean parcela) {
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
