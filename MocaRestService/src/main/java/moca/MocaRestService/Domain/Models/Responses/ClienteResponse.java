package moca.MocaRestService.Domain.Models.Responses;

import moca.MocaRestService.Infrastructure.Entities.Cliente;

public class ClienteResponse {
    private long id;
    private String nome;
    private String email;
    private long idTipoPerfil;
    private String telefone;
    private boolean enviaEmail;
    private boolean enviaSms;


    public ClienteResponse(long id, String nome, String email, long idTipoPerfil, String telefone, boolean enviaEmail, boolean enviaSms) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idTipoPerfil = idTipoPerfil;
        this.telefone = telefone;
        this.enviaEmail = enviaEmail;
        this.enviaSms = enviaSms;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isEnviaEmail() {
        return enviaEmail;
    }

    public void setEnviaEmail(boolean enviaEmail) {
        this.enviaEmail = enviaEmail;
    }

    public boolean isEnviaSms() {
        return enviaSms;
    }

    public void setEnviaSms(boolean enviaSms) {
        this.enviaSms = enviaSms;
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
