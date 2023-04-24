package moca.MocaRestService.Domain.Models.Requests;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Size;

public class CartaoRequest {
    private double limite;
    private Long idCliente;
    private Long idTipo;
    private Long idCor;
    private String Bandeira;
    private String apelido;
    private String vencimento;

    public CartaoRequest(double limite, Long idCliente, Long idTipo, Long idCor, String bandeira, String apelido, String vencimento) {
        this.limite = limite;
        this.idCliente = idCliente;
        this.idTipo = idTipo;
        this.idCor = idCor;
        Bandeira = bandeira;
        this.apelido = apelido;
        this.vencimento = vencimento;
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
        return Bandeira;
    }

    public void setBandeira(String bandeira) {
        Bandeira = bandeira;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }
}
