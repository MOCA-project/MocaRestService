package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Despesa;
import moca.MocaRestService.Data.Entities.Receita;
import moca.MocaRestService.Data.Repositories.ICartoesRepository;
import moca.MocaRestService.Data.Repositories.IDespesasRepository;
import moca.MocaRestService.Data.Repositories.IReceitasRepository;
import moca.MocaRestService.Domain.Helper.TipoDespesaEnum;
import moca.MocaRestService.Domain.Helper.TipoReceitaEnum;
import moca.MocaRestService.Domain.Models.Responses.ExtratoResponse;
import moca.MocaRestService.Domain.Models.Responses.ItemExtrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtratoService {
    @Autowired
    private IDespesasRepository despesasRepository;
    @Autowired
    private IReceitasRepository receitasRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ICartoesRepository cartoesRepository;

    public ExtratoResponse get(long idCliente, int mes, int ano) {
        var response = new ExtratoResponse();
        var receitas = receitasRepository.getReceitasMesLista(idCliente, mes, ano);
        var despesas = despesasRepository.getDespesasLista(idCliente, mes, ano);
        for (Receita receita: receitas) {
            int idTipo = receita.getIdTipoReceita().intValue();

            response.add(new ItemExtrato("Recebida",
                    receita.getData(),
                    receita.getDescricao(),
                    TipoReceitaEnum.getByID(idTipo),
                    receita.getValor(),
                    null,
                    receita.getIdReceita()));
        }

        for (Despesa despesa : despesas){
            String situacao = despesa.getPaid() ? "Paga" : "Não paga";

            response.add(new ItemExtrato(situacao,
                    despesa.getData(),
                    despesa.getDescricao(),
                    TipoDespesaEnum.getByID(despesa.getIdTipoDespesa().intValue()
                    ), despesa.getValor(),
                    despesa.getIdDespesa(),
                    null));
        }

        return response;
    }
}
