package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Domain.Helper.Iterator.Iterador;
import moca.MocaRestService.Domain.Models.Responses.ExtratoResponse;
import moca.MocaRestService.Domain.Models.Responses.ItemExtrato;
import moca.MocaRestService.Domain.Models.Responses.ListaDeExtrato;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import moca.MocaRestService.Infrastructure.Repositories.IReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

@Service
public class ExtratoService {
    @Autowired
    private IDespesasRepository despesasRepository;
    @Autowired
    private IReceitasRepository receitasRepository;
    @Autowired
    private ClienteService clienteService;

    public ExtratoResponse get(long idCliente, int mes, int ano) {
        clienteService.foundClienteOrThrow(idCliente);
        var response = new ExtratoResponse();

        var receitas = receitasRepository.getReceitasMesLista(idCliente, mes, ano);
        var despesas = despesasRepository.getDespesasLista(idCliente, mes, ano);

        Iterador<ItemExtrato> iterador = new ListaDeExtrato(receitas, despesas);
        while (iterador.hasNext()) {
            response.add(iterador.next());
        }
        return response;
    }

    public Void gravaArquivoCsv (List<ExtratoResponse> listaExtrato, String nomeArq){
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        //Bloco try-catch p abrir o arquivo
        try{
            //true = se tiver o arquivo, vai acrescentar + no arquivo, ex: se tem 7 cachorro, vai repetir os 7 embaixo = sobrescreve
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        //bloco try-catch pra gravar no arquivo
        try{
            saida.format("%s;%s;%s;%s;%s\n","Situacao","Data","Descricao","Categoria","Valor");

            for(int i = 0; i < listaExtrato.size(); i ++){
                var response = new ExtratoResponse();
                response = listaExtrato.get(i);
                List<String> situacoes = response.getSituacao();
                List<LocalDate> datas = response.getData();
                List<String> descricoes = response.getDescricao();
                List<String> categorias = response.getCategoria();
                List<Double> valores = response.getValor();

                    for (int iSituacao = 0; iSituacao < situacoes.size(); iSituacao++){
                        saida.format("%s;%s;%s;%s;%.2f\n",situacoes.get(iSituacao),datas.get(iSituacao),descricoes.get(iSituacao),
                                categorias.get(iSituacao),valores.get(iSituacao));
                    }

                }


        }
        catch (FormatterClosedException erro){
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
            deuRuim = true;
        }
        finally {
            try{
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim){
                System.exit(1);
            }

        }

        return null;
    }
}
