package moca.MocaRestService.Data.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tp_perfil", schema = "dbo", catalog = "moca")
public class TpPerfil {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tp_perfil")
    private long idTpPerfil;
    @Basic
    @Column(name = "nome_perfil")
    private String nomePerfil;

    public long getIdTpPerfil() {
        return idTpPerfil;
    }

    public void setIdTpPerfil(long idTpPerfil) {
        this.idTpPerfil = idTpPerfil;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TpPerfil tpPerfil = (TpPerfil) o;
        return idTpPerfil == tpPerfil.idTpPerfil && Objects.equals(nomePerfil, tpPerfil.nomePerfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTpPerfil, nomePerfil);
    }
}
