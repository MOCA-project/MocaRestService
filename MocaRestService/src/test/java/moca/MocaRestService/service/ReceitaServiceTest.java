package moca.MocaRestService.service;

import moca.MocaRestService.Domain.Mappers.ReceitaMapper;
import moca.MocaRestService.Domain.Models.Requests.PatchReceitaRequest;
import moca.MocaRestService.Domain.Models.Requests.ReceitaRequest;
import moca.MocaRestService.Domain.Models.Responses.ReceitaResponse;
import moca.MocaRestService.Domain.Services.PorquinhoService;
import moca.MocaRestService.Domain.Services.ReceitasService;
import moca.MocaRestService.Domain.exception.EntidadeNaoEncontradaException;
import moca.MocaRestService.Infrastructure.Entities.Despesa;
import moca.MocaRestService.Infrastructure.Entities.Porquinho;
import moca.MocaRestService.Infrastructure.Entities.Receita;
import moca.MocaRestService.Infrastructure.Repositories.IPorquinhoRepository;
import moca.MocaRestService.Infrastructure.Repositories.IReceitasRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ReceitaServiceTest {

    @Mock
    private IReceitasRepository receitasRepository;

    @InjectMocks
    private ReceitasService receitasService;

    @Test
    @DisplayName("Deve retornar lista vazia quando nao houver receitas")
    void deveRetornarListaVaziaQuandoNaoHouverReceitas() {

        int quantidadeEsperada = 0;

        List<ReceitaResponse> resultado = receitasService.get(1l,4,2023);

        //assert
        assertTrue(resultado.isEmpty());
        assertEquals(quantidadeEsperada, resultado.size());
    }

    @Test
    @DisplayName("Deve retornar excecao quando remover por id e nao existir receita com id informado")
    void deveRetornarExcecaoQuandoRemoverPorIdENaoExistirReceitaComIdInformado() {

        //given
        Long id = 1L;

        //when
        Mockito.when(receitasRepository.findById(id)).thenReturn(Optional.empty());

        //then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            receitasService.removeReceita(id);
        });

        //assert
        assertEquals("Receita não encontrada", exception.getMessage());
    }
    @Test
    @DisplayName("Deve retornar excecao quando editar por id e nao existir receita com id informado")
    void deveRetornarExcecaoQuandoEditarPorIdENaoExistirReceitaComIdInformado() {

        //given
        Long id = 1L;
        PatchReceitaRequest request = new PatchReceitaRequest("teste",100.0, LocalDate.now());
        //when
        Mockito.when(receitasRepository.findById(id)).thenReturn(Optional.empty());

        //then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            receitasService.edit(id,request);
        });

        //assert
        assertEquals("No value present", exception.getMessage());
    }


}
