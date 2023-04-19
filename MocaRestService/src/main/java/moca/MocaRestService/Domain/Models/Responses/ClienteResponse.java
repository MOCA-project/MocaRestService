package moca.MocaRestService.Domain.Models.Responses;

import moca.MocaRestService.Infrastructure.Entities.Cliente;

//retornar
public class ClienteResponse {
    private long id;
    private String nome;
    private String email;
    private long idTipoPerfil;

    public ClienteResponse(long id, String nome, String email, long idTipoPerfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idTipoPerfil = idTipoPerfil;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public void addCliente(Cliente cliente){
        this.id = cliente.getId();
        this.email = cliente.getEmail();
        this.idTipoPerfil = cliente.getIdPerfil();
        this.nome = cliente.getNome();
    }
}
