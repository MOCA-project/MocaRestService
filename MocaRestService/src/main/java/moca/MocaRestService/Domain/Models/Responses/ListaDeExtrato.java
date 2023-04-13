package moca.MocaRestService.Domain.Models.Responses;

import moca.MocaRestService.Domain.Helper.Enums.TipoDespesaEnum;
import moca.MocaRestService.Domain.Helper.Enums.TipoReceitaEnum;
import moca.MocaRestService.Domain.Helper.Iterator.Iterador;
import moca.MocaRestService.Infrastructure.Entities.Despesa;
import moca.MocaRestService.Infrastructure.Entities.Receita;

import java.util.List;

public class ListaDeExtrato implements Iterador<ItemExtrato> {
    private List<Receita> receitas;
    private List<Despesa> despesas;
    private int indexReceitas;
    private int indexDespesas;

    public ListaDeExtrato(List<Receita> receitas, List<Despesa> despesas) {
        this.receitas = receitas;
        this.despesas = despesas;
        this.indexReceitas = 0;
        this.indexDespesas = 0;
    }

    public boolean hasNext() {
        return indexReceitas < receitas.size() || indexDespesas < despesas.size();
    }

    public ItemExtrato next() {
        if (indexReceitas < receitas.size()) {
            Receita receita = receitas.get(indexReceitas++);
            int idTipo = receita.getIdTipoReceita().intValue();
            return new ItemExtrato("Recebida",
                    receita.getData(),
                    receita.getDescricao(),
                    TipoReceitaEnum.getByID(idTipo),
                    receita.getValor(),
                    null,
                    receita.getIdReceita());
        } else {
            Despesa despesa = despesas.get(indexDespesas++);
            String situacao = despesa.getPaid() ? "Paga" : "Não paga";
            return new ItemExtrato(situacao,
                    despesa.getData(),
                    despesa.getDescricao(),
                    TipoDespesaEnum.getByID(despesa.getIdTipoDespesa().intValue()),
                    despesa.getValor(),
                    despesa.getIdDespesa(),
                    null);
        }
    }
}
