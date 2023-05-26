package moca.MocaRestService.Domain.Models.Responses;


import java.time.LocalDate;

public class ArquivoResponse {
    private long idArquivo;
    private String situacao;
    private LocalDate data;
    private String descricao;
    private String categoria;
    private Double valor;
    private long idCliente;

    public ArquivoResponse(
            long idArquivo,
            String situacao, LocalDate data, String descricao, String categoria, Double valor, long idCliente) {
        this.idArquivo = idArquivo;
        this.situacao = situacao;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.idCliente = idCliente;
    }

    public long getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
}

