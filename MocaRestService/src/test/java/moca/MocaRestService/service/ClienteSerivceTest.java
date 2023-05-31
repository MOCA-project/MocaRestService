package moca.MocaRestService.service;
import moca.MocaRestService.Domain.Models.Requests.ClienteRequest;
import moca.MocaRestService.Domain.Models.Requests.ConfigRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import moca.MocaRestService.Domain.Services.ClienteService;
import moca.MocaRestService.Infrastructure.Entities.Cliente;
import moca.MocaRestService.Infrastructure.Repositories.IClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClienteSerivceTest {
    @Mock
    private IClienteRepository clienteRepository;
    @InjectMocks
    private ClienteService clienteService;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Deve retornar lista vazia quando nao houver clientes")
    void deveRetornarListaVaziaQuandoNaoHouverClientes() {

        //given
        int quantidadeEsperada = 0;

        //when
        Mockito.when(clienteRepository.findAll()).thenReturn(new ArrayList<>());

        //then
        List<Cliente> resultado = clienteService.getAll();

        //assert
        assertTrue(resultado.isEmpty());
        assertEquals(quantidadeEsperada, resultado.size());
    }

    @Test
    @DisplayName("Deve criar cliente quando informar dados validos")
    void deveCriarClienteQuandoInformarDadosValidos() {

        //given
        ClienteResponse clienteResponse = new ClienteResponse(1l,"Novo cliente", "cliente@email.com",1,"11959168156",true,true);

        Cliente newCliente = new Cliente();

        newCliente.setEnviaSms(true);
        newCliente.setEnviaEmail(true);
        newCliente.setEmail(clienteResponse.getEmail());
        newCliente.setTelefone(clienteResponse.getTelefone());
        newCliente.setNome(clienteResponse.getNome());
        newCliente.setId(clienteResponse.getId());
        newCliente.setIdPerfil(clienteResponse.getIdTipoPerfil());

        ClienteRequest request = new ClienteRequest();
        request.setEmail(newCliente.getEmail());
        request.setNome(newCliente.getNome());
        request.setTelefone(newCliente.getTelefone());
        request.setNome(newCliente.getNome());
        request.setIdTipoPerfil(newCliente.getIdPerfil());
        request.setIdTipoPerfil(newCliente.getIdPerfil());
        request.setSenha(passwordEncoder.encode(newCliente.getSenha()));

        Mockito.when(clienteRepository.save(newCliente)).thenReturn(newCliente);

        clienteService.addClient(request);

        assertNotNull(newCliente);
        assertEquals(newCliente.getEmail(),request.getEmail());
        assertEquals(newCliente.getNome(),request.getNome());
        assertEquals(newCliente.getSenha(),request.getSenha());
        assertEquals(newCliente.getIdPerfil(),request.getIdTipoPerfil());
        assertEquals(newCliente.getTelefone(),request.getTelefone());

    }

    @Test
    @DisplayName("Deve retornar excecao quando editar por id e nao existir cliente com id informado")
    void deveRetornarExcecaoQuandoEditarPorIdENaoExistirClienteComIdInformado() {

        //given
        Long id = 1L;
        //when
        Mockito.when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        //then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clienteService.getConfig(id);
        });

        //assert
        assertEquals("No value present", exception.getMessage());
    }
    @Test
    @DisplayName("Deve retornar excecao quando editar configuração por id e nao existir cliente com id informado")
    void deveRetornarExcecaoQuandoEditarConfiguracaoPorIdENaoExistirClienteComIdInformado() {
        //given
        Long id = 1L;
        //when
        Mockito.when(clienteRepository.findById(id)).thenReturn(Optional.empty());
        ConfigRequest request = new ConfigRequest();

        //then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clienteService.putConfig(id,request);
        });

        //assert
        assertEquals("No value present", exception.getMessage());
    }
}
