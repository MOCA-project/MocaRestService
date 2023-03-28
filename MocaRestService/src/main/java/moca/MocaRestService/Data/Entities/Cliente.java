package moca.MocaRestService.Data.Entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@jakarta.persistence.Entity
@Entity
public class Cliente {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "senha")
    private String senha;
    @Basic
    @Column(name = "id_perfil")
    private Long idPerfil;
    @Basic
    @Column(name = "saldo")
    private double saldo;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && Objects.equals(nome, cliente.nome) && Objects.equals(email, cliente.email) && Objects.equals(senha, cliente.senha) && Objects.equals(idPerfil, cliente.idPerfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha, idPerfil);
    }
}
