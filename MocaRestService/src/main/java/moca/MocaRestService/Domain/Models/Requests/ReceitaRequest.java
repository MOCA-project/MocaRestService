package moca.MocaRestService.Domain.Models.Requests;


import java.util.Date;

public class ReceitaRequest {
    private String descricao;
    private double valor;
    private Date data;
    private long idCliente;
    private long idTipoReceita;

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
