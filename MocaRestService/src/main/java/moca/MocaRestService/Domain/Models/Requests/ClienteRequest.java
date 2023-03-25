package moca.MocaRestService.Domain.Models.Requests;

//inserir, front nos manda
public class ClienteRequest {

    private String nome;
    private String email;
    private String senha;
    private long idTipoPerfil;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIdTipoPerfil() {
        return idTipoPerfil;
    }

    public void setIdTipoPerfil(long idTipoPerfil) {
        this.idTipoPerfil = idTipoPerfil;
    }
}
