package moca.MocaRestService.Domain.Autenticacao;

public class UsuarioTokenDTO {
    private long id;
    private String nome;
    private String email;
    private String token;
    private long idTipoPerfil;

    public UsuarioTokenDTO(long id, String nome, String email, String token, long idTipoPerfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.token = token;
        this.idTipoPerfil = idTipoPerfil;
    }

    public long getIdTipoPerfil() {
        return idTipoPerfil;
    }

    public void setIdTipoPerfil(long idTipoPerfil) {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
