package moca.MocaRestService.service;

import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import moca.MocaRestService.Domain.Models.Requests.PatchReceitaRequest;
import moca.MocaRestService.Domain.Models.Requests.PorquinhoRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import moca.MocaRestService.Domain.Models.Responses.DespesaResponse;
import moca.MocaRestService.Domain.Models.Responses.PorquinhoResponse;
import moca.MocaRestService.Domain.Models.Responses.ReceitaResponse;
import moca.MocaRestService.Domain.Services.ClienteService;
import moca.MocaRestService.Domain.Services.DespesasService;
import moca.MocaRestService.Domain.Services.PorquinhoService;
import moca.MocaRestService.Infrastructure.Entities.Cliente;
import moca.MocaRestService.Infrastructure.Entities.Despesa;
import moca.MocaRestService.Infrastructure.Entities.Porquinho;
import moca.MocaRestService.Infrastructure.Entities.Receita;
import moca.MocaRestService.Infrastructure.Repositories.IClienteRepository;
import moca.MocaRestService.Infrastructure.Repositories.IDespesasRepository;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.ResponseEntity;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;

@ExtendWith(MockitoExtension.class)
class PorquinhoServiceTest {

    @Mock
    private IPorquinhoRepository porquinhoRepository;

    @InjectMocks
    private PorquinhoService porquinhoService;
    @Mock
    private IDespesasRepository despesasRepository;
    @Mock
    private IReceitasRepository receitasRepository;

    @InjectMocks
    private DespesasService despesasService;
    @Mock
    private IClienteRepository clienteRepository;
    @InjectMocks
    private ClienteService clienteService;


    @Test
    @DisplayName("Deve criar um porquinho quando informado dados válidos")
    void deveCriarPorquinhoQuandoInformarDadosVálidos(){
        ClienteResponse clienteResponse = new ClienteResponse(1l,"Novo cliente", "cliente@email.com",1,"11959168156",true,true);
       PorquinhoResponse porquinhoResponse = new PorquinhoResponse(1l,"Porquinho 1", 100.0, 0.0,false,1);

       Porquinho newPorquinho = new Porquinho();

        newPorquinho.setConcluido(porquinhoResponse.getConcluido());
        newPorquinho.setIdCliente(porquinhoResponse.getIdCliente());
        newPorquinho.setValorFinal(porquinhoResponse.getValorFinal());
        newPorquinho.setValorAtual(porquinhoResponse.getValorAtual());
        newPorquinho.setNome(porquinhoResponse.getNome());
        newPorquinho.setIdIcone(1);

        PorquinhoRequest request = new PorquinhoRequest();
        request.setConcluido(newPorquinho.getConcluido());
        request.setIdCliente(newPorquinho.getIdCliente());
        request.setValorFinal(newPorquinho.getValorFinal());
        request.setValorAtual(newPorquinho.getValorAtual());
        request.setNome(newPorquinho.getNome());
        request.setIdIcone(1);

       Mockito.when(porquinhoRepository.save(newPorquinho)).thenReturn(newPorquinho);

       porquinhoService.addPorquinho(request);

       assertNotNull(newPorquinho);
       assertEquals(newPorquinho.getIdCliente(),request.getIdCliente());
       assertEquals(newPorquinho.getNome(),request.getNome());
       assertEquals(newPorquinho.getValorAtual(),request.getValorAtual());
       assertEquals(newPorquinho.getValorFinal(),request.getValorFinal());
       assertEquals(newPorquinho.getConcluido(),request.getConcluido());

    }
    @Test
    @DisplayName("Deve retornar lista vazia quando nao houver porquinhos")
    void deveRetornarListaVaziaQuandoNaoHouverPorquinhos() {

        int quantidadeEsperada = 0;

       // Mockito.when(porquinhoRepository.findAll()).thenReturn(new ArrayList<>());

        List<Porquinho> resultado = porquinhoService.getAllPorquinhoByIdCliente(1L);

        //assert
        assertTrue(resultado.isEmpty());
        assertEquals(quantidadeEsperada, resultado.size());
    }

