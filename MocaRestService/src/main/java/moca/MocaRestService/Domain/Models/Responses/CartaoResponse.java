package moca.MocaRestService.Domain.Models.Responses;

public class CartaoResponse {
    private Long idCartao;
    private double limite;
    private Long idCliente;
    private Long idTipo;
    private Long idCor;
    private String bandeira;
    private String apelido;


    public CartaoResponse(Long idCartao, double limite, Long idCliente, Long idTipo, Long idCor, String bandeira, String apelido) {
        this.idCartao = idCartao;
        this.limite = limite;
        this.idCliente = idCliente;
        this.idTipo = idTipo;
        this.idCor = idCor;
        this.bandeira = bandeira;
        this.apelido = apelido;
    }

    public Long getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Long idCartao) {
        this.idCartao = idCartao;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public Long getIdCor() {
        return idCor;
    }

    public void setIdCor(Long idCor) {
        this.idCor = idCor;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
