package moca.MocaRestService.Domain.Helper;

public enum TipoDespesaEnum {
    Morádia(1, "Morádia"),
    Alimentação(2, "Alimentação"),
    Transporte(3, "Transporte"),
    Saúde(4, "Saúde"),
    Educação(5, "Educação"),
    Lazer(6, "Lazer"),
    Vestuário(7, "Vestuário"),
    Dívidas(8, "Dívidas"),
    Impostos(9, "Impostos"),
    Outros(10, "Outros");

    private int id;
    private String descricao;

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
