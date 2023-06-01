package moca.MocaRestService.service;

import moca.MocaRestService.Domain.Models.Requests.ArquivoRequest;
import moca.MocaRestService.Domain.Models.Requests.PorquinhoRequest;
import moca.MocaRestService.Domain.Models.Responses.ArquivoResponse;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import moca.MocaRestService.Domain.Models.Responses.PorquinhoResponse;
import moca.MocaRestService.Domain.Services.ArquivoService;
import moca.MocaRestService.Domain.Services.DespesasService;
import moca.MocaRestService.Infrastructure.Entities.Arquivo;
import moca.MocaRestService.Infrastructure.Entities.Porquinho;
import moca.MocaRestService.Infrastructure.Repositories.IArquivoRepository;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ArquivoServiceTest {
    @Mock
    private IArquivoRepository arquivoRepository;

    @InjectMocks
    private ArquivoService arquivoService;

    @Test
    @DisplayName("Deve criar um arquivo quando informado dados válidos")
    void deveCriarPorquinhoQuandoInformarDadosVálidos(){
        ArquivoResponse arquivoResponse = new ArquivoResponse(1l,"Pago", LocalDate.now(), "Teste 1","Lazer",50.0,1L);

        Arquivo newArquivo = new Arquivo();

        newArquivo.setCategoria(arquivoResponse.getCategoria());
        newArquivo.setIdArquivo(arquivoResponse.getIdArquivo());
        newArquivo.setDescricao(arquivoResponse.getDescricao());
        newArquivo.setSituacao(arquivoResponse.getSituacao());
        newArquivo.setDataArquivo(arquivoResponse.getData());
        newArquivo.setIdCliente(arquivoResponse.getIdCliente());
        newArquivo.setValor(arquivoResponse.getValor());

        ArquivoRequest request = new ArquivoRequest();
        request.setDescricao(newArquivo.getDescricao());
        request.setData(newArquivo.getDataArquivo());
        request.setSituacao(newArquivo.getSituacao());
        request.setCategoria(newArquivo.getCategoria());
        request.setIdCliente(newArquivo.getIdCliente());
        request.setValor(newArquivo.getValor());

        Mockito.when(arquivoRepository.save(newArquivo)).thenReturn(newArquivo);

        arquivoService.saveArquivo(arquivoResponse);

        assertNotNull(newArquivo);
        assertEquals(newArquivo.getIdCliente(),request.getIdCliente());
        assertEquals(newArquivo.getDataArquivo(),request.getData());
        assertEquals(newArquivo.getValor(),request.getValor());
        assertEquals(newArquivo.getDataArquivo(),request.getData());
        assertEquals(newArquivo.getDescricao(),request.getDescricao());
        assertEquals(newArquivo.getSituacao(),request.getSituacao());
        assertEquals(newArquivo.getCategoria(),request.getCategoria());

    }
}
