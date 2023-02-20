package moca.MocaRestService.Data.Entities;

public class TipoPerfil {
    private int idTipoPerfil;
    private String nome;

    public TipoPerfil(String nome) {
        this.nome = nome;
    }


    public int getIdTipoPerfil() {
        return idTipoPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
