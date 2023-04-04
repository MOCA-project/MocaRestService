package moca.MocaRestService.Data.Entities;

import javax.persistence.*;

@Entity
@Table(name = "cor_cartao", schema = "dbo", catalog = "moca")
public class CorCartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cor_cartao")
    private long idCorCartao;
    private String hexadecimal;
    private String nome;

    public long getIdCorCartao() {
        return idCorCartao;
    }

    public void setIdCorCartao(long idCorCartao) {
        this.idCorCartao = idCorCartao;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
