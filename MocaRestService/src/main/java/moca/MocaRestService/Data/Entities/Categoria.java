package moca.MocaRestService.Data.Entities;

public class Categoria {
    private int idCategoria;
    private String nome;

    public Categoria(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
