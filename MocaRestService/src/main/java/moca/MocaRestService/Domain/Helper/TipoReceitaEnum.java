package moca.MocaRestService.Domain.Helper;

public enum TipoReceitaEnum {
    Salário(1, "Salário"),
    Rendimentos(2, "Rendimentos"),
    Vendas(3, "Vendas de bens"),
    Freelance(4, "Freelance"),
    Aluguel(5, "Aluguel"),
    Ajuda(6, "Ajuda financeira"),
    Reembolsos(7, "Reembolsos"),
    Prêmios(8, "Prêmios"),
    Outros(9, "Outros");

    private int id;
    private String descricao;

    TipoReceitaEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static String getByID(int id) {
        for (TipoReceitaEnum propriedade : TipoReceitaEnum.values()) {
            if (propriedade.getId() == id) {
                return propriedade.descricao;
            }
        }
        return null;
    }
}
