package moca.MocaRestService.service;

import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import moca.MocaRestService.Domain.Helper.Iterator.Iterador;
import moca.MocaRestService.Domain.Models.Responses.*;
import moca.MocaRestService.Domain.Services.*;
import moca.MocaRestService.Domain.exception.EntidadeNaoEncontradaException;
import moca.MocaRestService.Infrastructure.Repositories.*;
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
import org.mockito.stubbing.OngoingStubbing;

import javax.mail.FetchProfile;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;

@ExtendWith(MockitoExtension.class)
public class ExtratoServiceTest {
    @Mock
    private IReceitasRepository receitasRepository;

    @InjectMocks
    private ReceitasService receitasService;
    @Mock
    private IDespesasRepository despesasRepository;

    @InjectMocks
    private DespesasService despesasService;
    @Mock
    private IClienteRepository clienteRepository;
    @InjectMocks
    private ClienteService clienteService;

    @InjectMocks
    private ExtratoService extratoService;
    @Test
    @DisplayName("Deve retornar excecao quando criar extrato e nao existir cliente com id informado")
    void deveRetornarExcecaoQuandoCriarExtratoENaoExistirClienteComIdInformado() {
        //given
        Long id = Long.MAX_VALUE;

        //then
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            extratoService.get(id,4,2023);
        });

        //assert
        assertEquals("Cliente não encontrado", exception.getMessage());
    }

}
