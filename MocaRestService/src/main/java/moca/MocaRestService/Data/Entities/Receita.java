package moca.MocaRestService.Data.Entities;

import java.util.Date;

public class Receita {
    private int idReceita;
    private String descricao;
    private double valor;
    private Date data;
    private int idTipoReceita; // FK
    private int idCliente; // FK
    private int idCategoria; // FK

    public Receita(String descricao, double valor, Date data, int idTipoReceita, int idCliente, int idCategoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.idTipoReceita = idTipoReceita;
        this.idCliente = idCliente;
        this.idCategoria = idCategoria;
    }

    public int getIdReceita() {
        return idReceita;
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

    public int getIdTipoReceita() {
        return idTipoReceita;
    }

    public void setIdTipoReceita(int idTipoReceita) {
        this.idTipoReceita = idTipoReceita;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
