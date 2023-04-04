package moca.MocaRestService.Domain.Models.Responses;

public class CartoesHomeCartao {
    private double limite;
    private double utilizado;
    private double porcentagemUtilizado;
    private String vencimento;
    private long idCor;
    private String bandeira;
    private String apelido;

    public CartoesHomeCartao() {
    }

    public CartoesHomeCartao(double limite, double utilizado, double porcentagemUtilizado,
                             String vencimento, long idCor, String bandeira, String apelido) {
        this.limite = limite;
        this.utilizado = utilizado;
        this.porcentagemUtilizado = porcentagemUtilizado;
        this.vencimento = vencimento;
        this.idCor = idCor;
        this.bandeira = bandeira;
        this.apelido = apelido;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(double utilizado) {
        this.utilizado = utilizado;
    }

    public double getPorcentagemUtilizado() {
        return porcentagemUtilizado;
    }

    public void setPorcentagemUtilizado(double porcentagemUtilizado) {
        this.porcentagemUtilizado = porcentagemUtilizado;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public long getIdCor() {
        return idCor;
    }

    public void setIdCor(long idCor) {
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
