package moca.MocaRestService.Domain.Models.Responses;

//o que vai retornar
public class PorquinhoResponse {

    private long id;
    private String nome;

    private double valorFinal;

    private double valorAtual;

    private Boolean isConcluido;

    private long idCliente;

    public PorquinhoResponse(long id, String nome, double valorFinal, double valorAtual, Boolean isConcluido, long idCliente) {
        this.id = id;
        this.nome = nome;
        this.valorFinal = valorFinal;
        this.valorAtual = valorAtual;
        this.isConcluido = isConcluido;
        this.idCliente = idCliente;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public void setConcluido(Boolean concluido) {
        isConcluido = concluido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

}
