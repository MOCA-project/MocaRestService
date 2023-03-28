package moca.MocaRestService.Domain.Models.Responses;

import java.util.Date;

public class ReceitaResponse {
    public long idReceita;
    private String descricao;
    private double valor;
    private Date data;
    private long idCliente;
    private long idTipoReceita;

    public ReceitaResponse(long idReceita, String descricao, double valor, Date data, long idCliente, long idTipoReceita) {
        this.idReceita = idReceita;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.idCliente = idCliente;
        this.idTipoReceita = idTipoReceita;
    }

    public long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(long idReceita) {
        this.idReceita = idReceita;
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

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdTipoReceita() {
        return idTipoReceita;
    }

    public void setIdTipoReceita(long idTipoReceita) {
        this.idTipoReceita = idTipoReceita;
    }
}
