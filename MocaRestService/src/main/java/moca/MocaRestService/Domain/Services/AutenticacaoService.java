package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Data.Entities.Cliente;
import moca.MocaRestService.Data.Repositories.IClienteRepository;
import moca.MocaRestService.Domain.Autenticacao.UsuariosDetalhes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    public IClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Cliente> usuario = clienteRepository.findByEmail(username);
        if (usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontraado");
        }
        return new UsuariosDetalhes(usuario.get().getSenha(), usuario.get().getEmail(), usuario.get().getNome());
    }
}
