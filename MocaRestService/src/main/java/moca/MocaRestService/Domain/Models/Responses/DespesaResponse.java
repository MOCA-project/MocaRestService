package moca.MocaRestService.Domain.Models.Responses;

import java.time.LocalDate;

public class DespesaResponse {
    private long idDespesa;
    private String descricao;
    private double valor;
    private LocalDate data;
    private Boolean isPaid;
    private Boolean isParcela;
    private Long idCliente;
    private Long idTipoDespesa;

    public DespesaResponse(long idDespesa, String descricao, double valor, LocalDate data, Boolean isPaid, Boolean isParcela, Long idCliente, Long idTipoDespesa) {
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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
