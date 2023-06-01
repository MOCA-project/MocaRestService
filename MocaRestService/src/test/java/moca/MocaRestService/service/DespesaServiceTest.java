package moca.MocaRestService.service;

import moca.MocaRestService.Domain.Mappers.DespesaMapper;
import moca.MocaRestService.Domain.Models.Requests.DespesaRequesst;
import moca.MocaRestService.Domain.Models.Requests.PatchDespesaRequest;
import moca.MocaRestService.Domain.Models.Requests.PatchReceitaRequest;
import moca.MocaRestService.Domain.Models.Requests.PorquinhoRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import moca.MocaRestService.Domain.Models.Responses.DespesaResponse;
import moca.MocaRestService.Domain.Models.Responses.PorquinhoResponse;
import moca.MocaRestService.Domain.Services.DespesasService;
import moca.MocaRestService.Infrastructure.Entities.Despesa;
import moca.MocaRestService.Infrastructure.Entities.Porquinho;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class DespesaServiceTest {
    @Mock
    private IDespesasRepository despesasRepository;

    @InjectMocks
    private DespesasService despesasService;

    @Test
    @DisplayName("Deve retornar lista vazia quando nao houver despesas")
    void deveRetornarListaVaziaQuandoNaoHouverDespesas() {

        int quantidadeEsperada = 0;

        List<DespesaResponse> resultado = despesasService.get(1l,4,2023);

        //assert
        assertTrue(resultado.isEmpty());
        assertEquals(quantidadeEsperada, resultado.size());
    }

    @Test
    @DisplayName("Deve retornar excecao quando remover por id e nao existir despesa com id informado")
    void deveRetornarExcecaoQuandoRemoverPorIdENaoExistirDespesaComIdInformado() {

        //given
        Long id = 1L;

        //when
        Mockito.when(despesasRepository.findById(id)).thenReturn(Optional.empty());

        //then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            despesasService.delete(id);
        });

        //assert
        assertEquals("Despesa não encontrada", exception.getMessage());
    }
    @Test
    @DisplayName("Deve retornar excecao quando pagar por id e nao existir despesa com id informado")
    void deveRetornarExcecaoQuandoPagarPorIdENaoExistirDespesaComIdInformado() {

        //given
        Long id = 1L;

        //when
        Mockito.when(despesasRepository.findById(id)).thenReturn(Optional.empty());

        //then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            despesasService.pagar(id);
        });

        //assert
        assertEquals("Despesa não encontrada", exception.getMessage());
    }
    @Test
    @DisplayName("Deve retornar excecao quando editar por id e nao existir despesa com id informado")
    void deveRetornarExcecaoQuandoEditarPorIdENaoExistirDespesaComIdInformado() {

        //given
        Long id = 1L;
        PatchDespesaRequest request = new PatchDespesaRequest("teste",100.0, LocalDate.now());
        //when
        Mockito.when(despesasRepository.findById(id)).thenReturn(Optional.empty());

        //then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            despesasService.edit(id,request);
        });

        //assert
        assertEquals("No value present", exception.getMessage());
    }

    @Test
    @DisplayName("Deve criar uma despesa quando informado dados válidos")
    void deveCriarDespesaQuandoInformarDadosVálidos(){
        DespesaResponse response = new DespesaResponse(1l,"Despesa 1", 100.0, LocalDate.now(),false,false,1L,"1");

        Despesa newDespesa = new Despesa();

        newDespesa.setIdTipoDespesa(Long.parseLong(response.getIdTipoDespesa()));
        newDespesa.setIdDespesa(response.getIdDespesa());
        newDespesa.setData(response.getData());
        newDespesa.setPaid(response.getPaid());
        newDespesa.setParcela(response.getParcela());
        newDespesa.setValor(response.getValor());
        newDespesa.setIdCliente(response.getIdCliente());
        newDespesa.setDescricao(response.getDescricao());

        DespesaRequesst request = new DespesaRequesst();
        request.setData(newDespesa.getData());
        request.setDescricao(newDespesa.getDescricao());
        request.setIdCliente(newDespesa.getIdCliente());
        request.setPaid(newDespesa.getPaid());
        request.setIdTipoDespesa(newDespesa.getIdTipoDespesa());
        request.setValor(newDespesa.getValor());
        request.setParcela(newDespesa.getParcela());

        var despesa = DespesaMapper.toDespesa(request);

        Mockito.when(despesasRepository.save(newDespesa)).thenReturn(newDespesa);

        despesasService.add(request);

        assertNotNull(newDespesa);
        assertEquals(newDespesa.getIdTipoDespesa(),request.getIdTipoDespesa());
        assertEquals(newDespesa.getValor(),request.getValor());
        assertEquals(newDespesa.getIdCliente(),request.getIdCliente());
        assertEquals(newDespesa.getData(),request.getData());
        assertEquals(newDespesa.getDescricao(),request.getDescricao());

    }
}
