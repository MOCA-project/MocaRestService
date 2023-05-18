package moca.MocaRestService.Domain.Models.Requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteRequest {
    @NotNull
    private String nome;
    @Email
    private String email;
    @Size(min = 6, max = 20)
    private String senha;
    private long idTipoPerfil;
    private String telefone;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
