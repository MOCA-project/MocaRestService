package moca.MocaRestService.Infrastructure.Entities;

import javax.persistence.*;

@Entity
public class Cartao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cartao")
    private long idCartao;
    @Basic
    @Column(name = "limite")
    private double limite;
    @Basic
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic
    @Column(name = "id_tipo")
    private Long idTipo;
    @Basic
    @Column(name = "id_cor_cartao")
    private Long idCorCartao;
    @Basic
    @Column(name = "bandeira")
    private String bandeira;
    @Basic
    @Column(name = "apelido")
    private String apelido;

    @Basic
    @Column(name = "vencimento")
    private String vencimento;

    public long getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(long idCartao) {
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

    public Long getIdCorCartao() {
        return idCorCartao;
    }

    public void setIdCorCartao(Long idCorCartao) {
        this.idCorCartao = idCorCartao;
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

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }
}
