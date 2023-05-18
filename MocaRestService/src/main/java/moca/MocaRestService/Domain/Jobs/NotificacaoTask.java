package moca.MocaRestService.Domain.Jobs;

import moca.MocaRestService.CrossCutting.TwilioIntegration.Models.SmsSenderRequest;
import moca.MocaRestService.CrossCutting.TwilioIntegration.Services.TwilioService;
import moca.MocaRestService.Domain.Models.Responses.CartoesHomeCartao;
import moca.MocaRestService.Domain.Services.ClienteService;
import moca.MocaRestService.Infrastructure.Entities.Cartao;
import moca.MocaRestService.Infrastructure.Repositories.ICartoesRepository;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NotificacaoTask {
    @Autowired
    private ICartoesRepository cartoesRepository;
    @Autowired
    private IDespesasRepository despesasRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TwilioService twilioService;

    @Async
    public void revisarLimiteUtilizado(Long idCliente) {
        boolean enviar = false;
        var cliente = clienteService.getClienteOrThrow(idCliente);
        var numero = cliente.getTelefone();
        var cartoes = cartoesRepository.findByIdCliente(idCliente);

        for (Cartao cartao : cartoes){
            var gasto = despesasRepository.getGastosCartoesTotal(
                    idCliente, cartao.getIdCartao());

            if (getPorcentagem(cartao.getLimite(), gasto) > 75){
                enviar = true;
            }
        }

        if (enviar)
            twilioService.enviarAvisoLimite(numero);

    }
    private static double getPorcentagem(double total, double utilizado){
        double porcentagem =  (utilizado * 100) / total;
        return Math.floor(porcentagem * 100) / 100;
    }
}
