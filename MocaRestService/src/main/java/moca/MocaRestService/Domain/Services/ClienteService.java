package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Configuration.Security.Jwt.GerenciadorTokenJwt;
import moca.MocaRestService.Infrastructure.Entities.Cliente;
import moca.MocaRestService.Infrastructure.Repositories.IClienteRepository;
import moca.MocaRestService.Domain.Autenticacao.UsuarioLoginDTO;
import moca.MocaRestService.Domain.Autenticacao.UsuarioTokenDTO;
import moca.MocaRestService.Domain.Models.Requests.ClienteRequest;
import moca.MocaRestService.Domain.Models.Responses.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        Cliente newCliente = new Cliente();

        String senhaCriptografada = passwordEncoder.encode(request.getSenha());

        newCliente.setEmail(request.getEmail());
        newCliente.setSenha(senhaCriptografada);
        newCliente.setIdPerfil(request.getIdTipoPerfil());
        newCliente.setNome(request.getNome());

        Cliente cliente =  clienteRepository.save(newCliente);

        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getIdPerfil());
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

        return new UsuarioTokenDTO(usuarioAutenticado.getId(), usuarioAutenticado.getNome(), usuarioAutenticado.getEmail(), token);
    }

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }



}
