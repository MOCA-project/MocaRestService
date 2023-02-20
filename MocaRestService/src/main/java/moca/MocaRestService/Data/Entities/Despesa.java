package moca.MocaRestService.Data.Entities;

import java.util.Date;

public class Despesa {
    private int idDespesa;
    private String descricao;
    private double valor;
    private Date data;
    private boolean isPaga;
    private int idTipoDespesa; // FK
    private int idCliente; // FK
    private int idCartao; // FK
    private int idCategoria; // FK

    public Despesa(String descricao, double valor, Date data, boolean isPaga, int idTipoDespesa, int idCliente, int idCartao, int idCategoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.isPaga = isPaga;
        this.idTipoDespesa = idTipoDespesa;
        this.idCliente = idCliente;
        this.idCartao = idCartao;
        this.idCategoria = idCategoria;
    }

    public int getIdDespesa() {
        return idDespesa;
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

    public boolean isPaga() {
        return isPaga;
    }

    public void setPaga(boolean paga) {
        isPaga = paga;
    }

    public int getIdTipoDespesa() {
        return idTipoDespesa;
    }

    public void setIdTipoDespesa(int idTipoDespesa) {
        this.idTipoDespesa = idTipoDespesa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
