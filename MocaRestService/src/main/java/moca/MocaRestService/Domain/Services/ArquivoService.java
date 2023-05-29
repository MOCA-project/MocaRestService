package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Domain.Models.Responses.ArquivoResponse;
import moca.MocaRestService.Infrastructure.Entities.Arquivo;
import moca.MocaRestService.Infrastructure.Repositories.IArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ArquivoService {
    @Autowired
    IArquivoRepository arquivoRepository;

    @Transactional
    public ArquivoResponse saveArquivo(ArquivoResponse response) {
        Arquivo newArquivo = new Arquivo();

        newArquivo.setSituacao(response.getSituacao());
        newArquivo.setDataArquivo(response.getData());
        newArquivo.setDescricao(response.getDescricao());
        newArquivo.setCategoria(response.getCategoria());
        newArquivo.setValor(response.getValor());
        newArquivo.setIdCliente(response.getIdCliente());

        Arquivo arquivo = arquivoRepository.save(newArquivo);

        return new ArquivoResponse(
                arquivo.getIdArquivo(),
                arquivo.getSituacao(),
                arquivo.getDataArquivo(),
                arquivo.getDescricao(),
                arquivo.getCategoria(),
                arquivo.getValor(),
                arquivo.getIdCliente());


    }
}