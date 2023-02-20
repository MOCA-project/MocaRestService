package moca.MocaRestService.Data.Entities;

public class Banco {
    public int idBanco;
    public String nome;
    public String imagem;

    public Banco(int idBanco, String nome, String imagem) {
        this.idBanco = idBanco;
        this.nome = nome;
        this.imagem = imagem;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
