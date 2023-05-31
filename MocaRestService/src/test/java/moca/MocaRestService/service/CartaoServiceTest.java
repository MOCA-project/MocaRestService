package moca.MocaRestService.service;
import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import moca.MocaRestService.Domain.Mappers.CartaoMapper;
import moca.MocaRestService.Domain.Models.Requests.CartaoRequest;
import moca.MocaRestService.Domain.Models.Requests.PorquinhoRequest;
import moca.MocaRestService.Domain.Models.Responses.*;
import moca.MocaRestService.Domain.Services.CartaoService;
import moca.MocaRestService.Domain.Services.ClienteService;
import moca.MocaRestService.Infrastructure.Entities.Cartao;
import moca.MocaRestService.Infrastructure.Entities.Porquinho;
import moca.MocaRestService.Infrastructure.Repositories.ICartoesRepository;
import moca.MocaRestService.Infrastructure.Repositories.IClienteRepository;
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
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CartaoServiceTest {
    @Mock
    private ICartoesRepository cartoesRepository;
    @InjectMocks
    private CartaoService cartaoService;

    @Test
    @DisplayName("Deve retornar excecao quando remover por id e nao existir cartao com id informado")
    void deveRetornarExcecaoQuandoRemoverPorIdENaoExistirCartaoComIdInformado() {

        //given
        Long id = Long.MAX_VALUE;

        //then
        CustomException exception = assertThrows(CustomException.class, () -> {
            cartaoService.remove(id);
        });

        //assert
        assertEquals("Cartão não encontrado", exception.getMessage());
        //given

    }

    @Test
    @DisplayName("Deve retornar lista vazia quando nao houver cartoes")
    void deveRetornarListaVaziaQuandoNaoHouverCartoes() {

        int quantidadeEsperada = 0;

        List<CartoesHomeResponse> resultado = Collections.singletonList(cartaoService.get(1l, 4, 2023));

        //assert
        assertTrue(resultado.isEmpty());
        assertEquals(quantidadeEsperada, resultado.size());
    }

@Test
@DisplayName("Deve criar um cartão quando informado dados válidos")
void deveCriarCartaoQuandoInformarDadosVálidos(){
    CartaoRequest cartaoRequest = new CartaoRequest(200.0,1l, 1l, 1l,"Mastercard","Cartão Teste","10/23");
    var cartao = CartaoMapper.toCartao(cartaoRequest);

    Mockito.when(cartoesRepository.save(cartao)).thenReturn(cartao);

    cartaoService.add(cartaoRequest);

    assertNotNull(cartao);
//    assertEquals(cartao.getIdCliente(),request.getIdCliente());
//    assertEquals(newPorquinho.getNome(),request.getNome());
//    assertEquals(newPorquinho.getValorAtual(),request.getValorAtual());
//    assertEquals(newPorquinho.getValorFinal(),request.getValorFinal());
//    assertEquals(newPorquinho.getConcluido(),request.getConcluido());

}
}
