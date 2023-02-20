package moca.MocaRestService.Data.Entities;

public class Cartao {
    private int idCartao;
    private int idBanco;
    private double isCredito;
    private double idDebito;
    private double limite;
    private double saldo;

    public Cartao(int idBanco, double isCredito, double idDebito, double limite, double saldo) {
        this.idBanco = idBanco;
        this.isCredito = isCredito;
        this.idDebito = idDebito;
        this.limite = limite;
        this.saldo = saldo;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public double getIsCredito() {
        return isCredito;
    }

    public void setIsCredito(double isCredito) {
        this.isCredito = isCredito;
    }

    public double getIdDebito() {
        return idDebito;
    }

    public void setIdDebito(double idDebito) {
        this.idDebito = idDebito;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
