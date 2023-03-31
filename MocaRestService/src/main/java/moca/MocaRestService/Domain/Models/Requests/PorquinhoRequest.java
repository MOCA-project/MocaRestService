package moca.MocaRestService.Domain.Models.Requests;

public class PorquinhoRequest {

    private String nome;

    private double valorFinal;

    private double valorAtual;

    private Boolean isConcluido;

    private long idCliente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Boolean getConcluido() {
        return isConcluido;
    }

    public void setIsConcluido(Boolean concluido) {
        isConcluido = concluido;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

}