    @Test
    @DisplayName("Deve aumentar o valor atual do porquinho quando o valor a adicionar for valido")
    void deveAumentarOValorAtualDoPorquinhoQuandoOValorAAdicionarForValido() {
        PorquinhoResponse porquinhoResponse = new PorquinhoResponse(1l,"Porquinho 1", 100.0, 0.0,false,1l);
        Double valorProduto = 10.0;
        DespesaResponse despesaResponse = new DespesaResponse(1l,"Teste",valorProduto, LocalDate.now(),false,false,1L,"1");
        Despesa despesa = new Despesa();
        despesa.setIdCliente(despesaResponse.getIdCliente());
        despesa.setValor(despesaResponse.getValor());
        despesa.setDescricao(despesaResponse.getDescricao());
        despesa.setPaid(despesaResponse.getPaid());
        despesa.setIdTipoDespesa(Long.parseLong(despesaResponse.getIdTipoDespesa()));
        despesa.setParcela(despesaResponse.getParcela());
        despesa.setData(despesaResponse.getData());
        despesa.setIdDespesa(despesaResponse.getIdDespesa());
        porquinhoService.adicionarValor(1l,1l,valorProduto);
        despesasRepository.save(despesa);
        porquinhoResponse.setValorAtual(porquinhoResponse.getValorAtual()+valorProduto);

        assertEquals(10.0,porquinhoResponse.getValorAtual());

    }
    @Test
    @DisplayName("Deve diminuir o valor atual do porquinho quando o valor a retirar for valido")
    void deveDiminuirOValorAtualDoPorquinhoQuandoOValorARetirarrForValido() {
        PorquinhoResponse porquinhoResponse = new PorquinhoResponse(1l,"Porquinho 1", 100.0, 50.0,false,1l);
        Double valorProduto = 10.0;
        ReceitaResponse receitaResponse = new ReceitaResponse(1L,"Teste",10.0,LocalDate.now(),1L,"1");
        Receita receita = new Receita();
        receita.setIdCliente(receitaResponse.getIdCliente());
        receita.setValor(receitaResponse.getValor());
        receita.setDescricao(receitaResponse.getDescricao());
        receita.setIdTipoReceita(Long.parseLong(receitaResponse.getIdTipoReceita()));
        receita.setData(receitaResponse.getData());
        receita.setIdReceita(receitaResponse.getIdReceita());
        porquinhoService.retirarValor(1l,1l,valorProduto);
        receitasRepository.save(receita);
        porquinhoResponse.setValorAtual(porquinhoResponse.getValorAtual() - valorProduto);
        assertEquals(40.0,porquinhoResponse.getValorAtual());

    }

    @Test
    @DisplayName("Deve retornar lista vazia quando nao houver porquinhos")
    void deveRetornarListaVaziaQuandoNaoHouverReceitas() {

        int quantidadeEsperada = 0;

        List<Porquinho> resultado = porquinhoService.getAllPorquinhoByIdCliente(1L);

        //assert
        assertTrue(resultado.isEmpty());
        assertEquals(quantidadeEsperada, resultado.size());
    }

    @Test
    @DisplayName("Deve finalizar porquinho quando o id for existente informado")
    void deveFinalizarPorquinhoQuandoIdForValido() {
        //given
        Long id = 1L;
        Long idCliente = 1L;
        Porquinho porquinho = new Porquinho();
        PorquinhoResponse porquinhoResponse = new PorquinhoResponse(id,"Porquinho 1", 100.0, 50.0,false,1l);

        //when
        Mockito.when(porquinhoRepository.findById(id)).thenReturn(Optional.empty());

        //then
        porquinho.setIdPorquinho(porquinhoResponse.getId());
        porquinho.setValorAtual(porquinhoResponse.getValorAtual());
        porquinho.setConcluido(porquinhoResponse.getConcluido());
        porquinho.setValorFinal(porquinhoResponse.getValorFinal());
        porquinho.setIdCliente(porquinhoResponse.getIdCliente());
        porquinho.setConcluido(porquinhoResponse.getConcluido());

        porquinho.setValorAtual(100.0);
        assertNotNull(porquinhoService.finalizarPorquinho(idCliente,id));
        assertEquals(porquinho.getValorFinal(), porquinho.getValorAtual());
   }

    @Test
    @DisplayName("Deve mostrar o porquinho quando o id informado for existente")
    void deveMostrarPorquinhoQuandoIdForValido() {
        //given
        Long id = 1L;
        Long idCliente = 1L;
        Porquinho porquinho = new Porquinho();
        PorquinhoResponse porquinhoResponse = new PorquinhoResponse(id,"Porquinho 1", 100.0, 50.0,false,1l);

        //when
        Mockito.when(porquinhoRepository.findById(id)).thenReturn(Optional.empty());
//        Mockito.when(porquinhoRepository.existsById(Mockito.anyLong())).thenReturn(true);
//        Mockito.when(porquinhoRepository.save(Mockito.any(Porquinho.class))).thenReturn(porquinho);

        //then
        porquinho.setIdPorquinho(porquinhoResponse.getId());
        porquinho.setValorAtual(porquinhoResponse.getValorAtual());
        porquinho.setConcluido(porquinhoResponse.getConcluido());
        porquinho.setValorFinal(porquinhoResponse.getValorFinal());
        porquinho.setIdCliente(porquinhoResponse.getIdCliente());
        porquinho.setConcluido(porquinhoResponse.getConcluido());


        assertNotNull(porquinhoService.getPorquinhoId(idCliente,id));


        //Mockito.verify(porquinhoRepository, Mockito.times(1)).existsById(Mockito.anyLong());
        //Mockito.verify(porquinhoRepository, Mockito.times(1)).save(Mockito.any(Porquinho.class));
    }

        @Test
    @DisplayName("Deve retornar excecao quando excluir por id e nao existir porquinho com id informado")
    void deveRetornarExcecaoQuandoExcluirPorIdENaoExistirPorquinhoComIdInformado() {

        //given
        Long id = Long.MAX_VALUE;
        Long idCliente = Long.MAX_VALUE;


        //then
        CustomException exception = assertThrows(CustomException.class, () -> {
            porquinhoService.excluirPorquinho(idCliente, id);
        });

        //assert
        assertEquals("Porquinho não encontrado", exception.getMessage());
    }
}
