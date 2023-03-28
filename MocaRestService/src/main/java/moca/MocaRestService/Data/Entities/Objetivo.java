package moca.MocaRestService.Data.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Objetivo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_objetivo")
    private long idObjetivo;
    @Basic
    @Column(name = "nome")
    private String nome;

    public long getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(long idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objetivo objetivo = (Objetivo) o;
        return idObjetivo == objetivo.idObjetivo && Objects.equals(nome, objetivo.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObjetivo, nome);
    }
}
