package moca.MocaRestService.Domain.Helper.Enums;

public enum TipoDespesaEnum {
    Moradia(1, "Moradia"),
    Alimentacao(2, "Alimentação"),
    Transporte(3, "Transporte"),
    Saude(4, "Saúde"),
    Educacao(5, "Educação"),
    Lazer(6, "Lazer"),
    Vestuario(7, "Vestuário"),
    Dividas(8, "Dívidas"),
    Impostos(9, "Impostos"),
    Outros(10, "Outros"),
    Porquinho(11, "Porquinho");

    private final int id;
    private final String descricao;

    TipoDespesaEnum(int id, String descricao) {
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
        for (TipoDespesaEnum propriedade : TipoDespesaEnum.values()) {
            if (propriedade.getId() == id) {
                return propriedade.descricao;
            }
        }
        return null;
    }
}
