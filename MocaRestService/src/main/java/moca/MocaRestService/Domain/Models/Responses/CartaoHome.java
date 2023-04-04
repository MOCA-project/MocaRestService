package moca.MocaRestService.Domain.Models.Responses;

public class CartaoHome {
    private String bandeira;
    private Long idCor;
    private String nome;

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Long getIdCor() {
        return idCor;
    }

    public void setIdCor(Long idCor) {
        this.idCor = idCor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CartaoHome(String bandeira, Long idCor, String nome) {
        this.bandeira = bandeira;
        this.idCor = idCor;
        this.nome = nome;
    }
}
