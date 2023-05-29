package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Configuration.Security.Jwt.GerenciadorTokenJwt;
import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import moca.MocaRestService.Domain.Helper.GenericTypes.ListaObj;
import moca.MocaRestService.Domain.Mappers.ClienteMapper;
import moca.MocaRestService.Domain.Models.Requests.ConfigRequest;
import moca.MocaRestService.Infrastructure.Entities.Cliente;
import moca.MocaRestService.Infrastructure.Repositories.IClienteRepository;
import moca.MocaRestService.Domain.Autenticacao.UsuarioLoginDTO;
import moca.MocaRestService.Domain.Autenticacao.UsuarioTokenDTO;
import moca.MocaRestService.Domain.Models.Requests.ClienteRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ClienteResponse addClient(ClienteRequest request){
        var clienteOptional = clienteRepository.findByEmail(request.getEmail());
        if (clienteOptional.isPresent())
            throw new CustomException("Email já cadastrado", HttpStatus.CONFLICT);
        String senhaCriptografada = passwordEncoder.encode(request.getSenha());
        request.setSenha(senhaCriptografada);

        Cliente newCliente = ClienteMapper.toCliente(request);
        newCliente.setEnviaEmail(true);
        newCliente.setEnviaSms(true);
        Cliente cliente =  clienteRepository.save(newCliente);

        return ClienteMapper.toResponse(cliente);
    }

    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>();
        var result = clienteRepository.findAll();
        ListaObj<Cliente> listaClientes = new ListaObj<>(result.size());
        listaClientes.adicionaAll(result);

        for (int i = 0; i < listaClientes.getTamanho(); i++) {
            clientes.add(listaClientes.getElemento(i));
        }

        clientes.sort(Comparator.comparing(Cliente::getNome));

        return clientes;
    }

    public void foundClienteOrThrow(long idCliente){
        var cliente = clienteRepository.findById(idCliente);
        if (!cliente.isPresent()){
            throw new CustomException("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public Cliente getClienteOrThrow(long idCliente){
        var cliente = clienteRepository.findById(idCliente);
        if (!cliente.isPresent()){
            throw new CustomException("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
        return cliente.get();
    }

    public UsuarioTokenDTO autenticar(UsuarioLoginDTO usuarioLoginDto) {

        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Cliente usuarioAutenticado = clienteRepository.findByEmail(usuarioLoginDto.getEmail())
                .orElseThrow(
                        () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);
        usuarioAutenticado.setUltimoAcesso(LocalDate.now());
        clienteRepository.save(usuarioAutenticado);
        return new UsuarioTokenDTO(usuarioAutenticado.getId(), usuarioAutenticado.getNome(), usuarioAutenticado.getEmail(), token,
                usuarioAutenticado.getIdPerfil());
    }

    public ClienteResponse putConfig(Long idCliente, ConfigRequest request) {
        var cliente = clienteRepository.findById(idCliente).get();

        cliente.setEmail(request.getEmail() != cliente.getEmail() && request.getEmail() != null ? request.getEmail() : cliente.getEmail());
        cliente.setTelefone(request.getNumeroCelular() != cliente.getTelefone()  && request.getNumeroCelular() != null ? request.getNumeroCelular() : cliente.getTelefone());
        cliente.setEnviaEmail(request.isEnviarEmail() != cliente.isEnviaEmail() ? request.isEnviarEmail() : cliente.isEnviaEmail());
        cliente.setEnviaSms(request.isEnviarSms() != cliente.isEnviaSms() ? request.isEnviarSms() : cliente.isEnviaSms());

        clienteRepository.save(cliente);

        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getIdPerfil(),
                cliente.getTelefone(),
                cliente.isEnviaEmail(),
                cliente.isEnviaEmail()
        );

    }

    public ClienteResponse getConfig(Long idCliente) {
        var cliente = clienteRepository.findById(idCliente).get();

        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getIdPerfil(),
                cliente.getTelefone(),
                cliente.isEnviaEmail(),
                cliente.isEnviaEmail()
        );
    }
}
