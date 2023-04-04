package moca.MocaRestService.Domain.Models.Responses;

public class IndiceGrafico {
    private String descricao;
    private double porcentagem;

    public IndiceGrafico(String descricao, double porcentagem) {
        this.descricao = descricao;
        this.porcentagem = porcentagem;
    }

    public IndiceGrafico(){

    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }
}
